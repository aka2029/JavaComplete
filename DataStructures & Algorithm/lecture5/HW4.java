/*	Pattern2
 
 				*
 			*	*
 		*	*	*
 	*	*	*	*
 *	*	*	*	*
 
 */

package lecture5;

public class HW4 {
	static void pattern(int n) {
		final int val = 5;
		
		if(n == 0) {
			return;
		}
		
		pattern(n-1);
		
		for(int i = 1; i <= val - n; i++) {
			System.out.print("	");
		}
		for(int i = 1; i <= n; i++) {
			System.out.print("*	");
		}
		
		System.out.println("");
		return;
	}
	
	public static void main(String[] args) {
		pattern(5);
	}
}
