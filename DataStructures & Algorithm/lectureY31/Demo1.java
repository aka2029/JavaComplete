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
