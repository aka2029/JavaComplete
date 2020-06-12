/*	Pattern1
 * 
 * 		*
 * 		*	*
 * 		*	*	*
 * 		*	*	*	*
*/
package lecture5;

public class HW3 {
	static void pattern(int n) {
		if(n == 0) {
			return;
		}
		
		pattern(n-1);
		
		for(int i = 1; i<=n; i++) {
			System.out.print("* ");
		}
		
		System.out.println("");
	}
	
	public static void main(String[] args) {
		pattern(10);
	}
}
