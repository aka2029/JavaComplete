/*	Pattern4

	A
	A	B
	A	B	C
	A	B	C	D
	A	B	C	D	E

*/

package lecture5;

public class HW6 {
	static void pattern(int n) {
		
		if(n == 0) {
			return;
		}
		
		pattern(n-1);
		
		for(int i = 0; i<n; i++) {
			char x = (char) (65 + i);
			
			System.out.print(x + "	");
		} 
		
		System.out.println("");
	}
	
	public static void main(String[] args) {
		pattern(5);
	}
}
