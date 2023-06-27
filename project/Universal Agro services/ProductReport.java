import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

class ProductReport extends JFrame implements WindowListener, ActionListener
{
	int count = 0;

	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst, pst1, pst2;

	//JButton bprint = new JButton("Print");
	JButton bhome = new JButton("Home");

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();

	ProductReport()
	{
		super("Reports of Product");

		Container c = getContentPane();

		c.add(p1);
		c.add(p2);

		setSize(1024, 700);

	//	bprint.addActionListener(this);
		bhome.addActionListener(this);

	//	p2.add(bprint);
		p2.add(bhome);

		try
		{
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//con = DriverManager.getConnection("jdbc:odbc:Bank");
			
				if (con!= null)
                	con.close();
				con = ConnectTODB.getConnection();
				
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			p1.setBounds(0, 0, 1014, 400);
			p2.setBounds(0, 400, 1024, 60);

			p1.setBackground(Color.black);
			p2.setBackground(Color.black);

			p1.setLayout(new BorderLayout());
			p2.setLayout(null);

			//bprint.setBounds(400, 668, 100, 20);
			bhome.setBounds(420, 420, 100, 20);
			
			String[] colHeads = {"Prod.Id.", "Prod Name", "Weight per unit", "price", "Available Qty","Batch No","Mfg Date", "Exp Date"};
			//String[] colHeads = {"Customer Name", "Account_num", "Date", "Address", "Age" };

			rs = st.executeQuery("Select * from product");

			while (rs.next())
			{
				count++;
			}

			Object[][] results = new Object[count][10];
			rs.first();

			for (int i = 0; i < count; i++)
			{
				results[i][0] = rs.getString(1);
				results[i][1] = rs.getString(2);
				results[i][2] = rs.getString(3);
				results[i][3] = rs.getString(4);				
				results[i][4] = rs.getString(5);
				results[i][5] = rs.getString(6);
				results[i][6] = rs.getString(7);
				results[i][7] = rs.getString(8);
				rs.next();
			}

			JTable table = new JTable(results, colHeads);

			int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

			JScrollPane jsp = new JScrollPane(table, v, h);

			p1.add(jsp, BorderLayout.CENTER);
		}
		catch (Exception e)
		{
			String dt = " ERROR";
			String dm = " ERROR : " + e;
			int dtype = JOptionPane.ERROR_MESSAGE;

			JOptionPane.showMessageDialog((Component)null, dm, dt, dtype);
		}

		setVisible(true);
		c.setBackground(Color.black);
		addWindowListener(this);
	}

	public void actionPerformed(ActionEvent a)
	{
		String s = a.getActionCommand();

		if (s.equals("Home"))
		{
			setVisible(false);
			//Reports r1=new Reports();
				//mm.menu();
		}
		/*else
		if(s.equals("Print"))
		{
			//PrintUtilities.printComponent (this);
		}*/
	}

	public void windowClosing(WindowEvent w)
	{
		setVisible(false);
	}

	public void windowClosed(WindowEvent w) { }
	public void windowOpened(WindowEvent w) { }
	public void windowActivated(WindowEvent w) { }
	public void windowDeactivated(WindowEvent w) { }
	public void windowIconified(WindowEvent w) { }
	public void windowDeiconified(WindowEvent w) { }
}