/* =========================================================================
 * Class	: User
 * Purpose  : To get user name and User password from Administrator.
 * ========================================================================= */

import java.sql.*;
import java.util.Date;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import javax.swing.text.*;
import javax.swing.table.*;
import javax.sql.rowset.*;
import com.sun.rowset.*;
import java.awt.print.*;
 
class User extends JInternalFrame implements ActionListener
{
	JLabel l1,l2,l3,l4,l5;
	JTextField tf1,tf2; JPasswordField tf3;
	JComboBox cmb1; JButton b1,b2,b3,b4,b5;
	Font f1 = new Font("Times New Roman",Font.BOLD,22);
	JPanel panDescription,panComponent,panButton; Container c1; 
	Connection conn; ResultSet rs;
	int framemode = 0; // 1 : Addmode 2 : Editmode 3 : Viewmode
	
	public User()
	{
		super("Master : User");	setLayout(null); c1 = getContentPane();
	    c1.setBackground(Color.white);

		panDescription = new JPanel(); panComponent = new JPanel();
		panButton = new JPanel(); panDescription.setLayout(null);
		panComponent.setLayout(null); panButton.setLayout(null);
		panDescription.setBorder(new LineBorder(new Color(100,100,200),1,true));
		panComponent.setBorder(new LineBorder(new Color(100,100,200),1,true));
		panButton.setBorder(new LineBorder(new Color(100,100,200),1,true));
		panDescription.setBounds(0,0,492,60); 
		panComponent.setBounds(0,60,492,200);
		panButton.setBounds(0,260,492,60);
			    
		l1 = new JLabel("Enter Login Detail of User");
		l2 = new JLabel("User ID		:");
		l3 = new JLabel("User Name		:");
		l4 = new JLabel("User Password	:");
		l5 = new JLabel("User Type		:");
		
		l1.setBounds(120,13,400,30); l2.setBounds(60,20,150,22);
		l3.setBounds(60,60,150,22);  l4.setBounds(60,100,150,22);
		l5.setBounds(60,140,150,22); l1.setFont(f1);
 
		tf1 = new JTextField();       tf2 = new JTextField();
		tf3 = new JPasswordField();   tf1.setBounds(200,20,100,22);
		tf2.setBounds(200,60,200,22); tf3.setBounds(200,100,200,22);
		
		b1 = new JButton("Add");		b1.setMnemonic('A');
		b2 = new JButton("Modify");		b2.setMnemonic('M');
		b3 = new JButton("Delete");		b3.setMnemonic('D');
		b4 = new JButton("Ok");			b4.setMnemonic('O');
		b5 = new JButton("Cancel");		b5.setMnemonic('C');
	
		
		b1.setToolTipText("Add");		b2.setToolTipText("Modify");
		b3.setToolTipText("Delete");	b4.setToolTipText("Ok");
		b5.setToolTipText("Cancel");	
				
		b1.setBounds(10,15,75,30); 		b2.setBounds(90,15,75,30);
		b3.setBounds(170,15,75,30);		b4.setBounds(10,15,75,30);
		b5.setBounds(90,15,75,30);	

		cmb1 = new JComboBox();			cmb1.setBounds(200,140,200,22);
		cmb1.addItem("Administrator");	cmb1.addItem("User");

		panDescription.add(l1); 		panComponent.add(l2);
		panComponent.add(l3); 			panComponent.add(l4);
		panComponent.add(l5);			panComponent.add(tf1);
		panComponent.add(tf2);			panComponent.add(tf3);
		panComponent.add(cmb1);			panButton.add(b1);
		panButton.add(b2);	panButton.add(b3);	panButton.add(b4);				
		panButton.add(b5);	
		
		c1.add(panDescription);c1.add(panComponent,"Center");c1.add(panButton);
		
		b1.addActionListener(this);		b2.addActionListener(this);
		b3.addActionListener(this);		b4.addActionListener(this);
		b5.addActionListener(this);	
		 
		framemode = 3; enabledisable_Button(framemode); // View Mode
		display_Record(4); // Display last records
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	 	if(ae.getSource() == b1) // Add is clicked.
	 	{
			framemode = 1;
			tf1.setText(null); tf2.setText(null); tf3.setText(null);
			enabledisable_Button(framemode); // Add Mode
			tf2.requestFocus();
		}
		
		if(ae.getSource() == b2) // Modify is clicked.
	 	{
			/*if(tf1.getText().equals(""))
			{
				String msg = "There is no User to Modify";
			      	JOptionPane.showMessageDialog((Component)null,msg,"Agro services",
			      		JOptionPane.INFORMATION_MESSAGE);		
			}
			else
			{
				tf1.setText(null); tf2.setText(null); tf3.setText(null);
				
				
				framemode = 2; enabledisable_Button(framemode); // Edit Mode
				tf1.requestFocus();
			}*/
			
			tf1.setText(null); tf2.setText(null); tf3.setText(null);
				
				
				framemode = 2; enabledisable_Button(framemode); // Edit Mode
				tf1.requestFocus();
				
		tf1.addKeyListener(new KeyAdapter() 
		{
        	public void keyPressed(KeyEvent EVT) 
        	{
	    		if(!tf1.getText().equals(""))
				{
				 String ID = tf1.getText().trim();
				String qry = "";
				try
				{
					if(conn!= null)
						conn.close();
					conn = ConnectTODB.getConnection();
					// Query for Searching member name
			         qry = "Select User_Name,User_Password,User_Type,User_ID"+
                			 " From Login Where User_ID="+""+ID+"";
			        
			        PreparedStatement Record = conn.prepareStatement(qry);
					ResultSet rs = Record.executeQuery(); // execute query
					rs.next();	int i = rs.getRow();
					if(i == 0) // There is no record
					{
						String msg = "There is no User to display.";
			    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
			    	  			JOptionPane.ERROR_MESSAGE);
			    	  	conn.close();
			    	  	tf1.requestFocus();
			    	}
			 	   	else
			 	   	{
			 	   		tf1.setEditable(false);
			   	 	    tf2.setText(rs.getString(1));
			   	 	    tf3.setText(rs.getString(2));
			   	 	    cmb1.setSelectedItem(rs.getString(3));
			   	 	    			   	 	    
			   	 	        tf2.setEditable(true);	
	    	    			tf3.setEditable(true);
	    	    			cmb1.setEnabled(true);
	    	    			
			   	 	}    

			    }	// End of try
			 	catch(SQLException sqle)
				{
					System.out.println("SQL Error"+sqle);
				} // End of catch			
		 }				
	   } 
	});
			
		}
		
		if(ae.getSource() == b5) // Cancel is clicked.
	 	{
			framemode = 3; enabledisable_Button(framemode); // View Mode
			display_Record(4); // Display Last Record
		}
		
		if(ae.getSource() == b4) // Ok is clicked
		{
			String un= tf2.getText().trim(); // User Name
			String up = tf3.getText().trim(); // User Password
			String ut = (String)cmb1.getSelectedItem(); // User Type
			if(un.equals("") || up.equals(""))
			{
				String msg = "Please fill all Necessory Data";
		      	JOptionPane.showMessageDialog((Component)null,msg,"Agro services",
		      			JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
			  try
			  {
				if (conn!= null)
	            	conn.close(); 
				conn = ConnectTODB.getConnection();
				if(framemode == 1) // Addmode
				{
					// Query for checking user
                String qry = "Select User_Name,User_Password,User_Type,User_ID"+
                			 " From Login Where User_Name="+"'"+un+"'";
              	PreparedStatement Check_User = conn.prepareStatement(qry);
              	//chku.setString(1,usernm);
				ResultSet rs = Check_User.executeQuery(); // execute query
              	rs.next();
				int i = rs.getRow();
				if(i == 0) // User Does not exist
				{
					
					// Query for Inserting record
			        String qry1="INSERT INTO Login(User_Name,User_Password,"+
			        		   "User_Type) VALUES(?,?,?)";
			      	PreparedStatement Insert_Record=conn.prepareStatement(qry1);
			      	Insert_Record.setString(1,un);Insert_Record.setString(2,up);
			      	Insert_Record.setString(3,ut);
					Insert_Record.execute(); // execute query
					String msg = "Record Saved Sucessfully!";
			      	JOptionPane.showMessageDialog((Component)null,msg,"Agro services",
			      			JOptionPane.INFORMATION_MESSAGE);
		      	    conn.close();
		      	    display_Record(4);
				}
				else 
				{
					String msg = "User Already exist...!!!";
			      	JOptionPane.showMessageDialog((Component)null,msg,"Agro services",
			      			JOptionPane.INFORMATION_MESSAGE);
				}
			    }
			    else if(framemode == 2) // Editmode
			    {
			        String qry="UPDATE Login Set User_Name=?,User_Password=?,"+
			        		   "User_Type=?"+
			        		   " WHERE Login.User_ID="+tf1.getText()+";";
			      	PreparedStatement Update_Record=conn.prepareStatement(qry);
					Update_Record.setString(1,un);			        		   
			      	Update_Record.setString(2,up);
			      	Update_Record.setString(3,ut);
					Update_Record.execute(); // execute query
					String msg = "Record Updated Sucessfully!";
			      	JOptionPane.showMessageDialog((Component)null,msg,"Agro services",
			      			JOptionPane.INFORMATION_MESSAGE); 
			      	conn.close();
			    }
			    else if(framemode == 4) // Delete mode
			    {
					    if(tf1.getText().equals(""))
						{
							String msg = "There is no User to Delete";
						      	JOptionPane.showMessageDialog((Component)null,msg,"Agro services",
						      			JOptionPane.INFORMATION_MESSAGE);		
						}
						else
						{
							String msg = "Are you sure!";
							int i = JOptionPane.showConfirmDialog
								(this,msg,"Agro services",JOptionPane.YES_NO_OPTION,
								JOptionPane.WARNING_MESSAGE);			
							if(i==JOptionPane.YES_OPTION)
							{
							  try
							  {
							  	if (conn!= null)
					            	conn.close(); 
								conn = ConnectTODB.getConnection();
						        String qry="DELETE * FROM Login"+
						        		   " WHERE Login.User_ID="+tf1.getText()+";";
						      	PreparedStatement Delete_Record=conn.prepareStatement(qry);
								Delete_Record.execute(); // execute query
								msg = "Record Deleted Sucessfully!";
						      	JOptionPane.showMessageDialog((Component)null,msg,"Agro services",
						      			JOptionPane.INFORMATION_MESSAGE); 			
								tf1.setText("");tf2.setText("");tf3.setText("");
								display_Record(4); // Display last records
								conn.close();
							  }
							  catch(SQLException sqle)
							  {
							   	System.out.println("SQL Error"+sqle);
							  }
							}
						}
			    }
			    
	      	    framemode = 3; enabledisable_Button(framemode);
	      	  }
			  catch(SQLException sqle)
			  {
				System.out.println("SQL Error"+sqle);
			  }
			}
		}
		
		if(ae.getSource() == b3) // Delete is clicked
		{

			tf1.setText(null); tf2.setText(null); tf3.setText(null);
				framemode = 4; enabledisable_Button(framemode); // Delete Mode
				tf1.requestFocus();
				
						tf1.addKeyListener(new KeyAdapter() 
						{
				        	public void keyPressed(KeyEvent EVT) 
				        	{
					    		if(!tf1.getText().equals(""))
								{
								 String ID = tf1.getText().trim();
								String qry = "";
								try
								{
									if(conn!= null)
										conn.close();
									conn = ConnectTODB.getConnection();
									// Query for Searching member name
							         qry = "Select User_Name,User_Password,User_Type,User_ID"+
				                			 " From Login Where User_ID="+""+ID+"";
							        
							        PreparedStatement Record = conn.prepareStatement(qry);
									ResultSet rs = Record.executeQuery(); // execute query
									rs.next();	int i = rs.getRow();
									if(i == 0) // There is no record
									{
										String msg = "There is no User to display.";
							    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
							    	  			JOptionPane.ERROR_MESSAGE);
							    	  	conn.close();
							    	  	tf1.requestFocus();
							    	}
							 	   	else
							 	   	{
							 	   		tf1.setEditable(false);
							   	 	    tf2.setText(rs.getString(1));
							   	 	    tf3.setText(rs.getString(2));
							   	 	    cmb1.setSelectedItem(rs.getString(3));
							   	 	    			   	 	    
							   	 	        tf2.setEditable(true);	
					    	    			tf3.setEditable(true);
					    	    			cmb1.setEnabled(true);
					    	    			
							   	 	}    
				
							    }	// End of try
							 	catch(SQLException sqle)
								{
									System.out.println("SQL Error"+sqle);
								} // End of catch			
						 }				
					   } 
					});
		}

	}
	
	void enabledisable_Button(int Frame_Mode)
	{
		if(Frame_Mode == 1)
		{	// Frame Mode is addmode 
			b1.setVisible(false); b2.setVisible(false);	b3.setVisible(false);
			b4.setVisible(true);  b5.setVisible(true);	
			tf1.setEditable(false);tf2.setEditable(true); tf3.setEditable(true); 
			cmb1.setEnabled(true);
			
			this.closable = false;
		}
		else if(Frame_Mode == 2)
		{	// Frame Mode is edit mode
			b1.setVisible(false); b2.setVisible(false);	b3.setVisible(false);
			b4.setVisible(true);  b5.setVisible(true);	
			tf1.setEditable(true);tf2.setEditable(false); tf3.setEditable(false); 
			cmb1.setEnabled(false);
			
			this.closable = false;
		}
		else 
		if(Frame_Mode == 3) // Frame Mode is view Mode
		{
			b1.setVisible(true);  b2.setVisible(true);  b3.setVisible(true);
			b4.setVisible(false); b5.setVisible(false);
			
			tf1.setEditable(false);tf2.setEditable(false);
			tf3.setEditable(false);cmb1.setEnabled(false);
			
			this.closable = true;
		}
		else if(Frame_Mode == 4)
		{	// Frame Mode is delete mode
			b1.setVisible(false); b2.setVisible(false);	b3.setVisible(false);
			b4.setVisible(true);  b5.setVisible(true);	
			tf1.setEditable(true);tf2.setEditable(false); tf3.setEditable(false); 
			cmb1.setEnabled(false);
			
			this.closable = false;
		}
	}
	
	// This method display the record according to button clicked in view mode.
	void display_Record(int flag)
	{
		String U_ID = tf1.getText().trim();
		if(framemode!=3)
		{
			tf1.setText(null);tf2.setText(null);tf3.setText(null);
		}
		String qry = "";
		try
		{
			if(conn!= null)
					conn.close();
			conn = ConnectTODB.getConnection();
			if(flag==1)
			{	// Query for Selecting First record
		        qry = "SELECT Login.*, Login.User_ID"+
					  " FROM Login WHERE (((Login.User_ID)="+
				      "(SELECT Min(Login.User_ID) AS Expr1 FROM Login;)));";
			}
			if(flag==2)
			{ 	// Query for Selecting Previous record
		      	qry = "SELECT Login.*, Login.User_ID FROM Login "+
					  "WHERE (((Login.User_ID)<"+U_ID+"))"+
					  " ORDER BY Login.User_ID DESC;";
			}
			if(flag==3)
			{	// Query for Selecting Next record
		      	qry = "SELECT Login.*, Login.User_ID FROM Login "+
					  "WHERE (((Login.User_ID)>"+U_ID+"))"+
					  "ORDER BY Login.User_ID;";
			}
			if(flag==4)
			{	// Query for Selecting Last record
		        qry = "SELECT Login.*, Login.User_ID"+
					  " FROM Login WHERE (((Login.User_ID)="+
					  "(SELECT Max(Login.User_ID) AS Expr1 FROM Login;)));";
			}
	      	PreparedStatement Record = conn.prepareStatement(qry);
			ResultSet rs = Record.executeQuery(); // execute query
			rs.next();	int i = rs.getRow();
			if(i == 0) // There is no record
			{
				String msg = "There is no user to display.";
		      	JOptionPane.showMessageDialog((Component)null,msg,"Agro services",
		      			JOptionPane.INFORMATION_MESSAGE);
		      	conn.close();
		    }
		    else
		    {
		    	tf1.setText((String)rs.getString("User_ID"));
		    	tf2.setText(rs.getString(2));
		    	tf3.setText(rs.getString(3));
		    	String UT =(String)rs.getString(4);
		    	if(UT.equals("Administrator"))
		    		cmb1.setSelectedIndex(0);
		    	else
		    		cmb1.setSelectedIndex(1);
		    	conn.close();
		    }				
		} // End of try
		catch(SQLException sqle)
		{
			System.out.println("SQL Error"+sqle);
		} // End of catch		
	} // End of display_Record
} // End of User Frame