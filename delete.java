
import  javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
class delete extends JFrame implements ActionListener{
	
	JTextField j1;
	JTextField j2;	
	static Connection con;
	static Statement st;
	static ResultSet rs;
	delete(String title){
			
		super(title);
		ImageIcon pic =new ImageIcon("2.jpg");
		JLabel j=new JLabel("",pic,JLabel.CENTER);
		j.setBounds(0,0,650,700);
		
		setBounds(300,20,650,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel head=new JLabel("<html><h2><font color=white>Enter Your Name Or Roll number for changes</font><h2><html>");
		JLabel name=new JLabel("<html><h2><font color=white>Name</font><h2><html>");
		JLabel roll=new JLabel("<html><h2><font color=white>Roll Number</font><h2><html>");
		
		head.setBounds(150,4,500,100);
		add(head);
		
		name.setBounds(150,200,50,50);
		add(name);
		roll.setBounds(150,300,100,50);
		add(roll);


		j1=new JTextField();
		j1.setBounds(250,215,250,30);
		add(j1);
		j2=new JTextField();
		j2.setBounds(250,315,250,30);
		add(j2);	

		JButton next=new JButton("Back");
		next.setBounds(330,400,80,30);
		add(next);
		JButton cancel=new JButton("OK!");
		cancel.setBounds(420,400,80,30);
		add(cancel);
		next.addActionListener(this);
		cancel.addActionListener(this);
		add(j);		
		setVisible(true);		
	}
	public void actionPerformed(ActionEvent ae){
		JButton btn=(JButton)ae.getSource();
		if(btn.getText().equals("OK!")){
			
			int r=0;
			label:
			{
			String rol= j2.getText();
			String name=j1.getText();
			if(rol.equals("") || name.equals("") )
				{
					JOptionPane.showMessageDialog(null,"Please provide complete information");
				}
			else
			{
			 try{ r=Integer.parseInt(rol);}catch(Exception ax){JOptionPane.showMessageDialog(null,"Invalid DataType!");setVisible(false);new modi(); break label;}
				
				try{
					String driverClassName="com.mysql.cj.jdbc.Driver";
					String url="jdbc:mysql://localhost:3306/student";
					String user = "root";
					String password = "camelCase";
					Class.forName(driverClassName);
					con=DriverManager.getConnection(url,user,password);
					st=con.createStatement();
					rs=st.executeQuery("select id from Records ");
					boolean sear=true;
				while(rs.next())
				{
					if(rs.getInt(1)==r)
					{
						st.executeUpdate("delete from Records where id="+r);
						try{
						rs.close();
						st.close();
						con.close();}
						catch(Exception ai)
						{}
						
						sear=false;
					}
					
				}
				if(sear)
				{
				JOptionPane.showMessageDialog(null,"Record does not Exist");
				setVisible(false);
				new delete("DELETE RECORD");
				break label;
				}
				}catch(Exception ai){}
				JOptionPane.showMessageDialog(null,"Record Deleted");
				setVisible(false);
				new frame();		
			}
			}
		}
		else{
			setVisible(false);
			new frame();	
		}		
	}		
}
