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
import fileio.CSVIO;
import fileio.TextReader;
import model.FileModel;
import model.WordModel;
import process.TallyMaker;

public class TestModelLoader extends SwingWorker<ArrayList<FileModel>, String> {
	
	private String filepath;
	private JTextArea textArea;
	private JTable table;
	private MainController mainController;
	
	public TestModelLoader(String filepath, 
			JTextArea textArea, 
			JTable table, 
			MainController mainController) {
		
		this.filepath = filepath;
		this.textArea = textArea;
		this.table = table;
		this.mainController = mainController;
	}
	
	@Override
	protected ArrayList<FileModel> doInBackground() throws Exception {
		
		ArrayList<FileModel> testFiles = new ArrayList<FileModel>();
		ArrayList<String> testFilenames = CSVIO.read(filepath);
		
		publish("\nLoading Test Model from " + filepath.substring(filepath.lastIndexOf("\\") + 1));
		
		for(String testFilename : testFilenames) {
			
			File file = new File(testFilename);
			
			String tag = new String("Not Spam");
			if(file.getName().contains("spmsg")) {
				tag = "Spam";
			}
			ArrayList<String> texts = TextReader.read(file.getAbsolutePath());
			Map<WordModel, Integer> tally = TallyMaker.makeTally(texts, tag);
			
			testFiles.add(new FileModel(file, tag, tally));
			
		}
		
		return testFiles;
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
			mainController.setTestFiles(get());
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
		
		textArea.append("\nTest Model loaded from " + filepath.substring(filepath.lastIndexOf("\\") + 1) + " with " + mainController.getTestFiles().size() + " files.\n");
		textArea.repaint();
		textArea.revalidate();
		
	}
	
}
