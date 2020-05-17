// The Missing Number Question - Pg:4

package lecture2;

public class Demo1 {
	public static void main(String[] args) {

		int arr[] = { 1, 3, 4 };
		int x = 0;
		int y = 0;
		int min = 1;
		int max = 4;
		for (int i = 0; i < arr.length; i++) {
			x = x ^ arr[i];
		}
		for (int i = min; i <= max; i++) {
			y = y ^ i;
		}
		System.out.println("Missing No is " + (x ^ y));

	}
}
