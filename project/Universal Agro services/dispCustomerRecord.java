import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.sql.rowset.*;
import javax.swing.table.DefaultTableModel;

public class dispMemberRecord extends JFrame 
{

	private JPanel jpShow = new JPanel ();

	private DefaultTableModel dtmCustomer;
	private JTable tbCustomer;
	private JScrollPane jspTable;

	private int row = 0;
	private int total = 0;


	private String rowData[][];

	private FileInputStream fis;
	private DataInputStream dis;
	
	Connection conn; ResultSet rs;
	
	dispMemberRecord () 
	{

		setSize (500, 280);

		jpShow.setLayout (null);

		populateArray ();

		tbCustomer = makeTable ();
		jspTable = new JScrollPane (tbCustomer);
		jspTable.setBounds (20, 20, 425, 200);

		//Adding the Table to Panel.
		jpShow.add (jspTable);

		//Adding Panel to Window.
		getContentPane().add (jpShow);

		//In the End Showing the New Account Window.
		setVisible (true);

	}

	//Function use to load all Records from File when Window Open.
	void populateArray () 
	{
		// Query to find total no of records
		try 
        {  
        	if (conn!= null)
                conn.close();
			conn = ConnectTODB.getConnection();
    		// Query to get village names
	            String qry1 = "SELECT * FROM member;";
           	            PreparedStatement get_producerl = conn.prepareStatement(qry1);
	            ResultSet rs1 = get_producerl.executeQuery();
	            for(total=0;rs1.next();total++);
	            rs1.close();
	            conn.close();
        }  
        catch(Exception e) 
        {
         	System.out.println(e);
        }
		String rows[][] = new String [500][6];
		rowData = new String [total][5];
          try 
        {  
        	if (conn!= null)
                conn.close();    
   				conn = ConnectTODB.getConnection();
   	
            String qry = "SELECT member.ID, member.memb_name,"+
            			 " member.memb_addr, member.memb_ph, member.memb_email"+
						 " FROM member;";
            PreparedStatement get_producer = conn.prepareStatement(qry);
            ResultSet rs = get_producer.executeQuery(); // execute query
            
            	int i;
            	for (i = 0; rs.next(); i++) 
				{
				rowData[i][0] = rs.getString(1);
				rowData[i][1] = rs.getString(2);
				rowData[i][2] = rs.getString(3);
				rowData[i][3] = rs.getString(4);
				rowData[i][4] = rs.getString(5);
				
				/*String pno=rs.getString(1);
				String pna=rs.getString(2);
				String pa=rs.getString(3);
				String pn=rs.getString(4);
				System.out.print(pna);
				System.out.print(pa);
				System.out.print(pn);*/
				}
			rs.close();
			conn.close();
        }  
        catch(Exception e) 
        {
         	System.out.println(e);
        }
		
		
		/*
		
		//String Type Array use to Load Records into File.
		String rows[][] = new String [500][6];
		try 
		{
			fis = new FileInputStream ("Bank.dat");
			dis = new DataInputStream (fis);
			//Loop to Populate the Array.
			while (true) 
			{
				for (int i = 0; i < 6; i++) 
				{
					rows[row][i] = dis.readUTF ();
				}
				row++;
			}
		}
		catch (Exception ex) 
		{
			total = row;
			rowData = new String [total][4];
			if (total == 0) 
			{
				JOptionPane.showMessageDialog (null, "Records File is Empty.\nEnter Records to Display.",
							"BankSystem - EmptyFile", JOptionPane.PLAIN_MESSAGE);
			}
			else 
			{
				for (int i = 0; i < total; i++) 
				{
					rowData[i][0] = rows[i][0];
					rowData[i][1] = rows[i][1];
					rowData[i][2] = rows[i][2] + ", " + rows[i][3] + ", " + rows[i][4];
					rowData[i][3] = rows[i][5];
				}
				try 
				{
					dis.close();
					fis.close();
				}
				catch (Exception exp) { }
			}
		}*/

	}

	//Function to Create the Table and Add Data to Show.
	private JTable makeTable () 
	{
		//String Type Array use to Give Table Column Names.
		String cols[] = {"Cust. Id.", "Customer Name", "Customer Addr", "Phone No", "Email"};

		dtmCustomer  = new DefaultTableModel (rowData, cols);
		tbCustomer = new JTable (dtmCustomer) 
		{
			public boolean isCellEditable (int iRow, int iCol) 
			{
				return false;	//Disable All Columns of Table.
			}
		};
		//Sizing the Columns of Table.
		(tbCustomer.getColumnModel().getColumn(0)).setPreferredWidth (180);
		(tbCustomer.getColumnModel().getColumn(1)).setPreferredWidth (275);
		(tbCustomer.getColumnModel().getColumn(2)).setPreferredWidth (275);
		(tbCustomer.getColumnModel().getColumn(3)).setPreferredWidth (200);
		(tbCustomer.getColumnModel().getColumn(4)).setPreferredWidth (400);
		tbCustomer.setRowHeight (20);
		tbCustomer.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		return tbCustomer;
	}
}