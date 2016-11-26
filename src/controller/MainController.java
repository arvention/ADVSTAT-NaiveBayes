package controller;

import view.MainFrame;

public class MainController {
	
	private static final MainController mainController = new MainController();
	private final MainFrame mainFrame = MainFrame.getInstance();
	
	private MainController() {
		mainFrame.setVisible(true);
	}
	
	public static MainController getInstance() {
		return MainController.mainController;
	}
	
}
