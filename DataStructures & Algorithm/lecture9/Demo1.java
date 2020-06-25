//	Pg.18

package lecture9;

public class Demo1 {
	//Permutaion
	static void coinChange(int coins[], long amount, String result) {
		if (amount == 0) {
			System.out.println(result);
			return;
		}
		for (int i = 0; i < coins.length; i++) {
			if (amount >= coins[i]) {
				coinChange(coins, amount - coins[i], result + coins[i]);
			}
		}
	}

	//Combination
	static void coinChange2(int coins[], int amount, String result, int lastIndex) {
		if (amount == 0) {
			System.out.println(result);
			return;
		}
		for (int i = lastIndex; i < coins.length; i++) {
			if (amount >= coins[i]) {
				coinChange2(coins, amount - coins[i], result + coins[i], i);
			}
		}
	}

	static void maze(int startRow, int startCol, int endRow, int endCol, String result) {
		if (startRow == endRow && startCol == endCol) {
			System.out.println(result);
			return;
		}
		if (startRow > endRow || startCol > endCol) {
			return;
		}
		maze(startRow + 1, startCol, endRow, endCol, result + "H");
		maze(startRow, startCol + 1, endRow, endCol, result + "V");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// maze(0,0,2,2,"");
		int coins[] = { 2, 3, 5, 6 };
		int amount = 10;
		String result = "";
		coinChange2(coins, amount, result, 0);

	}
}
