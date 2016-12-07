package process;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextReader {
	
	public static ArrayList<String> read(String filename) {
		ArrayList<String> input = new ArrayList<String>();

		try {
			Scanner sc = new Scanner(new File(filename));
			
			while(sc.hasNextLine()) {
				String s = sc.nextLine();
				
				if(!s.isEmpty()) {
					input.add(s);
				}
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return input;
	}
	
}
