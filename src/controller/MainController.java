package controller;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.FileModel;
import model.WordModel;
import view.MainFrame;

public class MainController {

	private final MainFrame mainFrame;

	public static final Color COLOR_SELECTED = new Color(255, 0, 0);
	public static final Cursor CURSOR_SELECTED = new Cursor(Cursor.HAND_CURSOR);

	public static final Color COLOR_INACTIVE = new Color(0, 0, 0);
	public static final Cursor CURSOR_INACTIVE = new Cursor(Cursor.DEFAULT_CURSOR);

	private Map<WordModel, Integer> bagOfWordsModel;
	private int spamDocTrainCount;
	private int notSpamDocTrainCount;
	
	private int spamWordTrainCount;
	private int notSpamWordTrainCount;
	
	private ArrayList<FileModel> testFiles;
	ArrayList<String> wordList;
	
	public MainController(MainFrame mainFrame) {
		bagOfWordsModel = new HashMap<WordModel, Integer>();
		spamDocTrainCount = 0;
		notSpamDocTrainCount = 0;
		
		testFiles = new ArrayList<FileModel>();
		wordList = new ArrayList<String>();
		
		this.mainFrame = mainFrame;
		mainFrame.setVisible(true);
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public Map<WordModel, Integer> getBagOfWordsModel() {
		return bagOfWordsModel;
	}

	public void setBagOfWordsModel(Map<WordModel, Integer> bagOfWordsModel) {
		this.bagOfWordsModel = bagOfWordsModel;
	}

	public int getSpamDocTrainCount() {
		return spamDocTrainCount;
	}

	public void setSpamDocTrainCount(int spamDocTrainCount) {
		this.spamDocTrainCount = spamDocTrainCount;
	}

	public int getNotSpamDocTrainCount() {
		return notSpamDocTrainCount;
	}

	public void setNotSpamDocTrainCount(int notSpamDocTrainCount) {
		this.notSpamDocTrainCount = notSpamDocTrainCount;
	}
	
	public int getSpamWordTrainCount() {
		return spamWordTrainCount;
	}

	public void setSpamWordTrainCount(int spamWordTrainCount) {
		this.spamWordTrainCount = spamWordTrainCount;
	}

	public int getNotSpamWordTrainCount() {
		return notSpamWordTrainCount;
	}

	public void setNotSpamWordTrainCount(int notSpamWordTrainCount) {
		this.notSpamWordTrainCount = notSpamWordTrainCount;
	}

	public ArrayList<FileModel> getTestFiles() {
		return testFiles;
	}
	
	public void addTestFiles(ArrayList<FileModel> testFiles) {
		for (FileModel testFile : testFiles) {
			this.testFiles.add(testFile);
		}
	}
	
	public void setTestFiles(ArrayList<FileModel> testFiles) {
		this.testFiles = testFiles;
	}
	
	public ArrayList<String> getWordList() {
		return wordList;
	}
	
	public void addWord(String word) {
		if(!this.wordList.contains(word)) {
			this.wordList.add(word);
		}
	}
	
	public void setWordList(ArrayList<String> wordList) {
		this.wordList = wordList;
	}

}
