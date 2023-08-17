package applicationMain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import csvReader.CSVReader;
import domain.*;
import tshirtSearch.TshirtSearch;
import tshirtSearchOutput.TshirtSearchOutput;
import view.*;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input input = new Input();
		Timer timer = new Timer();
        
        // CSVReader class extends TimerTask
        TimerTask task = new CSVReader();
         
        /*
         *  Schedule() method calls for timer class.
         *  void schedule(TimerTask task, Date firstTime, long period)
         */
         
        timer.schedule(task, 200, 5000);
		TshirtSearch tshirtSearch = input.getInput();

		TshirtSearchOutput tshirtsearchoutput = new TshirtSearchOutput();
		ArrayList<Tshirt> matchedTShirts = null;
		try {
			matchedTShirts = tshirtsearchoutput.getMatchingTshirts(tshirtSearch);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Output output = new Output();
		output.displayOutput(matchedTShirts);
		
	}
}
	
