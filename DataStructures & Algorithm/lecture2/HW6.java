// find sum of digits (eg. 123 will give 6 ie 1+2+3)

package lecture2;

public class HW6 {
	static int print(int num) {
		if(num == 0) {
			return 0;
		}
		
		int returnVal = (num % 10) + print(num/10);
		return returnVal;
	}
	
	public static void main(String[] args) {
		System.out.print(print(123));
	}
}
