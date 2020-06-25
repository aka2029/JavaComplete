//	Pg.30 (All questions present) Arrays and multiple questions

package lecturew14;

import java.util.Arrays;
import java.util.HashMap;

public class Demo2 {
	
	//The pair sum question using 1 pointer
	static void pairSumAp2(int arr[]) {
		int sum = 11;
		int max = 0;
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		
		int hash[] = new int[max];
		// HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i : arr) {
			int key = sum - i;
			// if(map.get(key)!=null) {
			if (hash[key] == 1) {
				System.out.println("Pair Found " + i + " " + key);
				// break;
			}
			hash[i] = 1;
			// map.put(i, true);
			// System.err.println("Map is "+map);
		}
	}

	//The pair sum questino using 2 Pointor
	static void pairSumAp1(int arr[]) {
		int sum = 11;

		// int aux [] = arr.clone();
		// Arrays.sort(aux);
		Arrays.sort(arr);
		int i = 0;
		int j = arr.length - 1;
		boolean isPair = false;
		while (i < j) {
			if (arr[i] + arr[j] == sum) {
				System.out.println("Pair Sum " + arr[i] + " " + arr[j]);
				isPair = true;
				i++;
				j--;
				// return ;
			} else if (arr[i] + arr[j] < sum) {
				i++;
			} else if (arr[i] + arr[j] > sum) {
				j--;
			}
		}
		if (!isPair) {
			System.out.println("No Pair Sum Found...");
		}
	}

	//The Leader Element Question
	static void leader(int arr[]) {
		int max = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];
				System.out.println(max);
			}
		}
	}

	//The zigzag Array question
	static void zigZagArray(int arr[]) {
		// {4,3,7,8,6,2,1}
		int temp;
		boolean flag = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (flag) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			} else {
				if (arr[i] < arr[i + 1]) {
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			flag = !flag;
		}
		System.out.println("Zig Zag Array is ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	//Rotating the array
	static void rotate(int arr[], int start, int end) {
		int low = start;
		int high = end;
		while (low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}
	
	//Reversing the array
	static void reverse(int arr[]) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
		System.out.println("After Reverse");
		for (int i : arr) {
			System.out.println(i);
		}
	}

	static void print(int z[]) {
		for (int i : z) {
			System.out.print(i + ",");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int x[] = new int[5];
//		int [] y = new int[5];
//		int [] z = {10,20,30,40,50};
//		//reverse(z);
		
//		int n = 2;
//		rotate(z, 0, n-1); // 1st 0 to rotation-1
//		print(z);
//		rotate(z,n, z.length-1) ;// reverse remaining n to arr.len-1
//		print(z);
//		rotate(z,0,z.length-1) ;// reverse full array
//		print(z);

		// int t [] = new int[] {10,20,30,40,50};
//		 int arr[] = {4,3,7,8,6,2,10};
//		 zigZagArray(arr);
		// leader(arr);
		int arr[] = { 2, 9, 6, 3, 1, 10, 4, 10000 };
		pairSumAp2(arr);

	}
}
