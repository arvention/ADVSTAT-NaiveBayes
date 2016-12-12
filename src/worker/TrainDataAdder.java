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
		
		//Map<WordModel, Integer> tallyFinal = new HashMap<WordModel, Integer>();
		Map<WordModel, Integer> tally = new HashMap<WordModel, Integer>();
		int spamDocTrainCount = 0;
		int notSpamDocTrainCount = 0;
		
		int spamWordTrainCount = 0;
		int notSpamWordTrainCount = 0;
		
		for (File file : files) {
			ArrayList<String> texts = TextReader.read(file.getAbsolutePath());
			
			String tag = new String("Not Spam");
			if(file.getName().contains("spmsg")) {
				tag = "Spam";
				spamDocTrainCount++;
			} else {
				notSpamDocTrainCount++;
			}
			
			for (String text : texts) {
				String s = text.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");

				String[] temp = s.split(" ");
				for (int j = 0; j < temp.length; j++) {

					WordModel word = new WordModel(temp[j], tag);
					
					if(tag == "Spam" && !temp[j].isEmpty())
						spamWordTrainCount++;
					else if (!temp[j].isEmpty())
						notSpamWordTrainCount++;
					
					if (!tally.containsKey(word) && !temp[j].isEmpty()) {
						tally.put(word, new Integer(1));
					}

					else if (!temp[j].isEmpty()) {
						tally.replace(word, tally.get(word), tally.get(word) + 1);
					}
					
					mainController.addWord(word.getWord());
					
				}
			}
			
			publish(file.getName());
		}
		
		mainController.setSpamDocTrainCount(mainController.getSpamDocTrainCount() + spamDocTrainCount);
		mainController.setNotSpamDocTrainCount(mainController.getNotSpamDocTrainCount() + notSpamDocTrainCount);
		
		mainController.setSpamWordTrainCount(mainController.getSpamWordTrainCount() + spamWordTrainCount);
		mainController.setNotSpamWordTrainCount(mainController.getNotSpamWordTrainCount() + notSpamWordTrainCount);
		
		return tally;
		
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
		
		textArea.append("\nFinished adding to Train Data.\n");
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
		
		System.out.println("SPAM DOC COUNT: " + mainController.getSpamDocTrainCount());
		System.out.println("NOT SPAM DOC COUNT: " + mainController.getNotSpamDocTrainCount());
		System.out.println("SPAM WORD COUNT: " + mainController.getSpamWordTrainCount());
		System.out.println("NOT SPAM WORD COUNT: " + mainController.getNotSpamWordTrainCount());
		System.out.println("WORD LIST COUNT: " + mainController.getWordList().size());
		
	}
}
