package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.WordModel;

public class TallyRetriever {
	
	public static Map<WordModel, Integer> retrieveTally(ArrayList<String> input) {
		
		Map<WordModel, Integer> tally = new HashMap<WordModel, Integer>();
		
		for(String line : input) {
			
			String[] temp = line.split(",");
			
			tally.put(new WordModel(temp[0], temp[1]), Integer.parseInt(temp[2]));
		}
		
		return tally;
		
	}
	
}
