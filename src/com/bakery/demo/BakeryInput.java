package com.bakery.demo;

import java.io.*;

public class BakeryInput {

	public static Double readValue() {
		Double value = 0.0;
		
		try (BufferedInputStream buffer = new
			BufferedInputStream(System.in)) {
				
				value = (double) buffer.read();
				
		} catch (IOException except) {
			System.out.println("Exception: " + except.getMessage());
			return 0.0;
		}
		
		return value;
	}
	
	public static void main(String[] arguments) {
		BakeryInput inputTest = new BakeryInput();
		
		System.out.println("Enter a number:");
		System.out.println("The number you have entered is: " 
				+ inputTest.readValue());
		
		// The logic is broken. The program converts different
		// input signs to numbers instead of returning the numbers
		// that were entered.
	}
	
}
