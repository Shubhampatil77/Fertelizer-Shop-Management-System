/* =========================================================
 * Class	: searchcustomer
 * Purpose  : To search customer present or mot
 * ======================================================== */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.*;

class Mycls extends JFrame implements ActionListener
 {
 	 Container c1=getContentPane();
 	 JLabel l1,l2,l3;
 	 JButton b1,b2,b3;
 	 JTextField t1;
 	 Font f,f1;
 	 Connection conn; ResultSet rs;
 	 Mycls()
 	  {
 	  	 super("Agro Servises");
 	  	 setLayout(null);
 	  	 f=new Font("Arial",Font.BOLD+Font.ITALIC,16);
     	 f1=new Font("Bell MT",Font.BOLD+Font.ITALIC,30);
 	  	 l1=new JLabel("Search Customer");
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
         
         b1=new JButton("Search");
         b1.setMnemonic('S');
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
 public void actionPerformed(ActionEvent e)
  {
  	 if(e.getSource()==b1)
 		{
 	 	  	String M_ID = t1.getText().trim();
			String qry = "";
			try
			{
				if(conn!= null)
					conn.close();
				conn = ConnectTODB.getConnection();
				// Query for Searching record
		        qry = "SELECT customer.cust_Id, customer.cust_name,customer.cust_addr,"+
		              "customer.cust_prof, customer.cust_email, customer.nationality,"+
		              "customer.cust_ph, customer.cust_place FROM customer "+
		              "WHERE (((customer.cust_Id)="+M_ID+"));";
		        
		        PreparedStatement Record = conn.prepareStatement(qry);
				ResultSet rs = Record.executeQuery(); // execute query
				rs.next();	int i = rs.getRow();
				if(i == 0) // There is no record
				{
					String msg = "There is no Member to display.";
		    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Servises",
		    	  			JOptionPane.ERROR_MESSAGE);
		    	  	conn.close();
		    	}
		 	   	else
		   	 	{
		   	 		 dispose();
		   	 	dispmemb md=new dispmemb();
   	   	 			md.setVisible(true);
   	   	 			md.t1.setText(rs.getString(2));
   	   	 			md.t8.setText(rs.getString(3));
   	   	 			md.t2.setText(rs.getString(4));
   	   	 			md.t3.setText(rs.getString(5));
   	   	 			md.t4.setText(rs.getString(6));
   	   	 			md.t5.setText(rs.getString(7));
   	   	 			md.t6.setText(rs.getString(8));
   	   	 			md.t7.setText(rs.getString(9));
   	   	 			md.b1.setText("Exit");
   	   	 			conn.close();
		    	}			
			} // End of try
			catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			} // End of catch		
 	 	}
 	 	else
 	 	  if(e.getSource()==b2)
 	 	   {
 	 	   	 t1.setText("");
 	 	   	
 	 	   } 
 	 	 else
 	 	  if(e.getSource()==b3)
 	 	   {
 	 	   	 dispose();
 	 	   	
 	 	   } 
 	 }  
 }
class searchmember 
 {
 	 public static void main(String args[])
 	  {
 	  	 Mycls c=new Mycls();
 	  }
 }