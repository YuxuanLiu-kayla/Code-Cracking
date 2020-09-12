package myAnswers;
import java.util.LinkedList;

public class LongestValidParentheses {
	
	public static int longestValidParentheses(String s) {
        
		// edge cases -> empty input / single parenthesis
		if (s.length() == 0 || s.length() == 1) {
			return 0;
		}
		// deal with raw input:
		String newS = "";
		// if first parenthesis is a right parenthesis, then remove it
		if (s.charAt(0) == ')') {
			newS = s.substring(1);
		}
		else {
			newS = s;
		}
		// construct an empty LinkedList as a stack to hold parentheses
		LinkedList<Character> stack = new LinkedList<Character>();
		
		// store all possible number of valid consecutive parentheses
		LinkedList<Integer> nums = new LinkedList<Integer>();
		
		// keep track of valid parentheses
		int validP = 0;
		
		// traverse the whole string s and push parenthesis on an empty stack
		for (int i = 0; i < newS.length(); i++) {
			
			// if current parenthesis matches with the parenthesis on top of the stack,
			// then pop the top and validP + 2
			if (stack.size() > 0 && (stack.getFirst() == '(' && newS.charAt(i) == ')')) {
				stack.removeFirst();
				validP += 2;
				continue;
			}
			// if current parenthesis doesn't match with top, push it on stack
			stack.addFirst(newS.charAt(i));
		}
		return validP;
    }

	public static void main(String[] args) {
		String test1 = "(()";  // 2
		String test2 = "";  // 0
		String test3 = ")()())";  // 4
		System.out.println(longestValidParentheses(test3));
		
	}

}
