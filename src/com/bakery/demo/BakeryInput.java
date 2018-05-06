package com.bakery.demo;
 
import java.io.*;
import java.nio.charset.StandardCharsets;
 
public class BakeryInput {
 
 	public double readValue() {
 		
 		BufferedInputStream a_buffer = new
 				BufferedInputStream(System.in);
 		BufferedReader b_buffer = new BufferedReader(
 				new InputStreamReader(a_buffer,
 						StandardCharsets.UTF_8));
 		
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
 	

	public static void main(String[] arguments) {
		
		BakeryInput input = new BakeryInput();
		
		System.out.println("Enter a number:");
		System.out.println("The number you have entered is: " 
				+ input.readValue());
		
		// The logic seems to be fixed.
	}
	
}