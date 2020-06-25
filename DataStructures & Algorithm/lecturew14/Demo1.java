//	Pg.29 Just a warm up - Reverse Array

package lecturew14;

public class Demo1 {

	static int count = 0;

	static void reverse(int arr1[], int result) {
		if (count == arr1.length - 1) {
			System.out.println(result);// 1
			return;
		}
		reverse(arr1, arr1[++count]); // mentioned about this at the start of the lecture
		System.out.println(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 6, 9, 3, 10, 99, 65 };
		reverse(arr, arr[0]);
		System.out.println("After Reverse");
		for (int i : arr) {
			System.out.println(i);
		}
	}
}
