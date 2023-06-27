import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Login1 extends JFrame implements ActionListener
 {
 	JLabel l1,l2,l3,img;
 	JTextField t1,t2;
 	JButton b1,b2,b3;
 	Container c1=getContentPane();
 	Connection conn; ResultSet rs;
 	Font f1 = new Font("Arial",Font.PLAIN,14);
 	
 	public Login1()
 	 {
 	   super("Login : Agro Services");
 	   setBounds(300,200,400,300); 
 	   
 	   setVisible(true);
 	   setLayout(null);
 	   
 	  // Image img = getImage(getDocumentBase(),"bk.jpg");	   
 	   
 	   img=new JLabel(new ImageIcon("sss.jpg"));
 	   img.setBounds(8,0,90,90);
 	   c1.add(img); 
 	   
 	   l3=new JLabel("WEL-COME");
 	   l3.setBounds(120,20,500,30);
 	   Font f2=new Font("Bell MT",Font.BOLD+Font.ITALIC,30);
 	   l3.setFont(f2);
 	   c1.add(l3); 
 	   
 	   l1 = new JLabel("User Name  :");
       l1.setForeground(Color.black); 
       l1.setBounds(80,70,500,30);	
       l1.setFont(f1);	
	   c1.add(l1);
	    	 
	   l2 = new JLabel("Password   :");	
	   l2.setForeground(Color.black);							 	
       l2.setBounds(80,120,500,30);	
       l2.setFont(f1);
       c1.add(l2); 

       t1 = new JTextField();		
	   t1.setBounds(200,75,150,22);		
	   t1.setToolTipText("Enter your user name here.");
	   c1.add(t1);
	   t1.requestFocus();
	   
	   t2 = new JPasswordField();		
	   t2.setBounds(200,125,150,22);    
	   t2.setToolTipText("Enter your password here.");
       c1.add(t2);
		
	   JLabel lb = new JLabel("____________________________________"+
						            "____________________");
		
		lb.setForeground(Color.BLACK);
		lb.setBounds(0,125,400,125);
		c1.add(lb);
		
		
		b1 = new JButton("Ok");
		b1.setMnemonic('O'); 
		b1.setBounds(100,220,80,30);
		c1.add(b1);
		
		b2 = new JButton("Exit");
		b2.setMnemonic('x');	
		b2.setBounds(200,220,80,30);
		c1.add(b2);
					
		b1.addActionListener(this);
		b2.addActionListener(this);	 
		 setSize(410,310);
		 setVisible(true)   ;
 	}
 	
 	
 	public void actionPerformed(ActionEvent e)
 	 { 
 	  if(e.getSource()==b1)
 	   {
 	   	String usernm=t1.getText().trim();
 	   	String pswd=t2.getText().trim();
 	   	try
 	   	 {
 	   	 	 if(usernm.equals("") && pswd.equals(""))
 	   	 	  {
 	   	 	  	 String msg="Please Enter User name & password";
 	   	 	  	  int j = JOptionPane.showConfirmDialog
						(this,msg,"Login : Agro Services",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
					if(j == JOptionPane.OK_OPTION)
					{
						t2.setText(null);
						t1.setText(null);
						t1.requestFocusInWindow();
					}
					if(j == JOptionPane.CANCEL_OPTION)
					{
						System.exit(0);
					}
 	   	 	  }
 	   	 	  if (conn!= null)
                	conn.close();    
    			conn = ConnectTODB.getConnection();
    			// Query for checking user
                String qry = "Select User_Password,User_Type,User_ID"+
                			 " From Login Where User_Name="+"'"+usernm+"'";
              	PreparedStatement Check_User = conn.prepareStatement(qry);
              	//chku.setString(1,usernm);
				ResultSet rs = Check_User.executeQuery(); // execute query
              	rs.next();
				int i = rs.getRow();
				if(i == 0) // User Does not exist
				{
					String msg = "User "+"'"+usernm+"'"+" dose not exist.";
					int j = JOptionPane.showConfirmDialog
						(this,msg,"Login : Agro services",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.WARNING_MESSAGE);
					if(j == JOptionPane.OK_OPTION)
					{
						conn.close();
						t2.setText(null);
						t1.setText(null);
						t1.requestFocusInWindow();
					}
					if(j == JOptionPane.CANCEL_OPTION)
					{
						conn.close();
						System.exit(0);
					}
				}
				else
				if(i > 0) // User exist
				{
					String UserPass = rs.getString(1);
				//	Functions Fun = new Functions();
					if(pswd.equalsIgnoreCase(UserPass))
					{
						// Password Match grant Access.
						String msg = "Succesful Login.";
						int j = JOptionPane.showConfirmDialog
							(this,msg,"Login : Agro Services",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
						if(j == JOptionPane.OK_OPTION)
						{					
							// Exit Login and display main window
							dispose();
							master MW = new master();
							MW.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							MW.setExtendedState(JFrame.MAXIMIZED_BOTH);
							MW.setVisible(true);
							MW.setResizable(false);
						}
					}
					else
					{
						// Password not Match.
						String msg = "Password dose not match.";
						int j = JOptionPane.showConfirmDialog
							(this,msg,"Login : Agro Services",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.WARNING_MESSAGE);
						if(j == JOptionPane.OK_OPTION)
						{
							conn.close();
							t2.setText(null);
							t1.setText(null);
							t1.requestFocusInWindow();
						}
						if(j == JOptionPane.CANCEL_OPTION)
						{
							conn.close();
							System.exit(0);
						}
					}
 	   	 	  
 	   	 		}
 	   	 	}
 	   	catch(Exception e1){} 
 	
 	  }
 	  else
 	  if(e.getSource()==b2)
 	   {
 	   	 System.exit(0);
 	   } 
 	 }
  public static void main(String args[])
     {
     	Login1 l=new Login1();
     }     
  }