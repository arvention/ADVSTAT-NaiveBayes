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
import fileio.CSVIO;
import model.WordModel;

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
		
		Map<WordModel, Integer> tallyFinal = new HashMap<WordModel, Integer>();
		
		mainController.setSpamWordTrainCount(0);
		mainController.setNotSpamWordTrainCount(0);
		
		mainController.setSpamDocTrainCount(0);
		mainController.setNotSpamDocTrainCount(0);
		
		mainController.setWordList(new ArrayList<String>());
		
		for(File file : files) {
			
			publish("\nMerging " + file.getName());
			
			ArrayList<String> input = CSVIO.read(file.getAbsolutePath());
			int len = input.size();
			
			String[] temp = input.remove(len - 1).split(",");
			mainController.setSpamWordTrainCount(mainController.getSpamWordTrainCount() + Integer.parseInt(temp[1]));
			mainController.setNotSpamWordTrainCount(mainController.getNotSpamWordTrainCount() + Integer.parseInt(temp[2]));
			
			len = input.size();
			temp = input.remove(len - 1).split(",");
			mainController.setSpamDocTrainCount(mainController.getSpamDocTrainCount() + Integer.parseInt(temp[1]));
			mainController.setNotSpamDocTrainCount(mainController.getNotSpamDocTrainCount() + Integer.parseInt(temp[2]));
			
			for(String s : input) {
				
				temp = s.split(",");
				WordModel word = new WordModel(temp[0], temp[1]);
				
				if(!tallyFinal.containsKey(word)) {
					tallyFinal.put(word, Integer.parseInt(temp[2]));
				} else {
					tallyFinal.replace(word, tallyFinal.get(word), tallyFinal.get(word) + Integer.parseInt(temp[2]));
				}
				
				mainController.addWord(word.getWord());
				
			}
			
			// Map<WordModel, Integer> tally = TallyRetriever.retrieveTally(input);
			// tallyFinal = TallyMerger.mergeTally(tallyFinal, tally);
			
		}
		
		return tallyFinal;
		
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
		/*
		int lenKey = mainController.getBagOfWordsModel().keySet().size();
		
		for (int j = 0; j < lenKey; j++) {
			
			WordModel word = (WordModel)mainController.getBagOfWordsModel().keySet().toArray()[j];
			
			tableModel.addRow(new Object[] { word.getWord(), word.getTag(),
					mainController.getBagOfWordsModel().values().toArray()[j] });

		}
		*/
		table.repaint();
		table.revalidate();
		
		textArea.append("\nTrain Model merged.\n");
		textArea.repaint();
		textArea.revalidate();
		
		System.out.println("SPAM DOC COUNT: " + mainController.getSpamDocTrainCount());
		System.out.println("NOT SPAM DOC COUNT: " + mainController.getNotSpamDocTrainCount());
		System.out.println("SPAM WORD COUNT: " + mainController.getSpamWordTrainCount());
		System.out.println("NOT SPAM WORD COUNT: " + mainController.getNotSpamWordTrainCount());
		System.out.println("WORD LIST COUNT: " + mainController.getWordList().size());
		
	}
	
}
