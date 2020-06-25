//	Pg-22 Printing the nQueen board after being arranged

package lecturew10;

public class HW1 {
	static void printBoard(boolean[][] board, int n) {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board.length; col++) {
				if(board[row][col]) {
					System.out.print(" Q ");
				} else {
					System.out.print(" . ");
				}
			}
			System.out.println();
		}
		System.out.println("\n\n");
	}
	
	static boolean isAllowed(boolean[][] board, int row, int currentCol) {
		// Checking the row above
		for (int i = 0; i <= row; i++) {
			if (board[i][currentCol]) {
				return false;
			}
		}

		// Checking the currentCol
		for (int i = 0; i <= currentCol; i++) {
			if (board[row][i]) {
				return false;
			}
		}
		
		// Checking the right diagnol
		for (int i = row, j = currentCol; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}
		
		// Checking the left diagnol
		for (int i = row, j = currentCol; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}
		
		return true;
	}
	
	static int possibleArrangements(boolean[][] board, int curRow) {
		int count = 0;
		
		if(curRow == board.length) {
			printBoard(board, curRow);
			
			return 1;
		}
		
		for(int col = 0; col < board.length; col++) {
			if(isAllowed(board, curRow, col)) {
				board[curRow][col] = true;
				count = count + possibleArrangements(board, curRow+1);
				board[curRow][col] = false;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		boolean [][] board = new boolean[8][8];
		int result = possibleArrangements(board, 0);
		System.out.println(result);
	}
}
