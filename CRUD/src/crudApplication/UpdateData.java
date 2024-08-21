package crudApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateData {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/anudip";
		String username = "root";
		String password = "root";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Id : ");
			int id = sc.nextInt();
			
			System.out.println("Enter Updated Name : ");
			String name = sc.next();
			
			String query = "update students set name = ? where id = ?";
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			
			int rows = preparedStatement.executeUpdate();
			
			if(rows > 0) {
				System.out.println("Data Updated Successfully");
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
