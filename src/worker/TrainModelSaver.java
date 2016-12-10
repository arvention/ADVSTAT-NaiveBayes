package worker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import controller.MainController;
import model.WordModel;
import process.CSVIO;

public class TrainModelSaver extends SwingWorker<Void, String> {

	private String filepath;
	private JTextArea textArea;
	private MainController mainController;
	
	public TrainModelSaver(String filepath, 
			JTextArea textArea, 
			MainController mainController) {
		
		this.filepath = filepath;
		this.textArea = textArea;
		this.mainController = mainController;
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		
		Map<WordModel, Integer> trainModelMap = mainController.getBagOfWordsModel();
		ArrayList<String> output = new ArrayList<String>();
		
		publish("\nSaving Train Model as " + filepath.substring(filepath.lastIndexOf("\\") + 1));
		
		for(WordModel word : trainModelMap.keySet()) {
			output.add(word.getWord() + "," + word.getTag() + "," + trainModelMap.get(word));
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
		textArea.append("\nTrain Model saved as " + filepath.substring(filepath.lastIndexOf("\\") + 1) + "\n");
		textArea.repaint();
		textArea.revalidate();
	}
}
