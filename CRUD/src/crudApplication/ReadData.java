package crudApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadData {
	
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/anudip";
		String username = "root";
		String password = "root";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			Statement statement = conn.createStatement();
			
			String query = "select * from students";
			
			ResultSet res = statement.executeQuery(query);
			
			while(res.next()) {
				System.out.println(res.getString(2));
			}
			
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
