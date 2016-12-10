package worker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;

import controller.MainController;
import model.FileModel;

public class TestModelClearer extends SwingWorker<ArrayList<FileModel>, String>  {
	
	private JTextArea textArea;
	private JTable table;
	private MainController mainController;
	
	public TestModelClearer(JTextArea textArea,
			JTable table,
			MainController mainController) {
		
		this.textArea = textArea;
		this.table = table;
		this.mainController = mainController;
	}
	
	@Override
	protected ArrayList<FileModel> doInBackground() throws Exception {
		
		publish("\nClearing Test Model.");
		
		return new ArrayList<FileModel>();
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
		
		table.repaint();
		table.revalidate();
		
		textArea.append("\nTest Model cleared.\n");
		textArea.repaint();
		textArea.revalidate();
		
	}

}
