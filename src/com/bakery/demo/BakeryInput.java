 package com.bakery.demo;
 
 import java.io.*;
 
 public class BakeryInput {
 
 	public static double readValue() {
 		double value = 0.0;
 		
 		try (
 			BufferedInputStream buffer = new
 				BufferedInputStream(System.in);
 			DataInputStream dis = new
 				DataInputStream(buffer)
 			) {
 				
 				value = dis.readDouble();
 				dis.close();
 				return value;
 				
 		} catch (IOException except) {
 			System.out.println("Exception: " + except.getMessage());
 			return 0.0;
 		}
 		
 	}
 	
	public static void main(String[] arguments) {
		
		System.out.println("Enter a number:");
		System.out.println("The number you have entered is: " 
				+ BakeryInput.readValue());
		
		// The logic is still broken. The program does not return ASCII codes
		// anymore. The output data is much stranger.
	}
	
 }