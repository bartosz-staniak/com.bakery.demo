package com.bakery.demo;

public class CustomerWallet {
	double customerWallet;
	
	CustomerWallet(double inMoney) {
		customerWallet = inMoney;
	}
	
	public double getContents() {
		return customerWallet;
	}
	
	public void payReceipt(double outMoney) {
		if (outMoney < customerWallet) {
			customerWallet -= outMoney;
			System.out.println("Your current wallet"
					+ "amount is: " + customerWallet);
		}

		else
			System.out.println("Not enough money"
					+ "in the wallet!");
	}
}
