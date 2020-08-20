package myAnswers;
import java.util.HashMap;

public class WordPattern {
	
	public static boolean wordPattern(String pattern, String str) {
		
		// Create an Array from str
		String[] splitStr = str.split(" ");
		
		// Check lengths: if not equal, return false
		if (pattern.length() != splitStr.length) {
			return false;
		}
		// Create a HashMap to store key-value pairs
		HashMap<Character, String> map = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); i++) {
			char currentPat = pattern.charAt(i);
			if (map.get(currentPat) == null) {  // this key did not appear before
				map.put(currentPat, splitStr[i]);
			}
			else if (map.get(currentPat) != null && !map.get(currentPat).equals(splitStr[i])) {
				// different values appear!
				return false;
			}
			// else (map contain currentPat and value is the same): do nothing
		}
		// Check whether two keys have the same values
		for (int i = 0; i < pattern.length(); i++) {
			char checkDup = pattern.charAt(i);
			String currentValue = map.remove(checkDup);
			if (map.containsValue(currentValue)) {
				return false;
			}
		}
		return true;
	}
}
