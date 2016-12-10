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
import fileio.TextReader;
import model.WordModel;
import process.TallyMaker;
import process.TallyMerger;

public class TrainDataAdder extends SwingWorker<Map<WordModel, Integer>, String> {

	private File[] files;
	private JTextArea textArea;
	private JTable table;
	private MainController mainController;

	public TrainDataAdder(File[] files, 
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
		
		int spamTrainCount = 0;
		int notSpamTrainCount = 0;
		
		for (File file : files) {
			ArrayList<String> texts = TextReader.read(file.getAbsolutePath());
			
			String tag = new String("Not Spam");
			if(file.getName().contains("spmsg")) {
				tag = "Spam";
				spamTrainCount++;
			} else {
				notSpamTrainCount++;
			}
			
			Map<WordModel, Integer> tally = TallyMaker.makeTally(texts, tag);
			tallyFinal = TallyMerger.mergeTally(tallyFinal, tally);
			
			publish(file.getName());
		}
		
		mainController.setSpamTrainCount(mainController.getSpamTrainCount() + spamTrainCount);
		mainController.setNotSpamTrainCount(mainController.getNotSpamTrainCount() + notSpamTrainCount);
		
		return tallyFinal;
		
	}

	@Override
	protected void process(List<String> chunks) {
		for (String chunk : chunks) {
			textArea.append("\nAdding " + chunk + " to Train Data");
		}
		textArea.repaint();
		textArea.revalidate();
	}

	@Override
	protected void done() {
		
		textArea.append("\nFinished adding Train Data.\n");
		textArea.repaint();
		textArea.revalidate();
		
		Map<WordModel, Integer> tallyFinal = mainController.getBagOfWordsModel();
		
		try {
			tallyFinal = TallyMerger.mergeTally(tallyFinal, get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		mainController.setBagOfWordsModel(tallyFinal);
		
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
		
		System.out.println("SPAM COUNT: " + mainController.getSpamTrainCount());
		System.out.println("NOT SPAM COUNT: " + mainController.getNotSpamTrainCount());
		
	}
}
