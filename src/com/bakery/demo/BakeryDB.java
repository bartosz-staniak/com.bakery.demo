package com.bakery.demo;

import java.sql.*;

public class BakeryDB {
	
	public void createDB() {

		String dbaseURL = "jdbc:derby://localhost:1527/BakeryDB;create=true";
	
		try(
				Connection conn = DriverManager.getConnection
					(dbaseURL)
				) {
			try {
			PreparedStatement ps = conn.prepareStatement("CREATE TABLE Prices "
					+ "(ProductName CHAR(50),Price DECIMAL(5, 2))");
			ps.execute();
			ps.close();
			} catch (SQLException sqlExists) {
				String Error = (sqlExists).getSQLState();
				if(Error.equals("X0Y32")) {
					System.out.println("The table already exists.");
				}
			}
				
			conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public void addProduct(String ProductName, String ProductPrice) {
		
		String dbaseURL = "jdbc:derby://localhost:1527/BakeryDB;create=true";
		
		try (
				Connection conn = DriverManager.getConnection
					(dbaseURL)
				) {
			
				PreparedStatement ps = conn.prepareStatement("insert into "
						+ "APP.PRICES(ProductName, Price) "
						+ "values(?, ?)");
				ps.setString(1, ProductName);
				ps.setString(2, ProductPrice);
			} catch (SQLException sqe) {
				System.out.println("SQL Exception: " + sqe.getMessage());
			}
	}
	
	public static void main(String[] arguments) {
		
		BakeryDB db = new BakeryDB();
		db.createDB();
		db.addProduct("Bread", "4.0");
	}
}

