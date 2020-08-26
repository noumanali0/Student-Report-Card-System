
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
class sResultt extends JFrame implements ActionListener{
	
	
	static JTextField j1;
	static JTextField j2;
	static JTextField j3;
	static JTextField j4;
	static JTextField j5;
	static JTextField j6;
	static JTextField j7;
	
	static Connection con;
	static Statement st;
	static ResultSet rs;
	sResultt(){
		
		ImageIcon pic =new ImageIcon("2.jpg");
		JLabel j=new JLabel("",pic,JLabel.CENTER);
		j.setBounds(0,0,650,700);

		setBounds(300,20,650,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);	
		JLabel app=new JLabel("<html><h2><font color=white>RESULT CARD</font><h2><html>");
		JLabel roll=new JLabel("<html><h3><font color=white>Roll.no#</font><h3><html>");
		JLabel name=new JLabel("<html><h3><font color=white>Name</html><h3><html>");
		JLabel chem=new JLabel("<html><h3><font color=white>Chemistry</html><h3><html>");
		JLabel phy=new JLabel("<html><h3><font color=white>Physics</html><h3><html>");
		JLabel math=new JLabel("<html><h3><font color=white>Maths</html><h3><html>");
		JLabel ps=new JLabel("<html><h3><font color=white>PS</html><h3><html>");
		JLabel bio=new JLabel("<html><h3><font color=white>Biology</html><h3><html>");
		
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
		
		JButton add=new JButton("Back");
		add.setBounds(360,530,100,30);
		add(add);
		//JButton bak=new JButton("Back");
		//bak.setBounds(250,530,100,30);
		//add(bak);
		//bak.addActionListener(this);
		add.addActionListener(this);
		
		try{
			String driverClassName="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/student";
			String user = "root";
			String password = "camelCase";
			Class.forName(driverClassName);
			con=DriverManager.getConnection(url,user,password);
			st=con.createStatement();
			rs=st.executeQuery("select *from Records where id="+sResult.t);
		while(rs.next())
		{
			j1.setText(rs.getInt(1)+"");
			j2.setText(rs.getString(2));
			j3.setText(rs.getInt(3)+"");
			j4.setText(rs.getInt(4)+"");
			j5.setText(rs.getInt(5)+"");
			j6.setText(rs.getInt(6)+"");
			j7.setText(rs.getInt(7)+"");
			System.out.println(sResult.t);
		}		
		}catch(Exception ax){ax.printStackTrace();}
		try{
			con.close();
		st.close();
		rs.close();
		}catch(Exception ax){ax.printStackTrace();}
		
		setVisible(true);
		add(j);
	}
	public void actionPerformed(ActionEvent ae){
		JButton btn=(JButton)ae.getSource();
		if(btn.getText().equals("Back"))
		{
			setVisible(false);
			new sResult();		
		}
	}
}
