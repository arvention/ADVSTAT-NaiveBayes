package worker;

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

public class TrainModelClearer extends SwingWorker<Map<WordModel, Integer>, String> {
	
	private JTextArea textArea;
	private JTable table;
	private MainController mainController;
	
	public TrainModelClearer(JTextArea textArea,
			JTable table,
			MainController mainController) {
		this.textArea = textArea;
		this.table = table;
		this.mainController = mainController;
	}
	
	@Override
	protected Map<WordModel, Integer> doInBackground() throws Exception {
		
		publish("\nClearing Train Model.");
		
		mainController.setSpamDocTrainCount(0);
		mainController.setNotSpamDocTrainCount(0);
		
		mainController.setSpamWordTrainCount(0);
		mainController.setNotSpamWordTrainCount(0);
		
		return new HashMap<WordModel, Integer>();
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
		
		mainController.setWordList(new ArrayList<String>());
		
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
		
		textArea.append("\nTrain Model cleared.\n");
		textArea.repaint();
		textArea.revalidate();
		
		System.out.println("SPAM DOC COUNT: " + mainController.getSpamDocTrainCount());
		System.out.println("NOT SPAM DOC COUNT: " + mainController.getNotSpamDocTrainCount());
		System.out.println("SPAM WORD COUNT: " + mainController.getSpamWordTrainCount());
		System.out.println("NOT SPAM WORD COUNT: " + mainController.getNotSpamWordTrainCount());
		System.out.println("WORD LIST COUNT: " + mainController.getWordList().size());
		
	}

}
