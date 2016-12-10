package worker;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.WordModel;
import process.CSVIO;

public class TrainModelMerger extends SwingWorker<Map<WordModel, Integer>, String> {
	
	private File[] files;
	private JTextArea textArea;
	private JTable table;
	private MainController mainController;
	
	public TrainModelMerger(File[] files,
			JTextArea textArea,
			JTable table,
			MainController mainController) {
		
		this.files = files;
		this.textArea = textArea;
		this.table = table;
		this.mainController = mainController;
		
	}
	
	@Override
	protected Map<WordModel, Integer> doInBackground() throws Exception {
		Map<WordModel, Integer> tally = new HashMap<WordModel, Integer>();
		
		mainController.setSpamTrainCount(0);
		mainController.setNotSpamTrainCount(0);
		
		for(File file : files) {
			
			publish("\nMerging " + file.getName());
			
			ArrayList<String> input = CSVIO.read(file.getAbsolutePath());
			int len = input.size();
			
			for(int i = 0; i < len - 1; i++) {
				
				String[] temp = input.get(i).split(",");
				WordModel word = new WordModel(temp[0], temp[1]);
				
				if(!tally.containsKey(word)) {
					tally.put(word, Integer.parseInt(temp[2]));
				} else {
					tally.replace(word, tally.get(word), tally.get(word) + Integer.parseInt(temp[2]));
				}
			}
			
			String[] temp = input.get(len - 1).split(",");
			mainController.setSpamTrainCount(mainController.getSpamTrainCount() + Integer.parseInt(temp[1]));
			mainController.setNotSpamTrainCount(mainController.getNotSpamTrainCount() + Integer.parseInt(temp[2]));
			
		}
		
		System.out.println("SPAM COUNT: " + mainController.getSpamTrainCount());
		System.out.println("NOT SPAM COUNT: " + mainController.getNotSpamTrainCount());
		
		return tally;
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
		
		try {
			mainController.setBagOfWordsModel(get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);

		int lenKey = mainController.getBagOfWordsModel().keySet().size();

		for (int j = 0; j < lenKey; j++) {
			
			WordModel word = (WordModel)mainController.getBagOfWordsModel().keySet().toArray()[j];
			
			tableModel.addRow(new Object[] { word.getWord(), word.getTag(),
					mainController.getBagOfWordsModel().values().toArray()[j] });

		}

		table.repaint();
		table.revalidate();
		
		textArea.append("\nTrain Model merged.\n");
		textArea.repaint();
		textArea.revalidate();
	}
	
}
