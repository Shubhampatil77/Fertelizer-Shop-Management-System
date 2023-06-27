/* =========================================================
 * Class	: searchsupplier
 * Purpose  : To search supplier present or mot
 * ======================================================== */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import javax.sql.rowset.*;
import com.sun.rowset.*;

class MyclsSupp extends JFrame implements ActionListener
 {
 	 Container c1=getContentPane();
 	 JLabel l1,l2,l3;
 	 JButton b1,b2,b3;
 	 JTextField t1;
 	 Font f,f1;
 	 Connection conn; ResultSet rs;
 	 MyclsSupp()
 	  {
 	  	 super("Agro Servises");
 	  	 setLayout(null);
 	  	 f=new Font("Arial",Font.BOLD+Font.ITALIC,16);
     	 f1=new Font("Bell MT",Font.BOLD+Font.ITALIC,30);
 	  	 l1=new JLabel("Search Supplier");
 	  	 l1.setFont(f1);
 	  	 l1.setBounds(40,7,400,35);
 	  	 c1.add(l1);
 	  	 l2 = new JLabel("____________________________________"+
						            "________________________________");
         l2.setForeground(Color.BLUE);	
         l2.setBounds(0,10,400,50);
         c1.add(l2);
         l3=new JLabel("Supplier No. :");
         l3.setBounds(10,70,100,20);
         l3.setFont(f);
         c1.add(l3);
         t1=new JTextField();
         t1.setBounds(110,70,150,25);
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
 	 	  	String S_ID = t1.getText().trim();
			String qry = "";
			try
			{
				if(conn!= null)
					conn.close();
				conn = ConnectTODB.getConnection();
				// Query for Searching record
		        qry = "SELECT supplier.sid, supplier.sname,supplier.saddress,"+
		              "supplier.scompany, supplier.smob, supplier.splace"+
		              " FROM supplier "+
		              "WHERE (((supplier.sid)="+S_ID+"));";
		        
		        PreparedStatement Record = conn.prepareStatement(qry);
				ResultSet rs = Record.executeQuery(); // execute query
				rs.next();	int i = rs.getRow();
				if(i == 0) // There is no record
				{
					String msg = "There is no Supplier to display.";
		    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Servises",
		    	  			JOptionPane.ERROR_MESSAGE);
		    	  	conn.close();
		    	  	t1.setText("");
		    	}
		 	   	else
		   	 	{
		   	 		 dispose();
		   	 		dispsupp sd=new dispsupp();
   	   	 			sd.setVisible(true);
   	   	 			sd.t1.setText(rs.getString(2));
   	   	 			sd.t8.setText(rs.getString(3));
   	   	 			sd.t2.setText(rs.getString(4));
   	   	 			sd.t3.setText(rs.getString(5));
   	   	 			sd.t4.setText(rs.getString(6));
   	   	 		//	sd.t5.setText(rs.getString(7));
   	   	 		//	sd.t6.setText(rs.getString(8));
   	   	 		//	sd.t7.setText(rs.getString(9));
   	   	 			sd.b1.setText("Exit");
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
class searchsupplier
 {
 	 public static void main(String args[])
 	  {
 	  	 MyclsSupp c=new MyclsSupp();
 	  }
 }