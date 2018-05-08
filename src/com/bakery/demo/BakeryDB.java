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
					+ "(ProductName CHAR(50) NOT NULL PRIMARY KEY"
					+ ",Price DECIMAL(5, 2) NOT NULL)");
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
						+ "PRICES(ProductName, Price) "
						+ "values(?, ?)");
				ps.setString(1, ProductName);
				ps.setString(2, ProductPrice);
				ps.executeUpdate();
				
				ps.close();
				conn.close();
			} catch (SQLException SQLe) {
				System.out.println("SQL Exception: " + SQLe.getMessage());
			}
	}
	
	public void getProducts() {
		
		String dbaseURL = "jdbc:derby://localhost:1527/BakeryDB;create=true";
		
		try (
				Connection conn = DriverManager.getConnection
					(dbaseURL)
				) {
				
			Statement s = conn.createStatement();
			
			ResultSet results = s.executeQuery(
					"select ProductName, Price "
					+ "from PRICES "
					+ "order by ProductName");
			
			while (results.next()) {
				System.out.print("Product name: " + results.getString(1));
				System.out.println("\t Price: " + results.getString(2));
			}
			s.close();
			conn.close();
		} catch (SQLException SQLe) {
			System.out.println("SQL Exception: " + SQLe.getMessage());
		}
	}
	
	public static void main(String[] arguments) {
		
		BakeryDB db = new BakeryDB();
		db.createDB();
		db.addProduct("BreadRoll", "0.50");
		db.getProducts();
	}
}

