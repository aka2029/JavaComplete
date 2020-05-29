// factorial of a number

package lecture2;

public class HW4 {
	static int fact(int num) {
		if (num == 0) {
			return 1;
		}

		int returnVal = num * fact(num - 1);
		return returnVal;
	}

//	static int fact(int num) {
//		if (num == 1)
//			return 1;
//		int returnVal = num * fact(num - 1);
//		return returnVal;
//	}
//
//	static void fact1(int num, int ans) {
//		if (num > 0)
//			fact1(num - 1, ans * num);
//		else
//			System.out.println(ans);
//		return;
//	}
//
//	static void fact(int num, int ans) {
//		if (num == 0) {
//			System.out.println("Result is: " + ans);
//			return;
//		}
//		fact(num - 1, ans * num);
//	}

	public static void main(String[] args) {
		System.out.print(fact(5));
	}
}
