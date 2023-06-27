/* =========================================================================
 * Class	: modifyproduct
 * Purpose  : To modify product to database.
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
 class 	modProd extends JFrame implements ActionListener
 {
    JLabel l1,l2,l3,l4,l5,l6,img1,l7,l8,img2,dt;
	JTextField t1,t2,t3,t4,t5,txtdt,t6,t7,t8;
	JButton b1,b2,b3;
	Font f1=new Font("Bell MT",Font.BOLD+Font.ITALIC,30);
	Container c1=getContentPane();
	Connection conn;
	ResultSet rs;
	String qry;
	
	JComboBox day, month, year,day1,month1,year1;
	String dlist[]={"None","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
					"19","20","21","22","23","24","25","26","27","28","29","30","31"};
	String mlist[]={"None","1","2","3","4","5","6","7","8","9","10","11","12"};
	String ylist[]={"None","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980",
					"1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992",
					"1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004",
					"2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016",
					"2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
	String ylist1[]={"None","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021",
					"2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033","2034",
					"2035","2036","2037","2038","2039","2040","2041","2042","2043","2044","2045","2046","2047","2048",
					"2049","2050","2051","2052","2053","2054","2055","2056","2057","2058","2059","2060"};

	
	modProd()
	 {
	 	 super("PRODUCT ENTRY");
	 	 	setLayout(null);
		l1=new JLabel("PRODUCT ENTRY");
		l1.setBounds(90,20,300,30);
		c1.add(l1);
		l1.setFont(f1);
		l2 = new JLabel("_______________________________________________________"+
						            "________________________________________________________________");
		l3 = new JLabel("________________________________________________________"+
						            "_________________________________________________________________");
		
		l2.setForeground(Color.BLUE);	
		l3.setForeground(Color.BLUE);
		l2.setBounds(0,45,1000,20);
		c1.add(l2);	
		l3.setBounds(0,270,1000,20);
		c1.add(l3);
		
		img1 = new JLabel(new ImageIcon("sss.jpg"));
      	img1.setBounds(0,0,90,60);
      	c1.add(img1);
		
		b1=new JButton("Modify");
        b1.setBounds(10,300,100,30);
        c1.add(b1);
        
        b2=new JButton("Clear");
        b2.setBounds(130,300,100,30);
        c1.add(b2);
        
        b3=new JButton("Cancle");
        b3.setBounds(245,300,100,30);
        c1.add(b3);
        
        l1=new JLabel("Product No:");
		l1.setBounds(20,70,130,30);
		c1.add(l1);
		
		l1=new JLabel("Date:");
		l1.setBounds(280,70,130,30);
		c1.add(l1);
		
		l2=new JLabel("Product Name :");
		l2.setBounds(20,120,270,30);
		c1.add(l2);
		
		l3=new JLabel("Wt per unit :");
		l3.setBounds(20,180,130,30);
		c1.add(l3);
		
		l4=new JLabel("Price Rs.:");
		l4.setBounds(20,220,130,30);
		c1.add(l4);
		
		l5=new JLabel("Batch No:");
		l5.setBounds(280,120,130,30);
		c1.add(l5);
		
		l6=new JLabel("Mfg Date:");
		l6.setBounds(280,180,130,30);
		c1.add(l6);
		
		l7=new JLabel("Exp Date:");
		l7.setBounds(280,220,130,30);
		c1.add(l7);
		
        c1.add(b3);
        t1=new JTextField();	c1.add(t1);
        t2=new JTextField();	c1.add(t2);
        t3=new JTextField();	c1.add(t3);
        t4=new JTextField();    c1.add(t4);
        t5=new JTextField();    c1.add(t5);
        t6=new JTextField();    c1.add(t6);
        t7=new JTextField();    c1.add(t7);
        
       /* day=new JComboBox(dlist);
		day.setBounds(350,180,50,20);
		c1.add(day);
		
		month=new JComboBox(mlist);
		month.setBounds(420,180,75,20);
		c1.add(month);
		
		year=new JComboBox(ylist);
		year.setBounds(520,180,60,20);
		c1.add(year);
		
		day1=new JComboBox(dlist);
		day1.setBounds(350,220,50,20);
		c1.add(day1);
		
		month1=new JComboBox(mlist);
		month1.setBounds(420,220,75,20);
		c1.add(month1);
		
		year1=new JComboBox(ylist1);
		year1.setBounds(520,220,60,20);
		c1.add(year1);
		*/
		
        t1.setBounds(120,70,130,20);//item no
	 	t2.setBounds(120,120,150,20);//item name
		t3.setBounds(120,180,130,20);//item wt per unit
    	t4.setBounds(120,220,130,20);//item price
    	t5.setBounds(350,120,130,20);//item Batch
    	t6.setBounds(350,180,130,20);//item mfg
    	t7.setBounds(350,220,130,20);//item exp
    	
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
		txtdt.setBounds(350,70,130,20);
		txtdt.setEditable(false);
		txtdt.setText(dt+"/"+month+"/"+ye);
		c1.add(txtdt);
    	
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
    	
    		t4.addKeyListener(new KeyAdapter() 
			{
        		public void keyPressed(KeyEvent EVT) 
        		{     
	        		String value = t4.getText();
	                int l = value.length();
	                if(l<10)
	                {            	
	                if (EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' ||EVT.getKeyChar()=='\b')               
	                {
	                	t4.setEditable(true);
	                }
	                else 
	                {
	                    t4.setEditable(true);
	                    t4.setText("");
	                    JOptionPane.showMessageDialog((Component)null,"Enter Only Numbers","Agro Services",JOptionPane.INFORMATION_MESSAGE);
	             	}
	          		}
	             	else
	             		JOptionPane.showMessageDialog((Component)null,"Enter Only 10 Numbers","Agro Services",JOptionPane.INFORMATION_MESSAGE);
         		}

         	});
         	
         	
    		t5.addKeyListener(new KeyAdapter() 
			{
        		public void keyPressed(KeyEvent EVT) 
        		{     
	        		String value = t5.getText();
	                int l = value.length();
	                if(l<10)
	                {            	
	                if (EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9' ||EVT.getKeyChar()=='\b')               
	                {
	                	t5.setEditable(true);
	                }
	                else 
	                {
	                    t5.setEditable(true);
	                    t5.setText("");
	                    JOptionPane.showMessageDialog((Component)null,"Enter Only Numbers","Agro Services",JOptionPane.INFORMATION_MESSAGE);
	             	}
	          		}
	             	else
	             		JOptionPane.showMessageDialog((Component)null,"Enter Only 10 Numbers","Agro Services",JOptionPane.INFORMATION_MESSAGE);
         		}

         	});
    	
    	b1.addActionListener(this);
        b2.addActionListener(this);
	  	b3.addActionListener(this);
	  					t1.setEditable(true);
	  					t2.setEditable(false);
    	    			t3.setEditable(false);
    	    			t4.setEditable(false);
    	    			t5.setEditable(false);
    	    			t6.setEditable(false);
    	    			t7.setEditable(false);
	  	
	  	 t1.addKeyListener(new KeyAdapter() 
		{
        	public void keyPressed(KeyEvent EVT) 
        	{
	    		if(!t1.getText().equals(""))
				{
				 String p_ID = t1.getText().trim();
			String qry = "";
			try
			{
				if(conn!= null)
					conn.close();
				conn = ConnectTODB.getConnection();
				// Query for Searching member name
		        qry = "SELECT product.prod_name,product.wt_per_unit,product.price,item.batch_no,product.mfg_date,product.exp_date FROM product "+
		              "WHERE (((product.prod_id)="+p_ID+"));";
		        
		        PreparedStatement Record = conn.prepareStatement(qry);
				ResultSet rs = Record.executeQuery(); // execute query
				rs.next();	int i = rs.getRow();
				if(i == 0) // There is no record
				{
					String msg = "There is no product to display.";
		    	  	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
		    	  			JOptionPane.ERROR_MESSAGE);
		    	  	conn.close();
		    	  	t1.requestFocus();
		    	}
		 	   	else
		 	   	{
		 	   		t1.setEditable(false);
		   	 	    t2.setText(rs.getString(1));
		   	 	    t3.setText(rs.getString(2));
		   	 	    t4.setText(rs.getString(3));
		   	 	    t5.setText(rs.getString(4));
		   	 	    t6.setText(rs.getString(5));
		   	 	    t7.setText(rs.getString(6));
		   	 	    
		   	 	    	t2.setEditable(true);
    	    			t3.setEditable(true);
    	    			t4.setEditable(true);
    	    			t5.setEditable(true);
    	    			t6.setEditable(true);
    	    			t7.setEditable(true);
		   	 	}    	    
					
		     	}	// End of try
		 	catch(SQLException sqle)
			{
				System.out.println("SQL Error"+sqle);
			} // End of catch			
		 }				
	   } 
	});
	  	 
		setSize(550,400);
		setVisible(true);	            
	}
      public void actionPerformed(ActionEvent ae)
      {
    	if(ae.getSource()==b1)
    	 {
    	 	double price=0.0; 
    	 	int wt=0;
    	 	int batch=0;
    	 	String p_ID = t1.getText().trim();
    	 	
	        String iname = t2.getText().trim(); //item name
    	 	String iwt  =  t3.getText().trim();//item wt per unit
    	 	String iprz =  t4.getText().trim();//item price
    	 	String ibtno =  t5.getText().trim();//item batchno
    	 	String imfg =  t6.getText().trim();//item mfg
    	 	String iexp =  t7.getText().trim();//item exp
    	 	
    	    try
			{
				if (conn!= null)
	            	conn.close(); 
				conn = ConnectTODB.getConnection();
					if(iname.equals("") || iwt.equals("") || iprz.equals("") || ibtno.equals("") || imfg.equals("") || iexp.equals(""))
					{
						String msg = "Please fill all Necessory Data";
				      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Services",
				      			JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{ 	// Query for Inserting record
				        String qry="UPDATE product Set prod_name=?,wt_per_unit=?,"+
			        		   "price=?,batch_no=?,mfg_date=?,exp_date=?"+
			        		   " WHERE product.prod_id="+p_ID+";";
			                		   
					PreparedStatement Update_Record=conn.prepareStatement(qry);
					Update_Record.setString(1,iname);			        		   
			      	Update_Record.setString(2,iwt);
			      	Update_Record.setString(3,iprz);
			      	Update_Record.setString(4,ibtno);
			      	Update_Record.setString(5,imfg);
			      	Update_Record.setString(6,iexp);
			      				      	
					Update_Record.execute(); // execute query
					String msg = "Record Updated Sucessfully!";
			      	JOptionPane.showMessageDialog((Component)null,msg,"Agro Servises",
			      			JOptionPane.INFORMATION_MESSAGE); 
				      			
				      	t1.setText("");t2.setText("");t3.setText("");
    	    			t4.setText("");t1.requestFocus();
    	    			t5.setText("");t5.setText("");t6.setText("");t7.setText("");		
    	    			t1.setEditable(true);
    	    			t2.setEditable(false);
    	    			t3.setEditable(false);
    	    			t4.setEditable(false);
    	    			t5.setEditable(false);
    	    			t6.setEditable(false);
    	    			t7.setEditable(false);
			      	    conn.close();		
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
 	      t1.setText("");t2.setText("");t3.setText("");
    	    			t4.setText("");t1.requestFocus();
    	    			t5.setText("");t5.setText("");t6.setText("");t7.setText("");		
    	    			t1.setEditable(true);
    	    			t2.setEditable(false);
    	    			t3.setEditable(false);
    	    			t4.setEditable(false);
    	    			t5.setEditable(false);
    	    			t6.setEditable(false);
    	    			t7.setEditable(false);
 	 	}
 	  else
 	 	  if(ae.getSource()==b3)
 	 	   {
 	 	   	 dispose();
 	 	  	
 	 	   } 	  
	}

	public static void main(String args[])
	{
			modProd mp=new 	modProd();
	}
}		