package com.bakery.demo;

public class BakeryPrices {
	double bread = 0;
	double breadRoll = 0;
	
	BakeryPrices(double breadPrice, double rollPrice) {
		
		// use of "this" in this case seems to be unnecessary
		// as it would be required if argument's name was
		// the same as the variable name
		this.bread = breadPrice;
		this.breadRoll = rollPrice;
	}
	
	public void ShowPrices () {
		System.out.println("Bread price: " + bread);
		System.out.println("Breadroll price: " + breadRoll);
	}
}
