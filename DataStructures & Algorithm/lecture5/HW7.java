/*	Pattern4

	A
	B	C
	D	E	F
	G	H	I	J
	K	L	M	N	O

*/

package lecture5;

public class HW7 {
//	static char x = 65;
//	static void pattern(int n) {
//		
//		if(n == 0) {
//			return;
//		}
//		
//		pattern(n-1);
//		
//		for(int i = 0; i<n; i++) {
//			System.out.print(x + "	");
//			x++;
//		} 
//		
//		System.out.println("");
//	}
	
	
//	Doing the same above thing just without using static variable
	static void pattern(int n, char x, int end) {
		if(n == end) {
			return;
		}
		for(int i = 0; i<n; i++) {
			System.out.print(x+" ");
			x++;
		}
		System.out.println();
		pattern(n+1, x, end);
	}
	
//	The above thing can also be done by passing it in helper function
//	i.e inside function pattern(int n) pass the above function.
	
	public static void main(String[] args) {
//		pattern(5);
		pattern(1, ((char)65), 5);
	}
}

/*

	To do this without using Static variable:-
	

*/
