// power of a number

package lecture2;

public class HW5 {
	static int print(int num, int pow) {
		if(pow == 0) {
			return 1;
		}
		
		int returnVal = num*print(num, pow-1);
		return returnVal;
	}
	
	public static void main(String[] args) {
		System.out.print(print(2, 3));
	}
}
