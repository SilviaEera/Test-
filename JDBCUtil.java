package jdbc.date.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	
	private JDBCUtil() {
		
	}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getJDBCConnection() throws SQLException {
		String url = "jdbc:mysql:///tub";
		String user = "root";
		String pass = "admin";

		Connection connection = DriverManager.getConnection(url, user, pass);
		System.out.println("Connection object created...");

		return connection;

	}
	
	public static void closeAll(PreparedStatement pst, Connection connection, ResultSet resultSet) {
		
		try {
			if(connection != null) {
				connection.close();
			}
			
			if(pst!=null) {
				pst.close();
			}
			
			if(resultSet!=null) {
				resultSet.close();
			}
		} catch(SQLException e) {
				e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
