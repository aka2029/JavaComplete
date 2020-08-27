import java.util.HashMap;
import java.util.Map;

public class KthLargestFrequentWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kth = 3;
		Heap heap = new Heap(true);
		String words [] = {"i","i","love","love","leetcode","i","love","i","coding","coding"};
		HashMap<String, Integer> map = new HashMap<>();
		
		for(String word: words) {
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		for(Map.Entry<String, Integer> m : map.entrySet()) {
			heap.add(m.getValue());
		}
		while(kth>=1) {
		for(Map.Entry<String, Integer> m : map.entrySet()) {
			if(kth>=1) {
				if(m.getValue().equals(heap.get())) {
					System.out.println(m.getKey()+ " "+m.getValue());
					heap.remove();
					kth--;
				}
			}
			
		}
		}

	}

}
