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
	private static final MainFrame mainFrame = new MainFrame();
	
	private JPanel contentPane;
	private JTable tableBagOfWords;
	private JPanel panelSideLeft;
	private JPanel panelOperations;
	private JPanel panelOperationsHeader;
	private JLabel labelOperationsHeader;
	private JScrollPane scrollPaneOperationsList;
	private JPanel panelOperationsList;
	private JLabel labelOperationsParse;
	private JMenuItem menuItemParse;
	private JMenu menuFile;
	private JMenuBar mainMenuBar;
	private JPanel panelCenter;
	private JPanel panelTextFile;
	private JPanel panelTextFileHeader;
	private JLabel labelTextFileHeader;
	private JScrollPane scrollPaneTextFile;
	private JTextArea textAreaTextFile;
	private JPanel panelSideRight;
	private JPanel panelBagOfWords;
	private JPanel panelBagOfWordsHeader;
	private JLabel labelBagOfWordsHeader;
	private JScrollPane scrollPaneBagOfWords;
	
	private MainFrame() {
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
		
		menuItemParse = new JMenuItem("Parse Text File");
		menuFile.add(menuItemParse);
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
		gbl_panelOperationsList.rowHeights = new int[]{0, 0};
		gbl_panelOperationsList.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelOperationsList.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelOperationsList.setLayout(gbl_panelOperationsList);
		
		labelOperationsParse = new JLabel("Parse Text File");
		labelOperationsParse.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		labelOperationsParse.setFont(new Font("Roboto Slab", Font.PLAIN, 13));
		GridBagConstraints gbc_labelOperationsParse = new GridBagConstraints();
		gbc_labelOperationsParse.fill = GridBagConstraints.BOTH;
		gbc_labelOperationsParse.gridx = 0;
		gbc_labelOperationsParse.gridy = 0;
		panelOperationsList.add(labelOperationsParse, gbc_labelOperationsParse);
		
		panelCenter = new JPanel();
		GridBagConstraints gbc_panelCenter = new GridBagConstraints();
		gbc_panelCenter.fill = GridBagConstraints.BOTH;
		gbc_panelCenter.insets = new Insets(0, 0, 0, 5);
		gbc_panelCenter.gridx = 1;
		gbc_panelCenter.gridy = 0;
		contentPane.add(panelCenter, gbc_panelCenter);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{0, 0};
		gbl_panelCenter.rowHeights = new int[]{0, 0};
		gbl_panelCenter.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		panelTextFile = new JPanel();
		GridBagConstraints gbc_panelTextFile = new GridBagConstraints();
		gbc_panelTextFile.fill = GridBagConstraints.BOTH;
		gbc_panelTextFile.gridx = 0;
		gbc_panelTextFile.gridy = 0;
		panelCenter.add(panelTextFile, gbc_panelTextFile);
		panelTextFile.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		panelTextFile.setBackground(new Color(255, 255, 255));
		GridBagLayout gbl_panelTextFile = new GridBagLayout();
		gbl_panelTextFile.columnWidths = new int[]{0, 0};
		gbl_panelTextFile.rowHeights = new int[]{30, 0, 0};
		gbl_panelTextFile.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelTextFile.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelTextFile.setLayout(gbl_panelTextFile);
		
		panelTextFileHeader = new JPanel();
		panelTextFileHeader.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		GridBagConstraints gbc_panelTextFileHeader = new GridBagConstraints();
		gbc_panelTextFileHeader.insets = new Insets(0, 0, 5, 0);
		gbc_panelTextFileHeader.fill = GridBagConstraints.BOTH;
		gbc_panelTextFileHeader.gridx = 0;
		gbc_panelTextFileHeader.gridy = 0;
		panelTextFile.add(panelTextFileHeader, gbc_panelTextFileHeader);
		GridBagLayout gbl_panelTextFileHeader = new GridBagLayout();
		gbl_panelTextFileHeader.columnWidths = new int[]{0, 0};
		gbl_panelTextFileHeader.rowHeights = new int[]{0, 0};
		gbl_panelTextFileHeader.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelTextFileHeader.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelTextFileHeader.setLayout(gbl_panelTextFileHeader);
		
		labelTextFileHeader = new JLabel("TEXT FILE");
		labelTextFileHeader.setFont(new Font("Roboto Slab", Font.PLAIN, 14));
		GridBagConstraints gbc_labelTextFileHeader = new GridBagConstraints();
		gbc_labelTextFileHeader.gridx = 0;
		gbc_labelTextFileHeader.gridy = 0;
		panelTextFileHeader.add(labelTextFileHeader, gbc_labelTextFileHeader);
		
		scrollPaneTextFile = new JScrollPane();
		scrollPaneTextFile.setBorder(null);
		GridBagConstraints gbc_scrollPaneTextFile = new GridBagConstraints();
		gbc_scrollPaneTextFile.insets = new Insets(0, 5, 0, 5);
		gbc_scrollPaneTextFile.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTextFile.gridx = 0;
		gbc_scrollPaneTextFile.gridy = 1;
		panelTextFile.add(scrollPaneTextFile, gbc_scrollPaneTextFile);
		
		textAreaTextFile = new JTextArea();
		textAreaTextFile.setEditable(false);
		textAreaTextFile.setWrapStyleWord(true);
		textAreaTextFile.setLineWrap(true);
		scrollPaneTextFile.setViewportView(textAreaTextFile);
		
		panelSideRight = new JPanel();
		panelSideRight.setBackground(new Color(245, 245, 245));
		GridBagConstraints gbc_panelSideRight = new GridBagConstraints();
		gbc_panelSideRight.fill = GridBagConstraints.BOTH;
		gbc_panelSideRight.gridx = 2;
		gbc_panelSideRight.gridy = 0;
		contentPane.add(panelSideRight, gbc_panelSideRight);
		GridBagLayout gbl_panelSideRight = new GridBagLayout();
		gbl_panelSideRight.columnWidths = new int[]{0, 0};
		gbl_panelSideRight.rowHeights = new int[]{0, 0};
		gbl_panelSideRight.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelSideRight.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelSideRight.setLayout(gbl_panelSideRight);
		
		panelBagOfWords = new JPanel();
		panelBagOfWords.setBorder(new LineBorder(new Color(169, 169, 169), 1, true));
		panelBagOfWords.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelBagOfWords = new GridBagConstraints();
		gbc_panelBagOfWords.fill = GridBagConstraints.BOTH;
		gbc_panelBagOfWords.gridx = 0;
		gbc_panelBagOfWords.gridy = 0;
		panelSideRight.add(panelBagOfWords, gbc_panelBagOfWords);
		GridBagLayout gbl_panelBagOfWords = new GridBagLayout();
		gbl_panelBagOfWords.columnWidths = new int[]{0, 0};
		gbl_panelBagOfWords.rowHeights = new int[]{30, 0, 0};
		gbl_panelBagOfWords.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelBagOfWords.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panelBagOfWords.setLayout(gbl_panelBagOfWords);
		
		panelBagOfWordsHeader = new JPanel();
		panelBagOfWordsHeader.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(169, 169, 169)));
		GridBagConstraints gbc_panelBagOfWordsHeader = new GridBagConstraints();
		gbc_panelBagOfWordsHeader.insets = new Insets(0, 0, 5, 0);
		gbc_panelBagOfWordsHeader.fill = GridBagConstraints.BOTH;
		gbc_panelBagOfWordsHeader.gridx = 0;
		gbc_panelBagOfWordsHeader.gridy = 0;
		panelBagOfWords.add(panelBagOfWordsHeader, gbc_panelBagOfWordsHeader);
		GridBagLayout gbl_panelBagOfWordsHeader = new GridBagLayout();
		gbl_panelBagOfWordsHeader.columnWidths = new int[]{0, 0};
		gbl_panelBagOfWordsHeader.rowHeights = new int[]{0, 0};
		gbl_panelBagOfWordsHeader.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelBagOfWordsHeader.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelBagOfWordsHeader.setLayout(gbl_panelBagOfWordsHeader);
		
		labelBagOfWordsHeader = new JLabel("BAG OF WORDS");
		labelBagOfWordsHeader.setFont(new Font("Roboto Slab", Font.PLAIN, 14));
		GridBagConstraints gbc_labelBagOfWordsHeader = new GridBagConstraints();
		gbc_labelBagOfWordsHeader.gridx = 0;
		gbc_labelBagOfWordsHeader.gridy = 0;
		panelBagOfWordsHeader.add(labelBagOfWordsHeader, gbc_labelBagOfWordsHeader);
		
		scrollPaneBagOfWords = new JScrollPane();
		scrollPaneBagOfWords.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_scrollPaneBagOfWords = new GridBagConstraints();
		gbc_scrollPaneBagOfWords.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneBagOfWords.gridx = 0;
		gbc_scrollPaneBagOfWords.gridy = 1;
		panelBagOfWords.add(scrollPaneBagOfWords, gbc_scrollPaneBagOfWords);
		
		tableBagOfWords = new JTable();
		tableBagOfWords.setFillsViewportHeight(true);
		tableBagOfWords.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Word", "Count"
			}
		));
		scrollPaneBagOfWords.setViewportView(tableBagOfWords);
	}
	
	public static MainFrame getInstance() {
		return MainFrame.mainFrame;
	}

	public JTable getTableBagOfWords() {
		return tableBagOfWords;
	}

	public JLabel getLabelOperationsParse() {
		return labelOperationsParse;
	}

	public JMenuItem getMenuItemParse() {
		return menuItemParse;
	}

	public JTextArea getTextAreaTextFile() {
		return textAreaTextFile;
	}

}
