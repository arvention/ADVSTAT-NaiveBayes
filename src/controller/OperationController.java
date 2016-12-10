package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import view.MainFrame;
import worker.TestDataAdder;
import worker.TestModelClearer;
import worker.TestModelLoader;
import worker.TestModelMerger;
import worker.TestModelSaver;
import worker.TrainDataAdder;
import worker.TrainModelClearer;
import worker.TrainModelLoader;
import worker.TrainModelMerger;
import worker.TrainModelSaver;

public class OperationController {
	
	private final String[] TEXT_FILES = new String[] { "txt" };
	private final String[] CSV_FILES = new String[] { "csv" };
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
				addTrainData();
			}
			
		});
		
		mainFrame.getMenuItemLoadTrainModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadTrainModel();
			}
			
		});
		
		mainFrame.getMenuItemSaveTrainModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveTrainModel();
			}
			
		});
		
		mainFrame.getMenuItemClearTrainModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearTrainModel();
			}
			
		});
		
		mainFrame.getMenuItemMergeTrainModels().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mergeTrainModels();
			}
			
		});
		
		mainFrame.getMenuItemAddTestData().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addTestData();
			}
			
		});
		
		mainFrame.getMenuItemLoadTestModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadTestModel();
			}
			
		});
		
		mainFrame.getMenuItemSaveTestModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveTestModel();
			}
			
		});
		
		mainFrame.getMenuItemClearTestModel().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				clearTestModel();
			}
			
		});
		
		mainFrame.getMenuItemMergeTestModels().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mergeTestModel();
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
		
		mainFrame.getLabelOperationsLoadTrainModel().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loadTrainModel();
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
				saveTrainModel();
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
		
		mainFrame.getLabelOperationsClearTrainModel().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clearTrainModel();
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
		
		mainFrame.getLabelOperationsMergeTrainModels().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mergeTrainModels();
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
		
		mainFrame.getLabelOperationsAddTestData().addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				addTestData();
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
		
		mainFrame.getLabelOperationsLoadTestModel().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loadTestModel();
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
				saveTestModel();
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
		
		mainFrame.getLabelOperationsClearTestModel().addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clearTestModel();
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
		
		mainFrame.getLabelOperationsMergeTestModels().addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mergeTestModel();
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
			
			TrainDataAdder trainDataAdder = new TrainDataAdder(fc.getSelectedFiles(),
					mainFrame.getTextAreaStatus(), 
					mainFrame.getTableTrainModel(),
					mainController);
			trainDataAdder.execute();
			
		}
		
	}
	
	private void loadTrainModel() {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", CSV_FILES));
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(false);
		
		int returnVal = fc.showOpenDialog(mainFrame.getContentPane());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			TrainModelLoader trainModelLoader = new TrainModelLoader(fc.getSelectedFile().getAbsolutePath(), 
					mainFrame.getTextAreaStatus(), 
					mainFrame.getTableTrainModel(),
					mainController);
			trainModelLoader.execute();
			
		}
		
	}
	
	private void saveTrainModel() {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", CSV_FILES));
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(false);
		
		int returnVal = fc.showSaveDialog(mainFrame.getContentPane());
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			String filepath = fc.getSelectedFile().getAbsolutePath();
			
			if(!filepath.endsWith(CSV_FILES[0])) {
				filepath += "." + CSV_FILES[0];
			}
			
			TrainModelSaver trainModelSaver = new TrainModelSaver(filepath, 
					mainFrame.getTextAreaStatus(), 
					mainController);
			trainModelSaver.execute();
		}
		
	}
	
	private void clearTrainModel() {
		TrainModelClearer trainModelClearer = new TrainModelClearer(mainFrame.getTextAreaStatus(), 
				mainFrame.getTableTrainModel(),
				mainController);
		trainModelClearer.execute();
	}
	
	private void mergeTrainModels() {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", CSV_FILES));
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(true);
		
		int returnVal = fc.showOpenDialog(mainFrame.getContentPane());
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			TrainModelMerger trainModelMerger = new TrainModelMerger(fc.getSelectedFiles(),
					mainFrame.getTextAreaStatus(), 
					mainFrame.getTableTrainModel(),
					mainController);
			trainModelMerger.execute();
			
		}
		
	}
	
	private void addTestData() {
		
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Files", TEXT_FILES));
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(true);
		
		int returnVal = fc.showOpenDialog(mainFrame.getContentPane());

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			TestDataAdder testDataAdder = new TestDataAdder(fc.getSelectedFiles(),
					mainFrame.getTextAreaStatus(), 
					mainFrame.getTableTestModel(),
					mainController);
			testDataAdder.execute();
		}
		
	}
	
	private void loadTestModel() {
		
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", CSV_FILES));
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(false);
		
		int returnVal = fc.showOpenDialog(mainFrame.getContentPane());
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			TestModelLoader testModelLoader = new TestModelLoader(fc.getSelectedFile().getAbsolutePath(), 
					mainFrame.getTextAreaStatus(), 
					mainFrame.getTableTestModel(),
					mainController);
			testModelLoader.execute();
			
		}
		
	}
	
	private void saveTestModel() {
		
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", CSV_FILES));
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(false);
		
		int returnVal = fc.showSaveDialog(mainFrame.getContentPane());
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			String filepath = fc.getSelectedFile().getAbsolutePath();
			
			if(!filepath.endsWith(CSV_FILES[0])) {
				filepath += "." + CSV_FILES[0];
			}
			
			TestModelSaver testModelSaver = new TestModelSaver(filepath, 
					mainFrame.getTextAreaStatus(), 
					mainController);
			testModelSaver.execute();
		}
		
	}
	
	private void clearTestModel() {
		TestModelClearer testModelClearer = new TestModelClearer(mainFrame.getTextAreaStatus(), 
				mainFrame.getTableTestModel(),
				mainController);
		testModelClearer.execute();
	}
	
	private void mergeTestModel() {
		
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new FileNameExtensionFilter("CSV Files", CSV_FILES));
		fc.setAcceptAllFileFilterUsed(false);
		fc.setMultiSelectionEnabled(true);
		
		int returnVal = fc.showOpenDialog(mainFrame.getContentPane());
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
			TestModelMerger testModelMerger = new TestModelMerger(fc.getSelectedFiles(),
					mainFrame.getTextAreaStatus(), 
					mainFrame.getTableTestModel(),
					mainController);
			testModelMerger.execute();
			
		}
		
	}
	
}
