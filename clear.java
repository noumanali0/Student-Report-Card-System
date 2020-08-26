import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class clear extends JFrame implements ActionListener{


	JTextField j1;
	JTextField j2;
	
    static Connection con;
	static Statement st;
	
	clear(){
		super();
		
		setBounds(300,20,650,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		
		JLabel box=new JLabel("<html><h2><font color=white>Do you want to clear all the records?</font><h2><html>");
		box.setBounds(150,120,330,50);
		add(box);
		
		
		
		JButton yes=new JButton("YES");
		yes.setBounds(220,200,100,30);
		add(yes);
		yes.addActionListener(this);
		
		JButton no=new JButton("NO");
		no.setBounds(330,200,100,30);
		add(no);
		no.addActionListener(this);
		
		
		JButton bak=new JButton("Back");
		bak.setBounds(280,330,100,30);
		add(bak);
		bak.addActionListener(this);
		
		ImageIcon pic =new ImageIcon("2.jpg");
		JLabel j=new JLabel("",pic,JLabel.CENTER);
		j.setBounds(0,0,650,700);
		add(j);
		
		
	
	}
	


    public void actionPerformed(ActionEvent ae){
		JButton btn = (JButton) ae.getSource();
		
		
		if(btn.getText().equals("YES"))
		{
			
				try{
						String driverClassName="com.mysql.cj.jdbc.Driver";
						String url="jdbc:mysql://localhost:3306/student";
						String user = "root";
						String password = "camelCase";
						Class.forName(driverClassName);
						con=DriverManager.getConnection(url,user,password);
						st=con.createStatement();
						int count=st.executeUpdate("Delete from Records");
				
						con.close();
						st.close();
						}
					catch(Exception ax){
					ax.printStackTrace();
					}
				JOptionPane.showMessageDialog(null,"Your Record has been cleared successsfully\n                              Thanks!");
			
			setVisible(false);
			new frame();	
			
		}
		else if(btn.getText().equals("NO")){
			setVisible(false);
			new frame();	
			
		}
		else{
			setVisible(false);
			new frame();	
			}
		
    }
		
}