package com.bakery.demo;

public class BakeryStore {
	public static void main(String[] arguments) {
		BakeryPrices prices;
		double price1 = 0;
		double price2 = 0;
		double amountBread = 0;
		double amountRolls = 0;
		double cash = 0;
		double totalOrderValue = 0;
		
		System.out.println("Welcome to the store [v. 1.1]");
		
		if(arguments.length > 1) {
			price1 = Double.parseDouble(arguments[0]);
			price2 = Double.parseDouble(arguments[1]);
			amountBread = Double.parseDouble(arguments[2]);
			amountRolls = Double.parseDouble(arguments[3]);
			cash = Double.parseDouble(arguments[4]);
			
		}
		
		CustomerWallet wallet = new CustomerWallet(cash);
		System.out.println("You currently have: " + wallet.getContents() + " EUR");
		
		
		prices = new BakeryPrices(
					price1, price2);
		
		prices.ShowPrices();
		
		BasketCalculator basket = new BasketCalculator(price1, price2,
				amountBread, amountRolls);
		
		BakeryDiscounts discount = new BakeryDiscounts(basket.getBasketTotal());
		
		totalOrderValue = ( basket.getBasketTotal() ) * ( discount.getDiscount() );
		
		System.out.println("Total order value: "
				+ totalOrderValue );
		
		wallet.payReceipt(totalOrderValue);
	}
}
