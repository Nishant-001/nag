package comparator;

import java.util.Comparator;

import domain.*;

public class PriceComparator implements Comparator<Tshirt> {

	public int compare(Tshirt tshirt1, Tshirt tshirt2) {
		return (int) (tshirt2.getPrice() - tshirt1.getPrice());
	}
}
