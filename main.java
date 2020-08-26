
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class frame extends JFrame implements ActionListener{

	frame(){
		setName("Student Report Card System");
		setBounds(300,20,650,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		JLabel slo = new JLabel("<html><h2><font color=white>MERIT-QUALITY-EXCELLENCE</font></h2></html>");
		slo.setBounds(175,20,400,100);
		add(slo);
		
		ImageIcon iba =new ImageIcon("iba.png");
		JLabel i=new JLabel("",iba,JLabel.CENTER);
		i.setBounds(240,60,125,180);
		add(i);
		
		ImageIcon bak = new ImageIcon("1.jpg");
		JLabel j = new JLabel("",bak,JLabel.RIGHT);
		j.setBounds(0,0,650,700);
		
		JButton btn1 = new JButton("STUDENT RESULT");
		btn1.setBounds(150,210,140,50);
		btn1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
		btn1.addActionListener(this);
		add(btn1);
		
		JButton btn2 = new JButton("MODIFY");
		btn2.setBounds(150,275,140,50);
		btn2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
		btn2.addActionListener(this);
		add(btn2);
		
		JButton btn3 = new JButton("DELETE RECORD");
		btn3.setBounds(150,340,140,50);
		btn3.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
		btn3.addActionListener(this);
		add(btn3);
		
		JButton btn4 = new JButton("ADD RECORD");
		btn4.setBounds(330,210,140,50);
		btn4.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
		btn4.addActionListener(this);
		add(btn4);
		
		JButton btn5 = new JButton("COMMENTS");
		btn5.setBounds(330,275,140,50);
		btn5.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
		btn5.addActionListener(this);
		add(btn5);
		
		JButton btn6 = new JButton("CLEAR RECORDS");
		btn6.setBounds(330,340,140,50);
		btn6.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
		btn6.addActionListener(this);
		add(btn6);
		
		JButton btn7 = new JButton("ABOUT");
		btn7.setBounds(240,400,140,50);
		btn7.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
		btn7.addActionListener(this);
		add(btn7);
		
		JButton btn8 = new JButton("EXIT");
		btn8.setBounds(240,470,140,50);
		btn8.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));
		btn8.addActionListener(this);
		add(btn8);
		add(j);
		
		setVisible(true);
	}

	
	
	public void actionPerformed(ActionEvent ae){
		JButton btn = (JButton) ae.getSource();
		
			if(btn.getText().equals("COMMENTS"))
			{
				setVisible(false);	
				new comm();
				
			}
			
			if(btn.getText().equals("ADD RECORD"))
			{
				setVisible(false);	
				new creat();
				
			}
			
			if(btn.getText().equals("DELETE RECORD"))
			{
				setVisible(false);	
				new delete("DELETE");
				
			}
			
			if(btn.getText().equals("STUDENT RESULT"))
			{
				setVisible(false);	
				new sResult();
			}
			
			if(btn.getText().equals("MODIFY"))
			{
				setVisible(false);	
				new modi();
			}
			
			if(btn.getText().equals("CLEAR RECORDS"))
			{
				
				new clear();
			}
			
			if(btn.getText().equals("ABOUT"))
			{
				setVisible(false);	
				new about();
			}
			if(btn.getText().equals("EXIT"))
			{
				System.exit(1);
				setVisible(false);	
			}
		
	}

}
class Student
{
public static void main(String args[])
{
	new frame();
}
}