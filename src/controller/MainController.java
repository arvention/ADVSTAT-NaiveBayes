package controller;

import java.awt.Color;
import java.awt.Cursor;
import java.util.HashMap;
import java.util.Map;

import model.WordModel;
import view.MainFrame;

public class MainController {

	private final MainFrame mainFrame;

	public static final Color COLOR_SELECTED = new Color(255, 0, 0);
	public static final Cursor CURSOR_SELECTED = new Cursor(Cursor.HAND_CURSOR);

	public static final Color COLOR_INACTIVE = new Color(0, 0, 0);
	public static final Cursor CURSOR_INACTIVE = new Cursor(Cursor.DEFAULT_CURSOR);

	private Map<WordModel, Integer> bagOfWordsModel;
	private int spamTrainCount;
	private int notSpamTrainCount;

	public MainController(MainFrame mainFrame) {
		bagOfWordsModel = new HashMap<WordModel, Integer>();
		spamTrainCount = 0;
		notSpamTrainCount = 0;

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

	public int getSpamTrainCount() {
		return spamTrainCount;
	}

	public void setSpamTrainCount(int spamTrainCount) {
		this.spamTrainCount = spamTrainCount;
	}

	public int getNotSpamTrainCount() {
		return notSpamTrainCount;
	}

	public void setNotSpamTrainCount(int notSpamTrainCount) {
		this.notSpamTrainCount = notSpamTrainCount;
	}

}
