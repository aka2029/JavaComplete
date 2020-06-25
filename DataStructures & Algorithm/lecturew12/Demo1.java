//	Word Search inside matrix	

package lecturew12;

public class Demo1 {
	static char board[][] = { { 'A', 'B', 'C', 'E' }, 
							  { 'S', 'F', 'C', 'B' }, 
							  { 'A', 'D', 'E', 'E' } 
							};

	static boolean searchWord(String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; i++) {
				if (isMatch(i, j, word)) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isValidPath = false;

	static boolean isMatch(int row, int col, String word) {
		// word found
		if (word.length() == 0) {
			return true;
		}

		// Word not found
		if (row < 0 || col < 0 || row == board.length || board[row][col] != word.charAt(0)) {
			return false;
		}

		// Proof that char has been visited
		board[row][col] = '#';

		int directions[][] = { { 0, 1 }, // right
				{ 1, 0 }, 	 // down
				{ -1, 0 },  // left
				{ 0, -1 }  // above
		};

		for (int direction = 0; direction < directions.length; direction++) {
			int rowDirection = directions[direction][0]; // row
			int colDirection = directions[direction][1]; // col
			isValidPath = isMatch(row + rowDirection, col + colDirection, word.substring(1));
			if (isValidPath) {
				break;
			}
		}
		board[row][col] = word.charAt(0); // Undo (BackTracking)
		return isValidPath;
	}

	public static void main(String[] args) {
		String msg = searchWord("ABCCED") ? "Word has been found" : "Sorry, didn't find the word";
		System.out.println(msg);
	}
}
