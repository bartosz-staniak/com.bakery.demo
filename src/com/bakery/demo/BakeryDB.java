package com.bakery.demo;

import java.sql.*;

public class BakeryDB {
	
	public void Create() {
		
		String dbaseURL = "jdbc:derby://localhost:1527/BakeryDB;create=true";
	
		try(
				Connection conn = DriverManager.getConnection
					(dbaseURL)
				) {

			Class.forName("org.apache.derby.jdbc.ClientDriver"); // Does not work. Seems like the eclipse is not
			// configured properly.
			// java.sql.SQLException: No suitable driver found for jdbc:derby://localhost:1527/BakeryDB;create=true
			
			PreparedStatement ps = conn.prepareStatement("CREATE TABLE Prices "
					+ "(ProductName CHAR(50),Price DECIMAL(5, 2))");
			ps.executeQuery();
		
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] arguments) {
		
		BakeryDB db = new BakeryDB();
		db.Create();
	}
}

