package myAnswers;

public class ValidPalindrome {
	
	public boolean isPalindrome(String s) {
		
		// remove all characters that are non-alphanumeric.
		String newS = s.replaceAll("[^A-Za-z0-9]", "");
			
		// create a new String that is reverse to the original input
		String reverse = new StringBuilder(newS).reverse().toString();
		
		return newS.equalsIgnoreCase(reverse);
	}

}