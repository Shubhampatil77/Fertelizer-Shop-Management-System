import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class Report extends JFrame implements ActionListener
{
 
     JTabbedPane tb=new JTabbedPane();
     JPanel cust_report,supp_report,prod_report,comp_report;
     JTable tab1,tab2,tab3,tab4;
     
     JScrollPane jsp1,jsp2,jsp3;
     String[] colhead1={"cust_no","Name","Address","Profession","Email","Ph_No","Nationality","Date"};
     String[] colhead2={"Supp_no","Name","Address","Company","Mob_no","Place","Date"};
	 String[] colhead3={"Prod Id", "Name", "Weight_per_unit","Price","Available Quantity","Batch No.","Mfg Date","Exp Date","Date"};
	 String[] colhead4={"Comp Id", "Name", "Address","Ph_No","Email","City","Date"};


     Object[][] data1=new Object[25][10];
     Object[][] data2=new Object[25][10];
     Object[][] data3=new Object[25][10];
     Object[][] data4=new Object[25][10];
     
     Connection cn1;
     Statement stmt1,stmt2,stmt3,stmt4,st;
     ResultSet rs1,rs2,rs3,rs4,rs;
     int cnt1=0,cnt2=0,cnt3=0,cnt4=0;
     
     
     int[] count1=new int[65];
     
     public Report()
     {
     	super("REPORTS....!");
     	try
    	{
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
     	
     	Container c=getContentPane();
     	c.setLayout(null);
     	
     	cust_report=new JPanel();
     	cust_report.setLayout(null);
     		
	
        supp_report=new JPanel();
    	supp_report.setLayout(null);
    	
    	prod_report=new JPanel();
    	prod_report.setLayout(null);  	
        
        comp_report=new JPanel();
    	comp_report.setLayout(null);  	
        	
     	tb.addTab("Customer Report",cust_report);
     	tb.addTab("Supplier Report",supp_report);	
     	tb.addTab("Product Report",prod_report);
     	tb.addTab("Company Report",comp_report);
		tb.setBounds(100,80,850,500);
     	tb.setBorder(new LineBorder(Color.black,5));
     	c.add(tb);
     	
     	JButton b1=new JButton("HOME");
     	b1.setBounds(350,610,120,40);
     	b1.setMnemonic('H');
     	
     	b1.addActionListener(this);
     	c.add(b1);
     	 
     	 
     	JButton b2=new JButton("PRINT");
     	b2.setBounds(550,610,120,40);
     	b2.setMnemonic('p');
     	
     	b2.addActionListener(this);
     	c.add(b2);
     	 
     	Font f=new Font("algerian",4,50);
     	Font f1=new Font("Bell MT",Font.BOLD+Font.ITALIC,30);
     	JLabel l2=new JLabel("REPORTS");
     	l2.setForeground(Color.black);
     	l2.setFont(f1);
     	 
     	l2.setBounds(350,20,500,60);
     	c.add(l2);
     	
     	// Panel Customer	
     	try
     	{
     		if (cn1!= null)
	            	cn1.close(); 
				cn1 = ConnectTODB.getConnection();
	       	stmt1=cn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	       	rs1=stmt1.executeQuery("select * from customer");
	       	   
	       	    while(rs1.next())
	       	    {
	       	    	int j=0;
	       	    	for(int i=0;i<30;i++)
	       	    	{
	       	    		data1[i][j]=rs1.getString(1);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(2);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(3);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(4);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(5);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(7);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(6);
	       	    		j++;
	       	    		data1[i][j]=rs1.getString(9);
	       	    		j-=7;
	       	    		rs1.next();
	       	    	}
	       	    	
	       	    }
	       	   //rs1.close();
     	   }//try
       	   catch(SQLException kl)
       	   {
       	   	    System.out.println(kl);
       	   }
       	   catch(ArrayIndexOutOfBoundsException out)
       	   {
       	   		System.out.println(out);
       	   }  
       	   
       	// Panel Supplier
       	try
     	{
     		if (cn1!= null)
	            	cn1.close(); 
				cn1 = ConnectTODB.getConnection();
	       	stmt2=cn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	       	rs2=stmt2.executeQuery("select * from supplier");
	       	   
	       	    while(rs2.next())
	       	    {
	       	    	int j=0;
	       	    	for(int i=0;i<30;i++)
	       	    	{
	       	    		data2[i][j]=rs2.getString(1);
	       	    		j++;
	       	    		data2[i][j]=rs2.getString(2);
	       	    		j++;
	       	    		data2[i][j]=rs2.getString(3);
	       	    		j++;
	       	    		data2[i][j]=rs2.getString(4);
	       	    		j++;
	       	    		data2[i][j]=rs2.getString(5);
	       	    		j++;
	       	    		data2[i][j]=rs2.getString(6);
	       	    		j++;
	       	    		data2[i][j]=rs2.getString(7);
	       	    		j-=6;
	       	    		rs2.next();
	       	    	}
	       	    	
	       	    }
	       	   //rs1.close();
     	   }//try
       	   catch(SQLException kl)
       	   {
       	   	    System.out.println(kl);
       	   }
       	   catch(ArrayIndexOutOfBoundsException out)
       	   {
       	   		System.out.println(out);
       	   }  
       	   
       	   //PANEL product
       	try
     	{
     		if (cn1!= null)
	            	cn1.close(); 
				cn1 = ConnectTODB.getConnection();
	       	stmt3=cn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	       	rs3=stmt3.executeQuery("select * from product");
	       	   
	       	    while(rs3.next())
	       	    {
	       	    	int j=0;
	       	    	for(int i=0;i<30;i++)
	       	    	{
	       	  
	       	    		data3[i][j]=rs3.getString(1);
	       	    		j++;
	       	    		data3[i][j]=rs3.getString(2);
	       	    		j++;
	       	    		data3[i][j]=rs3.getString(3);
	       	    		j++;
	       	    		data3[i][j]=rs3.getString(4);
	       	    		j++;
	       	    		data3[i][j]=rs3.getString(5);
	       	    		j++;
	       	    		data3[i][j]=rs3.getString(6);
	       	    		j++;
	       	    		data3[i][j]=rs3.getString(7);
	       	    		j++;
	       	    		data3[i][j]=rs3.getString(8);
	       	    		j++;
	       	    		data3[i][j]=rs3.getString(9);
	       	    		j-=8;
	       	    		rs3.next();
	       	    	}
	       	    	
	       	    }
	       	   //rs1.close();
     	   }//try
       	   catch(SQLException kl)
       	   {
       	   	    System.out.println(kl);
       	   }
       	   catch(ArrayIndexOutOfBoundsException out)
       	   {
       	   		System.out.println(out);
       	   }  
     	
     	//PANEL company
       	try
     	{
     		if (cn1!= null)
	            	cn1.close(); 
				cn1 = ConnectTODB.getConnection();
	       	stmt4=cn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	       	rs4=stmt4.executeQuery("select * from company");
	       	   
	       	    while(rs4.next())
	       	    {
	       	    	int j=0;
	       	    	for(int i=0;i<30;i++)
	       	    	{
	       	  
	       	    		data4[i][j]=rs4.getString(1);
	       	    		j++;
	       	    		data4[i][j]=rs4.getString(2);
	       	    		j++;
	       	    		data4[i][j]=rs4.getString(3);
	       	    		j++;
	       	    		data4[i][j]=rs4.getString(4);
	       	    		j++;
	       	    		data4[i][j]=rs4.getString(5);
	       	    		j++;
	       	    		data4[i][j]=rs4.getString(6);
	       	    		j++;
	       	    		data4[i][j]=rs4.getString(7);
	       	    		j-=6;
	       	    		rs4.next();
	       	    	}
	       	    	
	       	    }
	       	   //rs1.close();
     	   }//try
       	   catch(SQLException kl)
       	   {
       	   	    System.out.println(kl);
       	   }
       	   catch(ArrayIndexOutOfBoundsException out)
       	   {
       	   		System.out.println(out);
       	   } 
     	
       	  JTable tab1=new JTable(data1,colhead1);
     	  JScrollPane jsp1=new JScrollPane(tab1);
          jsp1.setBounds(10,30,800,480);
      	  cust_report.add(jsp1); 
          
          JTable tab2=new JTable(data2,colhead2);
          JScrollPane jsp2=new JScrollPane(tab2);
          jsp2.setBounds(10,30,800,480);
          supp_report.add(jsp2);
          
          JTable tab3=new JTable(data3,colhead3);
          JScrollPane jsp3=new JScrollPane(tab3);
          jsp3.setBounds(10,30,800,480);
          prod_report.add(jsp3);
          
          JTable tab4=new JTable(data4,colhead4);
          JScrollPane jsp4=new JScrollPane(tab4);
          jsp4.setBounds(10,30,800,480);
          comp_report.add(jsp4);
          
		  setSize(1024,700);
		  setLocation(5,5);
		  setVisible(true);
		 
   }
     
     public void actionPerformed(ActionEvent ae)
     {
     	  String st=ae.getActionCommand();
     	
     	 if(st.equals("HOME"))
     	  {
     	  	setVisible(false);
           // Home m = new Home();
	   		//m.setVisible(true);
     	  }    	  
     }
     public static void main(String m[])
     {
     	Report rp=new Report();
     }
}     