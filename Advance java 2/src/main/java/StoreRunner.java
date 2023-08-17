

import com.training.model.TShirt;
import com.training.parser.ReadCSV;
import com.training.reader.HibernateReader;

import java.io.File;
import java.util.Scanner;

public class StoreRunner {
    TShirt tshirt;
    String outputPreference = "";

    public static void main(String[] args) {
        String inputStatus = "y";
        StoreRunner runner = new StoreRunner();
        try (Scanner scanner = new Scanner(System.in)) {
			while ("y".equalsIgnoreCase(inputStatus)) {
			    runner.getUserPreference();
			    runner.readFiles();
			    runner.findTShirt();

//			    System.out.print("do you: ");
//			    inputStatus = scanner.next();
			}
		}
    }

    public void getUserPreference() {
        tshirt = new TShirt();
        try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Colour: ");
			tshirt.setColour(sc.next());
			System.out.print("Gender(M OR F): ");
			tshirt.setGender(sc.next());
			System.out.print("Size(S,M,L,XL,XXL): ");
			tshirt.setSize(sc.next());
			System.out.print("Output Preference(Price,Rating or both): ");
			outputPreference = sc.next();
		}
    }

    public void readFiles() {
        Thread readFilesThread = new Thread(() -> {
            File[] files = new File("C:\\Users\\nishantchaudhary02\\Desktop\\shirt").
                    listFiles((obj) -> obj.isFile() && obj.getName().endsWith(".csv"));
            ReadCSV csvReader = new ReadCSV(files);
            csvReader.importData();
        });
        readFilesThread.start();
        try {
            readFilesThread.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void findTShirt() {
        HibernateReader hr = new HibernateReader(tshirt, outputPreference);
        hr.sortingTShirt();
    }

}
