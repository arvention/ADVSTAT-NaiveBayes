package worker;

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
		
		mainController.setSpamTrainCount(0);
		mainController.setNotSpamTrainCount(0);
		
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
		
		System.out.println("SPAM COUNT: " + mainController.getSpamTrainCount());
		System.out.println("NOT SPAM COUNT: " + mainController.getNotSpamTrainCount());
		
	}

}
