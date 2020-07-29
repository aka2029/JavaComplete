//	Generic Tree

package lecturex26;

import java.util.ArrayList;
import java.util.Scanner;

class Node {
	int data;
	ArrayList<Node> children;

	Node(int data) {
		this.data = data;
		children = new ArrayList<>();
	}
}

class GenericTreeOperations {
	Scanner scanner = new Scanner(System.in);
	Node root;

	Node add() {
		Node root = null;
		System.out.println("Enter the Parent Data");
		int data = scanner.nextInt();
		root = new Node(data);
		System.out.println("Enter the Number of Children");
		int children = scanner.nextInt();
		for (int i = 1; i <= children; i++) {
			Node child = add();
			root.children.add(child);
		}

		return root;
	}

	void print(Node root) {
		String str = root.data + " => ";
		for (int i = 0; i < root.children.size(); i++) {
			str += root.children.get(i).data + " , ";
		}
		System.out.println(str.substring(0, str.length() - 2));
		for (int i = 0; i < root.children.size(); i++) { //to remove the last comma(,) that comes as output
			print(root.children.get(i));
		}
	}

	int countNodes(Node root) {
		if (root == null) {
			return 0;
		}
		int count = 1;
		for (int i = 0; i < root.children.size(); i++) {
			count += countNodes(root.children.get(i));
		}
		return count;
	}

	int largestNode(Node root) {
		if (root == null) {
			return 0;
		}
		int largest = root.data;
		for (int i = 0; i < root.children.size(); i++) {
			int currentNode = largestNode(root.children.get(i));
			if (currentNode > largest) {
				largest = currentNode;
			}

		}
		return largest;
	}

	int height(Node root) {
		if (root == null) {
			return 0;
		}
		if (root.children.size() == 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < root.children.size(); i++) {
			max = Math.max(max, height(root.children.get(i)));
		}
		return max + 1;
	}

	int countLeafNodes(Node root) {
		int count = 0;
		if (root == null) {
			return 0;
		}
		if (root.children.size() == 0) {
			return 1;
		}
		for (int i = 0; i < root.children.size(); i++) {
			count += countNodes(root.children.get(i));
		}
		return count;
	}
}

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericTreeOperations gt = new GenericTreeOperations();
		gt.root = gt.add();
		gt.print(gt.root);
		gt.countNodes(gt.root);
	}
}
