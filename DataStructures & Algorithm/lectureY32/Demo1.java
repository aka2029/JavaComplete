package treedemo;

import java.util.Stack;

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
	
	void inOrderIterative() {
		if(root == null) {
			return ;
		}
		Stack<BST> stack = new Stack<>();
		BST currentNode = root;
		while(currentNode!=null || stack.size()>0) {
		while(currentNode!=null) {
			stack.push(currentNode);
			currentNode = currentNode.left;
		}
		currentNode = stack.pop();
		System.out.println(currentNode.data);
		currentNode = currentNode.right;
		}
	}
	void preOrderIterative() {
		if(root == null) {
			return ;
		}
		Stack<BST> stack = new Stack<>();
		BST currentNode = root;
		stack.push(currentNode);
		while(stack.size()>0) {
			currentNode = stack.pop();
			System.out.println(currentNode.data);
			if(currentNode.right!=null) {
				stack.push(currentNode.right);
			}
			if(currentNode.left!=null) {
				stack.push(currentNode.left);
			}
		}
	}
	void postOrderIterative() {
		
		if(root== null) {
			return;
		}
		Stack<BST> stack1 = new Stack<>();
		Stack<BST> stack2 = new Stack<>();
		stack1.push(root);
		while(stack1.size()>0) {
			BST currentNode= stack1.pop();
			stack2.push(currentNode);
			if(currentNode.left!=null) {
				stack1.push(currentNode.left);
			}
			if(currentNode.right!=null) {
				stack1.push(currentNode.right);
			}
		}
		while(stack2.size()>0) {
			System.out.println(stack2.pop().data);
		}
	}
	void printInBWRange(BST node, int r1, int r2) {
		if(node==null) {
			return ;
		}
		if(r1<node.data) {
			printInBWRange(node.left, r1, r2);
		}
		if(r1<=node.data && r2>=node.data) {
			System.out.println(node.data);
		}
		if(r2>node.data) {
			printInBWRange(node.right, r1, r2);
		}
	}
	
	boolean validateBST(BST node, Integer left, Integer right) {
		if(node==null) {
			return true;
		}
		int currentNodeValue = node.data;
		if(left!=null && currentNodeValue<=left) {
			return false;
		}
		if(right!=null && currentNodeValue>=right) {
			return false;
		}
		if(!validateBST(node.left, left, currentNodeValue)) {
			return false;
		}
		if(!validateBST(node.right, currentNodeValue, right)) {
			return false;
		}
		return true;
	}
	
	BST trimTree(BST node, int left, int right) {
		if(node==null) {
			return node;
		}
		if(node.data>right) {
			return trimTree(node.left, left, right);
		}
		if(node.data<left) {
			return trimTree(node.right, left, right);
		}
		node.left  = trimTree(node.left, left, right);
		node.right  = trimTree(node.right, left, right);
		return node;
	}
	
	int sum = 0;
	void printInBWSumRange(BST node, int r1, int r2) {
		if(node==null) {
			return ;
		}
		if(r1<node.data) {
			printInBWRange(node.left, r1, r2);
		}
		if(r1<=node.data && r2>=node.data) {
			sum+= node.data;
			//System.out.println(node.data);
		}
		if(r2>node.data) {
			printInBWRange(node.right, r1, r2);
		}
	}
	int minValue(BST node) {
		int minData = node.data;
		while(node.left!=null) {
			minData = node.left.data;
			node = node.left;
		}
		return minData;
	}
	int maxValue(BST node) {
		int maxData = node.data;
		while(node.right!=null) {
			maxData = node.right.data;
			node = node.right;
		}
		return maxData;
	}
	void inOrder(BST node) {
		if(node!=null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}
	int height(BST node) {
		if(node == null) {
			return 0;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		return Math.max(lh, rh) + 1;
	}
	boolean isBalanced(BST node) {
		if(node == null) {
			return true;
		}
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		boolean isLeftBalance = isBalanced(node.left);
		boolean isRightBalance = isBalanced(node.right);
		
		int bal  = Math.abs(leftHeight - rightHeight);
		if(bal<=1 && isLeftBalance && isRightBalance) {
			return true;
		}
		return false;
		
		
	}
	BST balanceBST(int inorderArr[], int low, int high) {
		if(low>high) {
			return null;
		}
		int mid =(low + high)/2;
		BST node = new BST(inorderArr[mid]);
		node.left = balanceBST(inorderArr,low,mid-1);
		node.right = balanceBST(inorderArr,mid+1,high);
		return node;
	}
	void balanceBST() {
		int inorderArr[] = {10,20,30,40,50,60,70,80,90};
		balanceBST(inorderArr,0,inorderArr.length-1);
	}
	// left --> true , left --> false (right)
	void removeNode(BST currentNode, BST parentNode, 
			boolean isLeft, int data) {
		
		
		
		// Right Traverse
		if(data>currentNode.data) {
			removeNode(currentNode.right,currentNode,false,data);
		}
		else
			// Left Traverse
		if(data<currentNode.data) {
			removeNode(currentNode.left,currentNode, true,data);
		}
		// When u found the node
		else {
			// Case -1 Left and right child are null (Leaf)
			if(currentNode.left==null && currentNode.right==null) {
				if(isLeft) {
					parentNode.left = null;
				}
				else {
					parentNode.right = null;
				}
			}
			// Case -2 Left is Null but right is not null
			if(currentNode.left==null && currentNode.right!=null) {
				if(isLeft) {
					parentNode.left = currentNode.right;
				}
				else {
					parentNode.right = currentNode.right;
				}
			}
			// Case-3 Left is Not Null but right is  null
			if(currentNode.left!=null && currentNode.right==null) {
				if(isLeft) {
					parentNode.left= currentNode.left;
				}
				else {
					parentNode.right = currentNode.left;
				}
			}
			// Case -4 left is not null && right is not null
			if(currentNode.left!=null && currentNode.right!=null) {
				int maxOfLeft = maxValue(currentNode.left);
				currentNode.data = maxOfLeft;
				removeNode(currentNode.left, currentNode,true,maxOfLeft);
			}
			
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
		bst.insert(bst.root, 10);
		bst.insert(bst.root, 20);
		bst.insert(bst.root, 18);
		bst.insert(bst.root, 30);
		bst.insert(bst.root, 7);
		bst.insert(bst.root, 3);
		bst.insert(bst.root, 9);
		System.out.println("INOrder Iterative ");
		bst.inOrderIterative();
		System.out.println("PreOrder Iterative");
		bst.preOrderIterative();
		System.out.println("PostOrder Iterative");
		bst.postOrderIterative();
		//bst.inOrder(bst.root);
		//System.out.println(bst.search(bst.root, 411));
		

	}

}
