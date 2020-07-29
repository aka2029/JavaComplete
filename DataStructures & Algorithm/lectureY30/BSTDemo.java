package treedemo;

class BST{
	int data;
	BST left;
	BST right;
	BST(int data){
		this.data = data;
	}
}
class BSTOperations{
	BST root;
	void inOrder(BST node) {
		if(node!=null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}
	boolean search(BST currentNode , int data) {
		// Empty Tree
		if(currentNode != null &&  currentNode.data == data) {
			return true;
		}
		if(currentNode == null) {
			return false;
		}
		// Tree is Not Empty
		if(data<currentNode.data) {
			
			
			return search(currentNode.left, data);
		}
		else {
			
			return search(currentNode.right, data);
		}
		
	}
	BST insert(BST currentNode , int data) {
		// Empty Tree
		if(root == null) {
			BST node = new BST(data);
			currentNode = node;
			root = node;
			return currentNode;
			
		}
		if(currentNode == null) {
			BST node = new BST(data);
			currentNode = node;
			return currentNode;
		}
		// Tree is Not Empty
		if(data<currentNode.data) {
			
			
			currentNode.left = insert(currentNode.left, data);
		}
		else {
			
			currentNode.right = insert(currentNode.right, data);
		}
		return currentNode;
	}
}
public class BSTDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTOperations bst = new BSTOperations();
		bst.insert(bst.root, 77);
		bst.insert(bst.root, 97);
		bst.insert(bst.root, 100);
		bst.insert(bst.root, 44);
		bst.insert(bst.root, 41);
		bst.insert(bst.root, 51);
		bst.inOrder(bst.root);
		System.out.println(bst.search(bst.root, 411));
		

	}

}
