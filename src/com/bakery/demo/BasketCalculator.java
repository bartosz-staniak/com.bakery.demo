package com.bakery.demo;

public class BasketCalculator {
	
	double total;
	
	BasketCalculator(double setBreadAmount,
			double setRollsAmount, 
			double priceBread, 
			double priceRoll) {
		total = (setBreadAmount * priceBread) +
				(setRollsAmount * priceRoll);
	}
}
