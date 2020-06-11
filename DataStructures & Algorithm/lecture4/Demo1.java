// Static in Recursion (ie Static recursion a type of recursion)

package lecture4;

public class Demo1 {
static int y = 0;
	
	static int print(int n) {
		if(n==0) {
			return 0;
		}
		y++;
		return print(n-1) + y;
//		if(n>0) {
//		return print(n-1);
//		}
//		return 0;
	}
	
	static void tree(int n) {
		if(n==0) {
			return ;
		}
		System.out.print(n);
		tree(n-1);
		tree(n-1);
//		tree(n-1);
//		tree(n-1);
	}
	
	static void tree2(int n) {
		if(n==0) {
			return ;
		}
		System.out.println(n);
		for(int i = 1; i<=5; i++) {
			tree(n-1);
		}
//		tree(n-1);
//		tree(n-1);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(print(5));
//		tree(3);
		tree2(5);
	}
}
