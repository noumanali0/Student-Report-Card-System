
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class creat extends JFrame implements ActionListener{
	
	
	JTextField j1;
	JTextField j2;
	JTextField j3;
	JTextField j4;
	JTextField j5;
	JTextField j6;
	JTextField j7;
	
	
	static Connection con;
	static Statement st;
	static ResultSet rs;
	
	creat(){
		setName("Record Form");
		ImageIcon pic =new ImageIcon("2.jpg");
		JLabel j=new JLabel("",pic,JLabel.CENTER);
		j.setBounds(0,0,650,700);

		setBounds(300,20,650,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);	
		JLabel app=new JLabel("<html><h2><font color=white>ENTER STUDENT RECORD</font><h2><html>");
		JLabel roll=new JLabel("<html><h3><font color=white>Roll.no#</font><h3><html>");
		JLabel name=new JLabel("<html><h3><font color=white>Name</html><h3><html>");
		JLabel chem=new JLabel("<html><h3><font color=white>Marks in Chemistry</html><h3><html>");
		JLabel phy=new JLabel("<html><h3><font color=white>Marks in Physics</html><h3><html>");
		JLabel math=new JLabel("<html><h3><font color=white>Marks in Maths</html><h3><html>");
		JLabel ps=new JLabel("<html><h3><font color=white>Marks in PS</html><h3><html>");
		JLabel bio=new JLabel("<html><h3><font color=white>Marks in Biology</html><h3><html>");
		
		app.setBounds(190,4,500,100);
		add(app);
		roll.setBounds(100,90,80,50);
		add(roll);
		name.setBounds(100,150,80,50);
		add(name);
		chem.setBounds(100,210,80,50);
		add(chem);
		phy.setBounds(100,270,80,50);
		add(phy);
		math.setBounds(100,330,80,50);
		add(math);
		ps.setBounds(100,390,80,50);
		add(ps);
		bio.setBounds(100,450,80,50);
		add(bio);

		j1=new JTextField();
		j1.setBounds(230,100,250,30);
		add(j1);
		j2=new JTextField();
		j2.setBounds(230,160,250,30);
		add(j2);
		j3=new JTextField();
		j3.setBounds(230,220,250,30);
		add(j3);
		j4=new JTextField();
		j4.setBounds(230,280,250,30);
		add(j4);
		j5=new JTextField();
		j5.setBounds(230,340,250,30);
		add(j5);
		j6=new JTextField();
		j6.setBounds(230,400,250,30);
		add(j6);
		j7=new JTextField();
		j7.setBounds(230,460,250,30);
		add(j7);
		
		JButton add=new JButton("Add");
		add.setBounds(360,530,100,30);
		add(add);
		JButton bak=new JButton("Back");
		bak.setBounds(250,530,100,30);
		add(bak);
		bak.addActionListener(this);
		add.addActionListener(this);
		setVisible(true);
		add(j);
	}
	public void actionPerformed(ActionEvent ae){
		int a=0,b=0,c=0,d=0,e=0,f=0;
		JButton btn=(JButton)ae.getSource();
		if(btn.getText().equals("Add"))
			{
				String roll = j1.getText();
				String name = j2.getText();
				String che = j3.getText();
				String ph = j4.getText();
				String mat = j5.getText();
				String ps = j6.getText();
				String bio = j7.getText();
				if(roll.equals("") || name.equals("") || che.equals("") || ph.equals("") || mat.equals("") || ps.equals("") || bio.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please provide complete information"); 
				}
				else
				{	
					 a=Integer.parseInt(roll);
					 b=Integer.parseInt(che);
					 c=Integer.parseInt(ph);
					 d=Integer.parseInt(mat);
					 e=Integer.parseInt(ps);
					 f=Integer.parseInt(bio);
					
					JFrame obj = new JFrame();
					try{
						
						String driverClassName="com.mysql.cj.jdbc.Driver";
						String url="jdbc:mysql://localhost:3306/student";
						String user = "root";
						String password = "camelCase";
						Class.forName(driverClassName).newInstance();
						con = DriverManager.getConnection(url,user,password);
						st = con.createStatement();
						st.executeUpdate("INSERT INTO Records(ID,Name,Chemistry,Physics,Maths,PS,Biology) VALUES ("+a+",'"+name+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')");
						rs.close();
						st.close();
						con.close();
					}
					catch(Exception ax){
						System.out.println(ax);
						
					}
					JOptionPane.showMessageDialog(null,"Your Record has been added successsfully\n                                       Thanks!");
					setVisible(false);
					new frame();	
				}
			
			}
		else{
			setVisible(false);
			new frame();		
		}	
		}
}
