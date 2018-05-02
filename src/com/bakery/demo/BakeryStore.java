package com.bakery.demo;

public class BakeryStore {
	public static void main(String[] arguments) {
		BakeryPrices prices;
		double price1 = 0;
		double price2 = 0;
		double amountBread = 0;
		double amountRolls = 0;
		
		System.out.println("Welcome to the store");
		
		if(arguments.length > 1) {
			price1 = Double.parseDouble(arguments[0]);
			price2 = Double.parseDouble(arguments[1]);
			amountBread = Double.parseDouble(arguments[2]);
			amountRolls = Double.parseDouble(arguments[3]);
			
		}
			prices = new BakeryPrices(
					price1, price2);
		
		prices.ShowPrices();
		
		BasketCalculator basket = new BasketCalculator(price1, price2,
				amountBread, amountRolls);
		
		System.out.println("Total order value: "
				+ basket.getBasketTotal());
	}
}
