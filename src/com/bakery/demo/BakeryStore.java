package com.bakery.demo;

public class BakeryStore {
	public static void main(String[] arguments) {
//		BakeryPrices prices; //Obsolete due to database presence
		double price1 = 0;
		double price2 = 0;
		double amountBread = 0;
		double amountRolls = 0;
		double cash = 0;
		double totalOrderValue = 0;
		
		BakeryInput input = new BakeryInput();
		BakeryDB db = new BakeryDB();
		
		System.out.println("Welcome to the store [v. 1.4]");
		
		if (!db.createDB()) {
			if(arguments.length > 1) {
			
				price1 = Double.parseDouble(arguments[0]);
				price2 = Double.parseDouble(arguments[1]);
				amountBread = Double.parseDouble(arguments[2]);
				amountRolls = Double.parseDouble(arguments[3]);
				cash = Double.parseDouble(arguments[4]);
			
			}
			else {
				System.out.println("Specify "
						+ "the price of a loaf of bread: ");
				price1 = input.readValue();
				System.out.println("Specify "
						+ "the price of a bread roll: ");
				price2 = input.readValue();
			
			}
			db.addProduct("Bread", String.valueOf(price1));
			db.addProduct("Bread roll", String.valueOf(price2));
		}
		else {
			System.out.println("Specify "
					+ "today's price "
					+ "of a loaf of bread: ");
			price1 = input.readValue();
			System.out.println("Specify"
					+ "today's price"
					+ "of a bread roll: ");
			price2 = input.readValue();
			db.updatePrice("Bread", String.valueOf(price1));
			db.updatePrice("Bread roll", String.valueOf(price2));
		}
		
		db.createAllergensTable();
		
		System.out.println("How much money can you spend on shopping: ");
		cash = input.readValue();
		CustomerWallet wallet = new CustomerWallet(cash);
		System.out.println("You currently have: " + wallet.getContents() + " EUR");
		
		db.getProducts();
		
		System.out.println("How many loafs of bread "
				+ "would you like to buy?");
		amountBread = input.readValue();
		System.out.println("How many bread rolls"
				+ "would you like to buy?");
		amountRolls = input.readValue();
		
	/*	// Obsolete due to DB presence
		prices = new BakeryPrices(
					price1, price2);
		
		prices.ShowPrices();
	*/	
		
		
		BasketCalculator basket = new BasketCalculator(price1, price2,
				amountBread, amountRolls);
		
		BakeryDiscounts discount = new BakeryDiscounts(basket.getBasketTotal());
		
		totalOrderValue = ( basket.getBasketTotal() ) * ( discount.getDiscount() );
		
		System.out.println("Total order value: "
				+ totalOrderValue );
		
		wallet.payReceipt(totalOrderValue);
	}
}
