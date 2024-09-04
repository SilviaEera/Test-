package jdbc.date.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet resultSet = null;
		Scanner sc = null;
		
		String insertQ = "insert into students value( ?, ?, ?)";
		try {
			connection = JDBCUtil.getJDBCConnection();
			
			if(connection != null) {
				pst = connection.prepareStatement(insertQ);
			}
			
			if(pst != null) {
				sc = new Scanner(System.in);
				if(sc!=null) {
//					System.out.print("enter id: ");
//					int id = sc.nextInt();
//					pst.setInt(1, id);
					System.out.print ("Please enter name  : ");
					String name = sc.next();
					pst.setString(1, name);
					
					System.out.print ("Please enter age : ");
					Integer age  = sc.nextInt();
					pst.setInt(2, age);
					
					System.out.print ("Please enter date (yyyy-mm-dd) : ");
					String date = sc.next();
					java.sql.Date sdate = java.sql.Date.valueOf(date);
					pst.setDate(3, sdate);
				}
				
				int row = pst.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
			
		} finally {
//			closing the resources 
			
			JDBCUtil.closeAll(pst, connection, resultSet);
			
			sc.close();
		}

	}

}
