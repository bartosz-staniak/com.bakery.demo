package com.bakery.demo;

public class CustomerWallet {
	double customerWallet;
	
	CustomerWallet(double inMoney) {
		customerWallet = inMoney;
	}
	
	public double showContents() {
		return customerWallet;
	}
}
