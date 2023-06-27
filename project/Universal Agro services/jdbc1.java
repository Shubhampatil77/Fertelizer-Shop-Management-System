import java.sql.*;
class jdbc1
{
	public static void main(String s1[])
	{
		Connection con;
		Statement s;
		try
		{
			Class.forName("snu.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:tab");
			s=con.createStatement();
		//	s.execute("create table studtab(eno int,ename varchar,eage int)");
			s.executeUpdate("Insert into studtab values(101,'snehal'10)");
			System.out.println("record ins");
			con.commit();
			ResultSet rs=s.executeQuery("select * from studtab");
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println("\t"+rs.getInt(2));
				System.out.println("\t"+rs.getInt(3));
				
				
			}
			con.setAutoCommit(true);
			con.close();
		}
			catch(Exception e)
			{
				System.out.println("exc "+e.getMessage());
			    System.exit(0);
			}
		}
	}
