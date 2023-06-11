import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class TemperatureConversion extends JFrame implements ActionListener{

     JLabel lab1,lab2,lab3,lab4;
     JButton b1,b2;
     JTextField tf1,tf2,tf3;
     JFrame d;
     TemperatureConversion(){
    	 Container c=getContentPane();
    	 c.setLayout(new FlowLayout());
    	 
         
         lab1=new JLabel("Celsius"); 
    	 lab2=new JLabel("Fahrenheit");
    	 lab3=new JLabel("Kelvin");
    	 lab4=new JLabel();
    	 tf1=new JTextField(20);
    	 tf2=new JTextField(20);
    	 tf3=new JTextField(20);
    	 b1=new JButton("Convert");
    	 b2=new JButton("Clear");
    	 c.add(lab1);
    	 c.add(tf1);
    	 c.add(lab2);
    	 c.add(tf2);
    	 c.add(lab3);
    	 c.add(tf3);
    	 c.add(b1);
    	 c.add(b2);
    	 c.add(lab4);
    	 b1.addActionListener(this);
    	 b2.addActionListener(this);

     }

	public static void main(String[] args) {
		 TemperatureConversion d=new TemperatureConversion();
		 d.setTitle("Temperature converter");
		 d.setVisible(true);
		 d.setSize(350,350 );
                 d.setBounds(845, 380, 500, 300);
		 d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2)
		{
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
		}
		else
		{
			    boolean flag1=true,flag2=true,flag3=true;
			    int x=0,y=0,z=0;
			    try
			    {
			        x=Integer.parseInt(tf1.getText());
			    }
			    catch(NumberFormatException nfe)
				{
					flag1=false;
				}
                try
                {
			        y=Integer.parseInt(tf2.getText());
                }
                catch(NumberFormatException nfe)
				{
					flag2=false;
				}
                try
                {
                	z=Integer.parseInt(tf3.getText());
                }
                catch(NumberFormatException nfe)
				{
					flag3=false;
				}
			    if(flag1==true&&flag2==false&&flag3==false)
			    {
			    		tf2.setText(String.format("%.2f",((9.0/5)*x)+32));
			    		tf3.setText(String.format("%.2f",(x+273.15)));
			    		lab4.setText("Done...successfully");
			    }
			    else if(flag1==false&&flag2==true&&flag3==false)
			    {
			    	      tf1.setText(String.format("%.2f",(y-32)*(5.0/9)));
		    		      tf3.setText(String.format("%.2f",((y-32)*(5.0/9))+273.15));
			    		lab4.setText("Done...successfully");
			    }
			    else if(flag1==false&&flag2==false&&flag3==true)
			    {
			    		tf1.setText(String.format("%.2f",z-273.15));
			    		tf2.setText(String.format("%.2f",((z-273.15)*(9.0/5))+32));
			    		lab4.setText("Done...successfully");
			    }
			    else
			    {
			    	lab4.setText("Error.Please enter valid input");
			    }
			}
	    }


}