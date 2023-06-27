/* =========================================================
 * Class	: addcustomer
 * Purpose  : To add the new customer
 * ======================================================== */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.regex.Matcher;
import java.sql.*;


class addmemb extends JFrame implements ActionListener
{
	
	String EMAIL_REGEX="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l11,l12,l13,img1,dt;
	JTextField t1,t2,t3,t4,t5,t6,t7,txtdt;
	JTextArea t8;
	JButton b1,b2,b3;
	Font f1=new Font("Bell MT",Font.BOLD+Font.ITALIC,30);
	String qty;
	Container c1=getContentPane();
	Connection conn;
	ResultSet rs;
	addmemb()
	{
		super("CUSTOMER ENTRY");
		setLayout(null);
		l11=new JLabel("CUSTOMER ENTRY");
		l11.setBounds(90,20,350,60);
		c1.add(l11);
		l11.setFont(f1);
		l12 = new JLabel("_______________________________________________________"+
						            "____________________________________________");
		l13 = new JLabel("________________________________________________________"+
						            "____________________________________________");
		
		l12.setForeground(Color.BLUE);	
		l13.setForeground(Color.BLUE);	
		l12.setBounds(0,60,700,20);
		c1.add(l12);
		l13.setBounds(0,355,700,20);
		c1.add(l13);
		
		img1 = new JLabel(new ImageIcon("sss.jpg "));
      	img1.setBounds(0,0,100,73);
       c1.add(img1);
		
		l8=new JLabel("Customer No:");
		l8.setBounds(30,90,150,30);
		c1.add(l8);
		
		dt=new JLabel("Date:");
		dt.setBounds(350,90,150,30);
		c1.add(dt);
		
		l1=new JLabel("Name:");
		l1.setBounds(30,150,130,30);
		c1.add(l1);
		
		l2=new JLabel("Address:");
		l2.setBounds(350,160,270,30);
		c1.add(l2);
		
		l3=new JLabel("Profession:");
		l3.setBounds(30,220,130,30);
		c1.add(l3);
		
		l4=new JLabel("Email:");
		l4.setBounds(30,270,130,30);
		c1.add(l4);
		
		l5=new JLabel("Nationality:");
		l5.setBounds(30,320,130,30);
		c1.add(l5);
		
		l6=new JLabel("Phone no:");
		l6.setBounds(350,220,100,30);
		c1.add(l6);
		
		l7=new JLabel("Place:");
		l7.setBounds(350,270,100,30);
		c1.add(l7);
		
		t7=new JTextField();
		t7.setBounds(110,100,130,20);
		t7.setEditable(false);
		c1.add(t7);
		
		String month; int dt; int ye;
		
		String months[] = {
		"01", "02", "03", "04",
		"05", "06", "07", "08",
		"09", "10", "11", "12"};
	 	Calendar calendar = Calendar.getInstance();	
    	 month = months[calendar.get(Calendar.MONTH)];
		dt = calendar.get(Calendar.DATE);
		ye = calendar.get(Calendar.YEAR);
		
		//tdt.setText(dt+"/"+month+"/"+ye);
		txtdt=new JTextField();
		txtdt.setBounds(430,90,130,20);
		txtdt.setEditable(false);
		txtdt.setText(dt+"/"+month+"/"+ye);
		c1.add(txtdt);
					
		t1=new JTextField();
		t1.setBounds(110,150,200,20);
		c1.add(t1);
			t1.addKeyListener(new KeyAdapter() 
		{
        	public void keyPressed(KeyEvent EVT) 
        	{
                                
        		String value = t1.getText();
                int l = value.length();
                if (EVT.getKeyChar() >= 'a' && EVT.getKeyChar() <= 'z' ||EVT.getKeyChar() >= 'A' && EVT.getKeyChar() <= 'Z'|| EVT.getKeyChar()=='\b'|| EVT.getKeyChar()==' '|| EVT.isShiftDown()==true)               
                {
                	t1.setEditable(true);
                    //System.out.println("Error");
                }
                else 
                {
                    t1.setEditable(true);
                    JOptionPane.showMessageDialog((Component)null,"Enter Only Characters","Agro Services",JOptionPane.INFORMATION_MESSAGE);
             
             	}
             }
          });
		
		
		t2=new JTextField();
		t2.setBounds(110,230,130,20);
		c1.add(t2);
			t2.addKeyListener(new KeyAdapter() 
		{
        	public void keyPressed(KeyEvent EVT) 
        	{
                                
        		String value = t2.getText();
                int l = value.length();
                if (EVT.getKeyChar() >= 'a' && EVT.getKeyChar() <= 'z' ||EVT.getKeyChar() >= 'A' && EVT.getKeyChar() <= 'Z'|| EVT.getKeyChar()=='\b'|| EVT.getKeyChar()==' '|| EVT.isShiftDown()==true)               
                {
                	t2.setEditable(true);
                    //System.out.println("Error");
                }
                else 
                {
                    t2.setEditable(true);
                    JOptionPane.showMessageDialog((Component)null,"Enter Only Characters","Agro Services",JOptionPane.INFORMATION_MESSAGE);
             
             	}
             }
          });
		
		
		t3=new JTextField();
		t3.setBounds(110,280,130,20);
		c1.add(t3);
		
			
		t4=new JTextField();
		t4.setBounds(110,330,130,20);
		c1.add(t4);
			t4.addKeyListener(new KeyAdapter() 
		{
        	public void keyPressed(KeyEvent EVT) 
        	{
                                
        		String value = t4.getText();
                int l = value.length();
                if (EVT.getKeyChar() >= 'a' && EVT.getKeyChar() <= 'z' ||EVT.getKeyChar() >= 'A' && EVT.getKeyChar() <= 'Z'|| EVT.getKeyChar()=='\b'|| EVT.getKeyChar()==' '|| EVT.isShiftDown()==true)               
                {
                	t4.setEditable(true);
                    //System.out.println("Error");
                }
                else 
                {
                    t4.setEditable(true);
                    JOptionPane.showMessageDialog((Component)null,"Enter Only Characters","Agro Services",JOptionPane.INFORMATION_MESSAGE);
             
             	}
             }
          });
		
			
		t5=new JTextField();
		t5.setBounds(430,230,130,20);
		c1.add(t5);
			t5.addKeyListener(new KeyAdapter() 
			{
        		public void keyPressed(KeyEvent EVT) 
        		{     
	        		String value = t5.getText();
	                int l = value.length();
	                if(l<10)
	                {            	
	                if (EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' ||EVT.getKeyChar()=='\b')               
	                {
	                	t5.setEditable(true);
	                }
	                else 
	                {
	                    t5.setEditable(true);
	                    JOptionPane.showMessageDialog((Component)null,"Enter Only Numbers","Agro Services",JOptionPane.INFORMATION_MESSAGE);
	             	}
	          		}
	             	else
	             		JOptionPane.showMessageDialog((Component)null,"Enter Only 10 Numbers","Agro Services",JOptionPane.INFORMATION_MESSAGE);
         		}

         	});
	  	
		t6=new JTextField();
		t6.setBounds(430,280,130,20);
		c1.add(t6);
		t6.addKeyListener(new KeyAdapter() 
		{
        	public void keyPressed(KeyEvent EVT) 
        	{
                                
        		String value = t6.getText();
                int l = value.length();
                if (EVT.getKeyChar() >= 'a' && EVT.getKeyChar() <= 'z' ||EVT.getKeyChar() >= 'A' && EVT.getKeyChar() <= 'Z'|| EVT.getKeyChar()=='\b'|| EVT.getKeyChar()==' '|| EVT.isShiftDown()==true)               
                {
                	t6.setEditable(true);
                    //System.out.println("Error");
                }
                else 
                {
                    t6.setEditable(true);
                    JOptionPane.showMessageDialog((Component)null,"Enter Only Characters","Agro Services",JOptionPane.INFORMATION_MESSAGE);
             
             	}
             }
          });
		
			
		t8=new JTextArea();
        		t8.setBounds(430,150,150,60);
        		c1.add(t8);
        		t8.setBorder(BorderFactory.createLineBorder(Color.black,1));
     
     	   b1=new JButton("Submit");
        b1.setBounds(30,400,100,30);
        c1.add(b1);
        
        b2=new JButton("Clear");
        b2.setBounds(150,400,100,30);
        c1.add(b2);
        
        b3=new JButton("Cancel");
        b3.setBounds(270,400,100,30);
        c1.add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        try
			{
				if (conn!= null)
	            	conn.close(); 
				conn = ConnectTODB.getConnection();
				
	  			String qry = "SELECT customer.*,customer.cust_Id"+
					  " FROM customer WHERE (((customer.cust_Id)="+
					  "(SELECT Max(customer.cust_id) AS Expr1 FROM customer;)));";
					  
				PreparedStatement Record = conn.prepareStatement(qry);
				ResultSet rs = Record.executeQuery(); // execute query
				rs.next();	int i = rs.getRow();
				
			t7.setText(""+ (rs.getInt("cust_Id") + 1));
				t7.setEditable(false);
	  			  conn.close();
		    }
			catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			}
        
       }
        
   public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==b1)
    	 {
    	 	String mn = t1.getText().trim(); // member Name
    	 	String mp = t2.getText().trim(); // member profession
    	 	String me = t3.getText().trim(); // member email
    	 	String mnt = t4.getText().trim(); // member nationality
    	 	String mph= t5.getText().trim(); // member phone
    	 	String mpl= t6.getText().trim(); // member place
    	 	String madd= t8.getText().trim(); // member addr
    	 	String dt= txtdt.getText().trim(); // member Date
    	 	
  			try
			{
				if (conn!= null)
	            	conn.close(); 
				conn = ConnectTODB.getConnection();
					if(mn.equals("") || madd.equals("") || mp.equals("") ||me.equals("") || mnt.equals(""))// || mpl.equals("")|| madd.equals(""))
					{
						String msg = "Please fill all Necessory Data";
				      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
				      			JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{ 						
								// Query for Inserting record
					        String qry="INSERT INTO customer(cust_name,cust_addr,cust_prof,cust_email,nationality,cust_ph,cust_place,entry_Date)"+
					        		   "VALUES(?,?,?,?,?,?,?,?)";
					      	PreparedStatement Insert_Record=conn.prepareStatement(qry);
					      	Insert_Record.setString(1,mn);
					      	Insert_Record.setString(2,madd);
					      	Insert_Record.setString(3,mp);
							Insert_Record.setString(4,me);
					      	Insert_Record.setString(5,mnt);
					      	Insert_Record.setString(6,mph);
						    Insert_Record.setString(7,mpl);
						    Insert_Record.setString(8,dt);
							Insert_Record.execute(); 
							
							String msg = "Record Saved Sucessfully!";
					      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
					      			JOptionPane.INFORMATION_MESSAGE);
				      	    conn.close();
							
				    	    t1.setText("");t2.setText("");t3.setText("");
				    	    t4.setText("");t5.setText("");t6.setText("");
				    	    t8.setText("");t1.requestFocus();
			    	}
		    }
			catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			}
    	 }
       	if(ae.getSource()==b2)
    	 {
    	    t1.setText("");t2.setText("");t3.setText("");
    	    t4.setText("");t5.setText("");t6.setText("");
    	    t8.setText("");t1.requestFocus();
    		
    	 }
   
    	if(ae.getSource()==b3)
    	 {
    	    dispose();
    	    
    	 }
      }    
  }   
        
    
 class addmember
{
	public static void main(String args[])
	{
		addmemb mb=new addmemb();
	}
}		
