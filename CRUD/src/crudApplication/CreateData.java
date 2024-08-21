package crudApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class CreateData {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/anudip";
		String username = "root";
		String password = "root";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter your Name : ");
			String name = sc.next();
			
			System.out.print("Enter your Age : ");
			int age = sc.nextInt();
			
			System.out.print("Enter your Email : ");
			String email = sc.next();
			
			System.out.print("Enter Mobile Number : ");
			String mobile = sc.next();
			
			String query = "insert into students(name, age, email, mobile) values(?, ?, ?, ?)";
			
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, mobile);
			
			int rows = preparedStatement.executeUpdate();
			
			if(rows > 0) {
				System.out.println("Data Inserted Successfully");
			}
			else {
				System.out.println("Data Insertion Failed, Try Again...");
			}
			
			preparedStatement.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
