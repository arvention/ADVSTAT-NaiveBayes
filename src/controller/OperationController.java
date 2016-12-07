package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.MainFrame;
import worker.StatusUpdater;

public class OperationController {
	
	private final String[] TEXT_FILES = new String[] { "txt" };
	//private final String[] CSV_FILES = new String[] { "csv" };
	private final MainFrame mainFrame;
	private final MainController mainController;
	
	public OperationController(MainFrame mainFrame, 
			MainController mainController) {
		this.mainFrame = mainFrame;
		this.mainController = mainController;
		addListeners();
	}
	
	private void addListeners() {
		
		mainFrame.getMenuItemAddTrainData().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		mainFrame.getMenuItemAddTestData().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		mainFrame.getMenuItemLoadTrainModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		mainFrame.getMenuItemSaveTrainModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		mainFrame.getMenuItemClearTrainModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		mainFrame.getMenuItemMergeTrainModels().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		mainFrame.getMenuItemLoadTestModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		mainFrame.getMenuItemSaveTestModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		mainFrame.getMenuItemClearTestModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		mainFrame.getMenuItemMergeTestModels().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		
		
		mainFrame.getMenuItemEvaluate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		});
		
		mainFrame.getLabelOperationsAddTrainData().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				addTrainData();
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsAddTrainData().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsAddTrainData().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsAddTrainData().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsAddTrainData().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		mainFrame.getLabelOperationsAddTestData().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsAddTestData().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsAddTestData().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsAddTestData().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsAddTestData().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		mainFrame.getLabelOperationsLoadTrainModel().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsLoadTrainModel().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsLoadTrainModel().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsLoadTrainModel().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsLoadTrainModel().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		mainFrame.getLabelOperationsSaveTrainModel().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsSaveTrainModel().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsSaveTrainModel().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsSaveTrainModel().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsSaveTrainModel().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		mainFrame.getLabelOperationsLoadTestModel().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsLoadTestModel().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsLoadTestModel().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsLoadTestModel().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsLoadTestModel().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		mainFrame.getLabelOperationsSaveTestModel().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsSaveTestModel().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsSaveTestModel().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsSaveTestModel().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsSaveTestModel().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		mainFrame.getLabelOperationsClearTrainModel().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsClearTrainModel().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsClearTrainModel().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsClearTrainModel().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsClearTrainModel().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		mainFrame.getLabelOperationsClearTestModel().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsClearTestModel().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsClearTestModel().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsClearTestModel().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsClearTestModel().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
		
		mainFrame.getLabelOperationsMergeTrainModels().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsMergeTrainModels().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsMergeTrainModels().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsMergeTrainModels().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsMergeTrainModels().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		mainFrame.getLabelOperationsMergeTestModels().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsMergeTestModels().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsMergeTestModels().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsMergeTestModels().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsMergeTestModels().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		mainFrame.getLabelOperationsEvaluate().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				mainFrame.getLabelOperationsEvaluate().setForeground(MainController.COLOR_SELECTED);
				mainFrame.getLabelOperationsEvaluate().setCursor(MainController.CURSOR_SELECTED);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				mainFrame.getLabelOperationsEvaluate().setForeground(MainController.COLOR_INACTIVE);
				mainFrame.getLabelOperationsEvaluate().setCursor(MainController.CURSOR_INACTIVE);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}
			
		});
	}
	
	private void addTrainData() {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Files", TEXT_FILES));
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(true);
		int returnVal = fc.showOpenDialog(mainFrame.getContentPane());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			StatusUpdater statusUpdater = new StatusUpdater(fc.getSelectedFiles(),
					mainFrame.getTextAreaStatus(), 
					mainFrame.getTableTrainModel(),
					mainController);
			statusUpdater.execute();
		}
	}
	
}
