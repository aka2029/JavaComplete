package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Pair{
	String vertexName;
	String processTill;
}
class Vertex{
	HashMap<String, Integer> neighbours = new HashMap<>();
}
class Graph{
	HashMap<String, Vertex> vertx = new HashMap<>();
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		graph.addEdge("C", "B", 4);
		//graph.addEdge("D", "E", 4);
		graph.addEdge("E", "F", 4);
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
