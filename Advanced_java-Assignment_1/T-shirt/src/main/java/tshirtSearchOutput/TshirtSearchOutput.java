package tshirtSearchOutput;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import csvReader.CSVReader;

import comparator.*;
import domain.*;
import tshirtSearch.TshirtSearch;

public class TshirtSearchOutput {
	Scanner sc;

	public ArrayList<Tshirt> getMatchingTshirts(TshirtSearch tshirtSearch) throws FileNotFoundException {

		ArrayList<Tshirt> tshirt = new ArrayList<Tshirt>();
		ArrayList<Tshirt> allTshirtData = CSVReader.getAllTshirts();

		String inputFormat = String.format("%s,%s,%s", tshirtSearch.getColor(), tshirtSearch.getSize(),
				tshirtSearch.getGender());
		String outputFormat;
		String output = tshirtSearch.getOutputPreference().name();

		System.out.println("Your choice of Output Preference is : ");

		for (Tshirt allTshirtDataiterator : allTshirtData) {
			outputFormat = String.format("%s,%s,%s", allTshirtDataiterator.getColor(), allTshirtDataiterator.getSize(),
					allTshirtDataiterator.getGender());
			if (inputFormat.equalsIgnoreCase(outputFormat))
				tshirt.add(allTshirtDataiterator);
		}

		if (output.equalsIgnoreCase("PRICE")) {
			Collections.sort(tshirt, new PriceComparator());
			System.out.println(output);
		} else if (output.equalsIgnoreCase("RATING")) {
			Collections.sort(tshirt, new RatingComparator());
			System.out.println(output);
		} else {
			Collections.sort(tshirt, new PriceComparator());
			Collections.sort(tshirt, new RatingComparator());
			System.out.println(output);
		}
		System.out.println("\n\n");

		return tshirt;
	}
}
