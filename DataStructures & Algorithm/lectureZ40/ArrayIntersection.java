package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ArrayIntersection {

	public static void main(String[] args) {
		int first [] = {1,2,3,1,2,4,1};
		int second [] = {2,1,3,1,5,2,2};
		HashMap<Integer, Integer> frequencyMap = new HashMap<>();
		for(int ele : first) {
			frequencyMap.put(ele, frequencyMap.getOrDefault(ele, 0)+1);
		}
		ArrayList<Integer> output = new ArrayList<>();
		for(int ele : second) {
			if(frequencyMap.containsKey(ele) && frequencyMap.get(ele)>0) {
				int count = frequencyMap.get(ele);
				count--;
				frequencyMap.put(ele, count);
				output.add(ele);
				
			}
		}
		Collections.sort(output);
		for(int ele : output) {
			System.out.print(ele+" ");
		}

	}

}
