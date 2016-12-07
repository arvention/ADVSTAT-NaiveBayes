package main;

import javax.swing.SwingUtilities;

import controller.MainController;
import controller.OperationController;
import view.MainFrame;

public class Main {
	
	public static void main(String[] args) {
		
		final MainFrame mainFrame = new MainFrame();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mainFrame.setVisible(true);
			}
		});
		MainController mainController = new MainController(mainFrame);
		new OperationController(mainFrame, mainController);
		
	}
	
}
