package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupOfAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str [] = {"eat","ate","tea","ball","bat","tab","tan","nat"};
		List<List<String>> results ;
		HashMap<String, List<String>> map  = new HashMap<>();
		for(String s : str) {
			char [] c= s.toCharArray();
			Arrays.sort(c);
			String key = String.valueOf(c);
			if(!map.containsKey(key)) {
				map.put(key, new ArrayList());
				
			}
			map.get(key).add(s);
		}
		System.out.println(map.values());
		

	}

}
