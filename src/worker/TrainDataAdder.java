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
import process.TextReader;

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
		Map<WordModel, Integer> tally = new HashMap<WordModel, Integer>();
		int len = files.length;
		for (int i = 0; i < len; i++) {
			ArrayList<String> texts = TextReader.read(files[i].getAbsolutePath());
			
			String tag = new String("Not Spam");
			if(files[i].getName().contains("spmsg")) {
				tag = "Spam";
			}
			for (String text : texts) {
				String s = text.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");

				String[] temp = s.split(" ");
				for (int j = 0; j < temp.length; j++) {

					WordModel word = new WordModel(temp[j], tag);

					if (!tally.containsKey(word) && !temp[j].isEmpty()) {
						tally.put(word, new Integer(1));
					}

					else if (!temp[j].isEmpty()) {
						tally.replace(word, tally.get(word), tally.get(word) + 1);
					}
				}
			}
			publish(files[i].getName());
		}

		return tally;
	}

	@Override
	protected void process(List<String> chunks) {
		for (String chunk : chunks) {
			textArea.append("\nOpening " + chunk);
		}
		textArea.repaint();
		textArea.revalidate();
	}

	@Override
	protected void done() {

		try {
			mainController.getBagOfWordsModel().putAll(get());
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

	}
}
