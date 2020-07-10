package lecturex23;

import java.util.HashMap;
import java.util.Scanner;

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
	Node<T> start; // head
	Node<T> tail;

	void kthNode(int k) {
		Node<T> fast = start;
		Node<T> slow = start;
		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		System.out.println(slow.data);
	}

	void reverse() {
		Node<T> current = start;
		Node<T> prev = null;
		Node<T> next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;

		}
		start = prev;

	}

	void nthNodeRemove(int n) {
		Node<T> fast = start;
		Node<T> slow = start;
		for (int i = 1; i <= n + 1; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		// System.out.println(slow.data);
	}

	void detectLoopInLL1() {
		Node<T> temp = null;
		temp = start;
		HashMap<Node<T>, Boolean> map = new HashMap<>();
		while (temp != null) {
			if (map.get(temp) == null) {
				map.put(temp, true);
			} else {
				System.out.println("Loop Detected ");
				return;
			}
			temp = temp.next;
		}
		System.out.println("No Loop in LL");
	}

	void detectLoopInLL() {
		Node<T> fast = start;
		Node<T> slow = start;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				System.out.println("Loop in LL ");
				return;
			}
		}
		System.out.println("No Loop in LL");
	}

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

	void addAtAnyPosition(int position, Node<T> node) {
		if (position == 0 && start == null) {
			start = tail = node;
			return;
		}
		if (position == 0) {
			node.next = start;
			start = node;
		} else {
			int i = 1;
			Node<T> temp = start;
			while (i < position) {
				temp = temp.next;
				i++;
			}
			node.next = temp.next;
			temp.next = node;
		}
	}

	void addInFirst(Node<T> node) {
		if (start == null) {
			start = tail = node;
		} else {

			node.next = start;
			start = node;

		}
	}

	void print() {
		Node<T> temp = start;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}

public class Demo1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Data Type of LinkedList");
		System.out.println("1. Integer");
		System.out.println("2. String");
		int choice = scanner.nextInt();
		if (choice == 1) {
			LinkedListOperations<Integer> opr = new LinkedListOperations<>();
			while (true) {
				System.out.println("1. For Add in Last");

				System.out.println("2. For Print");
				System.out.println("3. For Add at First");
				System.out.println("4. Add at Any Position");
				int ch = scanner.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter the data to add");
					int data = scanner.nextInt();
					Node<Integer> node = new Node<>(data);
					opr.addInLast(node);
					break;
				case 2:
					opr.print();
					break;
				case 3:
					System.out.println("Enter the data to add");
					data = scanner.nextInt();
					node = new Node<>(data);
					opr.addInFirst(node);
					break;
				case 4:
					System.out.println("Enter the Position");
					int pos = scanner.nextInt();
					System.out.println("Enter the data to add");
					data = scanner.nextInt();
					node = new Node<>(data);
					opr.addAtAnyPosition(pos, node);
				}

			}
		} else if (choice == 2) {
			LinkedListOperations<String> opr = new LinkedListOperations<>();
		}

		// TODO Auto-generated method stub
		/*
		 * Object t = 100; Object r = "Hello"; t = new Integer(100); t = new
		 * String("Hello"); t = new Double(90.20); ArrayList<Integer> l = new
		 * ArrayList<Integer>(); l.add(10); l.add(20); //Object g= l.get(0); int g =
		 * l.get(0); System.out.println(l.get(0) + l.get(1)); Node<Integer> node = new
		 * Node<>(10); Node<Integer> node2 = new Node<>(20); node.next = node2;
		 */

	}

}
