package view;

import java.util.Scanner;
import domain.*;
import tshirtSearch.TshirtSearch;

public class Input {
	public String getColor(Scanner sc) {
		boolean isValid = true;
		System.out.println(
				"Enter color of Tshirt:\n(You can choose from-\nPurple,Maroon,Black\nYellow,Blue,Grey\nWhite,Pink)");
		String colorType = "";
		do {
			try {
				colorType = sc.nextLine();
				if (Color.valueOf(colorType.toUpperCase()) != null)
					isValid = false;
			} catch (IllegalArgumentException e) {
				System.out.println(
						"Enter a valid color of Tshirt:\n (You can choose from-\nPurple,Maroon,Black\nYellow,Blue,Grey\nWhite,Pink");

			}

		} while (isValid);
		return colorType;
	}

	public String getSize(Scanner sc) {
		boolean isValid = true;
		System.out.println("Enter size of Tshirt:\n(You can choose from-\nS, M, L, XL)");
		String sizeType = "";
		do {
			try {
				sizeType = sc.nextLine();
				if (Size.valueOf(sizeType.toUpperCase()) != null)
					isValid = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Enter a valid size of Tshirt:\n(You can choose from-\nS, M, L, XL)");

			}
		} while (isValid);
		return sizeType;
	}

	public String getGender(Scanner sc) {
		boolean isValid = true;
		System.out.println("Enter your gender:\nM for Male, F for Female, U for Unisex");
		String gender = "";
		do {
			try {
				gender = sc.next();
				if (Gender.valueOf(gender.toUpperCase()) != null)
					isValid = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Enter a valid gender:\nM for Male, F for Female, U for Unisex");

			}
		} while (isValid);
		return gender;
	}

	public String getOutputPreference(Scanner sc) {
		boolean isValid = true;
		System.out.println("Enter sorting output preference of Tshirt:\n(You can choose from-\nPrice, Rating, Both)");
		String outputPreference = "";
		do {
			try {
				outputPreference = sc.next();
				if (OutputPreference.valueOf(outputPreference.toUpperCase()) != null)
					isValid = false;
			} catch (IllegalArgumentException e) {
				System.out.println("Enter a valid output prefernce:");

			}
		} while (isValid);
		return outputPreference;
	}

	public TshirtSearch getInput() {
		TshirtSearch tshirtSearchDto = new TshirtSearch();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the required details :\n");

		String color = getColor(sc);
		String size = getSize(sc);
		String gender = getGender(sc);
		String outputPreference = getOutputPreference(sc);

		tshirtSearchDto.setColor(Color.valueOf(color.toUpperCase()));
		tshirtSearchDto.setSize(Size.valueOf(size.toUpperCase()));
		tshirtSearchDto.setGender(Gender.valueOf(gender.toUpperCase()));
		tshirtSearchDto.setOutputPreference(OutputPreference.valueOf(outputPreference.toUpperCase()));

		return tshirtSearchDto;
	}
}
