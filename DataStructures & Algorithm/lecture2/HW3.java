// print 5, 3, 1, 2, 4
// It's very Odd number specific. How to generalize it??

package lecture2;

public class HW3 {
	static void print(int num) {
		if(num == 0) {
			return;
		}
		
		if(num % 2 == 1) {
			System.out.print(num);
		}
		
		num -= 1;
		print(num);
		
		if(num % 2 == 0 && num != 0) {
			System.out.print(num);
		}
		
	}
	
	public static void main(String[] args) {
		print(7);
	}
}
