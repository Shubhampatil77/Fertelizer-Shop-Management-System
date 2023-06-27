/* =========================================================
 * Class	: removecustomer
 * Purpose  : To remove the  customer
 * ======================================================== */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
class remove extends JFrame implements ActionListener
 {
 	 Container c1=getContentPane();
 	 JLabel l1,l2,l3;
 	 JButton b1,b2,b3;
 	 JTextField t1;
 	 Font f,f1;
 	 Connection conn;
   	 ResultSet rs;
 	 
 	 remove()
 	  {
 	  	 super("Fertilizer Department");
 	  	 setLayout(null);
 	  	 f=new Font("Arial",Font.BOLD+Font.ITALIC,16);
     	 f1=new Font("Bell MT",Font.BOLD+Font.ITALIC,30);
 	  	 l1=new JLabel("Remove Customer");
 	  	 l1.setFont(f1);
 	  	 l1.setBounds(40,7,400,35);
 	  	 c1.add(l1);
 	  	 l2 = new JLabel("____________________________________"+
						 "________________________________");
         l2.setForeground(Color.BLUE);	
		 
         l2.setBounds(0,10,400,50);
         c1.add(l2);
         l3=new JLabel("Ac No. :");
         l3.setBounds(30,70,100,20);
         l3.setFont(f);
         c1.add(l3);
         t1=new JTextField();
         t1.setBounds(100,70,150,25);
         c1.add(t1);
         
         b1=new JButton("Remove");
         b1.setMnemonic('R');
         b1.setBounds(10,130,80,20);
         c1.add(b1);
         
         b2=new JButton("Clear");
         b2.setMnemonic('C');
         b2.setBounds(100,130,80,20);
         c1.add(b2);
         
         b3=new JButton("Cancel");
         b3.setMnemonic('n');
         b3.setBounds(190,130,80,20);
         c1.add(b3);
         b1.addActionListener(this);
         b2.addActionListener(this);
         b3.addActionListener(this);
         
         
         setSize(300,200);
         setVisible(true);						            
 	  }
 	public void actionPerformed(ActionEvent ae)
 	 {
 	 	if(ae.getSource()==b1)
         {
          String mno = t1.getText().trim(); // member account no
    	 try
			{
				if (conn!= null)
	            	conn.close(); 
				conn = ConnectTODB.getConnection();
					if(mno.equals(""))
					{
						String msg = "Please fill all Necessory Data";
				      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Servises",
				      			JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{ 
						try {
							 int memno = Integer.parseInt(mno);
							String qry1 = "SELECT customer.cust_Id, customer.cust_name,customer.cust_addr,"+
					              "customer.cust_prof,customer.cust_email"+
					              " FROM customer "+
					              "WHERE (((customer.cust_Id)="+memno+"));";
					        
						        PreparedStatement Record = conn.prepareStatement(qry1);
								ResultSet rs = Record.executeQuery(); // execute query
								rs.next();	int i = rs.getRow();
								if(i == 0) // There is no record
								{
									String msg = "There is no Customer to display.";
						    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Servises",
						    	  			JOptionPane.ERROR_MESSAGE);
						    	  	conn.close();
						    	  	t1.setText("");
						    	}
						 	   	else
						   	 	{				
										// Query for Deleting record
							        String qry="DELETE * FROM customer"+
							        	   	" WHERE customer.cust_Id="+memno+";";
							        PreparedStatement Delete_Record=conn.prepareStatement(qry);
									Delete_Record.execute(); // execute query
									String msg = "Record Deleted Sucessfully!";
							      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Servises",
							      			JOptionPane.INFORMATION_MESSAGE);
						      	    conn.close();
						      	    t1.setText("");
						   	 	}
						} catch(NumberFormatException e1 ) {
								String msg = "Please fill numeric value..";
				      			JOptionPane.showMessageDialog((Component)null,msg,"Agro Servises..",
				      			JOptionPane.INFORMATION_MESSAGE);
				      			t1.setText("");
						}
			    	}
			    }
			catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			}
		   }	
          else
 	 	   if(ae.getSource()==b2)
 	 	   {
 	 	  	t1.setText("");
 	 	   }
 	 	 else
 	 	  if(ae.getSource()==b3)
 	 	   {
 	 	   	 dispose();
 	 	  	
 	 	   } 
 	 }  
  }
 class removemember 
 {
 	 public static void main(String args[])
 	  {
 	  	 remove cs=new remove();
 	  }
 }
