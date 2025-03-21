package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConenction {
	
	 static Connection con=null;
	
	
	static {
		try
		{
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##paridaashish","Ashish12345");
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getCon()
	{
		 try {
	           
	            if (con == null || con.isClosed()) {
	                con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##paridaashish","Ashish12345");
	            }
	        } catch (SQLException e) {
	            System.err.println("Failed to re-establish connection!");
	            e.printStackTrace();
	        }
	        return con;
		
	}
	

}
