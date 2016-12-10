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
import process.CSVIO;

public class TrainModelLoader extends SwingWorker<Map<WordModel, Integer>, String> {
	
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
	}
	
	@Override
	protected Map<WordModel, Integer> doInBackground() throws Exception {
		
		Map<WordModel, Integer> bagOfWordsModel = new HashMap<WordModel, Integer>();
		ArrayList<String> input = CSVIO.read(filepath);
		
		publish("\nLoading Train Model from " + filepath.substring(filepath.lastIndexOf("\\") + 1));
		int len = input.size();
		
		for(int i = 0; i < len - 1; i++) {
			
			String[] temp = input.get(i).split(",");
			bagOfWordsModel.put(new WordModel(temp[0], temp[1]), Integer.parseInt(temp[2]));
			
		}
		
		String[] temp = input.get(len - 1).split(",");
		mainController.setSpamTrainCount(Integer.parseInt(temp[1]));
		mainController.setNotSpamTrainCount(Integer.parseInt(temp[2]));
		System.out.println("SPAM COUNT: " + mainController.getSpamTrainCount());
		System.out.println("NOT SPAM COUNT: " + mainController.getNotSpamTrainCount());
		
		return bagOfWordsModel;
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
		
		textArea.append("\nTrain Model loaded from " + filepath.substring(filepath.lastIndexOf("\\") + 1) + " with " + lenKey + " words.\n");
		textArea.repaint();
		textArea.revalidate();
	}
	
}
