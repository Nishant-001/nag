package view;

import java.util.*;

import domain.*;

public class Output {
	public void displayOutput(ArrayList<Tshirt> matchedTshirts) {
		System.out.println("Thanks for your valuable time!! Your result is here:\n");
		if (matchedTshirts.isEmpty()) {
			System.out.println("Sorry, no tshirt is available of required choice");
		} else {
			for (Tshirt i : matchedTshirts) {
				System.out.println("ID:\t" + i.getId());
				System.out.println("NAME:\t" + i.getName());
				System.out.println("COLOR:\t" + i.getColor());
				System.out.println("GENDER\t" + i.getGender());
				System.out.println("SIZE:\t" + i.getSize());
				System.out.println("PRICE:\t" + i.getPrice());
				System.out.println("RATING:\t" + i.getRating());
				System.out.println("AVAILABILITY:\t" + i.getAvailability());
				System.out.println();
			}
		}
	}

}
