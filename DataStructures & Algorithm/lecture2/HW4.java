// factorial of a number

package lecture2;

public class HW4 {
	static int fact(int num) {
		if(num == 0) {
			return 1;
		}
		
		int returnVal = num*fact(num-1);
		return returnVal;
	}
	
	public static void main(String[] args) {
		System.out.print(fact(5));
	}
}
