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

public class TestModelMerger extends SwingWorker<ArrayList<FileModel>, String> {
	
	private File[] files;
	private JTextArea textArea;
	private JTable table;
	private MainController mainController;
	
	public TestModelMerger(File[] files,
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
			
			publish("\nMerging " + file.getName());
			
			ArrayList<String> testFilenames = CSVIO.read(file.getAbsolutePath());
			
			for(String testFilename : testFilenames) {
				
				File fileTemp = new File(testFilename);
				
				String tag = new String("Not Spam");
				if(fileTemp.getName().contains("spmsg")) {
					tag = "Spam";
				}
				
				ArrayList<String> texts = TextReader.read(fileTemp.getAbsolutePath());
				Map<WordModel, Integer> tally = TallyMaker.makeTally(texts, tag);
				
				testFiles.add(new FileModel(fileTemp, tag, tally));
				
			}
			
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
		
		textArea.append("\nTest Model merged.\n");
		textArea.repaint();
		textArea.revalidate();
		
	}
	
}
