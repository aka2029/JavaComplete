package lecture4;

public class HW3 {
	static int searchChar(String str, char x, int curIndex, int count) {
//		using recursion
		if (curIndex == str.length()) {
			return count;
		}

		if (str.charAt(curIndex) == x) {
			++count;
		}

		return searchChar(str, x, curIndex + 1, count);
	}

	public static void main(String[] args) {
		int val = searchChar("akash", 'k', 0, 0);
		System.out.println(val);
	}
}
