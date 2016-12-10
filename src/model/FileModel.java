package model;

import java.io.File;
import java.util.Map;

public class FileModel {
	
	private File file;
	private String tag;
	private Map<WordModel, Integer> tally;
	
	public FileModel(File file, 
			String tag,
			Map<WordModel, Integer> tally) {
		
		this.file = file;
		this.tag = tag;
		this.tally = tally;
	}
	
	public File getFile() {
		return file;
	}
	
	public String getTag() {
		return tag;
	}
	
	public Map<WordModel, Integer> getTally() {
		return tally;
	}
	
}
