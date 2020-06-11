// Pg.11 Q1	tree(n-i)

package lecture4;

public class HW1 { 
	static void tree(int n) {
		if(n==0 || n<0) {
			return;
		}
		System.out.print(n);
		for(int i = 1; i<=5; i++) {
			tree(n-i);
		}
	}
	
	public static void main(String[] args) {
		tree(5);
	}
}
