//	SplitAlternative

package lecturex24;

class Node<T> {
	T data;
	Node<T> next;

	// Node prev;
	Node(T data) {
		this.data = data;
		// this.next = null;
	}

}

class LinkedListOperations<T> {
	// this part from Previous lecture or do it yourself
	Node<T> start;  // head
	Node<T> tail;
	
	void addInLast(Node<T> node) {

		if (start == null) {
			start = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		/*
		 * else { Node<T> temp = start; while(temp.next!=null) { temp = temp.next; }
		 * temp.next = node; }
		 */

	}
}

public class Demo1 {
	
	//Approach-1
	static Node<Integer> merge(Node<Integer> start1, Node<Integer> start2) {
		Node<Integer> third = null;
		if (start1 == null) {
			return start2;
		}
		if (start2 == null) {
			return start1;
		}
		if (start1.data <= start2.data) {
			third = start1;
			start1 = start1.next;
		} else {
			third = start2;
			start2 = start2.next;
		}
		Node<Integer> temp = third;
		while (start1 != null && start2 != null) {
			if (start1.data <= start2.data) {
				temp.next = start1;
				temp = temp.next;
				start1 = start1.next;

			} else {
				temp.next = start2;
				temp = temp.next;
				start2 = start2.next;
			}
		}
		temp.next = start1 != null ? start1 : start2;
		return third;
	}

	//Approach-2
	static Node<Integer> split(Node<Integer> start) {
		Node<Integer> start2 = start;
		Node<Integer> temp, temp2;
		if (start == null) {
			System.out.println("LL is Empty");
			return start;
		}
		if (start.next == null) {
			return start;
		}
		temp = start;
		start2 = temp2 = start.next;
		while (temp.next != null && temp2.next != null) {
			temp.next = temp.next.next;
			temp2.next = temp2.next.next;
			temp = temp.next;

			temp2 = temp2.next;
		}
		if (temp.next != null)
			temp.next = null;

//		while((temp!=null && temp.next!=null) 
//				&& temp.next.next!=null) {
//			temp.next = temp.next.next;
//			temp2.next = temp2.next.next;
//			temp = temp.next;
//			
//				temp2 = temp2.next;
//				
//			if(temp2.next!=null) {
//			temp2 = temp2.next;
//			}
//		}

		// temp2.next = null;
		return start2;
	}
	
	static void print(Node<Integer> start) {
		Node<Integer> temp = start;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public static void main(String[] args) {

		LinkedListOperations<Integer> opr = new LinkedListOperations<>();
		for (int i = 1; i <= 5; i++) {
			Node<Integer> node = new Node<>(i);
			opr.addInLast(node);
		}
		Node<Integer> start2 = split(opr.start);
		System.out.println("After Split....");
		print(opr.start);
		print(start2);

	}

}
