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

public class InsertApp 
{

	public static void main(String[] args) throws SQLException
	{
		// Resource used in jdbc
				Connection connection = null;
				PreparedStatement pstmt = null;
		
		
				Scanner scanner = new Scanner(System.in);
				
				System.out.print("Enter the sname:: ");
				String sname = scanner.next();
				
				System.out.print("Enter the sage: ");
				int sage = scanner.nextInt();
	    
				System.out.print("Enter the saddress:: ");
				String saddr = scanner.next();
	   
				String sqlInsertQuery = "insert into student(`sname`,`sage`,`saddr`) values(?,?,?)";
				
		try 
	    {
			connection = JDBCUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlInsertQuery);
			
			if (pstmt != null) {
				
				pstmt.setString(1, sname);
				pstmt.setInt(2, sage);
				pstmt.setString(3, saddr);
				
				int rowAffected = pstmt.executeUpdate();
				System.out.println("No of rows Affected is :: " + rowAffected);
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
