import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class about extends JFrame implements ActionListener{
	about(){
		super();
		
		
		setBounds(300,20,650,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);	
		JLabel app=new JLabel("<html><h1><font color=black><u>ABOUT<u></font><h1><html>");
		app.setBounds(270,40,500,100);
		add(app);
		
		JLabel info =new JLabel("<html><h2><font color=black><i><u>PROJECT : Student Report Card System<br><br>DEVELOPER :  Tanveer Samejo<br><br>TEACHER : Khalid Hussain<br><br>LANGUAGE :  Java<br><br>YEAR : 2020<i><u></font><h2><html>");
		info.setBounds(120,80,500,500); 
		add(info);
		
		JButton close=new JButton("Close");
		close.setBounds(360,530,100,30);
		add(close);
		JButton bak=new JButton("Back");
		bak.setBounds(250,530,100,30);
		add(bak);
	
		bak.addActionListener(this);
		close.addActionListener(this);
		setVisible(true);
		
		ImageIcon pic =new ImageIcon("3.jpg");
		JLabel j=new JLabel("",pic,JLabel.CENTER);
		j.setBounds(0,0,650,700);
		add(j);
		
		
		
	}
	public void actionPerformed(ActionEvent ae){
		JButton btn=(JButton)ae.getSource();
		if(btn.getText().equals("Close"))
			{
				setVisible(false);
				
			}
		if(btn.getText().equals("Back")){
			//yahan p main frame h jo 6 buttons wala usk frame ko call krwana h
		setVisible(false);
		new frame();		
		}	
		}
}
class ucode{
public static void main(String args[])
{
	new about();
}
}