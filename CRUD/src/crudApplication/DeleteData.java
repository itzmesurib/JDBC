package crudApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteData {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/anudip";
		String username = "root";
		String password = "root";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter Student Id : ");
			int id = sc.nextInt();
			
			String query = "delete from students where id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			
			int rows = preparedStatement.executeUpdate();
			
			if(rows > 0) {
				System.out.println("Data Deleted Successfully");
			}
			else {
				System.out.println("Data not deleted, Try Again...");
			}
			
			preparedStatement.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
