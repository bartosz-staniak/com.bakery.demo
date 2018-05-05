 package com.bakery.demo;
 
 import java.io.*;
 
 public class BakeryInput {
 
 	public static double readValue() {
 		double value = 0.0;
 		
 		try (BufferedInputStream buffer = new
 			BufferedInputStream(System.in)) {
 				
 				return value = buffer.read();
 				
 		} catch (IOException except) {
 			System.out.println("Exception: " + except.getMessage());
 			return 0.0;
 		}
 		
 	}
 	
	public static void main(String[] arguments) {
		
		System.out.println("Enter a number:");
		System.out.println("The number you have entered is: " 
				+ BakeryInput.readValue());
		
		// The logic is broken. The program returns ASCII codes
		// of a given input sign.
	}
	
 }