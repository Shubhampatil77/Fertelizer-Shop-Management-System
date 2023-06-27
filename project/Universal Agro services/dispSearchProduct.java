import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.*;
class dispProd extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l11,l12,l13;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	//JTextArea t8;
	JButton b1;
	Font f1=new Font("Bell MT",Font.BOLD+Font.ITALIC,30);
	Container c1=getContentPane();
	Connection conn;
	ResultSet rs;
	dispProd()
	{
		super("Display PRODUCT Information");
		setLayout(null);
		l11=new JLabel("PRODUCT DETAILS");
		l11.setBounds(90,20,500,60);
		c1.add(l11);
		l11.setFont(f1);
		l12 = new JLabel("_______________________________________________________"+
						            "__________________________________");
		l13 = new JLabel("_______________________________________________________"+
						            "__________________________________");
        l12.setForeground(Color.BLUE);	
		l13.setForeground(Color.BLUE);	
		l12.setBounds(0,60,600,20);
		c1.add(l12);
		l13.setBounds(0,355,600,20);
		c1.add(l13);
		
		l1=new JLabel("Product No:");
		l1.setBounds(30,90,130,30);
		c1.add(l1);
		
		l2=new JLabel("Prod Name:");
		l2.setBounds(30,150,270,30);
		c1.add(l2);
		
		l3=new JLabel("Weight/unit:");
		l3.setBounds(30,220,130,30);
		c1.add(l3);
		
		l4=new JLabel("Price:");
		l4.setBounds(30,270,130,30);
		c1.add(l4);
		
		l5=new JLabel("Quantity:");
		l5.setBounds(30,320,130,30);
		c1.add(l5);
		
		l6=new JLabel("Mfg Date.:");
		l6.setBounds(280,220,130,30);
		c1.add(l6);
		
		l7=new JLabel("Exp Date.:");
		l7.setBounds(280,270,130,30);
		c1.add(l7);
		
		l8=new JLabel("Batch No.:");
		l8.setBounds(280,320,130,30);
		c1.add(l8);
				
		t1=new JTextField();
		t1.setBounds(110,100,130,20);
		c1.add(t1);
		
		t2=new JTextField();
		t2.setBounds(110,230,130,20);
		c1.add(t2);
		
		t3=new JTextField();
		t3.setBounds(110,280,130,20);
		c1.add(t3);
					
		t4=new JTextField();
		t4.setBounds(110,330,130,20);
		c1.add(t4);
		
		t5=new JTextField();
		t5.setBounds(350,220,130,20);
		c1.add(t5);
		
		t6=new JTextField();
		t6.setBounds(350,270,130,20);
		c1.add(t6);
			
		t7=new JTextField();
		t7.setBounds(110,150,300,20);
		c1.add(t7);
		
		t8=new JTextField();
		t8.setBounds(350,320,130,20);
		c1.add(t8);
	  		   	
        /*t8=new JTextArea();
        t8.setBounds(110,150,200,60);
        c1.add(t8);
        t8.setBorder(BorderFactory.createLineBorder(Color.black,1));*/
     
        b1=new JButton("Ok");
        b1.setBounds(100,400,100,30);
        c1.add(b1);
        
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        t7.setEditable(false);
        t8.setEditable(false);
        
        setSize(600,500);
        setVisible(true);
        b1.addActionListener(this);
        }
        
   public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==b1)
    	 {  
    	      dispose(); 
    	 	  MyclsItem c=new MyclsItem();
    	 	  c.setVisible(true);
        }    
    }   
       
   } 
 class dispSearchItem
{
	public static void main(String args[])
	{
		dispProd mp=new dispProd();
	}
}		