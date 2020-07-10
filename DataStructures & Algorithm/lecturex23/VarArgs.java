package lecturex23;

public class VarArgs {

	static int add(int... a) {
		int sum = 0;
		for (int x : a) {
			sum += x;
		}
		return sum;
	}

	public static void main(String... args) {
		// TODO Auto-generated method stub
		System.out.println(add());
		System.out.println(add(10, 20));
		System.out.println(add(10, 20, 30, 40));
	}

}
