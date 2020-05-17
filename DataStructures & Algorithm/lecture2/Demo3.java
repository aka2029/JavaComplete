// Printing 5432112345 using Recursion

package lecture2;

public class Demo3 {
	static void print(int num) {
		if (num == 0) {
			return;
		}

		// num--;
		// --num;
		// print(--num);
		System.out.println(num);
		print(num - 1);
		System.out.println(num);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(5);

	}
}
