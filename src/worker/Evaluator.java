package worker;

import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import controller.MainController;


public class Evaluator extends SwingWorker<Void, String> {
	
	private JTextArea textArea;
	private MainController mainController;
	
	private int wordCount;
	private int spamCount;
	private int notSpamCount;
	
	public Evaluator(JTextArea textArea,
			MainController mainController) {
		
		this.textArea = textArea;
		this.mainController = mainController;
		
		wordCount = mainController.getWordList().size();
		spamCount = mainController.getSpamTrainCount();
		notSpamCount = mainController.getNotSpamTrainCount();
		
		showStart();
		
	}
	
	private void showStart() {
		
		textArea.append("\nStarting classification");
		textArea.repaint();
		textArea.revalidate();
		
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		
		System.out.println("SPAM COUNT: " + spamCount);
		System.out.println("NOT SPAM COUNT: " + notSpamCount);
		System.out.println("WORD COUNT: " + wordCount);
		
		return null;
	}
	
	@Override
	protected void process(List<String> chunks) {
		
		for (String chunk : chunks) {
			textArea.append(chunk);
		}
		textArea.repaint();
		textArea.revalidate();
		
	}
	
	@Override
	protected void done() {
		
	}
	
}
