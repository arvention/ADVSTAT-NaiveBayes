package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import helper.TallyGenerator;
import helper.TextReader;
import view.MainFrame;

public class OperationController {
	
	private static final OperationController operationController = new OperationController();
	private final String[] TEXT_FILES = new String[] { "txt" };
	private final MainFrame mainFrame = MainFrame.getInstance();
	
	private OperationController() {
		addListeners();
	}
	
	public static OperationController getInstance() {
		return OperationController.operationController;
	}
	
	private void addListeners() {
		
		mainFrame.getMenuItemParse().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				openTXTFile();
			}
			
		});
		
		mainFrame.getLabelOperationsParse().addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				openTXTFile();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsParse().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsParse().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsParse().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsParse().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
	}
	
	private void openTXTFile() {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Files", TEXT_FILES));
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(false);
		int returnVal = fc.showOpenDialog(mainFrame.getContentPane());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			ArrayList<String> texts = TextReader.read(fc.getSelectedFile().getAbsolutePath());
			
			mainFrame.getTextAreaTextFile().setText(String.join("\n\n", texts));
			Map<String, Integer> tally = TallyGenerator.getTally(texts);
			
			DefaultTableModel tableModel = (DefaultTableModel)mainFrame.getTableBagOfWords().getModel();
			tableModel.setRowCount(0);
			
			int len = tally.keySet().size();
			
			for(int i = 0; i < len; i++) {
				
				tableModel.addRow(new Object[]{tally.keySet().toArray()[i],
						tally.values().toArray()[i]});
				
			}
			
		}
	}
	
}
