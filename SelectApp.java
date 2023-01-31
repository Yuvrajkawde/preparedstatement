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

public class SelectApp 
{

	public static void main(String[] args) throws SQLException
	{
		// Resource used in jdbc
				Connection connection = null;
				PreparedStatement pstmt = null;
				ResultSet resultset = null;
		
		
				Scanner scanner = new Scanner(System.in);
				
				System.out.print("Enter the SID:: ");
				int sid = scanner.nextInt();
				
				
				String sqlSelectQuery = "select sid,sname,sage,saddr from student where sid = ? ";
				
		try 
	    {
			connection = JDBCUtil.getJdbcConnection();
			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);
			
			if (pstmt != null) {
				
				pstmt.setInt(1, sid);
				resultset = pstmt.executeQuery();
				
			}
			if(resultset!=null)
			{
				if(resultset.next())
				{
					System.out.println("SID\t SNAME\t SAGE\t SAADR");
					System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getInt(3)+"\t"+resultset.getString(4));
				}
				else 
				{
					System.out.println("record not availablle for given id:: "+sid);
				}
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
	    	JDBCUtil.closeConnection(resultset, pstmt, connection);
	    	if(scanner!=null) 
	    	{
	    		scanner.close();
	    	}
	    }
	   
	    
	     
	  
	}

}
