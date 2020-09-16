package interview;

import java.util.HashMap;

public class NQueries {

	public static void main(String[] args) {
		int arr[] = {10,20,30,10,20,10,90,10,100};
		int queries [] = {10,90,100,10000,1000, 999};
		HashMap<Integer, Boolean > map = new HashMap<>();
		for(int i : arr) {
			map.put(i, true);
		}
		for(int i : queries) {
			System.out.println(map.get(i)!=null?"Yes":"No");
		}

	}

}
