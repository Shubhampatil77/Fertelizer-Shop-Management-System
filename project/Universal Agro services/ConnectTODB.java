/* =========================================================================
 * Class	: ConnectTODB
 * Purpose	: Connect to database.
 * ========================================================================= */
 
import java.sql.*;
class ConnectTODB
{
	//Connection con = null;
	public static Connection getConnection() throws SQLException
    {
		String url = ("jdbc:odbc:fertilizer");
		String username = null;
		String password = null;
    	try
        {
	    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		}
	    catch(ClassNotFoundException e)
		{
	    	System.out.println("SQL error");
        }
        Connection con = DriverManager.getConnection
    		(url,username,password);
        return con;
    }
}// End of Connect TODB