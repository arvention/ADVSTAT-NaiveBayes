package process;

import java.util.Map;

import model.WordModel;

public class TallyMerger {
	
	public static Map<WordModel, Integer> mergeTally(Map<WordModel, Integer> tally1, Map<WordModel, Integer> tally2) {
		
		Map<WordModel, Integer> tallyFinal = tally1;
		/*
		for(WordModel word : tally1.keySet()) {
			if (!tallyFinal.containsKey(word)) {
				tallyFinal.put(word, tally1.get(word));
			}

			else {
				tallyFinal.replace(word, tallyFinal.get(word), tallyFinal.get(word) + tally1.get(word));
			}
		}
		*/
		for(WordModel word : tally2.keySet()) {
			if (!tallyFinal.containsKey(word)) {
				tallyFinal.put(word, tally2.get(word));
			}

			else {
				tallyFinal.replace(word, tallyFinal.get(word), tallyFinal.get(word) + tally2.get(word));
			}
		}
		
		return tallyFinal;
		
	}
	
}
