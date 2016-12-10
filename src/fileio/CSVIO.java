package fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVIO {
	public static ArrayList<String> read(String filename) {
		ArrayList<String> input = new ArrayList<String>();

		try {
			Scanner sc = new Scanner(new File(filename));
			sc.useDelimiter(",");
			while (sc.hasNext()) {
				input.add(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return input;
	}

	public static void write(ArrayList<String> output, String filename) {

		try {
			FileWriter fw = new FileWriter(filename);
			for (String s : output) {
				String[] line = s.split(",");
				for (int i = 0; i < line.length; i++) {
					fw.append(line[i]);
					if (i + 1 != line.length)
						fw.append(",");
				}
				fw.append("\n");
			}
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}