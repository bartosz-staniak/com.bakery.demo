package com.bakery.demo;

public class BakeryDiscounts {
	double discount;
	
	BakeryDiscounts(double inPriceTotal) {
		if(inPriceTotal < 10)
			discount = 1;
		else if(inPriceTotal < 50)
			discount = 0.99;
		else if(inPriceTotal < 100)
			discount = 0.95;
		else
			discount = 0.9;
	}
	
	public double getDiscount() {
		return discount;
	}
}
