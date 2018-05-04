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
	
}
