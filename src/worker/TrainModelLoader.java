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
import fileio.CSVIO;
import model.WordModel;

public class TrainModelLoader extends SwingWorker<Map<WordModel, Integer>, String[]> {
	
	private String filepath;
	private JTextArea textArea;
	private JTable table;
	private MainController mainController;
	
	public TrainModelLoader(String filepath, 
			JTextArea textArea, 
			JTable table, 
			MainController mainController) {
		
		this.filepath = filepath;
		this.textArea = textArea;
		this.table = table;
		this.mainController = mainController;
		
		showStart();
		
	}
	
	private void showStart() {
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		textArea.append("\nLoading Train Model from " + filepath.substring(filepath.lastIndexOf("\\") + 1));
		
	}
	
	@Override
	protected Map<WordModel, Integer> doInBackground() throws Exception {
		
		Map<WordModel, Integer> bagOfWordsModel = new HashMap<WordModel, Integer>();
		ArrayList<String> input = CSVIO.read(filepath);
		
		int len = input.size();
		
		String[] temp = input.remove(len - 1).split(",");
		mainController.setSpamWordTrainCount(Integer.parseInt(temp[1]));
		mainController.setNotSpamWordTrainCount(Integer.parseInt(temp[2]));
		
		len = input.size();
		
		temp = input.remove(len - 1).split(",");
		mainController.setSpamDocTrainCount(Integer.parseInt(temp[1]));
		mainController.setNotSpamDocTrainCount(Integer.parseInt(temp[2]));
		
		mainController.setWordList(new ArrayList<String>());
		
		for(String line : input) {
			
			temp = line.split(",");
			publish(temp);
			bagOfWordsModel.put(new WordModel(temp[0], temp[1]), Integer.parseInt(temp[2]));
			mainController.addWord(temp[0]);
			
		}
		
		return bagOfWordsModel;
	}
	
	@Override
	protected void process(List<String[]> chunks) {
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		for (String[] chunk : chunks) {
			tableModel.addRow(new Object[] { chunk[0], chunk[1],
					chunk[2] });
		}
		table.repaint();
		table.revalidate();
	}
	
	@Override
	protected void done() {
		
		try {
			mainController.setBagOfWordsModel(get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		int lenKey = mainController.getBagOfWordsModel().keySet().size();
		
		textArea.append("\nTrain Model loaded from " + filepath.substring(filepath.lastIndexOf("\\") + 1) + " with " + lenKey + " words.\n");
		textArea.repaint();
		textArea.revalidate();
		
		System.out.println("SPAM DOC COUNT: " + mainController.getSpamDocTrainCount());
		System.out.println("NOT SPAM DOC COUNT: " + mainController.getNotSpamDocTrainCount());
		System.out.println("SPAM WORD COUNT: " + mainController.getSpamWordTrainCount());
		System.out.println("NOT SPAM WORD COUNT: " + mainController.getNotSpamWordTrainCount());
		System.out.println("WORD LIST COUNT: " + mainController.getWordList().size());
		
	}
	
}
