package in.ineuron.main1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.ineuron.jdbcUtil.JDBCUtil;

//import com.mysql.cj.jdbc.Driver;
//import com.mysql.cj.xdevapi.Statement;

public class UpdateApp 
{

	public static void main(String[] args) throws SQLException
	{
		// Resource used in jdbc
				Connection connection = null;
				PreparedStatement pstmt = null;
		
		
				Scanner scanner = new Scanner(System.in);
				
				System.out.print("Enter SID to Update:: ");
				int sid = scanner.nextInt();
				
				System.out.print("Enter SNAME to update:: ");
				String sname = scanner.next();
				
				
	   
				String sqlUpdateQuery = "update student set sname = ? where sid = ?";
								
		try 
	    {
			connection = JDBCUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlUpdateQuery);
			
			if (pstmt != null) {
				
				pstmt.setString(1, sname);
				pstmt.setInt(2, sid);
				int rowAffected = pstmt.executeUpdate();
				System.out.println("No of rows Updated is :: " + rowAffected);
			}
			
	    }
	    catch(SQLException se)
	    {
	    	se.printStackTrace();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    finally 
	    {
	    	JDBCUtil.closeConnection(null, pstmt, connection);
	    	if(scanner!=null) 
	    	{
	    		scanner.close();
	    	}
	    }
	   
	    
	     
	  
	}

}
