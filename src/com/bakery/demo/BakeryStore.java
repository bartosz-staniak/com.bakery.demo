package com.bakery.demo;

public class BakeryStore {
	public static void main(String[] arguments) {
		BakeryPrices prices;
		double price1 = 0;
		double price2 = 0;
		
		System.out.println("Welcome to the store");
		System.out.println("Pick your product");
		
		if(arguments.length > 1) {
			price1 = Double.parseDouble(arguments[0]);
			price2 = Double.parseDouble(arguments[1]);
		}
			prices = new BakeryPrices(
					price1, price2);
		
		prices.ShowPrices();
	}
}
