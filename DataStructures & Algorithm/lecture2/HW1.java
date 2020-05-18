// Give command print(5) function but print 1,2,3,4,5

package lecture2;

public class HW1 {
	static void print(int num) {
		if(num == 0) {
			return;
		}
		
		print(num-1);
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		print(5);
	}
}
