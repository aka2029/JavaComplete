// An Erudite Professor - Pg:3

package lecture1;

import java.util.HashMap;

public class Demo1 {
	public static void main(String[] args) {
		/*
		 * Approach-1
		 * 
		 * int arr [] = {1, 2, 3, 4, 7, 55, 1000, 444}; for(int i = 0; i< arr.length-1;
		 * i++) { for(int j = i + 1; j<arr.length; j++) { if(arr[i] == arr[j]) {
		 * System.out.println("Boys Party"); return; } } }
		 * System.out.println("Girls Party");
		 */

		// Approach-2 O(N)
		int arr[] = { 1, 2, 3, 1, 7, 55, 1000, 444 };
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) != null) {
				System.out.println("Boys Party");
				return;
			}
			map.put(arr[i], true);
		}

		System.out.println("Girls Party");

		// Approach-3
		/* Hint: int hash[] = new int[10001] & hash[arr[i]] = 1 */

	}
}
