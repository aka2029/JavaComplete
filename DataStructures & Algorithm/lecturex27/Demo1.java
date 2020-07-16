//	Binary Tree

package lecturex27;

import java.util.LinkedList;
import java.util.Scanner;

class BNode {
	int data;
	BNode left;
	BNode right;

	BNode(int data) {
		this.data = data;
	}
}

class BinaryTreeOperations {
	Scanner s = new Scanner(System.in);
	String str = "root";

	BNode add() {
		System.out.println("Enter the " + str + " Data Press -1 to Exit");
		int data = s.nextInt();
		if (data == -1) {
			return null;
		}
		BNode node = new BNode(data);
		str = "left";
		node.left = add();
		str = "right";
		node.right = add();
		str = "root";
		return node;
	}

	void print(BNode root) {
		if (root == null) {
			return;
		}
		String str = root.data + " => ";
		if (root.left != null) {
			str += "L:" + root.left.data;
		}
		if (root.right != null) {
			str += "R:" + root.right.data;
		}
		System.out.println(str);
		print(root.left);
		print(root.right);
	}

	int height(BNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		int max = Math.max(leftHeight, rightHeight);
		return max + 1;

	}

	void preOrder(BNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	void postOrder(BNode root) {
		if (root == null) {
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}

	void inOrder(BNode root) {
		if (root == null) {
			return;
		}

		postOrder(root.left);
		System.out.println(root.data);
		postOrder(root.right);

	}

	int countNodes(BNode root) {
		if (root == null) {
			return 0;
		}
		int counter = 1;
		counter += countNodes(root.left);
		counter += countNodes(root.right);
		return counter;
	}

	void levelOrder(BNode root) {
		LinkedList<BNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BNode currentNode = queue.removeFirst();
			System.out.println(currentNode.data);
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
	}
}

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeOperations opr = new BinaryTreeOperations();
		BNode root = opr.add();
		opr.print(root);
		System.out.println(opr.height(root));
		opr.levelOrder(root);
		System.out.println(opr.countNodes(root));

	}

}
