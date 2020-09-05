package triesdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Node{
	char data; // represent current node Character
	HashMap<Character, Node> children; // represent child nodes linkage
	boolean isEnd; // End of the Word
	Node(char data, boolean isEnd){
		this();
		this.data = data;
		this.isEnd = isEnd;
	}
	Node(char data){
		this();
		this.data = data;
		this.isEnd = false;
		
	}
	Node(){
		children = new HashMap<>();
	}
}
class TrieOperations{
	private Node root;
	private int numberOfwords ;
	public int getWordLength() {
		return numberOfwords;
	}
	public Node getRoot() {
		return root;
	}
	TrieOperations(){
		root = new Node('\0');
		numberOfwords=0;
	}
	public boolean search(Node parent , String word) {
		if(word.length()==0) {
			return parent.isEnd;
		}
		char firstChar = word.charAt(0);
		String restOfString = word.substring(1);
		Node child = parent.children.get(firstChar);
		if(child == null) {
			return false;
		}
		return search(child, restOfString);
	}
	public void remove(Node parent, String word) {
		if(word.length()==0) {
			if(parent.isEnd) {
				numberOfwords--;
				parent.isEnd = false;
			}
			return ;
		}
		char firstChar = word.charAt(0);
		String restOfString = word.substring(1);
		Node child = parent.children.get(firstChar);
		if(child == null) {
			System.out.println("Not Found so Can't Remove");
			return ;
			
		}
		remove(child, restOfString);
		// Stack Fall (Recursion)
		if(!child.isEnd && child.children.size()==0) {
			parent.children.remove(child);
		}
	}
	public void add(Node parent, String word) {
		// Base case 
		if(word.length()==0) {
			parent.isEnd = true;
			numberOfwords++;
			return ;
		}
		// amit (word)
		// Get the First Character , Check in HashMap this character is already there or not
		// if not then add it
		char firstChar = word.charAt(0);
		String restOfString = word.substring(1);
		Node child = parent.children.get(firstChar);
		if(child == null) {
			child = new Node(firstChar);
			parent.children.put(firstChar, child);
		}
		add(child,restOfString);
	}
	public void print(Node parent, String result) {
		if(parent.isEnd) {
			System.out.println(result.substring(1) + parent.data);
		}
		for(Map.Entry<Character, Node> obj: parent.children.entrySet() ) {
			print(obj.getValue(), result + parent.data);
		}
	}
}
public class TrieDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieOperations opr = new TrieOperations();
		opr.add(opr.getRoot(), "amit");
		opr.add(opr.getRoot(), "anil");
		opr.add(opr.getRoot(), "ajay");
		opr.add(opr.getRoot(), "aman");
		opr.add(opr.getRoot(), "ram");
		opr.add(opr.getRoot(), "shyam");
		opr.print(opr.getRoot(), "");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the word to Search in Dictionary");
		String searchWord = scanner.next();
		boolean result = opr.search(opr.getRoot(), searchWord);
		//System.out.println(result?"Found ":"Not Found");
		if(result) {
			opr.remove(opr.getRoot(), searchWord);
			System.out.println("After Remove");
			opr.print(opr.getRoot(), "");
		}
		else {
			System.out.println("Not Found...");
		}
		scanner.close();
		
		
		

	}

}
