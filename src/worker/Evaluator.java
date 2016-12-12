package worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import controller.MainController;
import fileio.CSVIO;
import model.FileModel;
import model.WordModel;
import process.ProbabilityComputer;


public class Evaluator extends SwingWorker<Void, String> {
	
	private final String CONFUSION_MATRIX_FILEPATH = "C:\\Users\\amcan\\Desktop\\ConfusionMatrix.csv";
	
	private JTextArea textArea;
	private MainController mainController;
	
	private int wordCount;
	private int spamDocCount;
	private int notSpamDocCount;
	private int spamWordCount;
	private int notSpamWordCount;
	
	private Map<WordModel, Double> probabilityMap;
	private ArrayList<FileModel> testFiles;
	
	private String[][] confusionMatrix;
	
	public Evaluator(JTextArea textArea,
			MainController mainController) {
		
		this.textArea = textArea;
		this.mainController = mainController;
		
		wordCount = mainController.getWordList().size();
		spamDocCount = mainController.getSpamDocTrainCount();
		notSpamDocCount = mainController.getNotSpamDocTrainCount();
		spamWordCount = mainController.getSpamWordTrainCount();
		notSpamWordCount = mainController.getNotSpamWordTrainCount();
		
		probabilityMap = new HashMap<WordModel, Double>();
		testFiles = mainController.getTestFiles();
		
		confusionMatrix = new String[][]{
			{"", "Actual Spam", "Actual Not Spam"},
			{"Predicted Spam", "0", "0"},
			{"Predicted Not Spam", "0", "0"}
		};
		
		showStart();
		
	}
	
	private void showStart() {
		
		textArea.append("\nStarting classification");
		textArea.repaint();
		textArea.revalidate();
		
	}
	
	@Override
	protected Void doInBackground() throws Exception {
		
		publish("\nComputing Probability...");
		
		System.out.println("SPAM DOC COUNT: " + spamDocCount);
		System.out.println("NOT SPAM DOC COUNT: " + notSpamDocCount);
		System.out.println("SPAM WORD COUNT: " + spamWordCount);
		System.out.println("NOT SPAM WORD COUNT: " + notSpamWordCount);
		System.out.println("WORD LIST COUNT: " + wordCount);
		
		probabilityMap = ProbabilityComputer.getProbabilityMap(mainController.getBagOfWordsModel(), wordCount, spamWordCount, notSpamWordCount);
		publish("\nProbability computation finished.\n\n");
		
		Double spamDocProbability = new Double((spamDocCount * 1.0) / (spamDocCount + notSpamDocCount));
		Double notSpamDocProbability = new Double((notSpamDocCount * 1.0) / (spamDocCount + notSpamDocCount));
		
		for(FileModel testFile : testFiles) {
			
			Double spamProbability = Math.log(spamDocProbability);
			Double notSpamProbability = Math.log(notSpamDocProbability);
			
			for(WordModel word : testFile.getTally().keySet()) {
				
				WordModel spamWord = new WordModel(word.getWord(), "Spam");
				WordModel notSpamWord = new WordModel(word.getWord(), "Not Spam");
				
				int freq = testFile.getTally().get(word);
				
				if(probabilityMap.containsKey(spamWord)) {
					spamProbability += Math.log(Math.pow(probabilityMap.get(spamWord), freq));
				}
				else {
					spamProbability += Math.log(Math.pow(1.0 / (spamWordCount + wordCount), freq));
				}
				
				if(probabilityMap.containsKey(notSpamWord)) {
					notSpamProbability += Math.log(Math.pow(probabilityMap.get(notSpamWord), freq));
				}
				else {
					notSpamProbability += Math.log(Math.pow(1.0 / (notSpamWordCount + wordCount), freq));
				}
				
			}
			
			publish("TEST FILE: " + testFile.getFile().getName() + "\n");
			publish("ACTUAL TAG: " + testFile.getTag() + "\n");
			publish("SPAM: " + spamProbability + "\n");
			publish("NOT SPAM PROBABILITY: " + notSpamProbability + "\n");
			
			if(spamProbability > notSpamProbability) {
				publish("TAGGED AS: SPAM\n");
				if(testFile.getTag().equals("Spam")) {
					confusionMatrix[1][1] = String.valueOf(Integer.parseInt(confusionMatrix[1][1]) + 1);
				} else {
					confusionMatrix[1][2] = String.valueOf(Integer.parseInt(confusionMatrix[1][2]) + 1);
				}
			}
			else {
				publish("TAGGED AS: NOT SPAM\n");
				if(testFile.getTag().equals("Spam")) {
					confusionMatrix[2][1] = String.valueOf(Integer.parseInt(confusionMatrix[2][1]) + 1);
				} else {
					confusionMatrix[2][2] = String.valueOf(Integer.parseInt(confusionMatrix[2][2]) + 1);
				}
			}
		}
		
		return null;
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
		
		textArea.append("\nClassification finished.");
		//textArea.append("\nConfusion Matrix: \n");
		
		ArrayList<String> output = new ArrayList<String>();
		
		for(int i = 0; i < confusionMatrix.length; i++) {
			String s = new String("");
			for(int j = 0; j < confusionMatrix[i].length; j++) {
				//textArea.append(s + "\t\t");
				s += confusionMatrix[i][j];
				if(j < confusionMatrix[i].length - 1) {
					s += ",";
				}
			}
			//textArea.append("\n");
			output.add(s);
		}
		
		CSVIO.write(output, CONFUSION_MATRIX_FILEPATH);
		
		textArea.repaint();
		textArea.revalidate();
		
	}
	
}
