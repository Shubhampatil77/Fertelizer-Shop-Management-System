import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.sql.rowset.*;
import javax.swing.table.DefaultTableModel;

public class dispProductRecord extends JFrame 
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
	
	dispProductRecord () 
	{

		setSize (700, 365);

		jpShow.setLayout (null);

		populateArray ();

		tbCustomer = makeTable ();
		jspTable = new JScrollPane (tbCustomer);
		jspTable.setBounds (20, 20, 700, 300);

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
            String qry1 = "SELECT * FROM product;";
            PreparedStatement get_producerl = conn.prepareStatement(qry1);
            ResultSet rs1 = get_producerl.executeQuery();
            for(total=0;rs1.next();total++);
			rs1.close();conn.close();
        }  
        catch(Exception e) 
        {
         	System.out.println(e);
        }
		String rows[][] = new String [500][10];
		rowData = new String [total][10];
		try 
        {  
        	if (conn!= null)
                conn.close();    
    		conn = ConnectTODB.getConnection();
    		// Query to get village names
            String qry = "SELECT product.prod_id, product.prod_name,"+
            			 " product.wt_per_unit, product.price, product.ava_qty, product.batch_no, product.mfg_date, product.exp_date"+
						 " FROM product;";
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
					rowData[i][5] = rs.getString(6);
					rowData[i][6] = rs.getString(7);
					rowData[i][7] = rs.getString(8);
				}
			rs.close();conn.close();
        }  
        catch(Exception e) 
        {
         	System.out.println(e);
        }
		
	}

	//Function to Create the Table and Add Data to Show.
	private JTable makeTable () 
	{

		//String Type Array use to Give Table Column Names.
		String cols[] = {"Prod_no.", "Prod_name", "wt_per_unit", "price","ava_qty","Batch No","Mfg_Date","Exp_Date"};

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
		(tbCustomer.getColumnModel().getColumn(4)).setPreferredWidth (180);
		(tbCustomer.getColumnModel().getColumn(5)).setPreferredWidth (180);
		(tbCustomer.getColumnModel().getColumn(6)).setPreferredWidth (180);
		(tbCustomer.getColumnModel().getColumn(7)).setPreferredWidth (180);
		
		tbCustomer.setRowHeight (20);
		tbCustomer.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
		return tbCustomer;

	}

}