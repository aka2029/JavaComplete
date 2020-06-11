//	Pg.22 Sudoku

package lecturew11;

public class Demo1 {
	static int board[][] = 
		{ 
			{ 5, 3, 0, 0, 7, 0, 0, 0, 0 },
			{ 6, 0, 0, 1, 9, 5, 0, 0, 0 },
			{ 0, 9, 8, 0, 0, 0, 0, 6, 0 }, 
			{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
			{ 4, 0, 0, 8, 0, 3, 0, 0, 1 },
			{ 7, 0, 0, 0, 2, 0, 0, 0, 6 }, 
			{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, 
			{ 0, 0, 0, 4, 1, 9, 0, 0, 5 },
			{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } 
		};
	static final int BOARD_SIZE = 9;

	static void print() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean solveIt(int row, int col) {
		// if col reach to end of the col length
		if (col == BOARD_SIZE) {
			row = row + 1;
			col = 0;
		}
		// Base Case
		if (row == board.length) {
			print();
			return true;
		}
		// Check current cell is blank or not
		if (board[row][col] != 0) {
			// current cell is not blank so move to next cell
			return solveIt(row, col + 1);
		}
		// now cell is zero
		// Possiblities from 1 to 9
		for (int digit = 1; digit <= BOARD_SIZE; digit++) {
			if (isItOkToPlace(row, col, digit)) {
				board[row][col] = digit;
				boolean answer = solveIt(row, col + 1);
				if (answer) {
					return true;
				} else {
					board[row][col] = 0; // Undo
				}
			}
		}
		return false;

	}

	static boolean isPresentInRow(int row, int digit) {
		for (int col = 0; col < BOARD_SIZE; col++) {
			if (board[row][col] == digit) {
				return true;
			}
		}
		return false;
	}

	static boolean isPresentInCol(int col, int digit) {
		for (int row = 0; row < BOARD_SIZE; row++) {
			if (board[row][col] == digit) {
				return true;
			}
		}
		return false;
	}

	static boolean isPresentInSubGrid(int row, int col, int digit) {
		int r = row - row % 3;
		int c = col - col % 3;
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (board[i][j] == digit) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isItOkToPlace(int row, int col, int digit) {
		return !isPresentInRow(row, digit) && !isPresentInCol(col, digit) && !isPresentInSubGrid(row, col, digit);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String result = solveIt(0, 0) ? "Solve It " : "Not Solve It";
		System.out.println(result);

	}
}
