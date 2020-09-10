package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
}
public class GraphDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "C", 3);
		graph.addEdge("B", "D", 5);
		graph.addEdge("C", "D", 4);
		graph.print();
		System.out.println("Remove Process");
		graph.removeEdge("A", "B");
		graph.print();
		graph.removeVertex("B");
		System.out.println("After Remove Vertex");
		graph.print();

	}

}
