package process;

import java.util.HashMap;
import java.util.Map;

import model.WordModel;

public class ProbabilityComputer {
	
	public static Map<WordModel, Double> getProbabilityMap(Map<WordModel, Integer> wordFrequency, 
			int wordCount, 
			int spamWordCount, 
			int notSpamWordCount) {
		
		Map<WordModel, Double> probabilityMap = new HashMap<WordModel, Double>();
		
		for(WordModel word : wordFrequency.keySet()) {
			if(word.getTag().equals("Spam"))
				probabilityMap.put(word, new Double((wordFrequency.get(word) + 1.0) / (spamWordCount + wordCount)));
			else 
				probabilityMap.put(word, new Double((wordFrequency.get(word) + 1.0) / (notSpamWordCount + wordCount)));
			
		}
		
		return probabilityMap;
		
	}
	
}
