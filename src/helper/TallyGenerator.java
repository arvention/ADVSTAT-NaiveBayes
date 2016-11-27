package helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TallyGenerator {
	
	public static Map<String, Integer> getTally(ArrayList<String> texts) {
		Map<String, Integer> tally = new HashMap<String, Integer>();
		
		for(String text : texts) {
			
			String s = text.replaceAll("[^a-zA-Z\\s]", "").replaceAll("\\s+", " ");
			System.out.println(s);
			
			String[] temp = s.split(" ");
			for(int i = 0; i < temp.length; i++) {
				
				if(!tally.containsKey(temp[i]) && !temp[i].isEmpty()) {
					tally.put(temp[i], new Integer(1));
				}
				
				else if(!temp[i].isEmpty()){
					tally.replace(temp[i], tally.get(temp[i]), tally.get(temp[i]) + 1);
				}
				
			}
		}
		
		System.out.println(tally.keySet());
		System.out.println(tally.values());
		
		return tally;
	}
	
}
