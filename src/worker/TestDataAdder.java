package worker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import controller.MainController;
import fileio.TextReader;
import model.FileModel;
import model.WordModel;
import process.TallyMaker;

public class TestDataAdder extends SwingWorker<ArrayList<FileModel>, String> {
	
	private File[] files;
	private JTextArea textArea;
	private JTable table;
	private MainController mainController;

	public TestDataAdder(File[] files, 
			JTextArea textArea, 
			JTable table, 
			MainController mainController) {
		
		this.files = files;
		this.textArea = textArea;
		this.table = table;
		this.mainController = mainController;
		
	}
	
	@Override
	protected ArrayList<FileModel> doInBackground() throws Exception {
		
		ArrayList<FileModel> testFiles = new ArrayList<FileModel>();
		
		for(File file : files) {
			
			ArrayList<String> texts = TextReader.read(file.getAbsolutePath());
			
			String tag = new String("Not Spam");
			if(file.getName().contains("spmsg")) {
				tag = "Spam";
			}
			
			Map<WordModel, Integer> tally = TallyMaker.makeTally(texts, tag);
			testFiles.add(new FileModel(file, tag, tally));
			
			publish(file.getName());
		}
		
		return testFiles;
	}
	
	@Override
	protected void process(List<String> chunks) {
		
		for (String chunk : chunks) {
			textArea.append("\nAdding " + chunk + " to Test Data");
		}
		textArea.repaint();
		textArea.revalidate();
		
	}
	
	protected void done() {
		
		textArea.append("\nFinished adding Test Data.\n");
		textArea.repaint();
		textArea.revalidate();
		
		try {
			mainController.addTestFiles(get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		
		for (FileModel fileModel : mainController.getTestFiles()) {
			tableModel.addRow(new Object[] {fileModel.getFile().getName()});
		}
		
		table.repaint();
		table.revalidate();
		
	}

}
