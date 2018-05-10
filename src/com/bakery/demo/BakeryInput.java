package com.bakery.demo;
 
import java.io.*;
 
public class BakeryInput {
 
 	public double readValue() {
 		
 		BufferedReader b_buffer = new BufferedReader(
 				new InputStreamReader(System.in));
 		
 		String original = "";
		try {
			original = b_buffer.readLine();
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
 		double converted = Double.parseDouble(original);
 		
 	return converted;

 	}
 	
public String readString() {
 		
 		String original = "";
		
 		try (BufferedReader b_buffer = new BufferedReader(
 				new InputStreamReader(System.in))) {
			original = b_buffer.readLine();
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
 		
 	return original;

 	}
 	

	public static void main(String[] arguments) {
		
		BakeryInput input = new BakeryInput();
		
		System.out.println("Enter a number:");
		System.out.println("The number you have entered is: " 
				+ input.readValue());
		
		// The logic seems to be fixed. And now code is shortened.
	}
	
}