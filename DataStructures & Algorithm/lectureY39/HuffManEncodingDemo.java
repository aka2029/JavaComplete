package hm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Node implements Comparable<Node>{
	char data;
	int cost;
	Node left;
	Node right;
	Node(){
		
	}
	Node(char data, int cost){
		this.data = data;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Node node) {
		return this.cost - node.cost;
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", cost=" + cost + ", left=" + left + ", right=" + right + "]";
	}
	
}
class Heap<T extends Comparable<T>>{
	ArrayList<T> data = new ArrayList<>();
	int size;
	int getSize() {
		return size;
	}
	void add(T item) {
		data.add(item);
		upHeapify(data.size()-1);
		size++;
	}
	
	private int compare2Nodes(T first, T second) {
		return first.compareTo(second);
	}
	private void swap(int parentIndex, int childIndex) {
		T parent = data.get(parentIndex);
		T child = data.get(childIndex);
		data.set(childIndex, parent);
		data.set(parentIndex, child);
	}
	private void upHeapify(int childIndex) {
		int parentIndex = (childIndex-1)/2;
		if(compare2Nodes(data.get(childIndex), data.get(parentIndex))>0) {
			swap(parentIndex, childIndex);
			upHeapify(parentIndex);
		}
		
		
	}
	public void print() {
		for(T t : data) {
			System.out.println(t);
		}
	}
	public T get() {
		return data.get(0);
	}
	public T delete() {
		swap(0, data.size()-1);
		T lastElement = data.remove(data.size()-1);
		downHeapify(0);
		size--;
		return lastElement;
	}
	private void downHeapify(int parentIndex) {
		int lci = parentIndex * 2 + 1;
		int rci = parentIndex * 2 + 2;
		int minIndex = parentIndex;
		if(lci < data.size() && compare2Nodes(data.get(lci), data.get(parentIndex))>0) {
			minIndex = lci;
		}
		if(rci < data.size() && compare2Nodes(data.get(rci), data.get(parentIndex))>0) {
			minIndex = rci;
		}
		
		
		if(minIndex!=parentIndex) {
			swap(parentIndex, minIndex);
			downHeapify(minIndex);
		}
		
	}
}
class HuffmanEncoderDecoder{
	HashMap<Character,String> encoder;
	HashMap<String, Character> decoder;
	HuffmanEncoderDecoder(String text){
		HashMap<Character, Integer> map = createFrequencyMap(text);
		Heap<Node> minHeap = createMinHeap(map);
		combineNodes(minHeap);
		Node lastNode = minHeap.delete();
		encoder = new HashMap<>();
		decoder = new HashMap<>();
		fillEncoderDecoder(lastNode, "");
		System.out.println("Encoder is "+encoder);
		System.out.println("Decoder is "+decoder);
	}
	HashMap<Character, Integer> createFrequencyMap(String str){
		HashMap<Character, Integer> frequencyMap = new HashMap<>();
		for(char currentChar : str.toCharArray()) {
			int c = frequencyMap.getOrDefault(currentChar, 0)+1;
			frequencyMap.put(currentChar, c);
		}
		System.out.println("Frequency Map is "+frequencyMap);
		return frequencyMap;
	}
	void combineNodes(Heap<Node> minHeap) {
		while(minHeap.size!=1) {
			Node firstMin = minHeap.delete();
			Node secondMin = minHeap.delete();
			Node combineNode = new Node();
			combineNode.left = firstMin;
			combineNode.right= secondMin;
			combineNode.data='\0';
			combineNode.cost = firstMin.cost + secondMin.cost;
			minHeap.add(combineNode);
			
		}
	}
	void fillEncoderDecoder(Node node , String result) {
		if(node== null) {
			return ;
		}
		if(node.left == null && node.right== null) {
			encoder.put(node.data, result);
			decoder.put(result, node.data);
		}
		fillEncoderDecoder(node.left, result + "0");
		fillEncoderDecoder(node.right, result + "1");
		
	}
	Heap<Node> createMinHeap(HashMap<Character, Integer> frequencyMap){
		Heap<Node> minHeap =new Heap<>();
		for(Map.Entry<Character, Integer> map: frequencyMap.entrySet()) {
			Node node = new Node(map.getKey(),map.getValue());
			minHeap.add(node);
		}
		System.out.println("MIn Heap is ");
		minHeap.print();
		return minHeap;
	}
	String encode(String str) {
		String result = "";
		for(char c : str.toCharArray()) {
			result += encoder.get(c);
		}
		return result;
	}
	String decode(String codedString) {
		String result ="";
		String key = "";
		for(char c : codedString.toCharArray()) {
			key += c;
			if(decoder.containsKey(key)) {
				result+=decoder.get(key);
				key= "";
			}
		}
		return result;
	}
}
public class HuffManEncodingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp = "aaaaaaaaaaaabbbccdab";
		HuffmanEncoderDecoder obj = new HuffmanEncoderDecoder(temp);
		String codedString = obj.encode(temp);
		System.out.println(codedString);
		String str = obj.decode(codedString);
		System.out.println(str);
		

	}

}
