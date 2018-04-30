package com.bakery.demo;

public class BakeryPrices {
	double bread = 0;
	double breadRoll = 0;
	
	BakeryPrices(double breadPrice, double rollPrice) {
		this.bread = breadPrice;
		this.breadRoll = rollPrice;
	}
	
	public void ShowPrices () {
		System.out.println("Bread price: " + bread);
		System.out.println("Breadroll price: " + breadRoll);
	}
}
