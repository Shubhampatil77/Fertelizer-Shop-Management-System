/* =========================================================
 * Class	: removecompany
 * Purpose  : To remove the  company
 * ======================================================== */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
class removeComp extends JFrame implements ActionListener
 {
 	 Container c1=getContentPane();
 	 JLabel l1,l2,l3;
 	 JButton b1,b2,b3;
 	 JTextField t1;
 	 Font f,f1;
 	 Connection conn;
   	 ResultSet rs;
 	 
 	 removeComp()
 	  {
 	  	 super("Agro Servises");
 	  	 setLayout(null);
 	  	 f=new Font("Arial",Font.BOLD+Font.ITALIC,16);
     	 f1=new Font("Bell MT",Font.BOLD+Font.ITALIC,30);
 	  	 l1=new JLabel("Remove Company");
 	  	 l1.setFont(f1);
 	  	 l1.setBounds(40,7,550,35);
 	  	 c1.add(l1);
 	  	 l2 = new JLabel("____________________________________"+
						 "________________________________");
         l2.setForeground(Color.BLUE);	
		 
         l2.setBounds(0,10,400,50);
         c1.add(l2);
         l3=new JLabel("Company No.:");
         l3.setBounds(8,70,150,20);
         l3.setFont(f);
         c1.add(l3);
         t1=new JTextField();
         t1.setBounds(150,70,150,25);
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
         
         
         setSize(350,200);
         setVisible(true);						            
 	  }
 	public void actionPerformed(ActionEvent ae)
 	 {
 	 	if(ae.getSource()==b1)
         	{
          		String cno = t1.getText().trim(); 
    	 		try
			{
				if (conn!= null)
	            	conn.close(); 
				conn = ConnectTODB.getConnection();
					if(cno.equals(""))
					{
						String msg = "Please fill all Necessory Data";
				      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Servises",
				      			JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{ 
						try {
							 int compno = Integer.parseInt(cno);
							String qry1 = "SELECT company.comp_id,company.comp_name,company.comp_addr,"+
					              "company.comp_phone,company.comp_email,company.comp_city"+
					              " FROM company "+
					              "WHERE (((company.comp_id)="+compno+"));";
					        
						        PreparedStatement Record = conn.prepareStatement(qry1);
								ResultSet rs = Record.executeQuery(); // execute query
								rs.next();	int i = rs.getRow();
								if(i == 0) // There is no record
								{
									String msg = "There is no Company to display.";
						    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Servises",
						    	  			JOptionPane.ERROR_MESSAGE);
						    	  	conn.close();
						    	  	t1.setText("");
						    	}
						 	   	else
						   	 	{				
										// Query for Deleting record
							        String qry="DELETE * FROM company"+
							        	   	" WHERE company.comp_id="+compno+";";
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
 class removeCompany 
 {
 	 public static void main(String args[])
 	  {
 	  	 removeComp cs=new removeComp();
 	  }
 }
