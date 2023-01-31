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

public class DeleteApp 
{

	public static void main(String[] args) throws SQLException
	{
		// Resource used in jdbc
				Connection connection = null;
				PreparedStatement pstmt = null;
		
		
				Scanner scanner = new Scanner(System.in);
				
				System.out.print("Enter SID to delete:: ");
				int sid = scanner.nextInt();
				
	   
				String sqDeleteQuery = "delete from student where sid = ?";
								//
		try 
	    {
			connection = JDBCUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqDeleteQuery);
			
			if (pstmt != null) {
				
				pstmt.setInt(1, sid);
				int rowAffected = pstmt.executeUpdate();
				System.out.println("No of rows deleted is :: " + rowAffected);
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
