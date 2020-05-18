// print 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5

package lecture2;

public class HW2 {
	static void print(int num) {
		if(num == 0) {
			System.out.print(0 + " ");
			return;
		}
		System.out.print(num + " ");
		print(num-1);
		System.out.print(num + " ");
	}
	
	public static void main(String[] args) {
		print(5);
	}
}
