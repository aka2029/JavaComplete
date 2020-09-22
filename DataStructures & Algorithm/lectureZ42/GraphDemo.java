package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Pair{
	String vertexName;
	String processTill;
}
class Vertex{
	HashMap<String, Integer> neighbours = new HashMap<>();
}
class HPair{
	String vertexName;
	String acquireVertexName;
	int cost;
}
class Graph{
	HashMap<String, Vertex> vertx = new HashMap<>();
	HashMap<String,Integer> dijkstra(String source){
		HashMap<String,Integer> answerMap = new HashMap<>();
		HashMap<String, HPair> map = new HashMap<>();
		PriorityQueue<HPair> heap = new PriorityQueue<>((first, second)-> first.cost - second.cost);
		for(String key : vertx.keySet()) {
			HPair pair = new HPair();
			pair.vertexName = key;
			pair.acquireVertexName = null;
			pair.cost = Integer.MAX_VALUE;
			if(key.equals(source)) {
				pair.cost = 0;
				pair.acquireVertexName = key;
			}
			heap.add(pair);
			map.put(key, pair);
		}
		while(!heap.isEmpty()) {
			HPair p = heap.remove();
			map.remove(p.vertexName);
			answerMap.put(p.vertexName, p.cost);
			for(String neighbour: vertx.get(p.vertexName).neighbours.keySet()) {
				if(map.containsKey(neighbour)) {
					int oldCost = map.get(neighbour).cost;
					int newCost = p.cost + vertx.get(p.vertexName).neighbours.get(neighbour);
					if(newCost<oldCost) {
						HPair p2 = map.get(neighbour);
						HPair p3 = new HPair();
						p3.vertexName = p2.vertexName;
						heap.remove(p2);
						p3.acquireVertexName = p.acquireVertexName + neighbour;
						p3.cost = newCost;
						heap.add(p3);
						map.put(neighbour, p3);
						
					}
				}
			}
			
		}
		return answerMap;
	}
	Graph prims() {
		Graph mst = new Graph();
		HashMap<String, HPair> map = new HashMap<>();
		PriorityQueue<HPair> heap = new PriorityQueue<>((first, second)->first.cost - second.cost);
		for(String key : vertx.keySet()) {
			HPair pair = new HPair();
			pair.vertexName = key;
			pair.acquireVertexName  = null;
			pair.cost = Integer.MAX_VALUE;
			heap.add(pair);
			map.put(key, pair);
		}
		while(!heap.isEmpty()) {
			HPair p= heap.remove();
			map.remove(p.vertexName);
			if(p.acquireVertexName==null) {
				mst.addVertex(p.vertexName); 
			}
			else {
				mst.addVertex(p.vertexName);
				mst.addEdge(p.vertexName, p.acquireVertexName, p.cost);
			}
			// Explore the neighbours
			for(String neighbour:  vertx.get(p.vertexName).neighbours.keySet()) {
				if(map.containsKey(neighbour)) {
					int oldCost = map.get(neighbour).cost;
					int newCost = vertx.get(p.vertexName).neighbours.get(neighbour);
					if(newCost<oldCost) {
						HPair pair2  = map.get(neighbour);
						HPair pair3 = new HPair();
						pair3.vertexName = pair2.vertexName;
						heap.remove(pair2);
						pair3.cost = newCost;
						pair3.acquireVertexName = p.vertexName;
						heap.add(pair3);
						map.put(neighbour, pair3);
						
					}
				}
			}
		}
		return mst;
	}
	int getSize() {
		return vertx.size();
	}
	boolean containsVertex(String vertexName) {
		return vertx.containsKey(vertexName);
	}
	void removeEdge(String firstVertex, String secondVertex) {
		if(isEdgePresent(firstVertex, secondVertex)) {
			Vertex v1 = vertx.get(firstVertex);
			Vertex v2 = vertx.get(secondVertex);
			v1.neighbours.remove(secondVertex);
			v2.neighbours.remove(firstVertex);
		}
		else {
			System.out.println("No Edge Present So Can't Delete");
		}
		
	}
	void removeVertex(String vertexName) {
		Vertex v1 = vertx.get(vertexName);
		ArrayList<String> negNames = new ArrayList<>(v1.neighbours.keySet());
		for(String name : negNames) {
			Vertex temp = vertx.get(name);
			temp.neighbours.remove(vertexName);
		}
		vertx.remove(vertexName);
	}
	void addVertex(String vertexName) {
		Vertex vertex = new Vertex();
		vertx.put(vertexName, vertex);
	}
	boolean isEdgePresent(String firstVertex, String secondVertex) {
		Vertex v1 = vertx.get(firstVertex);
		Vertex v2 = vertx.get(secondVertex);
		if(v1== null || v2==null || !v1.neighbours.containsKey(secondVertex)) {
			return false;
		}
		return true;
		
	}
	void addEdge(String firstVertex, String secondVertex, int cost) {
		if(isEdgePresent(firstVertex, secondVertex)) {
			System.out.println("Edge Already Present So Can't Add Edge");
		}
		else {
			Vertex first = vertx.get(firstVertex);
			Vertex second = vertx.get(secondVertex);
			first.neighbours.put(secondVertex, cost);
			second.neighbours.put(firstVertex, cost);
		}
	}
	public void print() {
		for(Map.Entry<String, Vertex> m : vertx.entrySet()) {
			System.out.println(m.getKey()+" "+m.getValue().neighbours);
		}
	}
	
	boolean dfs(String source, String destination) {
		HashMap<String, Boolean> visitedMap = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		Pair pair = new Pair();
		pair.vertexName = source;
		pair.processTill = source;
		stack.addFirst(pair);
		while(!stack.isEmpty()) {
			Pair p = stack.removeLast();
			if(visitedMap.containsKey(p.vertexName)) {
				continue;
			}
			visitedMap.put(p.vertexName, true);
			if(isEdgePresent(p.vertexName, destination)) {
				return true;
			}
			Vertex v1 = vertx.get(p.vertexName);
			ArrayList<String> neighbours = new ArrayList<>(v1.neighbours.keySet());
			for(String neighbour: neighbours) {
				if(!visitedMap.containsKey(neighbour)) {
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.processTill = p.processTill + neighbour;
					stack.addFirst(newPair);
				}
			}
		}
		return false;
		
	}
	
	
	void dft() {
		HashMap<String, Boolean> visitedMap = new HashMap<>();
		LinkedList<Pair> stack = new LinkedList<>();
		ArrayList<String> keys = new ArrayList<>(vertx.keySet());
		for(String key: keys) {
			if(visitedMap.containsKey(key)) {
				continue;
			}
		
		Pair pair = new Pair();
		pair.vertexName = key;
		pair.processTill = key;
		stack.addFirst(pair);
		while(!stack.isEmpty()) {
			Pair p = stack.removeFirst();
			if(visitedMap.containsKey(p.vertexName)) {
				continue;
			}
			visitedMap.put(p.vertexName, true);
			System.out.println(p.vertexName + " " + p.processTill);
//			if(isEdgePresent(p.vertexName, destination)) {
//				return true;
//			}
			Vertex v1 = vertx.get(p.vertexName);
			ArrayList<String> neighbours = new ArrayList<>(v1.neighbours.keySet());
			for(String neighbour: neighbours) {
				if(!visitedMap.containsKey(neighbour)) {
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.processTill = p.processTill + neighbour;
					stack.addFirst(newPair);
				}
			}
		}
		}
		//return false;
		
	}
	
	void bft() {
		HashMap<String, Boolean> visitedMap = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys= new ArrayList<>(vertx.keySet());
//		Pair pair = new Pair();
//		pair.vertexName = source;
//		pair.processTill = source;
		//queue.addLast(pair);
		for(String key : keys) {
			if(visitedMap.containsKey(key)) {
				continue;
			}
		Pair pair = new Pair();
		pair.vertexName = key;
		pair.processTill = key;
		queue.addLast(pair);
		while(!queue.isEmpty()) {
			Pair p = queue.removeFirst();
			if(visitedMap.containsKey(p.vertexName)) {
				continue;
			}
			visitedMap.put(p.vertexName, true);
			System.out.println(p.vertexName+" "+p.processTill);
			
//			if(isEdgePresent(p.vertexName, destination)) {
//				return true;
//			}
			Vertex v1 = vertx.get(p.vertexName);
			ArrayList<String> neighbours = new ArrayList<>(v1.neighbours.keySet());
			for(String neighbour: neighbours) {
				if(!visitedMap.containsKey(neighbour)) {
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.processTill = p.processTill + neighbour;
					queue.addLast(newPair);
				}
			}
		} // queue loop end
		}// Key loop ends
		//return false;
		
	}
	
	HashMap<String,ArrayList<String>> getComponents() {
		int component = 0;
		HashMap<String, ArrayList<String>> componentMap = new HashMap<>();
		HashMap<String, Boolean> visitedMap = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys= new ArrayList<>(vertx.keySet());
//		Pair pair = new Pair();
//		pair.vertexName = source;
//		pair.processTill = source;
		//queue.addLast(pair);
		
		for(String key : keys) {
			if(visitedMap.containsKey(key)) {
				continue;
			}
		ArrayList<String>	subComponent = new ArrayList<>();
		Pair pair = new Pair();
		pair.vertexName = key;
		pair.processTill = key;
		queue.addLast(pair);
		while(!queue.isEmpty()) {
			Pair p = queue.removeFirst();
			if(visitedMap.containsKey(p.vertexName)) {
				continue;
				
				//return true;
			}
			visitedMap.put(p.vertexName, true);
			subComponent.add(p.vertexName);
			//System.out.println(p.vertexName+" "+p.processTill);
			
//			if(isEdgePresent(p.vertexName, destination)) {
//				return true;
//			}
			Vertex v1 = vertx.get(p.vertexName);
			ArrayList<String> neighbours = new ArrayList<>(v1.neighbours.keySet());
			for(String neighbour: neighbours) {
				if(!visitedMap.containsKey(neighbour)) {
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.processTill = p.processTill + neighbour;
					queue.addLast(newPair);
				}
			}
		} // queue loop end
		component++;
		componentMap.put(String.valueOf(component), subComponent);
		}// Key loop ends
		return componentMap;
		
	}

	
	boolean isConnected() {
		HashMap<String, Boolean> visitedMap = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys= new ArrayList<>(vertx.keySet());
//		Pair pair = new Pair();
//		pair.vertexName = source;
//		pair.processTill = source;
		//queue.addLast(pair);
		int visitCount = 0;
		for(String key : keys) {
			if(visitedMap.containsKey(key)) {
				continue;
			}
			visitCount++;
		Pair pair = new Pair();
		pair.vertexName = key;
		pair.processTill = key;
		queue.addLast(pair);
		while(!queue.isEmpty()) {
			Pair p = queue.removeFirst();
			if(visitedMap.containsKey(p.vertexName)) {
				continue;
				
				//return true;
			}
			visitedMap.put(p.vertexName, true);
			//System.out.println(p.vertexName+" "+p.processTill);
			
//			if(isEdgePresent(p.vertexName, destination)) {
//				return true;
//			}
			Vertex v1 = vertx.get(p.vertexName);
			ArrayList<String> neighbours = new ArrayList<>(v1.neighbours.keySet());
			for(String neighbour: neighbours) {
				if(!visitedMap.containsKey(neighbour)) {
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.processTill = p.processTill + neighbour;
					queue.addLast(newPair);
				}
			}
		} // queue loop end
		}// Key loop ends
		return visitCount==1;
		
	}
	
	boolean icCyclePresent() {
		HashMap<String, Boolean> visitedMap = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		ArrayList<String> keys= new ArrayList<>(vertx.keySet());
//		Pair pair = new Pair();
//		pair.vertexName = source;
//		pair.processTill = source;
		//queue.addLast(pair);
		for(String key : keys) {
			if(visitedMap.containsKey(key)) {
				continue;
			}
		Pair pair = new Pair();
		pair.vertexName = key;
		pair.processTill = key;
		queue.addLast(pair);
		while(!queue.isEmpty()) {
			Pair p = queue.removeFirst();
			if(visitedMap.containsKey(p.vertexName)) {
				//continue;
				return true;
			}
			visitedMap.put(p.vertexName, true);
			System.out.println(p.vertexName+" "+p.processTill);
			
//			if(isEdgePresent(p.vertexName, destination)) {
//				return true;
//			}
			Vertex v1 = vertx.get(p.vertexName);
			ArrayList<String> neighbours = new ArrayList<>(v1.neighbours.keySet());
			for(String neighbour: neighbours) {
				if(!visitedMap.containsKey(neighbour)) {
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.processTill = p.processTill + neighbour;
					queue.addLast(newPair);
				}
			}
		} // queue loop end
		}// Key loop ends
		return false;
		
	}
	
	boolean bfs(String source, String destination) {
		HashMap<String, Boolean> visitedMap = new HashMap<>();
		LinkedList<Pair> queue = new LinkedList<>();
		Pair pair = new Pair();
		pair.vertexName = source;
		pair.processTill = source;
		queue.addLast(pair);
		while(!queue.isEmpty()) {
			Pair p = queue.removeFirst();
			if(visitedMap.containsKey(p.vertexName)) {
				continue;
			}
			visitedMap.put(p.vertexName, true);
			if(isEdgePresent(p.vertexName, destination)) {
				return true;
			}
			Vertex v1 = vertx.get(p.vertexName);
			ArrayList<String> neighbours = new ArrayList<>(v1.neighbours.keySet());
			for(String neighbour: neighbours) {
				if(!visitedMap.containsKey(neighbour)) {
					Pair newPair = new Pair();
					newPair.vertexName = neighbour;
					newPair.processTill = p.processTill + neighbour;
					queue.addLast(newPair);
				}
			}
		}
		return false;
		
	}
	boolean containsPath(String firstVertex, String lastVertex, HashMap<String, Boolean> visitedMap) {
		visitedMap.put(firstVertex, true);
		if(isEdgePresent(firstVertex, lastVertex)) {
			return true;
		}
		Vertex v1 = vertx.get(firstVertex);
		ArrayList<String> neighbours = new ArrayList<>(v1.neighbours.keySet());
		for(String neighbour: neighbours) {
			if(!visitedMap.containsKey(neighbour) && containsPath(neighbour, lastVertex, visitedMap)) {
				return true;
			}
		}
		
		return false;
	}
}
public class GraphDemo {
	static void placeInAdList() {
		int arr[][] = {{0,1},{1,2},{2,0},{1,3}};
		List<List<Integer>> list = new ArrayList<>();
		for(int i = 0; i<arr.length; i++) {
			List<Integer> subList =new ArrayList<>();
			subList.add(arr[i][0]);
			subList.add(arr[i][1]);
			list.add(subList);
		}
		System.out.println(list);
		Graph graph = new Graph();
		for(int i = 0; i<arr.length; i++) {
			graph.addVertex(String.valueOf(i));
		}
		for(List<Integer> sub : list) {
			String firstVertex = sub.get(0).toString();
			String secondVertex = sub.get(1).toString();
			graph.addEdge(firstVertex, secondVertex, 0);
		}
		graph.print();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("AD LIST TEST ");
		placeInAdList();
		System.out.println("$$$$$$$$$$$$$$$$$$");
		int matrix[][] = new int[3][3];
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addEdge("A", "D", 2);
		graph.addEdge("A", "C", 3);
		graph.addEdge("B", "D", 5);
		graph.addEdge("C", "B", 1);
		graph.addEdge("D", "E", 2);
		//Graph mst = graph.prims();
		//mst.print();
	
		System.out.println("**********************");
		
		//graph.addEdge("E", "F", 4);
		//boolean result = graph.containsPath("A", "M", new HashMap<>());
		System.out.println("BFT.......");
		System.out.println("Cycle Present "+graph.icCyclePresent());
		graph.bft();
		System.out.println("Connected "+graph.isConnected());
		System.out.println("Sub Component Details are :::::::::");
		System.out.println(graph.getComponents());
		System.out.println("BFT.......");
		System.out.println("DFT ........");
		graph.dft();
		System.out.println("DFT %%%%%%%%%%%%%%");
		boolean result = graph.dfs("A", "T");
		System.out.println("DFS "+result);
		
		
		System.out.println("Path Contains B/W A to M "+result);
		
		graph.print();
		System.out.println("Remove Process");
		graph.removeEdge("A", "B");
		graph.print();
		graph.removeVertex("B");
		System.out.println("After Remove Vertex");
		graph.print();

	}

}
