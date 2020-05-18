// The printing Introduction Question - 12345
// RECURSION

package lecture2;

public class Demo2 {
	static void print() {
		System.out.println("Print Call");
	}

	static int count = 1;

	public static void main(String[] args) {
		// main(null);
		// print();
		if (count == 6) {
			return;
		}
		int a = 10;
		int b = 20;
		System.out.println("Main Call " + (a + b) + " Count is " + count);
		count++;
		main(null);
	}
	
//	static void print(int num) {
//		if(num == 0) {
//			return;
//		}
//		
//		print(num-1);
//		System.out.println(num + " ");
//	}
//	
//	public static void main(String[] args) {
//		print(5);
//	}
}
