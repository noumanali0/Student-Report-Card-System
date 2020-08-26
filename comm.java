import java.sql.*;
import  javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class comm extends JFrame implements ActionListener{
	
	JTextArea Text;
	static Connection con;
	static Statement st;
	comm(){
		ImageIcon bak = new ImageIcon("2.jpg");
		JLabel j = new JLabel("",bak,JLabel.RIGHT);
		j.setBounds(0,0,650,700);

		setBounds(300,20,650,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel label=new JLabel("<html><h2><font color=white><b>Comment And Suggestion Box<b></font></h2></html>");
		
		label.setBounds(70,100,300,50);
		add(label);
		
		Text=new JTextArea();
		Font f=new Font("Verdana",Font.PLAIN,18);
		Text.setFont(f);
		Text.setBounds(70,200,500,300);
		add(Text);
		
		JButton submit=new JButton("Submit");
		submit.setBounds(470,530,100,30);
		add(submit);
		
		JButton back=new JButton("Back");
		back.setBounds(360,530,100,30);
		add(back);
		
		submit.addActionListener(this);
		back.addActionListener(this);
		setVisible(true);
		add(j);	
		
	}
	public void actionPerformed(ActionEvent ae){
		JButton btn=(JButton)ae.getSource();
		if(btn.getText().equals("Submit"))
		{
				String ma=Text.getText();
				if(ma.equals(""))
				{JOptionPane.showMessageDialog(null,"Please enter text");}
				else
				{
						try{
						String driverClassName="com.mysql.cj.jdbc.Driver";
						String url="jdbc:mysql://localhost:3306/student";
						String user = "root";
						String password = "camelCase";
						Class.forName(driverClassName).newInstance();
						con=DriverManager.getConnection(url,user,password);
						st=con.createStatement();
						st.executeUpdate("insert into comments(Comments) values ('"+ma+"')");
						con.close();
						st.close();
						}catch(Exception ax){}
						JOptionPane.showMessageDialog(null,"Your Comments has been Successfully submited\n                         Thanks!");
						setVisible(false);
						new frame();
				}
				
				
				
		}
		else    
		{
				setVisible(false);
				new frame();
		}
	}
	
		
}