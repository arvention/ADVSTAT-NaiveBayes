package model;

import java.io.File;
import java.util.Map;

public class FileModel {
	
	private File file;
	private Map<WordModel, Integer> tally;
	
	public FileModel(File file, Map<WordModel, Integer> tally) {
		this.file = file;
		this.tally = tally;
	}
	
	public File getFile() {
		return file;
	}
	
	public Map<WordModel, Integer> getTally() {
		return tally;
	}
	
}
