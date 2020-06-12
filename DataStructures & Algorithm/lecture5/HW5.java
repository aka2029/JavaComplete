/*	Pattern3
 * 
 * 		1
 * 		2	2
 * 		3	3	3
 * 		4	4	4	4
 * 		5	5	5	5	5
*/
package lecture5;

public class HW5 {
	static void pattern(int n) {
		if(n == 0) {
			return;
		}
		
		pattern(n-1);
		
		for(int i = 1; i<=n; i++) {
			System.out.print(n + " ");
		}
		
		System.out.println("");
	}
	
	public static void main(String[] args) {
		pattern(5);
	}
}
