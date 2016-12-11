package process;

import java.util.ArrayList;
import java.util.Set;

import model.WordModel;

public class VocabCounter {
	
	public static int getVocabCount(Set<WordModel> words) {
		
		ArrayList<String> wordString = new ArrayList<String>();
		
		for(WordModel word : words) {
			
			if(!wordString.contains(word.getWord())) {
				wordString.add(word.getWord());
			}
			
		}
		
		return wordString.size();
		
	}
	
}
