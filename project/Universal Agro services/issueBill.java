/* ==============================================================
 * Class	: issueBill
 * Purpose  	: To give the bill.
 * ============================================================== */
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
class issueBill extends JFrame implements ActionListener
{
	Container c1=getContentPane();
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,bno,lbal;
    JTextField jt1,jt3,jt5,jt6,jt7,jt8,jt9,jt10,jt11,jt12,jt13,jt14,jt15,jt16,jt17,jt18,txtbno;
    JTextField jt19,jt20,jt21,jt22,jt25,jt28,jt29,jt30,jt31,jt32,jt33,jtb1,jtb2,jtb3,jtb4,jtpaid,jtbal;
    JButton b1,b2,b3,b4,b5;
    Font f,f1,f2;
    JTextField jt23,jt24,jt26,jt27,jt4,tdt;
    JComboBox jtype1,jtype2,jtype3,jtype4;
        
    int flag1=0,flag2=0,flag3=0,flag4=0,uflag1=0,uflag2=0,uflag3=0,uflag4=0;
    
    Date date=new Date();
    Date date1=new Date();
    String strDate;
     //String strDate1;
    int framemode = 0;   // 1 : Addmode 2 : Editmode 3 : Viewmode
    Connection conn;
   	ResultSet rs;
   	Statement st,st1;
   	
   issueBill()
    {
	   	 super("Item Purchase Bill");
	     setLayout(null); 
	     f=new Font("Arial",Font.BOLD+Font.ITALIC,16);
	     
		//     calendar.setTime(date);
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
     //String strDate=calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
     tdt=new JTextField();
     tdt.setText(dt+"/"+month+"/"+ye);
     tdt.setBounds(515,140,170,20);  
     	tdt.setEditable(false);
     c1.add(tdt); 
     l20=new JLabel("Date :");
     l20.setBounds(425,140,170,30); l20.setFont(f);
     c1.add(l20); 
     	
     bno=new JLabel("Bill No.:");
     bno.setBounds(25,140,170,30); bno.setFont(f);
     c1.add(bno); 
     	
     txtbno=new JTextField();
     txtbno.setBounds(100,140,170,20);
     c1.add(txtbno); 
    
     f1=new Font("Bell MT",Font.BOLD+Font.ITALIC,30);
     f2=new Font("Elephant",Font.BOLD+Font.ITALIC,30);
     
     l1 = new JLabel(new ImageIcon("l1.jpeg"));
     l2 = new JLabel("________________________________________________________________________"+
						            "_________________________________________________________________________");
  	 l3=new JLabel("Universal Fertilizers"); 
  	 l4=new JLabel("Department System"); 
	 l5=new JLabel("* BILL *");
	// l6=new JLabel("bill no");
	 l7=new JLabel("Supplier no.");
	 l7.setToolTipText("Enter Supplier name hear");
	 l8=new JLabel("Supplier name");
	 l8.setToolTipText("Enter Supplier no hear");
	 l9=new JLabel("Product");
	 l21=new JLabel("Batch No.");
 	 l10=new JLabel("Quantity");
     l11=new JLabel("wt per unit");
     l12=new JLabel("total wt");
     l13=new JLabel("prize per unit");
     l14=new JLabel("total prize"); 	
     l15=new JLabel("VAT(Total Prize*0.5)"); 	
     l16=new JLabel("add"); 
     l17=new JLabel("Paid Amt."); 
     lbal=new JLabel("Balance Amt.");
	 JLabel l18 = new JLabel("________________________________________________________________________"+
						            "___________________________________________________________________________");
	
	 l2.setForeground(Color.BLUE);
	 l18.setForeground(Color.BLUE);
	 b1=new JButton("Add");
	 b2=new JButton("clear");
	 b3=new JButton("List");
	 b4=new JButton("Print");
	 b5=new JButton("Home");
	 
	 b1.setBounds(20,550,100,30);     c1.add(b1); b1.setFont(f);
     b2.setBounds(150,550,100,30);    c1.add(b2); b2.setFont(f);
     b3.setBounds(280,550,100,30);    c1.add(b3); b3.setFont(f);
     b4.setBounds(410,550,100,30);    c1.add(b4); b4.setFont(f);
     b5.setBounds(540,550,80,30);     c1.add(b5); b5.setFont(f);
    
	 l1.setBounds(7,7,170,110);     c1.add(l1);
     l2.setBounds(0,90,1000,50);     c1.add(l2);
     l3.setBounds(250,5,600,50);    c1.add(l3);
     l4.setBounds(220,40,600,50);   c1.add(l4);
	 l5.setBounds(270,75,300,50);   c1.add(l5);
    // l6.setBounds(25,135,100,30);   c1.add(l6);
	 l7.setBounds(25,180,250,25);   c1.add(l7);
	 l8.setBounds(25,225,180,25);   c1.add(l8);
	 l9.setBounds(60,270,140,25);   c1.add(l9);
	 l21.setBounds(180,270,140,25); c1.add(l21);
	 l10.setBounds(270,270,140,25);
	 l11.setBounds(382,270,140,25);
	 l12.setBounds(495,270,140,25);
	 l13.setBounds(610,270,140,25);
	 l14.setBounds(730,270,140,25);
	 l15.setBounds(330,435,200,25);
	 l16.setBounds(650,435,140,25);
	 l17.setBounds(650,470,140,25);
	 lbal.setBounds(620,500,140,25);
     l18.setBounds(0,500,1000,50); 	 c1.add(l18);
     l3.setFont(f1);  l7.setFont(f); bno.setFont(f);
	 l4.setFont(f1);  l8.setFont(f); l21.setFont(f);
	 l5.setFont(f2);  l9.setFont(f);
	// l6.setFont(f);  
	 c1.add(l10);    l10.setFont(f);
     c1.add(l11);    l11.setFont(f);
     c1.add(l12);    l12.setFont(f);
     c1.add(l13);    l13.setFont(f);
     c1.add(l14);    l14.setFont(f);
     c1.add(l15);    l15.setFont(f);
     c1.add(l16);    l16.setFont(f);
     c1.add(l17);    l17.setFont(f); 
     c1.add(lbal);   lbal.setFont(f);
     // jt1=new JTextField();   c1.add(jt1);//bill no
      // jt1.setEditable(false);
      jt3=new JTextField();   c1.add(jt3);//Ac no
      jt3.requestFocus();
   	  jt4=new JTextField();   c1.add(jt4);//member name
      jt5=new JTextField();   c1.add(jt5);//unit 1
   	  jt6=new JTextField();   c1.add(jt6);//unit 2
   	  jt7=new JTextField();   c1.add(jt7);//unit 3 
   	  jt20=new JTextField();  c1.add(jt20);//unit total
   	  jt25=new JTextField(); c1.add(jt25);//unit 4 
      
      jt8=new JTextField();   c1.add(jt8);//wt per unit 1
      jt9=new JTextField();   c1.add(jt9);//wt per unit 2
      jt10=new JTextField();  c1.add(jt10);//wt per unit 3
      jt29=new JTextField();  c1.add(jt29);//wt per unit 4
      
      jt11=new JTextField();  c1.add(jt11);//total wt 1
      jt12=new JTextField();  c1.add(jt12);//total wt 2
      jt13=new JTextField();  c1.add(jt13);	//total wt 3
      jt33=new JTextField();  c1.add(jt33); //total wt 4
   	  
   	  jt14=new JTextField();  c1.add(jt14);//prize per unit 1
      jt15=new JTextField();  c1.add(jt15);//prize per unit 2
      jt16=new JTextField();  c1.add(jt16);//prize per unit 3
      jt21=new JTextField();  c1.add(jt21);//prize per unit 4
   	  
   	  jt17=new JTextField();  c1.add(jt17);//total prz 1
      jt18=new JTextField();  c1.add(jt18);//total prz 2
      jt19=new JTextField();  c1.add(jt19);//total prz 3
      jt22=new JTextField();  c1.add(jt22);//total prz 4
      
      /*jt23=new JTextField();  c1.add(jt23);//type 1
      jt24=new JTextField();  c1.add(jt24);//type 2
      jt27=new JTextField();  c1.add(jt27);//type 3
	  jt26=new JTextField();  c1.add(jt26); //type 4*/
	  
	  jtype1 = new JComboBox(); c1.add(jtype1);
	  jtype2 = new JComboBox(); c1.add(jtype2);
	  jtype3 = new JComboBox(); c1.add(jtype3);
	  jtype4 = new JComboBox(); c1.add(jtype4);
	  
	  jtb1=new JTextField();  c1.add(jtb1);//batch 1
	  jtb2=new JTextField();  c1.add(jtb2);//batch 2
	  jtb3=new JTextField();  c1.add(jtb3);//batch 3
	  jtb4=new JTextField();  c1.add(jtb4);//batch 4
      
      jt28=new JTextField();  c1.add(jt28); //prz tot 5
      jt30=new JTextField();  c1.add(jt30); //add potr
      
      jt31=new JTextField();  c1.add(jt31); //final tot
      jt32=new JTextField();  c1.add(jt32); //final tot
      jtbal=new JTextField();  c1.add(jtbal); //final balance
      /*jt31.setText("31");
      jt32.setText("32");
      jtbal.setText("jtbal");
      jt28.setText("28");
      jt30.setText("30");*/
   
   	jt28.setBounds(600,475,110,25);
   	jtype1.setBounds(30,295,110,20);
    jtype2.setBounds(30,319,110,20);
    jtype3.setBounds(30,343,110,20);
    jtype4.setBounds(30,367,110,20);
   	jt3.setBounds(150,180,140,20);
   	jt4.setBounds(150,225,290,20);
   	
   	jtb1.setBounds(144,295,110,20);
    jtb2.setBounds(144,319,110,20);
    jtb3.setBounds(144,343,110,20);
    jtb4.setBounds(144,367,110,20);
    
    jt5.setBounds(258,295,110,20);
    jt6.setBounds(258,319,110,20);
    jt7.setBounds(258,343,110,20);
    
   	jt8.setBounds(372,295,110,20);
    jt9.setBounds(372,319,110,20);
    jt10.setBounds(372,343,110,20);
    
    jt11.setBounds(486,295,110,20);
    jt12.setBounds(486,319,110,20);
    jt13.setBounds(486,343,110,20);
    
    jt14.setBounds(600,295,110,20);
    jt15.setBounds(600,319,110,20);
    jt16.setBounds(600,343,110,20);
    
    jt17.setBounds(730,295,110,20);
    jt18.setBounds(730,319,110,20);
    jt19.setBounds(730,343,110,20);
    
    jt20.setBounds(258,400,110,25);
    jt25.setBounds(258,367,110,20);
    jt29.setBounds(372,367,110,20);
    
    jt32.setBounds(486,435,110,25);
    jt33.setBounds(486,367,110,20);
    jtbal.setBounds(730,500,110,20);
    jt21.setBounds(600,367,110,20);
    
    jt22.setBounds(730,367,110,20);
    jt28.setBounds(730,400,110,25);
    jt30.setBounds(730,435,110,25);
    jt31.setBounds(730,470,110,25);
    
    jtbal.setEditable(false);
         
	b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);
    b4.addActionListener(this);
    b5.addActionListener(this);
   	setSize(920,650);
	setVisible(true);
	
	jtype1.addItem("NONE");
	jtype2.addItem("NONE");
	jtype3.addItem("NONE");
	jtype4.addItem("NONE");
	
	
				jtb1.setEditable(false);
		      	jt8.setEditable(false);
		      	jt11.setEditable(false);
		      	jt17.setEditable(false);
		      	jt14.setEditable(false);
		      			
		      	jtb2.setEditable(false);
      			jt9.setEditable(false);
      			jt12.setEditable(false);
      			jt18.setEditable(false);
      			jt15.setEditable(false);
		      			
				jtb3.setEditable(false);
      			jt10.setEditable(false);
      			jt13.setEditable(false);
      			jt19.setEditable(false);
      			jt16.setEditable(false);
      			
      			jtb4.setEditable(false);
      			jt29.setEditable(false);
      			jt33.setEditable(false);
      			jt22.setEditable(false);
      			jt21.setEditable(false);
      			
      			jt20.setEditable(false);
      			jt28.setEditable(false);
      			jt30.setEditable(false);
      			jt32.setEditable(false);
	
	try
			{
				if (conn!= null)
	            	conn.close(); 
				conn = ConnectTODB.getConnection();
				
	  			String qry = "SELECT po_header.*,po_header.po_no"+
					  " FROM po_header WHERE (((po_header.po_no)="+
					  "(SELECT Max(po_header.po_no) AS Expr1 FROM po_header;)));";
					  
				PreparedStatement Record = conn.prepareStatement(qry);
				ResultSet rs = Record.executeQuery(); // execute query
				rs.next();	int i = rs.getRow();
				
			txtbno.setText(""+ (rs.getInt("po_no") + 1));
				txtbno.setEditable(false);
	  			  conn.close();
		    }
			catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			}
			
			try
			{
				if (conn!= null)
	            	conn.close(); 
				conn = ConnectTODB.getConnection();
				
	  			String qry = "SELECT product.prod_id,product.prod_name,product.wt_per_unit,product.price,product.batch_no,product.mfg_date,product.exp_date"+
					  " FROM product";
					  
				st = conn.createStatement();
				ResultSet rs = st.executeQuery(qry); // execute query

				while(rs.next())
                 {
                    jtype1.addItem(rs.getString(2));
                   
                 }
				st.close();
				rs.close();
	  			  conn.close();
		    }
			catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			}
	
			try{  
					if (conn!= null)
	            		conn.close(); 
				conn = ConnectTODB.getConnection();
				
	  				String qry = "SELECT product.prod_id,product.prod_name,product.wt_per_unit,product.price,product.batch_no,product.mfg_date,product.exp_date"+
					  " FROM product";
					  
				st = conn.createStatement();
				ResultSet rs = st.executeQuery(qry); // execute query

				while(rs.next())
                 {
                    jtype2.addItem(rs.getString(2));
                    
                 }
				st.close();
				rs.close();
	  			  conn.close();
                    }
                    catch(Exception ex)
                    	{
                    		System.out.println("SQL Error"+ex);
                    	}

			try{  
					if (conn!= null)
	            		conn.close(); 
				conn = ConnectTODB.getConnection();
				
	  				String qry = "SELECT product.prod_id,product.prod_name,product.wt_per_unit,product.price,product.batch_no,product.mfg_date,product.exp_date"+
					  " FROM product";
					  
				st = conn.createStatement();
				ResultSet rs = st.executeQuery(qry); // execute query

				while(rs.next())
                 {
                    jtype3.addItem(rs.getString(2));
                    
                 }
				st.close();
				rs.close();
	  			  conn.close();
              }
              catch(Exception ex)
              {
                System.out.println("SQL Error"+ex);
              }
	
				try{  
						if (conn!= null)
		            		conn.close(); 
					conn = ConnectTODB.getConnection();
					
		  			String qry = "SELECT product.prod_id,product.prod_name,product.wt_per_unit,product.price,product.batch_no,product.mfg_date,product.exp_date"+
					  " FROM product";
						  
					st = conn.createStatement();
					ResultSet rs = st.executeQuery(qry); // execute query
	
					while(rs.next())
	                 {
	                    jtype4.addItem(rs.getString(2));
	                    
	                 }
					st.close();
					rs.close();
		  			  conn.close();
                }
                  catch(Exception ex)
                   {
                    		System.out.println("SQL Error"+ex);
                   }
	
	   jt3.requestFocus();
	   jt4.setEditable(false);
	   
	   jt3.addKeyListener(new KeyAdapter() 
		{
        	public void keyPressed(KeyEvent EVT) 
        	{
	    		if(!jt3.getText().equals(""))
				{
				 String s_ID = jt3.getText().trim();
			String qry = "";
			try
			{
				if(conn!= null)
					conn.close();
				conn = ConnectTODB.getConnection();
				// Query for Searching member name
		        qry = "SELECT supplier.sid,supplier.sname FROM supplier "+
		              "WHERE (((supplier.sid)="+s_ID+"));";
		        
		        PreparedStatement Record = conn.prepareStatement(qry);
				ResultSet rs = Record.executeQuery(); // execute query
				rs.next();	int i = rs.getRow();
				if(i == 0) // There is no record
				{
					String msg = "There is no Supplier to display.";
		    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
		    	  			JOptionPane.ERROR_MESSAGE);
		    	  	conn.close();
		    	  	jt3.requestFocus();
		    	}
		 	   	else
		   	 	    jt4.setText(rs.getString(2));
					
		     	}	// End of try
		 	catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			} // End of catch			
		 }				
	   } 
	});
	
	
	jtype1.addItemListener(new ItemListener()
		{
      		public void itemStateChanged(ItemEvent ie)
      		{ 
      				try
				{
				if(conn!= null)
					conn.close();
				conn = ConnectTODB.getConnection();
				// Query for Searching record
		        String qry = "SELECT product.prod_id, product.prod_name,"+
            			 " product.wt_per_unit, product.price, product.ava_qty,product.batch_no,product.mfg_date,product.exp_date"+
						 " FROM product WHERE product.prod_name='"+jtype1.getSelectedItem()+"'";
		        
		        PreparedStatement Record = conn.prepareStatement(qry);
				ResultSet rs = Record.executeQuery(); // execute query
				rs.next();	int i = rs.getRow();
				if(i == 0) // There is no record
				{
					String msg = "There is no Produt Info to display.";
		    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
		    	  			JOptionPane.ERROR_MESSAGE);
		    	}
		 	   	else
		 	   	{
		 	   	     	jtb1.setEditable(false);
		      			jt8.setEditable(false);
		      			jt11.setEditable(false);
		      			jt17.setEditable(false);
		      			jt14.setEditable(false);
      			
   	   	 			jt8.setText(rs.getString(3));
   	   	 			jt14.setText(rs.getString(4));
   	   	 			jtb1.setText(rs.getString(6));
   	   	 			
   	   	 			if(!jt5.getText().equals(""))
					{
	   	   	 			float jts5=Float.parseFloat(jt5.getText());
						float jts8=Float.parseFloat(jt8.getText());
						float jts11=(float)(jts5*jts8);
						jt11.setText(String.valueOf(jts11)); //total wt
					
						jts5=Float.parseFloat(jt5.getText());
						float jts14=Float.parseFloat(jt14.getText());
						float jts17=(float)(jts5*jts14);
						jt17.setText(String.valueOf(jts17));
						
						rs.close();	
				}
  	   	 			conn.close();
		    	}			
			} // End of try
			catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			} // End of catch
      			 
      		
      		}
		});
		
		jt14.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{				
				if(jt14.getText().equals(""))
				{
					jt14.setText("0");
				}
				else 
				{
						float jts5=Float.parseFloat(jt5.getText());
						float jts8=Float.parseFloat(jt8.getText());
						float jts11=(float)(jts5*jts8);
						jt11.setText(String.valueOf(jts11)); //total wt
					
						jts5=Float.parseFloat(jt5.getText());
						float jts14=Float.parseFloat(jt14.getText());
						float jts17=(float)(jts5*jts14);
						jt17.setText(String.valueOf(jts17));
				}
			}
		});
		
		jtype2.addItemListener(new ItemListener()
		{
      		public void itemStateChanged(ItemEvent ie)
      		{  
      			jtb2.setEditable(false);
      			jt9.setEditable(false);
      			jt12.setEditable(false);
      			jt18.setEditable(false);
      			
      			try
				{
				if(conn!= null)
					conn.close();
				conn = ConnectTODB.getConnection();
				// Query for Searching record
				String qry = "SELECT product.prod_id, product.prod_name,"+
            			 " product.wt_per_unit, product.price, product.ava_qty,product.batch_no,product.mfg_date,product.exp_date"+
						 " FROM product WHERE product.prod_name='"+jtype2.getSelectedItem()+"'";
				
		       		        
		        PreparedStatement Record = conn.prepareStatement(qry);
				ResultSet rs = Record.executeQuery(); // execute query
				rs.next();	int i = rs.getRow();
				if(i == 0) // There is no record
				{
					String msg = "There is no Product Info to display.";
		    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
		    	  			JOptionPane.ERROR_MESSAGE);
		    	}
		 	   	else
		 	   	{
		 	   	     	jtb2.setEditable(false);
		      			jt9.setEditable(false);
		      			jt12.setEditable(false);
		      			jt18.setEditable(false);
		      			jt15.setEditable(false);
      			
   	   	 			jt9.setText(rs.getString(3));
   	   	 			jt15.setText(rs.getString(4));
   	   	 			jtb2.setText(rs.getString(6));
   	   	 			
   	   	 			if(!jt6.getText().equals(""))
					{
	   	   	 			float jts6=Float.parseFloat(jt6.getText());
						float jts9=Float.parseFloat(jt9.getText());
						float jts12=(float)(jts6*jts9);
						jt12.setText(String.valueOf(jts12)); //total wt
					
						jts6=Float.parseFloat(jt6.getText());
						float jts15=Float.parseFloat(jt15.getText());
						float jts18=(float)(jts6*jts15);
						jt18.setText(String.valueOf(jts18));
						
						rs.close();	
				}
  	   	 			conn.close();
		    	}			
			} // End of try
			catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			} // End of catch
      			 
      		}
		});
		
		jt15.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{				
				if(jt15.getText().equals(""))
				{
					jt15.setText("0");
				}
				else 
				{
						float jts6=Float.parseFloat(jt6.getText());
						float jts9=Float.parseFloat(jt9.getText());
						float jts12=(float)(jts6*jts9);
						jt12.setText(String.valueOf(jts12)); //total wt
					
						jts6=Float.parseFloat(jt6.getText());
						float jts15=Float.parseFloat(jt15.getText());
						float jts18=(float)(jts6*jts15);
						jt18.setText(String.valueOf(jts18));
				}
			}
		});
		
			jtype3.addItemListener(new ItemListener()
		{
      		public void itemStateChanged(ItemEvent ie)
      		{  
      			jtb3.setEditable(false);
      			jt10.setEditable(false);
      			jt13.setEditable(false);
      			jt19.setEditable(false);
      			
      			try
				{
				if(conn!= null)
					conn.close();
				conn = ConnectTODB.getConnection();
				// Query for Searching record
		       String qry = "SELECT product.prod_id, product.prod_name,"+
            			 " product.wt_per_unit, product.price, product.ava_qty,product.batch_no,product.mfg_date,product.exp_date"+
						 " FROM product WHERE product.prod_name='"+jtype3.getSelectedItem()+"'";
		       		        
		        PreparedStatement Record = conn.prepareStatement(qry);
				ResultSet rs = Record.executeQuery(); // execute query
				rs.next();	int i = rs.getRow();
				if(i == 0) // There is no record
				{
					String msg = "There is no Product Info to display.";
		    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
		    	  			JOptionPane.ERROR_MESSAGE);
		    	}
		 	   	else
		 	   	{
		 	   	     	jtb3.setEditable(false);
		      			jt10.setEditable(false);
		      			jt13.setEditable(false);
		      			jt18.setEditable(false);
		      			jt19.setEditable(false);
      			
   	   	 			jt10.setText(rs.getString(3));
   	   	 			jt16.setText(rs.getString(4));
   	   	 			jtb3.setText(rs.getString(6));
   	   	 			
   	   	 			if(!jt7.getText().equals(""))
					{
	   	   	 			float jts7=Float.parseFloat(jt7.getText());
						float jts10=Float.parseFloat(jt10.getText());
						float jts13=(float)(jts7*jts10);
						jt13.setText(String.valueOf(jts13)); //total wt
					
						jts7=Float.parseFloat(jt7.getText());
						float jts16=Float.parseFloat(jt16.getText());
						float jts19=(float)(jts7*jts16);
						jt19.setText(String.valueOf(jts19));
						
						rs.close();	
				}
  	   	 			conn.close();
		    	}			
			} // End of try
			catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			} // End of catch
      		
      		}
		});
		
	
		
		jt16.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{				
				if(jt16.getText().equals(""))
				{
					jt16.setText("0");
				}
				else 
				{
						float jts7=Float.parseFloat(jt7.getText());
						float jts10=Float.parseFloat(jt10.getText());
						float jts13=(float)(jts7*jts10);
						jt13.setText(String.valueOf(jts13)); //total wt
					
						jts7=Float.parseFloat(jt7.getText());
						float jts16=Float.parseFloat(jt16.getText());
						float jts19=(float)(jts7*jts16);
						jt19.setText(String.valueOf(jts19));
				}
			}
		});
		
			jtype4.addItemListener(new ItemListener()
		{
      		public void itemStateChanged(ItemEvent ie)
      		{  
      			jtb4.setEditable(false);
      			jt29.setEditable(false);
      			jt33.setEditable(false);
      			jt22.setEditable(false);
      			
      			try
				{
				if(conn!= null)
					conn.close();
				conn = ConnectTODB.getConnection();
				// Query for Searching record
				String qry = "SELECT product.prod_id, product.prod_name,"+
            			 " product.wt_per_unit, product.price, product.ava_qty,product.batch_no,product.mfg_date,product.exp_date"+
						 " FROM product WHERE product.prod_name='"+jtype4.getSelectedItem()+"'";
				
		        PreparedStatement Record = conn.prepareStatement(qry);
				ResultSet rs = Record.executeQuery(); // execute query
				rs.next();	int i = rs.getRow();
				if(i == 0) // There is no record
				{
					String msg = "There is no Product Info to display.";
		    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
		    	  			JOptionPane.ERROR_MESSAGE);
		    	}
		 	   	else
		 	   	{
		 	   	     	jtb4.setEditable(false);
		      			jt29.setEditable(false);
		      			jt33.setEditable(false);
		      			jt22.setEditable(false);
		      			      			
   	   	 			jt29.setText(rs.getString(3));
   	   	 			jt21.setText(rs.getString(4));
   	   	 			jtb4.setText(rs.getString(6));
   	   	 			
   	   	 			if(!jt25.getText().equals(""))
					{
	   	   	 			float jts25=Float.parseFloat(jt25.getText());
						float jts29=Float.parseFloat(jt29.getText());
						float jts33=(float)(jts25*jts29);
						jt33.setText(String.valueOf(jts33)); //total wt
					
						jts25=Float.parseFloat(jt25.getText());
						float jts21=Float.parseFloat(jt21.getText());
						float jts22=(float)(jts25*jts21);
						jt22.setText(String.valueOf(jts22));
						
						rs.close();	
				}
  	   	 			conn.close();
		    	}			
			} // End of try
			catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			} // End of catch
      		
      		}
		});
		
		jt21.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{				
				if(jt21.getText().equals(""))
				{
					jt21.setText("0");
				}
				else 
				{
						float jts25=Float.parseFloat(jt25.getText());
						float jts29=Float.parseFloat(jt29.getText());
						float jts33=(float)(jts25*jts29);
						jt33.setText(String.valueOf(jts33)); //total wt
					
						jts25=Float.parseFloat(jt25.getText());
						float jts21=Float.parseFloat(jt21.getText());
						float jts22=(float)(jts25*jts21);
						jt22.setText(String.valueOf(jts22));
				}
			}
		});
	   
	   jt20.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt5.getText().equals(""))
				{
					float unit1s=Float.parseFloat(jt5.getText());
					float unit2s=Float.parseFloat(jt6.getText());
					float unit3s=Float.parseFloat(jt7.getText());
					float unit4s=Float.parseFloat(jt25.getText());
					float total=(float)(unit1s+unit2s+unit3s+unit4s);
					jt20.setText(String.valueOf(total));
					jt28.requestFocus();
				}
			}
		});        
	   
	   jt28.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt17.getText().equals(""))
				{
					float price1s=Float.parseFloat(jt17.getText());
					float price2s=Float.parseFloat(jt18.getText());
					float price3s=Float.parseFloat(jt19.getText());
					float price4s=Float.parseFloat(jt22.getText());
					float total1=(float)(price1s+price2s+price3s+price4s);
					jt28.setText(String.valueOf(total1));
					jt32.requestFocus();
				}
			}
		});
		
			jt30.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt32.getText().equals(""))
				{
					float tot28=Float.parseFloat(jt28.getText());
					float tot32=Float.parseFloat(jt32.getText());
					float finaltota=(float)(tot28+tot32);
					jt30.setText(String.valueOf(finaltota));
					jt31.requestFocus();				}
			}
		});
		
	jt31.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(jt30.getText().equals(""))
				{
					float jts130=Float.parseFloat(jt30.getText());
					jtbal.setText(String.valueOf(jts130));
					jtbal.requestFocus();					
				}
				else
				{
					float jts130=Float.parseFloat(jt30.getText());
					float jts131=Float.parseFloat(jt31.getText());
					float finalbal=(float)(jts130-jts131);
					jtbal.setText(String.valueOf(finalbal));
					jtbal.requestFocus();	
				}	
			}
		});	 
			
	   jt32.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt28.getText().equals(""))
				{
					float jts128=Float.parseFloat(jt28.getText());
					float jts122=(float)((jts128/100)*5);
					jt32.setText(String.valueOf(jts122));
					jt30.requestFocus();					
				}
			}
		});	
	   
	 jt5.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt5.getText().equals(""))
				{
					jt5.setText("0");
				}
			}
		});	    
		 jt8.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt8.getText().equals(""))
				{
					jt8.setText("0");
				}
			}
		});	    
		jt14.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt14.getText().equals(""))
				{
					jt14.setText("0");
				}
			}
		});	    
		 jt6.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt6.getText().equals(""))
				{
					jt6.setText("0");
				}
			}
		});	         
		
		
		 jt9.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt9.getText().equals(""))
				{
					jt9.setText("0");
				}
			}
		});	    
		 jt15.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt15.getText().equals(""))
				{
					jt15.setText("0");
				}
			}
		});	    
		jt7.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt7.getText().equals(""))
				{
					jt7.setText("0");
				}
			}
		});	    
		 jt10.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt10.getText().equals(""))
				{
					jt10.setText("0");
				}
			}
		});	         
		jt16.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt16.getText().equals(""))
				{
					jt16.setText("0");
				}
			}
		});	   
			jt25.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt25.getText().equals(""))
				{
					jt25.setText("0");
				}
			}
		});	      
			jt29.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt29.getText().equals(""))
				{
					jt29.setText("0");
				}
			}
		});	  
			jt21.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(jt21.getText().equals(""))
				{
					jt21.setText("0");
				}
			}
		});    
	 
	 	jt11.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(!jt5.getText().equals(""))
				{
					float jts5=Float.parseFloat(jt5.getText());
					float jts8=Float.parseFloat(jt8.getText());
					float jts11=(float)(jts5*jts8);
					jt11.setText(String.valueOf(jts11));
				}
			}
		});
	 jt17.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
								
				if(!jt5.getText().equals(""))
				{
					float jts5=Float.parseFloat(jt5.getText());
					float jts14=Float.parseFloat(jt14.getText());
					float jts17=(float)(jts5*jts14);
					jt17.setText(String.valueOf(jts17));
				}
			}
		});	
			jt12.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt6.getText().equals(""))
				{
					float jts6=Float.parseFloat(jt6.getText());
					float jts9=Float.parseFloat(jt9.getText());
					float jts12=(float)(jts6*jts9);
					jt12.setText(String.valueOf(jts12));
				}
			}
		});
	 jt18.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt6.getText().equals(""))
				{
					float jts6=Float.parseFloat(jt6.getText());
					float jts15=Float.parseFloat(jt15.getText());
					float jts18=(float)(jts6*jts15);
					jt18.setText(String.valueOf(jts18));
				}
			}
		});	
		jt13.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt7.getText().equals(""))
				{
					float jts7=Float.parseFloat(jt7.getText());
					float jts10=Float.parseFloat(jt10.getText());
					float jts13=(float)(jts7*jts10);
					jt13.setText(String.valueOf(jts13));
				}
			}
		});
	 jt19.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt7.getText().equals(""))
				{
					float jts7=Float.parseFloat(jt7.getText());
					float jts16=Float.parseFloat(jt16.getText());
					float jts19=(float)(jts7*jts16);
					jt19.setText(String.valueOf(jts19));
				}
			}
		});	
			jt33.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt25.getText().equals(""))
				{
					float jts25=Float.parseFloat(jt25.getText());
					float jts29=Float.parseFloat(jt29.getText());
					float jts33=(float)(jts25*jts29);
					jt33.setText(String.valueOf(jts33));
				}
			}
		});
	 jt22.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt25.getText().equals(""))
				{
					float jts25=Float.parseFloat(jt25.getText());
					float jts21=Float.parseFloat(jt21.getText());
					float jts22=(float)(jts25*jts21);
					jt22.setText(String.valueOf(jts22));
				}
			}
		});	
/*	jt20.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt5.getText().equals(""))
				{
					float unit1s=Float.parseFloat(jt5.getText());
					float unit2s=Float.parseFloat(jt6.getText());
					float unit3s=Float.parseFloat(jt7.getText());
					float unit4s=Float.parseFloat(jt25.getText());
					float total=(float)(unit1s+unit2s+unit3s+unit4s);
					jt20.setText(String.valueOf(total));
					jt28.requestFocus();
				}
			}
		});
	jt28.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt17.getText().equals(""))
				{
					float price1s=Float.parseFloat(jt17.getText());
					float price2s=Float.parseFloat(jt18.getText());
					float price3s=Float.parseFloat(jt19.getText());
					float price4s=Float.parseFloat(jt22.getText());
					float total1=(float)(price1s+price2s+price3s+price4s);
					jt28.setText(String.valueOf(total1));
					jt32.requestFocus();
				}
			}
		});
	jt32.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt20.getText().equals(""))
				{
					float jts120=Float.parseFloat(jt20.getText());
					float jts122=(float)(jts120*2.50f);
					jt32.setText(String.valueOf(jts122));
					jt30.requestFocus();					
				}
			}
		});	
	jt30.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt32.getText().equals(""))
				{
					float jts132=Float.parseFloat(jt32.getText());
					jt30.setText(String.valueOf(jts132));
					jt31.requestFocus();					
				}
			}
		});	 
	jt31.addFocusListener(new MyActionListener()
		{
			public void focusLost(FocusEvent e)
			{
				if(!jt30.getText().equals(""))
				{
					float tot28=Float.parseFloat(jt28.getText());
					float tot30=Float.parseFloat(jt30.getText());
					float finaltota=(float)(tot28+tot30);
					jt31.setText(String.valueOf(finaltota));
					b1.requestFocus();				}
			}
		});  */

       	}
 public void actionPerformed(ActionEvent e)
  {  
     if(e.getSource()==b1)
    	 {
     
	        String sid = jt3.getText().trim(); //Supplier id
    	 	String qty  = jt20.getText().trim();//bill qty
    	    String prz =  jt30.getText().trim();//item price
    	    String paid =  jt31.getText().trim();//paid
    	    String bal =  jtbal.getText().trim();//balance
    	    String txtdt = tdt.getText().trim();// date
    	 try
			{
				if (conn!= null)
	            	conn.close(); 
				conn = ConnectTODB.getConnection();
					if(sid.equals("")|| qty.equals("") || prz.equals("") || paid.equals("") || bal.equals(""))
					{
						String msg = "Please fill all Necessory Data";
				      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
				      			JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{ 	// Query for Inserting record
			        String qry="INSERT INTO po_header(qty,amount,sid,paid_amt,bal_amt,bill_date)"+
			        		   "VALUES(?,?,?,?,?,?)";			      
			        		   	PreparedStatement Insert_Record=conn.prepareStatement(qry);
			      	Insert_Record.setString(1,qty);
			       	Insert_Record.setString(2,prz);
			      	Insert_Record.setString(3,sid);
			      	Insert_Record.setString(4,paid);
			      	Insert_Record.setString(5,bal);
			      	Insert_Record.setString(6,txtdt);
					Insert_Record.execute(); // execute query
					
					String msg = "Record Inserted Sucessfully!";
			      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
			      			JOptionPane.INFORMATION_MESSAGE);
		      	    conn.close();
			    	}
		    }
			catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			}
			
			///Qry for prod1 insert and update qty
			try
			{
				int bno = Integer.parseInt(txtbno.getText());
				
				if (conn!= null)
	            	conn.close(); 
					conn = ConnectTODB.getConnection();
				
					if(jtype1.getSelectedItem().equals("NONE"))
					{
						String msg = "Please fill all Necessory Data";
				      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
				      			JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{ 	
						// Query for Inserting record
			        String qry1="INSERT INTO po_details(po_no,prod_name,qty)"+
			        		   "VALUES(?,?,?)";			      
			        PreparedStatement Insert_Record=conn.prepareStatement(qry1);
			      	Insert_Record.setString(1,bno+"");
			       	Insert_Record.setString(2,jtype1.getSelectedItem().toString());
			      	Insert_Record.setString(3,jt5.getText());
					Insert_Record.execute(); // execute query
					
					/*String msg1 = "PO Inserted Sucessfully!";
			      	JOptionPane.showMessageDialog((Component)null,msg1,"Agro Services",
			      			JOptionPane.INFORMATION_MESSAGE);*/
			      			flag1=1;
			      			
					 try
					{
						if (conn!= null)
			            	conn.close(); 
						conn = ConnectTODB.getConnection();
						
			  			String selqry = "SELECT product.prod_id,product.ava_qty"+
							  " FROM product WHERE product.prod_name='"+jtype1.getSelectedItem()+"'";
							  
						PreparedStatement Record = conn.prepareStatement(selqry);
						ResultSet rs = Record.executeQuery(); // execute query
						rs.next();	int i = rs.getRow();
						
						int ava_qty = rs.getInt("ava_qty");
						int updated_qty=Integer.parseInt(jt5.getText()) + ava_qty;
						
						String qry2="UPDATE product Set ava_qty=?"+
			        		   " WHERE product.prod_name='"+jtype1.getSelectedItem()+"';";
				                		   
						  PreparedStatement Update_Record=conn.prepareStatement(qry2);
						Update_Record.setString(1,updated_qty+"");			        		   
				      	
				      	
						Update_Record.execute(); // execute query
						/*String msg2 = "Record Updated Sucessfully!";
				      	JOptionPane.showMessageDialog((Component)null,msg2,"Agro Servises",
				      			JOptionPane.INFORMATION_MESSAGE); */
				      			uflag1=1;
							
				    }
					catch(SQLException sqle)
					{
						System.out.println("SQL Error"+sqle);
					}
					} 
				}
				catch(SQLException sqle)
				{
						System.out.println("SQL Error"+sqle);
				}
	  	
	      			/////////Qry for prod 2 insert and update
	      	try
			{
				int bno = Integer.parseInt(txtbno.getText());
				
				if (conn!= null)
	            	conn.close(); 
					conn = ConnectTODB.getConnection();
				
					if(jtype2.getSelectedItem().equals("NONE"))
					{
						/*String msg = "Please fill all Necessory Data";
				      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
				      			JOptionPane.INFORMATION_MESSAGE);*/
					}
					else
					{ 	
						// Query for Inserting record
			        String qry1="INSERT INTO po_details(po_no,prod_name,qty)"+
			        		   "VALUES(?,?,?)";			      
			        PreparedStatement Insert_Record=conn.prepareStatement(qry1);
			      	Insert_Record.setString(1,bno+"");
			       	Insert_Record.setString(2,jtype2.getSelectedItem().toString());
			      	Insert_Record.setString(3,jt6.getText());
					Insert_Record.execute(); // execute query
					
					/*String msg1 = "PO Inserted Sucessfully!";
			      	JOptionPane.showMessageDialog((Component)null,msg1,"Agro Services",
			      			JOptionPane.INFORMATION_MESSAGE);*/
			      			flag2=1;
			      			
					 try
					{
						if (conn!= null)
			            	conn.close(); 
						conn = ConnectTODB.getConnection();
						
			  			String selqry = "SELECT product.prod_id,product.ava_qty"+
							  " FROM product WHERE product.prod_name='"+jtype2.getSelectedItem()+"'";
							  
						PreparedStatement Record = conn.prepareStatement(selqry);
						ResultSet rs = Record.executeQuery(); // execute query
						rs.next();	int i = rs.getRow();
						
						int ava_qty = rs.getInt("ava_qty");
						int updated_qty=Integer.parseInt(jt6.getText()) + ava_qty;
						
						String qry2="UPDATE product Set ava_qty=?"+
			        		   " WHERE product.prod_name='"+jtype2.getSelectedItem()+"';";
				                		   
						  PreparedStatement Update_Record=conn.prepareStatement(qry2);
						Update_Record.setString(1,updated_qty+"");			        		   
				      	
				      	
						Update_Record.execute(); // execute query
						/*String msg2 = "Record Updated Sucessfully!";
				      	JOptionPane.showMessageDialog((Component)null,msg2,"Agro Servises",
				      			JOptionPane.INFORMATION_MESSAGE); */
				      			uflag2=1;
							
				    } 
					catch(SQLException sqle)
					{
						System.out.println("SQL Error"+sqle);
					}
					}
				}
				catch(SQLException sqle)
				{
						System.out.println("SQL Error"+sqle);
				}
	  	
			      	/////////////Qry for prod 3 insert and update
	      	try
			{
				int bno = Integer.parseInt(txtbno.getText());
				
				if (conn!= null)
	            	conn.close(); 
					conn = ConnectTODB.getConnection();
				
					if(jtype3.getSelectedItem().equals("NONE"))
					{
						/*String msg = "Please fill all Necessory Data";
				      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
				      			JOptionPane.INFORMATION_MESSAGE);*/
					}
					else
					{ 	
						// Query for Inserting record
			        String qry1="INSERT INTO po_details(po_no,prod_name,qty)"+
			        		   "VALUES(?,?,?)";			      
			        PreparedStatement Insert_Record=conn.prepareStatement(qry1);
			      	Insert_Record.setString(1,bno+"");
			       	Insert_Record.setString(2,jtype3.getSelectedItem().toString());
			      	Insert_Record.setString(3,jt7.getText());
					Insert_Record.execute(); // execute query
					
					/*String msg1 = "PO Inserted Sucessfully!";
			      	JOptionPane.showMessageDialog((Component)null,msg1,"Agro Services",
			      			JOptionPane.INFORMATION_MESSAGE);*/
			      		flag3=1;
			      			
					 try
					{
						if (conn!= null)
			            	conn.close(); 
						conn = ConnectTODB.getConnection();
						
			  			String selqry = "SELECT product.prod_id,product.ava_qty"+
							  " FROM product WHERE product.prod_name='"+jtype3.getSelectedItem()+"'";
							  
						PreparedStatement Record = conn.prepareStatement(selqry);
						ResultSet rs = Record.executeQuery(); // execute query
						rs.next();	int i = rs.getRow();
						
						int ava_qty = rs.getInt("ava_qty");
						int updated_qty=Integer.parseInt(jt7.getText()) + ava_qty;
						
						String qry2="UPDATE product Set ava_qty=?"+
			        		   " WHERE product.prod_name='"+jtype3.getSelectedItem()+"';";
				                		   
						  PreparedStatement Update_Record=conn.prepareStatement(qry2);
						Update_Record.setString(1,updated_qty+"");			        		   
				      	
				      	
						Update_Record.execute(); // execute query
					/*	String msg2 = "Record Updated Sucessfully!";
				      	JOptionPane.showMessageDialog((Component)null,msg2,"Agro Servises",
				      			JOptionPane.INFORMATION_MESSAGE); */
				      			uflag3=1;
							
				    }
					catch(SQLException sqle)
					{
						System.out.println("SQL Error"+sqle);
					}
					}
				}
				catch(SQLException sqle)
				{
						System.out.println("SQL Error"+sqle);
				}
	  				
	  				///////////Qry for prod 4 insert and update
	      	try
			{
				int bno = Integer.parseInt(txtbno.getText());
				
				if (conn!= null)
	            	conn.close(); 
					conn = ConnectTODB.getConnection();
				
					if(jtype4.getSelectedItem().equals("NONE"))
					{
						/*String msg = "Please fill all Necessory Data";
				      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
				      			JOptionPane.INFORMATION_MESSAGE);*/
					}
					else
					{ 	
						// Query for Inserting record
			        String qry1="INSERT INTO po_details(po_no,prod_name,qty)"+
			        		   "VALUES(?,?,?)";			      
			        PreparedStatement Insert_Record=conn.prepareStatement(qry1);
			      	Insert_Record.setString(1,bno+"");
			       	Insert_Record.setString(2,jtype4.getSelectedItem().toString());
			      	Insert_Record.setString(3,jt25.getText());
					Insert_Record.execute(); // execute query
					
					/*String msg1 = "PO Inserted Sucessfully!";
			      	JOptionPane.showMessageDialog((Component)null,msg1,"Agro Services",
			      			JOptionPane.INFORMATION_MESSAGE);*/
			      			flag4=1;
			      			
					 try
					{
						if (conn!= null)
			            	conn.close(); 
						conn = ConnectTODB.getConnection();
						
			  			String selqry = "SELECT product.prod_id,product.ava_qty"+
							  " FROM product WHERE product.prod_name='"+jtype4.getSelectedItem()+"'";
							  
						PreparedStatement Record = conn.prepareStatement(selqry);
						ResultSet rs = Record.executeQuery(); // execute query
						rs.next();	int i = rs.getRow();
						
						int ava_qty = rs.getInt("ava_qty");
						int updated_qty=Integer.parseInt(jt25.getText()) + ava_qty;
						
						String qry2="UPDATE product Set ava_qty=?"+
			        		   " WHERE product.prod_name='"+jtype4.getSelectedItem()+"';";
				                		   
						  PreparedStatement Update_Record=conn.prepareStatement(qry2);
						Update_Record.setString(1,updated_qty+"");			        		   
				      	
				      	
						Update_Record.execute(); // execute query
						/*String msg2 = "Record Updated Sucessfully!";
				      	JOptionPane.showMessageDialog((Component)null,msg2,"Agro Servises",
				      			JOptionPane.INFORMATION_MESSAGE); */
				      			uflag4=1;
				      			
							conn.close();
							
							
						if(flag1==1 || flag2==1 || flag3==1 || flag4==1 || uflag1==1 || uflag2==1 || uflag3==1 || uflag4==1)
						{
							String msg1 = "PO Inserted Sucessfully!";
			      			JOptionPane.showMessageDialog((Component)null,msg1,"Agro Services",
			      			JOptionPane.INFORMATION_MESSAGE);
						}
				    }
					catch(SQLException sqle)
					{
						System.out.println("SQL Error"+sqle);
					}
	  			    }
	  			}
				catch(SQLException sqle)
				{
						System.out.println("SQL Error"+sqle);
				}		      	    
       } 
     else 
  	 if(e.getSource()==b2)
  	  {	  	  
	  	  jt8.setText("");jt9.setText("");jt10.setText("");jt29.setText("");
	  	  jt5.setText("");jt6.setText("");jt7.setText("");jt25.setText("");
	  	  jt11.setText("");jt12.setText("");jt13.setText("");jt33.setText("");
	  	  jt14.setText("");jt15.setText("");jt16.setText("");jt21.setText("");
	  	  jt17.setText("");jt18.setText("");jt19.setText("");jt22.setText("");
	  	  jt32.setText("");jt30.setText("");jt28.setText("");jt20.setText("");jt31.setText("");jtbal.setText("");
	  	  jt3.setText("");jt4.setText("");
   	} 	 
  	else	 
		if(e.getSource()==b3)
  		{
  	  
   	  		dispProductRecord dispitem = new dispProductRecord ();
   	   		dispitem.show ();
   		}
  		else
  		if(e.getSource()==b4)
  		{
  			String rec=makeRecordPrint();
  			printRecord(rec);
  		}
   		if(e.getSource()==b5)
   		{
   	  		dispose();
   		}
	}	  
	 public static  void main(String args[])
	 {
	 	 issueBill ib=new issueBill();
	 }
	 //Function use to make Current Record ready for Print.
	String makeRecordPrint () 
	{

		String data;
		String data0 = "     Universal Fertilizers \n";	
		String data1 = "                  Perchase Bill.         \n";
		String data2 = "  Supplier No.       : " + jt3.getText() + "\n";
		String data3 = "  Supplier Name  : " + jt4.getText() + "\n";
		String data4 = "  Total Unit's   : " + jt20.getText() + "\n";
		String data5 = "  Gross Amount   : " + jt28.getText() + "\n";
		String data6 = "  VAT            : " + jt32.getText() + "\n"; 
		String data7 = "  Net Amount     : " + jt30.getText() + "\n";
		String data8 = "  Paid Amount    : " + jt31.getText() + "\n";
		String data9 = "  Balance Amount : " + jtbal.getText() + "\n";
		String sep0 = " -----------------------------------------------------------\n";
		String sep1 = " -----------------------------------------------------------\n";
		String sep2 = " -----------------------------------------------------------\n";
		String sep3 = " -----------------------------------------------------------\n";
		String sep4 = " -----------------------------------------------------------\n\n";

		data = data0 + sep0 + data1 + sep1 + data2 + data3 + sep2 + data4 + sep3 + data5 + data6 + data7 + data8 + data9 + sep4;
		return data;

	}

	//Function use to Print the Current Record.

	void printRecord (String rec) 
	{
		StringReader sr = new StringReader (rec);
		LineNumberReader lnr = new LineNumberReader (sr);
		Font typeface = new Font ("Times New Roman", Font.PLAIN, 12);
		Properties p = new Properties ();
		PrintJob pJob = getToolkit().getPrintJob (this, "Print Customer Balance Report", p);

		if (pJob != null) {
			Graphics gr = pJob.getGraphics ();
			if (gr != null) {
				FontMetrics fm = gr.getFontMetrics (typeface);
				int margin = 20;
				int pageHeight = pJob.getPageDimension().height - margin;
    				int fontHeight = fm.getHeight();
	    			int fontDescent = fm.getDescent();
    				int curHeight = margin;
				String nextLine;
				gr.setFont (typeface);

				try {
					do {
						nextLine = lnr.readLine ();
						if (nextLine != null) {         
							if ((curHeight + fontHeight) > pageHeight) {	//New Page.
								gr.dispose();
								gr = pJob.getGraphics ();
								curHeight = margin;
							}							
							curHeight += fontHeight;
							if (gr != null) {
								gr.setFont (typeface);
								gr.drawString (nextLine, margin, curHeight - fontDescent);
							}
						}
					}
					while (nextLine != null);					
				}
				catch (EOFException eof) { }
				catch (Throwable t) { }
			}
			gr.dispose();
		}
		if (pJob != null)
			pJob.end ();
	}
} 
class MyActionListener implements FocusListener
{
   	public void focusGained(FocusEvent e)
   	{
   	}
	public void focusLost(FocusEvent e)
	{
	}
}
	