package com.bakery.demo;

public class BakeryShowProducts {
	public void chooseMethod() {
		String[] allergens = {"Eggs", "Milk", "Tree Nuts", "Corn", "Maize", "Wheat"};
		String allergenName = "";
		String answer = "";
		String exit = "exit";
		BakeryInput stringInput = new BakeryInput();
		BakeryDB db = new BakeryDB();
		
		while (true) {
			System.out.println("Would you like to browse"
					+ "the products by alergens?\n"
					+ "If yes press 'y' key and press enter.");
			answer = stringInput.readString();
			System.out.println(answer);
			if ( answer.equals("y") ) {
				System.out.println("Type the name of the allergen "
						+ "and press enter:");
				allergenName = stringInput.readString();
				boolean exists = false;
				int i = 0;
				while (exists == false && i <= allergens.length) { // enters infinite loop. Needs an exit condition.
					if ( (i < allergens.length) && (allergenName.equals(allergens[i])) ) {
						exists = true;
						db.filterByAllergen(allergenName);
						return;
					}
					else if ( (exists == false) && (i >= allergens.length) ) {
						System.out.println("Unable to verify presence"
								+ "of the specified allergen\n."
								+ "We know of the following allergnes"
								+ "present in our products: Eggs, Milk, "
								+ "Tree Nuts, Corn, Maize, Wheat");
						break;
					}
					else
						i++;
				}
			
			}
			else
				break;
		}
	}
}
