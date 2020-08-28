package myAnswers;
import java.util.Arrays;
import java.util.ArrayList;

public class SurroundedRegions {
	
	public static void solver(char[][] board) {
		
		// if the input matrix is empty
		if (board.length == 0) {
			System.out.println(board);
		}
		
		// if the number of row/column of this matrix is less than 3, then print directly. 
		// No need to flip.
		else if (board.length <= 2 || board[0].length <= 2) {
			System.out.println(board);
		}
		
		else {  // the number of row/column is larger than 3
			
			// loop through all the elements that are not on the border
			for (int i = 1; i < board.length - 1; i++) {
				for (int j = 1; j < board[0].length - 1; j++) {
					
					ArrayList<Character> currentSur = new ArrayList<Character>();
					// if the current element is O, then check surroundings
					if (board[i][j] == 'O') {
						currentSur.add(board[i-1][j]);
						currentSur.add(board[i][j+1]);
						currentSur.add(board[i+1][j]);
						currentSur.add(board[i][j-1]);
						if (currentSur.contains('O')) {
							
						}
					}
				}
			}
		}
		
	}
	
	public static boolean borderChecker(char[][] board, int row, int column) {
		if (board == null) {
			return true;
		}
		else {
			if (row == 0 || row == board.length || column == 0 || column == board[0].length) {
				return true;
			}
		}
		return false;
	}
	
	public static void matrixPrinter(char[][] c) {
		for (char[] row: c) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static void main(String[] args) {
		char[][] test = {{'X', 'X', 'X'}, {'X', 'O', 'X'}, {'X', 'X', 'X'}};
		char[][] test2 = new char[3][];
		matrixPrinter(test2);
		System.out.println(test.length);

	}

}
