package model;

public class WordModel {
	
	private final String word;
	private final String tag;
	
	public WordModel(String word, String tag) {
		this.word = word;
		this.tag = tag;
	}

	public String getWord() {
		return word;
	}

	public String getTag() {
		return tag;
	}
	
	@Override
	public boolean equals(Object object) {
		boolean isEqual = false;
		WordModel model = (WordModel) object;
		
		if(model != null 
				&& model.getWord().equals(this.word)
				&& model.getTag().equals(this.tag))
			isEqual = true;
		
		return isEqual;
	}
	
	@Override
	public String toString() {
		return word + "-" + tag;
	}
	
	@Override
	public int hashCode() {
		return 1;
	}
	
}
