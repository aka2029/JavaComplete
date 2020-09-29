package interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class BPPair {
	String vertexName;
	int level;

	BPPair(String vertexName, int level) {
		this.vertexName = vertexName;
		this.level = level;
	}
}

public class BiPartileDemo {
	static Graph graph = new Graph();
	static boolean isBP(String vertexName, HashMap<String, Integer> visitedMap) {
		LinkedList<BPPair> queue = new LinkedList<>();
		queue.addLast(new BPPair(vertexName,0));
		while(!queue.isEmpty()) {
			BPPair pair = queue.removeFirst();
			if(visitedMap.get(pair.vertexName)!=null) {
				// Odd vertex cycle
				if(pair.level!=visitedMap.get(pair.vertexName)) {
					return false;
				}
			}
			else {
				visitedMap.put(pair.vertexName, pair.level);
			}
			Vertex v1 = graph.vertx.get(pair.vertexName);
			ArrayList<String> neighbours = new ArrayList<>(v1.neighbours.keySet());
			for(String neighbour : neighbours) {
				if(!visitedMap.containsKey(neighbour)) {
					BPPair newPair = new BPPair(neighbour, pair.level+ 1);
					queue.addLast(newPair);
				}
			}
		}
		return true;
	}

	static void checkBP() {
		
		// add vertex, add edge
		HashMap<String, Integer> visitedMap = new HashMap<>();
		for(String key : graph.vertx.keySet()) {
			if(visitedMap.get(key)==null) {
				if(!isBP(key, visitedMap)) {
					System.out.println("NOT BP");
					return;
				}
			}
			
		}
		System.out.println("BP");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkBP();

	}

}
