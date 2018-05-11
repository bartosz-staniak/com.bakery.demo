package com.bakery.demo;

public class BakeryShowProducts {
	public void chooseMethod() {
		String allergenName = "";
		String answer = "";
		BakeryInput stringInput = new BakeryInput();
		BakeryDB db = new BakeryDB();
		
		System.out.println("Would you like to browse"
				+ "the products by alergens?\n"
				+ "If yes press 'y' key and press enter.");
		answer = stringInput.readString();
		System.out.println(answer);
		if ( answer.equals("y") ) {
			System.out.println("Type the name of the allergen "
					+ "and press enter:");
			allergenName = stringInput.readString();
			db.filterByAllergen(allergenName);
		}
	}
}
