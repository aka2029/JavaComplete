package interview;

import java.util.HashMap;

public class LargestPerm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {3,4,1,2,5};
		int swap = 2;
		int i = 0;
		int n = arr.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for( i =0; i<n; i++) {
			map.put(arr[i], i);
		}
		i = 0;
		while(i<n && swap>0) {
			int bestPos = n - i;
			int index = map.get(bestPos);
			if(index== n - arr[i]+i) {
				i++;
				continue;
			}
			else {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				map.put(arr[index], index);
				map.put(arr[i], i);
				i++;
				swap--;
			}
		}
		System.out.println("After swap");
		
		for(int a : arr) {
			System.out.print(a);
		}

	}

}
