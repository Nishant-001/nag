package csvReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;

import domain.*;
public class CSVReader extends TimerTask{
	public static ArrayList<Tshirt> getAllTshirts() {
		ArrayList<Tshirt> getalldata = new ArrayList<Tshirt>();
		CSVReaderMethod("src\\main\\resources\\Adidas.csv", getalldata);
		CSVReaderMethod("src\\main\\resources\\Nike.csv", getalldata);
		CSVReaderMethod("src\\main\\resources\\Puma.csv", getalldata);
		return getalldata;
	}

	private static void CSVReaderMethod(String filePath, ArrayList<Tshirt> getalldata) {
		try {
			CSVParser parser = new CSVParserBuilder().withSeparator('|').withIgnoreQuotations(true).build();
			com.opencsv.CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath)).withCSVParser(parser).withSkipLines(1)
					.build();

			String[] line;
			try {
				while ((line = csvReader.readNext()) != null) {
					Tshirt tshirt = new Tshirt();

					tshirt.setId(line[0]);
					tshirt.setName(line[1]);
					tshirt.setColor(Color.valueOf(line[2].toUpperCase()));
					tshirt.setGender(Gender.valueOf(line[3].toUpperCase()));
					tshirt.setSize(Size.valueOf(line[4].toUpperCase()));
					tshirt.setPrice(Double.parseDouble(line[5]));
					tshirt.setRating(Double.parseDouble(line[6]));
					tshirt.setAvailability(line[7]);

					getalldata.add(tshirt);

				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		getAllTshirts();
		
	}
}
