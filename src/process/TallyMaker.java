package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.WordModel;

public class TallyMaker {
	
	public static Map<WordModel, Integer> makeTally(ArrayList<String> texts, String tag) {
		
		Map<WordModel, Integer> tally = new HashMap<WordModel, Integer>();
		
		for (String text : texts) {
			String s = text.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");

			String[] temp = s.split(" ");
			for (int j = 0; j < temp.length; j++) {

				WordModel word = new WordModel(temp[j], tag);

				if (!tally.containsKey(word) && !temp[j].isEmpty()) {
					tally.put(word, new Integer(1));
				}

				else if (!temp[j].isEmpty()) {
					tally.replace(word, tally.get(word), tally.get(word) + 1);
				}
			}
		}
		
		return tally;
		
	}
	
}
