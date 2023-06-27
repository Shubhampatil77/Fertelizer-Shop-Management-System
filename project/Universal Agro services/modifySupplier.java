/* =========================================================
 * Class	:modifysupplier
 * Purpose  : To modify the  supplier
 * ======================================================== */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;


class modsupp extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l11,l12,l13,img1,dt;
	JTextField t1,t2,t3,t4,t5,t6,t7,txtdt;
	JTextArea t8;
	JButton b1,b2,b3;
	Font f1=new Font("Bell MT",Font.BOLD+Font.ITALIC,30);
	Container c1=getContentPane();
	Connection conn;
	ResultSet rs;
	modsupp()
	{
		super("SUPPLIER ENTRY");
		setLayout(null);
		l11=new JLabel("SUPPLIER ENTRY");
		l11.setBounds(110,20,300,60);
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
		
		l1=new JLabel("Name:");
		l1.setBounds(30,160,130,30);
		c1.add(l1);
		
		l2=new JLabel("Address:");
		l2.setBounds(300,220,270,30);
		c1.add(l2);
		
		l3=new JLabel("Company:");
		l3.setBounds(30,220,130,30);
		c1.add(l3);
		
		l4=new JLabel("Mobile No:");
		l4.setBounds(30,270,130,30);
		c1.add(l4);
		
		l5=new JLabel("Place:");
		l5.setBounds(30,320,130,30);
		c1.add(l5);
		
		l6=new JLabel("Supplier no:");
		l6.setBounds(30,90,100,30);
		c1.add(l6);
		
		dt=new JLabel("Date:");
		dt.setBounds(300,90,100,30);
		c1.add(dt);
		
		/*
		l7=new JLabel("Place:");
		l7.setBounds(350,270,100,30);
		c1.add(l7);*/
		
		t1=new JTextField();
		t1.setBounds(110,100,130,20);
		c1.add(t1);
		
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
                    t2.setText("");
                    JOptionPane.showMessageDialog((Component)null,"Enter Only Characters","Agro Services",JOptionPane.INFORMATION_MESSAGE);
             
             	}
             }
          });	
		
		t3=new JTextField();
		t3.setBounds(110,280,130,20);
		c1.add(t3);
		t3.addKeyListener(new KeyAdapter() 
			{
        		public void keyPressed(KeyEvent EVT) 
        		{     
	        		String value = t3.getText();
	                int l = value.length();
	                if(l<10)
	                {            	
	                if (EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' ||EVT.getKeyChar()=='\b')               
	                {
	                	t3.setEditable(true);
	                }
	                else 
	                {
	                    t3.setEditable(true);
	                    t3.setText("");
	                    JOptionPane.showMessageDialog((Component)null,"Enter Only Numbers","Agro Services",JOptionPane.INFORMATION_MESSAGE);
	             	}
	          		}
	             	else
	             		JOptionPane.showMessageDialog((Component)null,"Enter Only 10 Numbers","Agro Services",JOptionPane.INFORMATION_MESSAGE);
         		}

         	});
		
	
			
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
                    t4.setText("");
                    JOptionPane.showMessageDialog((Component)null,"Enter Only Characters","Agro Services",JOptionPane.INFORMATION_MESSAGE);
             
             	}
             }
          });
		  
			
		t5=new JTextField();
		t5.setBounds(110,160,300,20);
		c1.add(t5);
			t5.addKeyListener(new KeyAdapter() 
		{
        	public void keyPressed(KeyEvent EVT) 
        	{
                                
        		String value = t5.getText();
                int l = value.length();
                if (EVT.getKeyChar() >= 'a' && EVT.getKeyChar() <= 'z' ||EVT.getKeyChar() >= 'A' && EVT.getKeyChar() <= 'Z'|| EVT.getKeyChar()=='\b'|| EVT.getKeyChar()==' '|| EVT.isShiftDown()==true)               
                {
                	t5.setEditable(true);
                    //System.out.println("Error");
                }
                else 
                {
                    t5.setEditable(true);
                    t5.setText("");
                    JOptionPane.showMessageDialog((Component)null,"Enter Only Characters","Agro Services",JOptionPane.INFORMATION_MESSAGE);
             
             	}
             }
          });
		
			
		t8=new JTextArea();
        		t8.setBounds(380,220,200,60);
        		c1.add(t8);
        		t8.setBorder(BorderFactory.createLineBorder(Color.black,1));
        		
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
		txtdt.setBounds(350,90,130,20);
		txtdt.setEditable(false);
		txtdt.setText(dt+"/"+month+"/"+ye);
		c1.add(txtdt);
     
     	   b1=new JButton("Modify");
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
        
        t1.addKeyListener(new KeyAdapter() 
		{
        	public void keyPressed(KeyEvent EVT) 
        	{
	    		if(!t1.getText().equals(""))
				{
				 String s_ID = t1.getText().trim();
			String qry = "";
			try
			{
				if(conn!= null)
					conn.close();
				conn = ConnectTODB.getConnection();
				// Query for Searching member name
		        qry = "SELECT supplier.sname,supplier.saddress,supplier.scompany,supplier.smob,supplier.splace FROM supplier "+
		              "WHERE (((supplier.sid)="+s_ID+"));";
		        
		        PreparedStatement Record = conn.prepareStatement(qry);
				ResultSet rs = Record.executeQuery(); // execute query
				rs.next();	int i = rs.getRow();
				if(i == 0) // There is no record
				{
					String msg = "There is no supplier to display.";
		    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
		    	  			JOptionPane.ERROR_MESSAGE);
		    	  	conn.close();
		    	  	t1.requestFocus();
		    	}
		 	   	else
		 	   	{
		 	   		t1.setEditable(false);
		   	 	    t5.setText(rs.getString(1));
		   	 	    t8.setText(rs.getString(2));
		   	 	    t2.setText(rs.getString(3));
		   	 	    t3.setText(rs.getString(4));
		   	 	    t4.setText(rs.getString(5));
		   	 	    
		   	 	    
    	   			 t5.setEditable(true);
    	   			 t2.setEditable(true);
    	   			 t3.setEditable(true);
    	   			 t4.setEditable(true);
    	   			 t8.setEditable(true);
		   	 	    
		   	 	}    
		   	 	    
					
		     	}	// End of try
		 	catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			} // End of catch			
		 }				
	   } 
	});
	
				t1.setEditable(true);
    	   			 t5.setEditable(false);
    	   			 t2.setEditable(false);
    	   			 t3.setEditable(false);
    	   			 t4.setEditable(false);
    	   			 t8.setEditable(false);
	  	
		setSize(630,500);
		setVisible(true);	            
       }
        
   public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource()==b1)
    	 {
    	 	String sn = t5.getText().trim(); // Supplier Name
    	 	String sc = t2.getText().trim(); // Supplier company
    	 	String smb = t3.getText().trim(); // Supplier mob no
    	 	String sp = t4.getText().trim(); // Supplier place
    		String sadd= t8.getText().trim(); // Supplier addr
  			try
			{
				if (conn!= null)
	            	conn.close(); 
				conn = ConnectTODB.getConnection();
					if(sn.equals("") || sadd.equals("") || sp.equals("") || smb.equals("") || sc.equals(""))  // || mpl.equals("")|| madd.equals(""))
					{
						String msg = "Please fill all Necessory Data";
				      	JOptionPane.showMessageDialog((Component)null,msg,"Agro servises",
				      			JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{ 	
						String s_ID = t1.getText().trim();
						// Query for Inserting record
				        String qry="UPDATE supplier Set sname=?,saddress=?,"+
			        		   "scompany=?,smob=?,splace=?"+
			        		   " WHERE supplier.sid="+s_ID+";";
			                		   
					  PreparedStatement Update_Record=conn.prepareStatement(qry);
					Update_Record.setString(1,sn);			        		   
			      	Update_Record.setString(2,sadd);
			      	Update_Record.setString(3,sc);
			      	Update_Record.setString(4,smb);
			      	Update_Record.setString(5,sp);
			      				      	
					Update_Record.execute(); // execute query
					String msg = "Record Updated Sucessfully!";
			      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Servises",
			      			JOptionPane.INFORMATION_MESSAGE); 
		      	    
		      	    t1.setText("");t2.setText("");t3.setText("");
    				 t4.setText("");t5.setText("");
    			    t8.setText("");t1.requestFocus();
    	   			 
    	   			 t1.setEditable(true);
    	   			 t5.setEditable(false);
    	   			 t2.setEditable(false);
    	   			 t3.setEditable(false);
    	   			 t4.setEditable(false);
    	   			 t8.setEditable(false);
    	   			 conn.close();
    	   			 
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
    				 t4.setText("");t5.setText("");
    			    t8.setText("");t1.requestFocus();
    	   			 
    	   			 t1.setEditable(true);
    	   			 t5.setEditable(false);
    	   			 t2.setEditable(false);
    	   			 t3.setEditable(false);
    	   			 t4.setEditable(false);
    	   			 t8.setEditable(false);
    		
    	 }
   
    	if(ae.getSource()==b3)
    	 {
    	    dispose();
    	    
    	 }
      }    
  }   
        
 class modsupplier
{
	public static void main(String args[])
	{
		modsupp msp =new modsupp();
	}
}		

  