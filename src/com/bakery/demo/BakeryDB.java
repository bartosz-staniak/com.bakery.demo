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
			PreparedStatement psPrices = conn.prepareStatement("CREATE TABLE Prices "
					+ "(ProductName CHAR(50) NOT NULL PRIMARY KEY"
					+ ",Price DECIMAL(5, 2) NOT NULL)");

			psPrices.execute();
			psPrices.close();
			
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
	
	public boolean createAllergensTable() {

		String dbaseURL = "jdbc:derby://localhost:1527/BakeryDB;create=true";
	
		try(
				Connection conn = DriverManager.getConnection
					(dbaseURL)
				) {
			try {
			
			PreparedStatement psIngredients = conn.prepareStatement(
					"CREATE TABLE Allergens(ProductName CHAR(50)"
					+ "NOT NULL PRIMARY KEY, Eggs BOOLEAN, Milk BOOLEAN,"
					+ " TreeNuts BOOLEAN, Corn BOOLEAN, "
					+ "Maize BOOLEAN, Wheat BOOLEAN)");

			psIngredients.execute();
			psIngredients.close();
			
			} catch (SQLException sqlExists) {
				System.out.println("Problem");
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
	
	public void addAllergens(String ProductName, String BoolEggs, String BoolMilk, 
			String BoolTreeNuts, String BoolCorn, String BoolMaize,
			String BoolWheat) {
		
		String dbaseURL = "jdbc:derby://localhost:1527/BakeryDB;create=true";
		
		try (
				Connection conn = DriverManager.getConnection
					(dbaseURL)
				) {
			
				PreparedStatement psIns = conn.prepareStatement("insert into " 
						+ "Allergens(ProductName ,Eggs, Milk, " 
						+ "TreeNuts , Corn, Maize, Wheat) "
						+ "values (?, ?, ?, ?, ?, ?, ?)");
				psIns.setString(1, ProductName);
				psIns.setString(2, BoolEggs);
				psIns.setString(3, BoolMilk);
				psIns.setString(4, BoolTreeNuts);
				psIns.setString(5, BoolCorn);
				psIns.setString(6, BoolMaize);
				psIns.setString(7, BoolWheat);
				
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
	
	public void filterByAllergen(String allergenName) {
		String dbaseURL = "jdbc:derby://localhost:1527/BakeryDB;create=true";
		
		try (
				Connection conn = DriverManager.getConnection
					(dbaseURL)
				) {
			
			StringBuilder query = new StringBuilder();
			query.append("SELECT Prices.ProductName, Allergens.Eggs, "
					+ "Allergens.Milk, Allergens.TreeNuts, "
					+ "Allergens.Corn, Allergens.Maize, "
					+ "Allergens.Wheat "
					+ "FROM Prices "
					+ "INNER JOIN Allergens "
					+ "ON Prices.ProductName = Allergens.ProductName ");
			query.append("WHERE " + allergenName + " = True");
			PreparedStatement psFilter = conn.prepareStatement(query.toString());

			ResultSet results = psFilter.executeQuery();
			
			while(results.next()) {
				System.out.print("Product Name: " + results.getString(1));
				System.out.print(" |Eggs: " + results.getBoolean(2) + "|");
				System.out.print(" |Milk: " + results.getBoolean(3) + "|");
				System.out.print(" |Tree Nuts: " + results.getBoolean(4) + "|");
				System.out.print(" |Corn: " + results.getBoolean(5) + "|");
				System.out.print(" |Maize: " + results.getBoolean(6) + "|");
				System.out.println(" |Wheat: " + results.getBoolean(7) + "|");
			}
			
			psFilter.close();
			conn.close();
			
		} catch (SQLException SQLe) {
			 System.out.println("SQL Exception: " + SQLe.getMessage());
			 SQLe.printStackTrace();
		}
	}
	
	public static void main(String[] arguments) {
		
		BakeryDB db = new BakeryDB();
		db.createDB();
		db.createAllergensTable();
		db.addAllergens("Cake", "False", "True", "False", "True", "False", "True");
		db.addAllergens("Bread", "True", "True", "True", "True", "True", "True");
		db.addProduct("RollBread", "9.50");
		db.addProduct("Cake", "20.00");
		db.addProduct("BreadRoll", "0.35");
		db.addProduct("Bread", "3.50");
		db.getProducts();
		db.updatePrice("Bread", "3.30");
		db.getProducts();
		db.filterByAllergen("milk");
	}
}

