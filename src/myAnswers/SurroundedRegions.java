package myAnswers;

public class SurroundedRegions {
	
	public void solver(char[][] board) {
		
		if (board == null || board.length == 0 || board == null || 
				(board[0] != null && board[0].length == 0) || board[0] == null) {
			return;
		}
		else if (board.length <= 2 || board[0].length <= 2) {
			return;
		}
		
		// find all 'O's on the border
		
		// top & bottom
		for (int i = 0; i < board[0].length; i++) {
			//top
			if (board[0][i] == 'O') {
				board[0][i] = '#';
				allPossible(board, 0, i);
			}
			// bottom
			if (board[board.length - 1][i] == 'O') {
				board[board.length - 1][i] = '#';
				allPossible(board, board.length - 1, i);
			}
		}
		
		// left & right
		for (int i = 0; i < board.length; i++) {
			// left
			if (board[i][0] == 'O') {
				board[i][0] = '#';
				allPossible(board, i, 0);
			}
			// right
			if (board[i][board[0].length - 1] == 'O') {
				board[i][board[0].length - 1] = '#';
				allPossible(board, i, board[0].length - 1);
			}
		}
		
		// change: '#' -> 'O'
		// change: 'O' -> 'X'
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '#') {
					board[i][j] = 'O';
				}
				else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}
	
	// find all surrounding 'O's (these 'O's should not be flipped)
	public void allPossible(char[][] c, int row, int column) {
		
		if (row < 0 || column < 0 || row > c.length - 1 || column > c[0].length - 1) {
			return;
		}
		if (c[row][column] == 'O') {
			c[row][column] = '#';
		}
		if (row > 0 && c[row - 1][column] == 'O') {
			allPossible(c, row - 1, column);
		}
		if (column < c[0].length - 1 && c[row][column + 1] == 'O') {
			allPossible(c, row, column + 1);
		}
		if (row < c.length - 1 && c[row + 1][column] == 'O') {
			allPossible(c, row + 1, column);
		}
		if (column > 0 && c[row][column - 1] == 'O') {
			allPossible(c, row, column - 1);
		}
	}
}
