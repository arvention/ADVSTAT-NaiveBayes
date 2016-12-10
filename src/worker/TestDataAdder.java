package worker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import controller.MainController;
import model.FileModel;

public class TestDataAdder extends SwingWorker<ArrayList<FileModel>, String> {
	
	private File[] files;
	private JTextArea textArea;
	private JTable table;
	private MainController mainController;

	public TestDataAdder(File[] files, 
			JTextArea textArea, 
			JTable table, 
			MainController mainController) {
		
		this.files = files;
		this.textArea = textArea;
		this.table = table;
		this.mainController = mainController;
		
	}
	
	@Override
	protected ArrayList<FileModel> doInBackground() throws Exception {
		
		ArrayList<FileModel> testFiles = new ArrayList<FileModel>();
		
		for(File file : files) {
			
		}
		
		return testFiles;
	}
	
	@Override
	protected void process(List<String> chunks) {
		for (String chunk : chunks) {
			textArea.append("\nAdding " + chunk + " to Test Data");
		}
		textArea.repaint();
		textArea.revalidate();
	}
	
	protected void done() {
		
	}

}
