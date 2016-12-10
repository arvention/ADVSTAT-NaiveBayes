package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTable tableTrainModel;
	private JPanel panelSideLeft;
	private JPanel panelOperations;
	private JPanel panelOperationsHeader;
	private JLabel labelOperationsHeader;
	private JScrollPane scrollPaneOperationsList;
	private JPanel panelOperationsList;
	private JLabel labelOperationsAddTrainData;
	private JMenuItem menuItemAddTrainData;
	private JMenu menuFile;
	private JMenuBar mainMenuBar;
	private JPanel panelCenter;
	private JPanel panelEvaluation;
	private JPanel panelEvaluationHeader;
	private JLabel labelEvaluationHeader;
	private JScrollPane scrollPaneEvaluation;
	private JTextArea textAreaEvaluation;
	private JPanel panelSideRight;
	private JPanel panelTrainModel;
	private JPanel panelTrainModelHeader;
	private JLabel labelTrainModelHeader;
	private JScrollPane scrollPaneTrainModel;
	private JLabel labelOperationsLoadTrainModel;
	private JLabel labelOperationsSaveTrainModel;
	private JLabel labelOperationsAddTestData;
	private JLabel labelOperationsEvaluate;
	private JPanel panelStatus;
	private JPanel panelStatusHeader;
	private JScrollPane scrollPaneStatus;
	private JTextArea textAreaStatus;
	private JLabel labelStatusHeader;
	private JMenuItem menuItemAddTestData;
	private JMenu menuModel;
	private JMenu menuEvaluate;
	private JMenuItem menuItemEvaluate;
	private JLabel labelOperationsLoadTestModel;
	private JLabel labelOperationsSaveTestModel;
	private JLabel labelOperationsClearTrainModel;
	private JLabel labelOperationsClearTestModel;
	private JLabel labelOperationsMergeTrainModels;
	private JLabel labelOperationsMergeTestModels;
	private JPanel panelTestModel;
	private JPanel panelTestModelHeader;
	private JLabel labelTestModelHeader;
	private JScrollPane scrollPaneTestModel;
	private JTable tableTestModel;
	private JMenu menuTrainModel;
	private JMenuItem menuItemLoadTrainModel;
	private JMenuItem menuItemSaveTrainModel;
	private JMenuItem menuItemClearTrainModel;
	private JMenuItem menuItemMergeTrainModels;
	private JMenu menuTestModel;
	private JMenuItem menuItemLoadTestModel;
	private JMenuItem menuItemSaveTestModel;
	private JMenuItem menuItemClearTestModel;
	private JMenuItem menuItemMergeTestModels;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		initializeComponents();
	}
	
	private void initializeComponents() {
		
		mainMenuBar = new JMenuBar();
		setJMenuBar(mainMenuBar);
		
		menuFile = new JMenu("File");
		mainMenuBar.add(menuFile);
		
		menuItemAddTrainData = new JMenuItem("Add Train Data");
		menuFile.add(menuItemAddTrainData);
		
		menuItemAddTestData = new JMenuItem("Add Test Data");
		menuFile.add(menuItemAddTestData);
		
		menuModel = new JMenu("Model");
		mainMenuBar.add(menuModel);
		
		menuTrainModel = new JMenu("Train Model");
		menuModel.add(menuTrainModel);
		
		menuItemLoadTrainModel = new JMenuItem("Load Train Model");
		menuTrainModel.add(menuItemLoadTrainModel);
		
		menuItemSaveTrainModel = new JMenuItem("Save Train Model");
		menuTrainModel.add(menuItemSaveTrainModel);
		
		menuItemClearTrainModel = new JMenuItem("Clear Train Model");
		menuTrainModel.add(menuItemClearTrainModel);
		
		menuItemMergeTrainModels = new JMenuItem("Merge Train Models");
		menuTrainModel.add(menuItemMergeTrainModels);
		
		menuTestModel = new JMenu("Test Model");
		menuModel.add(menuTestModel);
		
		menuItemLoadTestModel = new JMenuItem("Load Test Model");
		menuTestModel.add(menuItemLoadTestModel);
		
		menuItemSaveTestModel = new JMenuItem("Save Test Model");
		menuTestModel.add(menuItemSaveTestModel);
		
		menuItemClearTestModel = new JMenuItem("Clear Test Model");
		menuTestModel.add(menuItemClearTestModel);
		
		menuItemMergeTestModels = new JMenuItem("Merge Test Models");
		menuTestModel.add(menuItemMergeTestModels);
		
		menuEvaluate = new JMenu("Evaluate");
		mainMenuBar.add(menuEvaluate);
		
		menuItemEvaluate = new JMenuItem("Evaluate");
		menuEvaluate.add(menuItemEvaluate);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{150, 0, 200, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panelSideLeft = new JPanel();
		panelSideLeft.setBackground(new Color(245, 245, 245));
		GridBagConstraints gbc_panelSideLeft = new GridBagConstraints();
		gbc_panelSideLeft.insets = new Insets(0, 0, 0, 5);
		gbc_panelSideLeft.fill = GridBagConstraints.BOTH;
		gbc_panelSideLeft.gridx = 0;
		gbc_panelSideLeft.gridy = 0;
		contentPane.add(panelSideLeft, gbc_panelSideLeft);
		GridBagLayout gbl_panelSideLeft = new GridBagLayout();
		gbl_panelSideLeft.columnWidths = new int[]{0, 0};
		gbl_panelSideLeft.rowHeights = new int[]{0, 0};
		gbl_panelSideLeft.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelSideLeft.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelSideLeft.setLayout(gbl_panelSideLeft);
		
		panelOperations = new JPanel();
		panelOperations.setBackground(new Color(255, 255, 255));
		panelOperations.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		GridBagConstraints gbc_panelOperations = new GridBagConstraints();
		gbc_panelOperations.fill = GridBagConstraints.BOTH;
		gbc_panelOperations.gridx = 0;
		gbc_panelOperations.gridy = 0;
		panelSideLeft.add(panelOperations, gbc_panelOperations);
		GridBagLayout gbl_panelOperations = new GridBagLayout();
		gbl_panelOperations.columnWidths = new int[]{143, 0};
		gbl_panelOperations.rowHeights = new int[]{30, 0, 0};
		gbl_panelOperations.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelOperations.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelOperations.setLayout(gbl_panelOperations);
		
		panelOperationsHeader = new JPanel();
		panelOperationsHeader.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		panelOperationsHeader.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_panelOperationsHeader = new GridBagConstraints();
		gbc_panelOperationsHeader.insets = new Insets(0, 0, 5, 0);
		gbc_panelOperationsHeader.fill = GridBagConstraints.BOTH;
		gbc_panelOperationsHeader.gridx = 0;
		gbc_panelOperationsHeader.gridy = 0;
		panelOperations.add(panelOperationsHeader, gbc_panelOperationsHeader);
		GridBagLayout gbl_panelOperationsHeader = new GridBagLayout();
		gbl_panelOperationsHeader.columnWidths = new int[]{0, 0};
		gbl_panelOperationsHeader.rowHeights = new int[]{0, 0};
		gbl_panelOperationsHeader.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelOperationsHeader.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelOperationsHeader.setLayout(gbl_panelOperationsHeader);
		
		labelOperationsHeader = new JLabel("OPERATIONS");
		labelOperationsHeader.setFont(new Font("Roboto Slab", Font.PLAIN, 14));
		GridBagConstraints gbc_labelOperationsHeader = new GridBagConstraints();
		gbc_labelOperationsHeader.gridx = 0;
		gbc_labelOperationsHeader.gridy = 0;
		panelOperationsHeader.add(labelOperationsHeader, gbc_labelOperationsHeader);
		
		scrollPaneOperationsList = new JScrollPane();
		scrollPaneOperationsList.setBorder(null);
		GridBagConstraints gbc_scrollPaneOperationsList = new GridBagConstraints();
		gbc_scrollPaneOperationsList.insets = new Insets(0, 5, 0, 5);
		gbc_scrollPaneOperationsList.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneOperationsList.gridx = 0;
		gbc_scrollPaneOperationsList.gridy = 1;
		panelOperations.add(scrollPaneOperationsList, gbc_scrollPaneOperationsList);
		
		panelOperationsList = new JPanel();
		panelOperationsList.setBackground(new Color(255, 255, 255));
		scrollPaneOperationsList.setViewportView(panelOperationsList);
		GridBagLayout gbl_panelOperationsList = new GridBagLayout();
		gbl_panelOperationsList.columnWidths = new int[]{0, 0};
		gbl_panelOperationsList.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelOperationsList.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelOperationsList.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelOperationsList.setLayout(gbl_panelOperationsList);
		
		labelOperationsAddTrainData = new JLabel("Add Train Data");
		labelOperationsAddTrainData.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		labelOperationsAddTrainData.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsAddTrainData = new GridBagConstraints();
		gbc_labelOperationsAddTrainData.insets = new Insets(0, 0, 5, 0);
		gbc_labelOperationsAddTrainData.fill = GridBagConstraints.BOTH;
		gbc_labelOperationsAddTrainData.gridx = 0;
		gbc_labelOperationsAddTrainData.gridy = 0;
		panelOperationsList.add(labelOperationsAddTrainData, gbc_labelOperationsAddTrainData);
		
		labelOperationsLoadTrainModel = new JLabel("Load Train Model");
		labelOperationsLoadTrainModel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		labelOperationsLoadTrainModel.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsLoadTrainModel = new GridBagConstraints();
		gbc_labelOperationsLoadTrainModel.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelOperationsLoadTrainModel.insets = new Insets(0, 0, 5, 0);
		gbc_labelOperationsLoadTrainModel.gridx = 0;
		gbc_labelOperationsLoadTrainModel.gridy = 1;
		panelOperationsList.add(labelOperationsLoadTrainModel, gbc_labelOperationsLoadTrainModel);
		
		labelOperationsSaveTrainModel = new JLabel("Save Train Model");
		labelOperationsSaveTrainModel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		labelOperationsSaveTrainModel.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsSaveTrainModel = new GridBagConstraints();
		gbc_labelOperationsSaveTrainModel.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelOperationsSaveTrainModel.insets = new Insets(0, 0, 5, 0);
		gbc_labelOperationsSaveTrainModel.gridx = 0;
		gbc_labelOperationsSaveTrainModel.gridy = 2;
		panelOperationsList.add(labelOperationsSaveTrainModel, gbc_labelOperationsSaveTrainModel);
		
		labelOperationsClearTrainModel = new JLabel("Clear Train Model");
		labelOperationsClearTrainModel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		labelOperationsClearTrainModel.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsClearTrainModel = new GridBagConstraints();
		gbc_labelOperationsClearTrainModel.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelOperationsClearTrainModel.insets = new Insets(0, 0, 5, 0);
		gbc_labelOperationsClearTrainModel.gridx = 0;
		gbc_labelOperationsClearTrainModel.gridy = 3;
		panelOperationsList.add(labelOperationsClearTrainModel, gbc_labelOperationsClearTrainModel);
		
		labelOperationsMergeTrainModels = new JLabel("Merge Train Models");
		labelOperationsMergeTrainModels.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		labelOperationsMergeTrainModels.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsMergeTrainModels = new GridBagConstraints();
		gbc_labelOperationsMergeTrainModels.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelOperationsMergeTrainModels.insets = new Insets(0, 0, 5, 0);
		gbc_labelOperationsMergeTrainModels.gridx = 0;
		gbc_labelOperationsMergeTrainModels.gridy = 4;
		panelOperationsList.add(labelOperationsMergeTrainModels, gbc_labelOperationsMergeTrainModels);
		
		labelOperationsAddTestData = new JLabel("Add Test Data");
		labelOperationsAddTestData.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		labelOperationsAddTestData.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsAddTestData = new GridBagConstraints();
		gbc_labelOperationsAddTestData.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelOperationsAddTestData.insets = new Insets(0, 0, 5, 0);
		gbc_labelOperationsAddTestData.gridx = 0;
		gbc_labelOperationsAddTestData.gridy = 5;
		panelOperationsList.add(labelOperationsAddTestData, gbc_labelOperationsAddTestData);
		
		labelOperationsLoadTestModel = new JLabel("Load Test Model");
		labelOperationsLoadTestModel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		labelOperationsLoadTestModel.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsLoadTestModel = new GridBagConstraints();
		gbc_labelOperationsLoadTestModel.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelOperationsLoadTestModel.insets = new Insets(0, 0, 5, 0);
		gbc_labelOperationsLoadTestModel.gridx = 0;
		gbc_labelOperationsLoadTestModel.gridy = 6;
		panelOperationsList.add(labelOperationsLoadTestModel, gbc_labelOperationsLoadTestModel);
		
		labelOperationsSaveTestModel = new JLabel("Save Test Model");
		labelOperationsSaveTestModel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		labelOperationsSaveTestModel.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsSaveTestModel = new GridBagConstraints();
		gbc_labelOperationsSaveTestModel.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelOperationsSaveTestModel.insets = new Insets(0, 0, 5, 0);
		gbc_labelOperationsSaveTestModel.gridx = 0;
		gbc_labelOperationsSaveTestModel.gridy = 7;
		panelOperationsList.add(labelOperationsSaveTestModel, gbc_labelOperationsSaveTestModel);
		
		labelOperationsClearTestModel = new JLabel("Clear Test Model");
		labelOperationsClearTestModel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		labelOperationsClearTestModel.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsClearTestModel = new GridBagConstraints();
		gbc_labelOperationsClearTestModel.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelOperationsClearTestModel.insets = new Insets(0, 0, 5, 0);
		gbc_labelOperationsClearTestModel.gridx = 0;
		gbc_labelOperationsClearTestModel.gridy = 8;
		panelOperationsList.add(labelOperationsClearTestModel, gbc_labelOperationsClearTestModel);
		
		labelOperationsMergeTestModels = new JLabel("Merge Test Models");
		labelOperationsMergeTestModels.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		labelOperationsMergeTestModels.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsMergeTestModels = new GridBagConstraints();
		gbc_labelOperationsMergeTestModels.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelOperationsMergeTestModels.insets = new Insets(0, 0, 5, 0);
		gbc_labelOperationsMergeTestModels.gridx = 0;
		gbc_labelOperationsMergeTestModels.gridy = 9;
		panelOperationsList.add(labelOperationsMergeTestModels, gbc_labelOperationsMergeTestModels);
		
		labelOperationsEvaluate = new JLabel("Evaluate");
		labelOperationsEvaluate.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		labelOperationsEvaluate.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsEvaluate = new GridBagConstraints();
		gbc_labelOperationsEvaluate.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelOperationsEvaluate.gridx = 0;
		gbc_labelOperationsEvaluate.gridy = 10;
		panelOperationsList.add(labelOperationsEvaluate, gbc_labelOperationsEvaluate);
		
		panelCenter = new JPanel();
		panelCenter.setBackground(new Color(245, 245, 245));
		GridBagConstraints gbc_panelCenter = new GridBagConstraints();
		gbc_panelCenter.fill = GridBagConstraints.BOTH;
		gbc_panelCenter.insets = new Insets(0, 0, 0, 5);
		gbc_panelCenter.gridx = 1;
		gbc_panelCenter.gridy = 0;
		contentPane.add(panelCenter, gbc_panelCenter);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{0, 0};
		gbl_panelCenter.rowHeights = new int[]{0, 150, 0};
		gbl_panelCenter.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		panelEvaluation = new JPanel();
		GridBagConstraints gbc_panelEvaluation = new GridBagConstraints();
		gbc_panelEvaluation.insets = new Insets(0, 0, 5, 0);
		gbc_panelEvaluation.fill = GridBagConstraints.BOTH;
		gbc_panelEvaluation.gridx = 0;
		gbc_panelEvaluation.gridy = 0;
		panelCenter.add(panelEvaluation, gbc_panelEvaluation);
		panelEvaluation.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		panelEvaluation.setBackground(new Color(255, 255, 255));
		GridBagLayout gbl_panelEvaluation = new GridBagLayout();
		gbl_panelEvaluation.columnWidths = new int[]{0, 0};
		gbl_panelEvaluation.rowHeights = new int[]{30, 0, 0};
		gbl_panelEvaluation.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelEvaluation.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelEvaluation.setLayout(gbl_panelEvaluation);
		
		panelEvaluationHeader = new JPanel();
		panelEvaluationHeader.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		GridBagConstraints gbc_panelEvaluationHeader = new GridBagConstraints();
		gbc_panelEvaluationHeader.insets = new Insets(0, 0, 5, 0);
		gbc_panelEvaluationHeader.fill = GridBagConstraints.BOTH;
		gbc_panelEvaluationHeader.gridx = 0;
		gbc_panelEvaluationHeader.gridy = 0;
		panelEvaluation.add(panelEvaluationHeader, gbc_panelEvaluationHeader);
		GridBagLayout gbl_panelEvaluationHeader = new GridBagLayout();
		gbl_panelEvaluationHeader.columnWidths = new int[]{0, 0};
		gbl_panelEvaluationHeader.rowHeights = new int[]{0, 0};
		gbl_panelEvaluationHeader.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelEvaluationHeader.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelEvaluationHeader.setLayout(gbl_panelEvaluationHeader);
		
		labelEvaluationHeader = new JLabel("EVALUATION");
		labelEvaluationHeader.setFont(new Font("Roboto Slab", Font.PLAIN, 14));
		GridBagConstraints gbc_labelEvaluationHeader = new GridBagConstraints();
		gbc_labelEvaluationHeader.gridx = 0;
		gbc_labelEvaluationHeader.gridy = 0;
		panelEvaluationHeader.add(labelEvaluationHeader, gbc_labelEvaluationHeader);
		
		scrollPaneEvaluation = new JScrollPane();
		scrollPaneEvaluation.setBorder(null);
		GridBagConstraints gbc_scrollPaneEvaluation = new GridBagConstraints();
		gbc_scrollPaneEvaluation.insets = new Insets(0, 5, 0, 5);
		gbc_scrollPaneEvaluation.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneEvaluation.gridx = 0;
		gbc_scrollPaneEvaluation.gridy = 1;
		panelEvaluation.add(scrollPaneEvaluation, gbc_scrollPaneEvaluation);
		
		textAreaEvaluation = new JTextArea();
		textAreaEvaluation.setEditable(false);
		textAreaEvaluation.setWrapStyleWord(true);
		textAreaEvaluation.setLineWrap(true);
		scrollPaneEvaluation.setViewportView(textAreaEvaluation);
		
		panelStatus = new JPanel();
		panelStatus.setBackground(new Color(255, 255, 255));
		panelStatus.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		GridBagConstraints gbc_panelStatus = new GridBagConstraints();
		gbc_panelStatus.fill = GridBagConstraints.BOTH;
		gbc_panelStatus.gridx = 0;
		gbc_panelStatus.gridy = 1;
		panelCenter.add(panelStatus, gbc_panelStatus);
		GridBagLayout gbl_panelStatus = new GridBagLayout();
		gbl_panelStatus.columnWidths = new int[]{0, 0};
		gbl_panelStatus.rowHeights = new int[]{30, 0, 0};
		gbl_panelStatus.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelStatus.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelStatus.setLayout(gbl_panelStatus);
		
		panelStatusHeader = new JPanel();
		panelStatusHeader.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		GridBagConstraints gbc_panelStatusHeader = new GridBagConstraints();
		gbc_panelStatusHeader.insets = new Insets(0, 0, 5, 0);
		gbc_panelStatusHeader.fill = GridBagConstraints.BOTH;
		gbc_panelStatusHeader.gridx = 0;
		gbc_panelStatusHeader.gridy = 0;
		panelStatus.add(panelStatusHeader, gbc_panelStatusHeader);
		GridBagLayout gbl_panelStatusHeader = new GridBagLayout();
		gbl_panelStatusHeader.columnWidths = new int[]{0, 0};
		gbl_panelStatusHeader.rowHeights = new int[]{0, 0};
		gbl_panelStatusHeader.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelStatusHeader.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelStatusHeader.setLayout(gbl_panelStatusHeader);
		
		labelStatusHeader = new JLabel("STATUS");
		labelStatusHeader.setFont(new Font("Roboto Slab", Font.PLAIN, 14));
		GridBagConstraints gbc_labelStatusHeader = new GridBagConstraints();
		gbc_labelStatusHeader.fill = GridBagConstraints.VERTICAL;
		gbc_labelStatusHeader.gridx = 0;
		gbc_labelStatusHeader.gridy = 0;
		panelStatusHeader.add(labelStatusHeader, gbc_labelStatusHeader);
		
		scrollPaneStatus = new JScrollPane();
		scrollPaneStatus.setBorder(null);
		GridBagConstraints gbc_scrollPaneStatus = new GridBagConstraints();
		gbc_scrollPaneStatus.insets = new Insets(0, 5, 0, 5);
		gbc_scrollPaneStatus.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneStatus.gridx = 0;
		gbc_scrollPaneStatus.gridy = 1;
		panelStatus.add(scrollPaneStatus, gbc_scrollPaneStatus);
		
		textAreaStatus = new JTextArea();
		textAreaStatus.setWrapStyleWord(true);
		textAreaStatus.setLineWrap(true);
		textAreaStatus.setBorder(null);
		scrollPaneStatus.setViewportView(textAreaStatus);
		
		panelSideRight = new JPanel();
		panelSideRight.setBackground(new Color(245, 245, 245));
		GridBagConstraints gbc_panelSideRight = new GridBagConstraints();
		gbc_panelSideRight.fill = GridBagConstraints.BOTH;
		gbc_panelSideRight.gridx = 2;
		gbc_panelSideRight.gridy = 0;
		contentPane.add(panelSideRight, gbc_panelSideRight);
		GridBagLayout gbl_panelSideRight = new GridBagLayout();
		gbl_panelSideRight.columnWidths = new int[]{0, 0};
		gbl_panelSideRight.rowHeights = new int[]{0, 0, 0};
		gbl_panelSideRight.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelSideRight.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panelSideRight.setLayout(gbl_panelSideRight);
		
		panelTrainModel = new JPanel();
		panelTrainModel.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		panelTrainModel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelTrainModel = new GridBagConstraints();
		gbc_panelTrainModel.insets = new Insets(0, 0, 5, 0);
		gbc_panelTrainModel.fill = GridBagConstraints.BOTH;
		gbc_panelTrainModel.gridx = 0;
		gbc_panelTrainModel.gridy = 0;
		panelSideRight.add(panelTrainModel, gbc_panelTrainModel);
		GridBagLayout gbl_panelTrainModel = new GridBagLayout();
		gbl_panelTrainModel.columnWidths = new int[]{0, 0};
		gbl_panelTrainModel.rowHeights = new int[]{30, 0, 0};
		gbl_panelTrainModel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelTrainModel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelTrainModel.setLayout(gbl_panelTrainModel);
		
		panelTrainModelHeader = new JPanel();
		panelTrainModelHeader.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		GridBagConstraints gbc_panelTrainModelHeader = new GridBagConstraints();
		gbc_panelTrainModelHeader.insets = new Insets(0, 0, 5, 0);
		gbc_panelTrainModelHeader.fill = GridBagConstraints.BOTH;
		gbc_panelTrainModelHeader.gridx = 0;
		gbc_panelTrainModelHeader.gridy = 0;
		panelTrainModel.add(panelTrainModelHeader, gbc_panelTrainModelHeader);
		GridBagLayout gbl_panelTrainModelHeader = new GridBagLayout();
		gbl_panelTrainModelHeader.columnWidths = new int[]{0, 0};
		gbl_panelTrainModelHeader.rowHeights = new int[]{0, 0};
		gbl_panelTrainModelHeader.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelTrainModelHeader.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelTrainModelHeader.setLayout(gbl_panelTrainModelHeader);
		
		labelTrainModelHeader = new JLabel("TRAIN MODEL");
		labelTrainModelHeader.setFont(new Font("Roboto Slab", Font.PLAIN, 14));
		GridBagConstraints gbc_labelTrainModelHeader = new GridBagConstraints();
		gbc_labelTrainModelHeader.gridx = 0;
		gbc_labelTrainModelHeader.gridy = 0;
		panelTrainModelHeader.add(labelTrainModelHeader, gbc_labelTrainModelHeader);
		
		scrollPaneTrainModel = new JScrollPane();
		scrollPaneTrainModel.setBorder(null);
		scrollPaneTrainModel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_scrollPaneTrainModel = new GridBagConstraints();
		gbc_scrollPaneTrainModel.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTrainModel.gridx = 0;
		gbc_scrollPaneTrainModel.gridy = 1;
		panelTrainModel.add(scrollPaneTrainModel, gbc_scrollPaneTrainModel);
		
		tableTrainModel = new JTable();
		tableTrainModel.setFillsViewportHeight(true);
		tableTrainModel.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Word", "Tag", "Count"
			}
		));
		tableTrainModel.setAutoCreateRowSorter(true);
		scrollPaneTrainModel.setViewportView(tableTrainModel);
		
		panelTestModel = new JPanel();
		panelTestModel.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		panelTestModel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelTestModel = new GridBagConstraints();
		gbc_panelTestModel.fill = GridBagConstraints.BOTH;
		gbc_panelTestModel.gridx = 0;
		gbc_panelTestModel.gridy = 1;
		panelSideRight.add(panelTestModel, gbc_panelTestModel);
		GridBagLayout gbl_panelTestModel = new GridBagLayout();
		gbl_panelTestModel.columnWidths = new int[]{0, 0};
		gbl_panelTestModel.rowHeights = new int[]{30, 0, 0};
		gbl_panelTestModel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelTestModel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelTestModel.setLayout(gbl_panelTestModel);
		
		panelTestModelHeader = new JPanel();
		panelTestModelHeader.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		GridBagConstraints gbc_panelTestModelHeader = new GridBagConstraints();
		gbc_panelTestModelHeader.insets = new Insets(0, 0, 5, 0);
		gbc_panelTestModelHeader.fill = GridBagConstraints.BOTH;
		gbc_panelTestModelHeader.gridx = 0;
		gbc_panelTestModelHeader.gridy = 0;
		panelTestModel.add(panelTestModelHeader, gbc_panelTestModelHeader);
		GridBagLayout gbl_panelTestModelHeader = new GridBagLayout();
		gbl_panelTestModelHeader.columnWidths = new int[]{0, 0};
		gbl_panelTestModelHeader.rowHeights = new int[]{0, 0};
		gbl_panelTestModelHeader.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelTestModelHeader.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelTestModelHeader.setLayout(gbl_panelTestModelHeader);
		
		labelTestModelHeader = new JLabel("TEST MODEL");
		labelTestModelHeader.setFont(new Font("Roboto Slab", Font.PLAIN, 14));
		GridBagConstraints gbc_labelTestModelHeader = new GridBagConstraints();
		gbc_labelTestModelHeader.gridx = 0;
		gbc_labelTestModelHeader.gridy = 0;
		panelTestModelHeader.add(labelTestModelHeader, gbc_labelTestModelHeader);
		
		scrollPaneTestModel = new JScrollPane();
		scrollPaneTestModel.setBorder(null);
		GridBagConstraints gbc_scrollPaneTestModel = new GridBagConstraints();
		gbc_scrollPaneTestModel.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTestModel.gridx = 0;
		gbc_scrollPaneTestModel.gridy = 1;
		panelTestModel.add(scrollPaneTestModel, gbc_scrollPaneTestModel);
		
		tableTestModel = new JTable();
		tableTestModel.setAutoCreateRowSorter(true);
		tableTestModel.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
			},
			new String[] {
				"File Name"
			}
		));
		tableTestModel.setFillsViewportHeight(true);
		scrollPaneTestModel.setViewportView(tableTestModel);
	}

	public JTable getTableTrainModel() {
		return tableTrainModel;
	}

	public JLabel getLabelOperationsAddTrainData() {
		return labelOperationsAddTrainData;
	}

	public JMenuItem getMenuItemAddTrainData() {
		return menuItemAddTrainData;
	}

	public JMenu getMenuFile() {
		return menuFile;
	}

	public JTextArea getTextAreaEvaluation() {
		return textAreaEvaluation;
	}

	public JLabel getLabelOperationsLoadTrainModel() {
		return labelOperationsLoadTrainModel;
	}

	public JLabel getLabelOperationsSaveTrainModel() {
		return labelOperationsSaveTrainModel;
	}

	public JLabel getLabelOperationsAddTestData() {
		return labelOperationsAddTestData;
	}

	public JLabel getLabelOperationsEvaluate() {
		return labelOperationsEvaluate;
	}

	public JTextArea getTextAreaStatus() {
		return textAreaStatus;
	}

	public JMenuItem getMenuItemAddTestData() {
		return menuItemAddTestData;
	}

	public JMenu getMenuEvaluate() {
		return menuEvaluate;
	}

	public JMenuItem getMenuItemEvaluate() {
		return menuItemEvaluate;
	}

	public JLabel getLabelOperationsLoadTestModel() {
		return labelOperationsLoadTestModel;
	}

	public JLabel getLabelOperationsSaveTestModel() {
		return labelOperationsSaveTestModel;
	}

	public JLabel getLabelOperationsClearTrainModel() {
		return labelOperationsClearTrainModel;
	}

	public JLabel getLabelOperationsClearTestModel() {
		return labelOperationsClearTestModel;
	}

	public JLabel getLabelOperationsMergeTrainModels() {
		return labelOperationsMergeTrainModels;
	}

	public JLabel getLabelOperationsMergeTestModels() {
		return labelOperationsMergeTestModels;
	}

	public JTable getTableTestModel() {
		return tableTestModel;
	}

	public JMenuItem getMenuItemLoadTrainModel() {
		return menuItemLoadTrainModel;
	}

	public JMenuItem getMenuItemSaveTrainModel() {
		return menuItemSaveTrainModel;
	}

	public JMenuItem getMenuItemClearTrainModel() {
		return menuItemClearTrainModel;
	}

	public JMenuItem getMenuItemMergeTrainModels() {
		return menuItemMergeTrainModels;
	}

	public JMenuItem getMenuItemLoadTestModel() {
		return menuItemLoadTestModel;
	}

	public JMenuItem getMenuItemSaveTestModel() {
		return menuItemSaveTestModel;
	}

	public JMenuItem getMenuItemClearTestModel() {
		return menuItemClearTestModel;
	}

	public JMenuItem getMenuItemMergeTestModels() {
		return menuItemMergeTestModels;
	}
	
	

}
