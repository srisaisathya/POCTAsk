import java.lang.*;

public class ReadFile {

	private static String vrms;
	private static String irms;
	private static String total;

	public static Connection getConnection() {
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/student";
			String username = "root";
			String password = "password";

			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username,password);
			System.out.println("Connection Established");
			return conn;
		} catch (Exception e) {
			System.out.println("Connection not established");
			return null;
		}   }
	public static void main(String[] args) throws Exception {
		ReadFile rf=new ReadFile();
		FileInputStream fstream = new FileInputStream("C:\\Users\\srisai.chinthakunta\\Documents\\POC-Data/input.txt");
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine;
		while ((strLine = br.readLine()) != null)  
		{
			strLine.split(" ");
			System.out.println(strLine);
		} 
		in.close();
		FileInputStream fis = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			File file = new File(strLine);
			fis = new FileInputStream(file);
			pstmt = conn.prepareStatement("insert into student(studentid, fullname, lastname , total) values (?, ?, ?)");
			pstmt.setString(1, vrms);
			pstmt.setString(2, irms);
			pstmt.setString(3, total);
			pstmt.executeUpdate();
			conn.commit();
		} 
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		} finally {
			pstmt.close();
			fis.close();
			conn.close();
		}}}