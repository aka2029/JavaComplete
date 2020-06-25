//	Pg.31

package lecturew15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Demo1 {
	static int array[] = { 1, 1, 2, 1, 2, 0, 2 };

	static void howManyNumbersAreSmaller() {
		int org[] = { 8, 1, 2, 2, 3 };
		int aux[] = org.clone();
		int output[] = new int[org.length];
		Arrays.sort(aux);
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < aux.length; i++) {
			if (map.get(aux[i]) == null) {
				map.put(aux[i], i);
			}
		}
		for (int i = 0; i < org.length; i++) {

			output[i] = map.get(org[i]);
		}
		for (int i : output) {
			System.out.print(i + " , ");
		}

	}

	static void leader(int n) {
		int arr[] = { 16, 17, 4, 3, 5, 2 };
		Arrays.sort(arr);
		/*
		 * for(int i:arr) { System.out.println(i); }
		 */
		int x = arr.length - n;
		System.out.println(x);
		System.out.println(arr[arr.length - (x + 1)]);

	}

	//
	static void negativePositive() {
		int arr[] = { 90, -1000, 100, -200, 666, 77, -1 };
		for (int i = 0, j = 0; i < arr.length; i++) {
			if (arr[i] < 0 && i != j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}

	//Pg.33 Q6
	static void nthLargest(int n) {
		int arr[] = { 90, 1000, 100, 200, 666, 77, 1 };
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : arr) {
			l.add(i);
		}
		Collections.sort(l, (a, b) -> b - a);
		System.out.println(l);
		System.out.println(n + "th Largest is ::: " + l.get(n - 1));

	}

	//Pg.33 Q5
	static void firstThreeLargest() {
		int arr[] = { 90, 1000, 100, 200, 666, 77, 1 };
		int first = arr[0];
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i > first) {
				third = second;
				second = first;
				first = i;
			} else if (i > second) {
				third = second;
				second = i;
			} else if (i > third) {
				third = i;
			}
		}
		System.out.println(first);
		System.out.println(second);
		System.out.println(third);
	}

//	Part of below question
	static void swap(int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}

	//Pg.32 Q3
//	The Dutch national flag problem (DNF) is a programming problem proposed by Edsger. The flag of the NeitherLands consists of three 
//	colors: red, white and blue. Given balls of these three colors arranged randomly in a line (the actual number of balls does not matter), 
//	the task is to arrange them such that all balls of the same color are together and their collective color groups are in the correct order.
	static void dnf() {
		int low = 0, mid = 0;
		int high = array.length - 1;
		while (mid <= high) {
			switch (array[mid]) {
			case 0:
				swap(low, mid);
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(mid, high);
				high--;
				break;

			}
		}
		for (int i : array) {
			System.out.print(i+" ");
		}
	}

	//Q2 Pg.31
	static void arrange0And1() {
		int arr[] = { 0, 1, 0, 1, 0, 0, 1, 1, 0 };
		int count = 0;
		for (int i : arr) {
			if (i == 0) {
				count++;
			}
		}
		for (int i = 0; i < count; i++) {
			arr[i] = 0;
		}
		for (int i = count; i < arr.length; i++) {
			arr[i] = 1;
		}
		for (int i : arr) {
			System.out.println(i);
		}
	}

	// Q1 Pg.31
	static void unique() {
		int arr[] = { 90, 10, 1, 10, 1, 7, 90, 2, 88, 88 };
		int max = 0;
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		int hash[] = new int[max + 1];
		for (int i : arr) {
			hash[i]++;
		}
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] == 1) {
				System.out.println("Unique " + i);
			}
		}
	}

	public static void main(String[] args) {
		// unique();
		// arrange0And1();
		 dnf();
		// firstThreeLargest();
		// nthLargest(2);
		// negativePositive();
//		howManyNumbersAreSmaller();
	}
}
