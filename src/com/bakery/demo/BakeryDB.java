package com.bakery.demo;

import java.sql.*;

public class BakeryDB {
	
	public boolean createDB() {

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
					return true;
				}
			}
				
			conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}
	
	public void addProduct(String ProductName, String ProductPrice) {
		
		String dbaseURL = "jdbc:derby://localhost:1527/BakeryDB;create=true";
		
		try (
				Connection conn = DriverManager.getConnection
					(dbaseURL)
				) {
			
				PreparedStatement psIns = conn.prepareStatement("insert into "
						+ "PRICES(ProductName, Price) "
						+ "values(?, ?)");
				psIns.setString(1, ProductName);
				psIns.setString(2, ProductPrice);
				psIns.executeUpdate();
				
				psIns.close();
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
	
	public void updatePrice(String ProductName, String ProductPrice) {
		
		String dbaseURL = "jdbc:derby://localhost:1527/BakeryDB;create=true";
		
		try (
				Connection conn = DriverManager.getConnection
					(dbaseURL)
				) {
			
			PreparedStatement psUpdate = conn.prepareStatement(
					"UPDATE Prices SET Price=? "
					+ "WHERE ProductName=?");
			psUpdate.setString(1, ProductPrice);
			psUpdate.setString(2, ProductName);
			psUpdate.executeUpdate();
			
		} catch (SQLException SQLe) {
			System.out.println("SQL Exception: " + SQLe.getMessage());
		}
	}
	
	public static void main(String[] arguments) {
		
		BakeryDB db = new BakeryDB();
		db.createDB();
		db.addProduct("BreadRoll", "0.50");
		db.getProducts();
		db.updatePrice("Bread", "3.30");
		db.getProducts();
	}
}

