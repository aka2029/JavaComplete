//	Pg. 20 NQueen Problem

package lecturew10;

public class Demo1 {
	static boolean isAllowToPlace(boolean board[][], int currentRow, int currentCol) {
		// Above Row
		for (int i = currentRow; i >= 0; i--) {
			if (board[i][currentCol]) {
				return false;
			}
		}
		// Same Row
		int totalCols = board[0].length;
		for (int i = 0; i < totalCols; i++) {
			if (board[currentRow][i]) {
				return false;
			}
		}
		// right
		for (int i = currentRow, j = currentCol; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}
		// Left
		for (int i = currentRow, j = currentCol; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}
		return true;
	}

	static int possibleQueenBoardArrangement(boolean board[][], int currentRow) {
		int count = 0;
		// this count won't affect during recusion bec every time we won't come out of
		// the for loop & count is stored each time with the stack.
		// & hence static isn't required. But if we used static then after each loop it
		// would have incremented and we don't want that.
		if (currentRow == board.length) {
			return 1;
		}
		for (int col = 0; col < board[currentRow].length; col++) {
			if (isAllowToPlace(board, currentRow, col)) {
				board[currentRow][col] = true;
				count = count + possibleQueenBoardArrangement(board, currentRow + 1);
				board[currentRow][col] = false; // this is the undo operation
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean board[][] = new boolean[4][4];
		int result = possibleQueenBoardArrangement(board, 0);
		System.out.println(result);
	}
}
