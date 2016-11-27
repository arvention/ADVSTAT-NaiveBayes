package controller;

import java.awt.Color;
import java.awt.Cursor;

import view.MainFrame;

public class MainController {
	
	private static final MainController mainController = new MainController();
	private final MainFrame mainFrame = MainFrame.getInstance();
	
	public static final Color COLOR_SELECTED = new Color(255, 0, 0);
	public static final Cursor CURSOR_SELECTED = new Cursor(Cursor.HAND_CURSOR);

	public static final Color COLOR_INACTIVE = new Color(0, 0, 0);
	public static final Cursor CURSOR_INACTIVE = new Cursor(Cursor.DEFAULT_CURSOR);
	
	private MainController() {
		OperationController.getInstance();
		
		mainFrame.setVisible(true);
	}
	
	public static MainController getInstance() {
		return MainController.mainController;
	}
	
}
