// Printing 5432112345 using Recursion

package lecture2;

public class Demo3 {
	static void print(int num) {
		if (num == 0) {
			return;
		}

		// num--;
		// --num;
		// print(--num);
		System.out.println(num);
		print(num - 1);
		System.out.println(num);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(5);

	}
	
	
//	??? HOW TO DO IT WITH INTEGER RETURN SIGNATURE..?
//	static int print(int num, int count) {
//		if(count == 1) {
//			return 1;
//		}
//		
//		count -= 1;
//		System.out.print(num);
//		print(num-1, count);
//		return num;
//	}
//	
//	public static void main(String[] args) {
//		System.out.println(print(5, 5)); //num, count
//	}	
}
