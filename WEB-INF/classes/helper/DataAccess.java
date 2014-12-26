package helper;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;



public class DataAccess{

    public static enum DBType
    {
    	MYSQL,
    	ORACLE,
    	MS_ACCESS,
    	MS_SQL_SERVER
    };
    
    private DBType DatabaseServer;
    private String servername = "";
    private String port = "";
    private String dbname = "";
    private String username = "";
    private String password = "";
    
    public DataAccess(DBType serverType, String serverName, String portNumber, String databaseName, String userName, String pass)
    {
    	DatabaseServer = serverType;
    	servername = serverName;
    	port = portNumber;
    	dbname = databaseName;
    	username = userName;
    	password = pass;
    }
    
    public ResultSet getResultSet(String sql)
	{
		try
		{
			Connection con = null;
			
			if(DatabaseServer.equals(DBType.MYSQL))
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://" + servername + ":" + port + "/" + dbname, username, password);
			}
			else if(DatabaseServer.equals(DBType.ORACLE))
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@" + servername + ":" + port + ":" + dbname, username, password);
			}
			else if(DatabaseServer.equals(DBType.MS_ACCESS))
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection("jdbc:odbc:" + dbname, username, password);
			}
			else if(DatabaseServer.equals(DBType.MS_SQL_SERVER))
			{
				
			}
			
			Statement stm=con.createStatement();
	    	return stm.executeQuery(sql);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
		}
		return null;	    	
	}
	
	public void executeSQL(String sql)
	{
		try
		{
			Connection con = null;
			
			if(DatabaseServer.equals(DBType.MYSQL))
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://" + servername + ":" + port + "/" + dbname, username, password);
			}
			else if(DatabaseServer.equals(DBType.ORACLE))
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@" + servername + ":" + port + ":" + dbname, username, password);
			}
			else if(DatabaseServer.equals(DBType.MS_ACCESS))
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con = DriverManager.getConnection("jdbc:odbc:" + dbname, username, password);
			}
			else if(DatabaseServer.equals(DBType.MS_SQL_SERVER))
			{
				
			}
			
	    	Statement stm=con.createStatement();
	    	stm.execute(sql);
		}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
		}
	}
}
/*
    Connection to MySQL Database
    .............................
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbname, username, password);
    
    
    Connection to MS Access Database
    .................................
    
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    Connection con = DriverManager.getConnection("jdbc:odbc:" + dbname, username, password);
    
    
    Connection to Oracle Database
    .................................
    
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@serverName:portNumber:" + dbname, username, password);
    
*/