package com.bakery.demo;

import java.sql.*;

public class BakeryDB {
	
	public void Create() {
	String driver = "org.apache.derby.jdbc."
			+ "ClientDriver";
	String dbaseURL = "jdbc:derby://localhost:1527/BakeryDB;create=true";
	
	try(
		Connection conn = DriverManager.getConnection
			(dbaseURL)
		) {
		
		PreparedStatement ps = conn.prepareStatement("CREATE TABLE Prices "
				+ "(ProductName CHAR(50),Price DECIMAL(5, 2))");
		ps.executeQuery();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}

