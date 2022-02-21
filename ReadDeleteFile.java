package deletefiledata;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;


public class ReadDeleteFile {
	public static Connection getConnection() {
		try {
			//String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/studentdata";
			String username = "root";
			String password = "password";

			//Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username,password);
			System.out.println("Connection Established");
			return conn;
		} catch (Exception e) {
			System.out.println("Connection not established");
			return null;
		}
	}

	public static void main(String[] args) throws Exception {

		FileInputStream fstream = new FileInputStream("C:\\Users\\srisai.chinthakunta\\Documents\\POC-Data\\deletestudent.txt");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		

		String strLine;
		while ((strLine = br.readLine()) != null)  
		{
			strLine.split("\n");
			System.out.println(strLine);
		} 
		in.close();
		FileInputStream fis = null;	
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			File file = new File(strLine);
			fis = new FileInputStream(file);


			conn.commit();
		} 
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {

			fis.close();
			conn.close();
		}}
}
