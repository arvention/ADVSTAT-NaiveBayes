package worker;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import controller.MainController;
import fileio.CSVIO;
import model.FileModel;

public class TestModelSaver extends SwingWorker<Void, String> {
	
	private String filepath;
	private JTextArea textArea;
	private MainController mainController;
	
	public TestModelSaver(String filepath,
			JTextArea textArea,
			MainController mainController) {
		
		this.filepath = filepath;
		this.textArea = textArea;
		this.mainController = mainController;
		
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		
		ArrayList<FileModel> testFiles = mainController.getTestFiles();
		ArrayList<String> output = new ArrayList<String>();
		
		publish("\nSaving Test Model as " + filepath.substring(filepath.lastIndexOf("\\") + 1));
		
		for(FileModel testFile : testFiles) {
			output.add(testFile.getFile().getAbsolutePath());
		}
		
		CSVIO.write(output, filepath);
		
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
		
		textArea.append("\nTest Model saved as " + filepath.substring(filepath.lastIndexOf("\\") + 1) + "\n");
		textArea.repaint();
		textArea.revalidate();
		
	}
	
}
