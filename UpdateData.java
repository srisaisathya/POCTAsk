

import java.sql.*; 
import java.util.*;

public class UpdateData{  
	public static void main(String args[]) throws SQLException{ 
		Connection con = null;
		try{  
			//Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/studentdata","root","password");  
			//here student is database name, root is username and password 
			System.out.println("connection successful");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from student");  
			
			String sql = "update student set fullName='Vikranth' where studentId=1;";

			stmt.executeUpdate(sql);

			stmt.close();

			System.out.println("Data updated");
			con.close();
		} 
		catch (SQLException s) 
		{
			System.out.println("SQL statement is not executed!");
		}



		catch(Exception e)
		{
			System.out.println(e);
		} 
	}	
}  
