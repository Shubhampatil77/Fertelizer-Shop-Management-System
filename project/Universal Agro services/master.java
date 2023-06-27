/* =========================================================================
 * Class	: master
 * Purpose	: Main screen 
 * ========================================================================= */
import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class master extends JFrame implements ActionListener
 {
 	 Container c1=getContentPane();
 	 JMenuBar mbr;
 	 JMenu m1,m2,m3,m4,m5,m6,m7,m31,m8;
 	 Font f1;
 	 JMenuItem jsubmenu_Cust,jsubmenu_Prod, jsubmenu1,jmi1,jmi2,jmi3,jmi5,jmi7,jmi8,jmi9;
 	 JMenuItem jmi10,jmi11,jmi12,jmi13,jmi14 , js_cust1,js_cust2,js_cust3,js_cust4,js_prod1,js_prod2,js_prod3,js_prod4, js_supp1,js_supp2,js_supp3,js_supp4,js_comp1,js_comp2,js_comp3,js_comp4,js5,js6;
 	 JLabel img1,img2,img3,img4,img5,img6;
 	 
   public master()
   {  
   
      super("Agro Services");
      c1.setLayout(new BorderLayout());
      mbr=new JMenuBar();
      c1.add(mbr);
      f1=new Font("Arial",Font.BOLD,14);
      
   	 	img2 = new JLabel(new ImageIcon("home.bmp"));
	    img2.setBounds(0,0,500,500);
	    c1.add(img2);
	   
   	  m1=new JMenu("File    ");           mbr.add(m1);
   	  m1.setMnemonic('F');
   	  m31=new JMenu("User     ");   	  mbr.add(m31);
   	  m31.setMnemonic('U');
   	 
   	  m2=new JMenu("Master    ",true);    mbr.add(m2);
   	  m2.setMnemonic('M'); 
   	  //m8=new JMenu("Item     ",true);    mbr.add(m8);
   	  //m8.setMnemonic('I'); 
   	 
   	  m3=new JMenu("Transaction    ");    mbr.add(m3);
   	  m3.setMnemonic('T');
   	 
   	  m4=new JMenu("Report     ");         mbr.add(m4);
   	  m4.setMnemonic('R');
   	 
   	  m6=new JMenu("Utility    ");         mbr.add(m6);
   	  m6.setMnemonic('t'); 
   	 
   	  m5=new JMenu("Help    ");           mbr.add(m5);
   	  m5.setMnemonic('H');
   	  setJMenuBar(mbr);
   	 
   	  jmi1=new JMenuItem("Log Off"); 
   	  m1.add(jmi1);   	 
   	  jmi1.setMnemonic(KeyEvent.VK_L);
   	  KeyStroke ks=KeyStroke.getKeyStroke(KeyEvent.VK_L,KeyEvent.CTRL_MASK);
   	  jmi1.setAccelerator(ks);
   	 
   	  jmi2=new JMenuItem("Exit");    
   	  m1.add(jmi2); 
   	  jmi2.setMnemonic(KeyEvent.VK_X);
   	  KeyStroke ks1=KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_MASK);
   	  jmi2.setAccelerator(ks1);
   	 
   	  jmi3=new JMenuItem("User"); 
   	  m31.add(jmi3);   	  
   	  jmi3.setMnemonic(KeyEvent.VK_L);
   	  KeyStroke ks3=KeyStroke.getKeyStroke(KeyEvent.VK_U,KeyEvent.CTRL_MASK);
   	  jmi3.setAccelerator(ks3);
   	  
   	 JMenu jsubmenu_Comp=new JMenu("Company",true); m2.add(jsubmenu_Comp);
   	 JMenu jsubmenu_Supp=new JMenu("Supplier",true); m2.add(jsubmenu_Supp);
   	 JMenu jsubmenu_Prod=new JMenu("Product",true); m2.add(jsubmenu_Prod);
   	 JMenu jsubmenu_Cust=new JMenu("Customer",true); m2.add(jsubmenu_Cust); 
   	 	
   	 JMenu jsubmenu1=new JMenu("Bills",true); m3.add(jsubmenu1);
   	 js_cust1=new JMenuItem("Search Customer");
   	 js_cust2=new JMenuItem("Add New Customer");
   	 js_cust3=new JMenuItem("Remove Customer");
   	 js_cust4=new JMenuItem("Modify Customer");
   	 
   	 js_prod1=new JMenuItem("Search Product");
   	 js_prod2=new JMenuItem("Add New Product");
   	 js_prod3=new JMenuItem("Remove Product");
   	 js_prod4=new JMenuItem("Modify Product");
   	 
   	 js_supp1=new JMenuItem("Search Supplier");
   	 js_supp2=new JMenuItem("Add New Supplier");
   	 js_supp3=new JMenuItem("Remove Supplier");
   	 js_supp4=new JMenuItem("Modify Supplier");
   	 
   	 js_comp1=new JMenuItem("Search Company");
   	 js_comp2=new JMenuItem("Add New Company");
   	 js_comp3=new JMenuItem("Remove Company");
   	 js_comp4=new JMenuItem("Modify Company");
   	 
   	 js5=new JMenuItem("Prepare bill");
   	 js6=new JMenuItem("Sale bill");
   	 
   	 jsubmenu_Cust.add(js_cust1);
   	 jsubmenu_Cust.add(js_cust2);
   	 jsubmenu_Cust.add(js_cust3);
   	 jsubmenu_Cust.add(js_cust4);
   	 
   	 jsubmenu_Prod.add(js_prod1);
   	 jsubmenu_Prod.add(js_prod2);
   	 jsubmenu_Prod.add(js_prod3);
	 jsubmenu_Prod.add(js_prod4);
	 
   	 jsubmenu_Supp.add(js_supp1);
   	 jsubmenu_Supp.add(js_supp2);
   	 jsubmenu_Supp.add(js_supp3);
   	 jsubmenu_Supp.add(js_supp4);
   	 
   	 jsubmenu_Comp.add(js_comp1);
   	 jsubmenu_Comp.add(js_comp2);
   	 jsubmenu_Comp.add(js_comp3);
   	 jsubmenu_Comp.add(js_comp4);
   	 
   	 jsubmenu1.add(js5);
   	 jsubmenu1.add(js6);
  
   	 jmi7=new JMenuItem("Calculator"); m6.add(jmi7);
   	 jmi8=new JMenuItem("Master Reports");   m4.add(jmi8);
   	/* jmi12=new JMenuItem("Supplier");   m4.add(jmi12);
   	 jmi13=new JMenuItem("Product");   m4.add(jmi13);
   	 jmi14=new JMenuItem("Company");   m4.add(jmi14);*/
   	// jmi9=new JMenuItem("Bill Book");  m4.add(jmi9);
   	 jmi10=new JMenuItem("Stock Detail");   m4.add(jmi10);
   	 jmi11=new JMenuItem("About Software..");  m5.add(jmi11);
   	 
   	  m1.setFont(f1);m2.setFont(f1);m3.setFont(f1);m4.setFont(f1);
   	  //m8.setFont(f1);
   	  m6.setFont(f1);m5.setFont(f1);
   	  m31.setFont(f1);
   	  	  	 
   	 jmi1.addActionListener(this);  jmi7.addActionListener(this);
   	 jmi2.addActionListener(this);  jmi8.addActionListener(this);
   	 jmi3.addActionListener(this); // jmi9.addActionListener(this);
   	 jmi10.addActionListener(this); jmi11.addActionListener(this); 
   	 /*jmi12.addActionListener(this); jmi14.addActionListener(this); */ 
   	 js6.addActionListener(this);
   	 js5.addActionListener(this);  
   	
   	 jsubmenu_Cust.addActionListener(this);
   	 jsubmenu_Prod.addActionListener(this);
   	 jsubmenu_Supp.addActionListener(this);
   	 jsubmenu_Comp.addActionListener(this);
   	 js_cust1.addActionListener(this);	
   	 js_cust2.addActionListener(this);
   	 js_cust3.addActionListener(this);
   	 js_cust4.addActionListener(this); 	  
   	
   	 js_prod1.addActionListener(this);	
   	 js_prod2.addActionListener(this);
   	 js_prod3.addActionListener(this);
   	 js_prod4.addActionListener(this);
   	 
   	 js_supp1.addActionListener(this);
   	 js_supp2.addActionListener(this);
   	 js_supp3.addActionListener(this);
   	 js_supp4.addActionListener(this);
   	 
   	 js_comp1.addActionListener(this);
   	 js_comp2.addActionListener(this);
   	 js_comp3.addActionListener(this);
   	 js_comp4.addActionListener(this);
   	 
   	 setSize(1000,1000);
   	 setVisible(true);
   }
  public void actionPerformed(ActionEvent e)
   {
   	 JMenuItem jmi=(JMenuItem)e.getSource();
   	
   	  if(jmi==jmi2)
   	  { 
   	    System.out.println("\n Thank You For Using Agro Services 1.0");
		System.out.println("\n\tSoftware Developed By");
		System.out.println("\t     Monika Bafna");
		System.out.println("\t     Pranali Sonje");
	
		
		System.exit(0);
	  }
   	 else
   	  if(jmi==jmi1)
   	   {
   	   	 dispose();
   	   	 Login1 l=new Login1();
   	   	 l.setVisible(true);
   	   }
   	   else
   	  if(jmi==jmi3)
   	   {
   	   	
   	   	String arg = (String)e.getActionCommand();
		Object obj = e.getSource();
		Functions Fun = new Functions();

	
			if(Fun.User_Type == 2)
			{
				String msg = "User not have authority to add new user.";
				int j = JOptionPane.showConfirmDialog
						((Component)null,msg,"Main Window : Agro Services",
						JOptionPane.DEFAULT_OPTION,
						JOptionPane.WARNING_MESSAGE);
			}
			else
			{
				User U = new User();
				U.setSize(400,400);
				c1.add(U);
				U.setVisible(true);
				U.setMaximizable(false);
				U.setBounds(250,150,500,350);
				U.setResizable(false);
				U.setClosable(true);
				U.setIconifiable(true);
				U.show();
			 }
   	   	   } 
   	      else
   	       if(jmi==js_cust1)
   	         {
   	   	 		//CustomerReport cr=new CustomerReport();
  	  			//cr.show();
   	   	       Mycls c=new Mycls();
   	   	       c.setVisible(true);
   	         } 
   	     else
   	      if(jmi==js_cust3)
   	         {
		   	  //  dispMemberRecord  mb=new dispMemberRecord();
   	   	 		//mb.setVisible(true);
   	   	 		CustomerReport cr=new CustomerReport();
  	  			cr.show();
   	   	 		remove cs=new remove();
   	   	 		cs.setVisible(true);  	 		
   	         } 
   	 	else
   	  if(jmi==js_cust2)
   	   {
   	   	 addmemb mf=new addmemb();
   	   	 mf.setSize(600,500);
   	   	 mf.setVisible(true);
   	   }
   	   else
   	  if(jmi==js_cust4)
   	   {
   	   	 modmemb mm=new modmemb();
   	   	 mm.setSize(600,500);
   	   	 mm.setVisible(true);
   	   }
   	   
   	     else
   	       if(jmi==js_prod1)
   	         {
   	   	 		//ProductReport pr=new ProductReport();
   	   			//pr.show (); 
   	   		
   	   	       MyclsItem c=new MyclsItem();
   	   	       c.setVisible(true);
   	         } 
   	     else
   	      if(jmi==js_prod3)
   	         {  
   	         	ProductReport pr=new ProductReport();
   	   			pr.show (); 
   	         	
   	         	delete del=new delete();
   	   			del.setVisible(true); 		
   	         } 
   	 	else
   	  if(jmi==js_prod2)
   	   {  
   	   		additem addi=new 	additem();
   	   		addi.show ();
   	   }
   	   	else
   	  if(jmi==js_prod4)
   	   {  
   	   		modProd mp =new modProd();
   	   		mp.show ();
   	   }
   	 	  
   	     else
   	       if(jmi==js_supp1)
   	         {
   	   	 	      //SupplierReport suppr=new SupplierReport();
   	   				//suppr.show ();	 	   		
   	   	       MyclsSupp s=new MyclsSupp();
   	   	       s.setVisible(true);
   	         } 
   	     else
   	      if(jmi==js_supp3)
   	         {   
   	         	SupplierReport suppr=new SupplierReport();
   	   				suppr.show ();
   	         	removesupp del=new removesupp();
   	   			del.setVisible(true);
   	   			   	 	
   	         } 
   	 	else
   	  if(jmi==js_supp2)
   	   {  
   	   		addsupp adds=new 	addsupp();
   	   		adds.show ();
   	   }
   	 	else
   	  if(jmi==js_supp4)
   	   {  
   	   		modsupp ms=new 	modsupp();
   	   		ms.show ();
   	   }  
   	    else
   	       if(jmi==js_comp1)
   	         {
   	   	 		//CompanyReport cr=new CompanyReport();
   	   			//cr.show ();
   	   	       MyclsComp c=new MyclsComp();
   	   	       c.setVisible(true);
   	         } 
   	     else
   	      if(jmi==js_comp3)
   	         {   
   	         	CompanyReport cr=new CompanyReport();
   	   			cr.show ();
   	         	removeComp del=new removeComp();
   	   			del.setVisible(true);
   	   	    }
   	 	else
   	  if(jmi==js_comp2)
   	   {  
   	   		addcmp addc=new addcmp();
   	   		addc.show ();
      	   }
   	   else
   	  if(jmi==js_comp4)
   	   {  
   	   		modcmp mc=new modcmp();
   	   		mc.show ();
      	   }
   	   
   	   else
   	    if(jmi==jmi7)
		{
			StringBuffer cmd = new StringBuffer();
			cmd.append("C:/WINDOWS/system32/Calc.exe");
			try {
				Runtime.getRuntime().exec(cmd.toString());
			}
    		catch (Exception ae) {
      			ae.printStackTrace();
      			System.out.println(cmd + " could not be executed.");
    		}
    	 				
		}
   	  else
   	  if(jmi==js5)
   	   {
   	   	 issueBill ib=new issueBill();
   	   	 ib.setVisible(true);
   	   } 
   	   else
   	  if(jmi==js6)
   	   {
   	   	 issueSaleBill ib=new issueSaleBill();
   	   	 ib.setVisible(true);
   	   } 
   	   
   	   else
   	  if(jmi==jmi11)
   	   {
   	   		About ab=new About();  	 
   	   	    ab.setVisible(true);
		    ab.show();
   	   }
   	 else 
   	 if(jmi==jmi8)
   	   {
   	   		Report rp=new Report();	
      } 
   
    else 
   	 if(jmi==jmi10)
   	   {
   	   	dispProductRecord dispitem = new dispProductRecord ();
   	   	dispitem.show ();
   	   } 
   } 	 
 
  public static void main(String args[])
  	  {
  	  	try 
        {
        	// For Set System Look & Feel ie Theme
        	 UIManager.setLookAndFeel
        		(UIManager.getSystemLookAndFeelClassName());
        } 
      	catch(Exception e) 
        { 
    	    System.out.println("Error Loading Theme:" + e.toString());
   		}
  	  	       master ms=new master();
	}
  
 }