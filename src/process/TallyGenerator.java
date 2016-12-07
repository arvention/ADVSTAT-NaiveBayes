package process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.WordModel;

public class TallyGenerator {
	
	public static Map<WordModel, Integer> getTally(ArrayList<String> texts, String tag) {
		Map<WordModel, Integer> tally = new HashMap<WordModel, Integer>();
		
		for(String text : texts) {
			
			String s = text.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
			//System.out.println(s);
			
			String[] temp = s.split(" ");
			for(int i = 0; i < temp.length; i++) {
				if(!tally.containsKey(new WordModel(temp[i], tag)) && !temp[i].isEmpty()) {
					tally.put(new WordModel(temp[i], tag), new Integer(1));
				}
				
				else if(!temp[i].isEmpty()) {
					tally.replace(new WordModel(temp[i], tag), tally.get(new WordModel(temp[i], tag)), tally.get(new WordModel(temp[i], tag)) + 1);
				}
				
			}
		}
		
		//System.out.println(tally.keySet());
		//System.out.println(tally.values());
		
		return tally;
	}
	
}
