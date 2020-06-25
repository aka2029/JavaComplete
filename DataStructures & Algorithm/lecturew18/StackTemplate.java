package lecturew18;

import java.util.ArrayList;

class TStack<T> {
	// private T array[];
	private ArrayList<T> array;
	private int top;
	private final int DEFAULT_CAPACITY;
	private double loadFactor = 0.75;

	TStack() {
		DEFAULT_CAPACITY = 10;
		top = -1;
		// array = new T [DEFAULT_CAPACITY];
		array = new ArrayList<>();
	}

	TStack(int capacity, double loadFactor) {
		this.loadFactor = loadFactor;
		DEFAULT_CAPACITY = capacity;
		top = -1;
		array = new ArrayList<>(DEFAULT_CAPACITY);
	}

	private int getSize() {
		return top + 1;
	}

	private boolean isEmpty() {
		return getSize() == 0;
	}

	public void push(T data) {
//		if(getSize()==array.size()) {
//			int incrementSize = (int)(array.length * loadFactor);
//			int temp[] = new int[array.length + incrementSize];
//			for(int i =0; i<array.length; i++) {
//				temp [i] = array[i];
//			}
//			array = temp;
//			//throw new RuntimeException("Stack is Full");
//		}
		top++;
		array.add(top, data);
		// array[top] = data;
	}

	public T pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		T value = array.remove(top);
		top--;
//		int value = array[top];
//		array[top] = 0;
//		top--;
		return value;

	}

	public T peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return array.get(top);
		// return array[top];
	}

	public void display() {
		System.out.println("**********************");
		for (int i = top; i >= 0; i--) {
			System.out.println(array.get(i));
			// System.out.println(array[i]);
		}
	}
}

public class StackTemplate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TStack<String> stack = new TStack<>();
		stack.push("amit");
		stack.push("ram");
		stack.push("shyam");
		stack.display();
		System.out.println("Top " + stack.peek());
		stack.pop();
		stack.pop();
		stack.display();
	}

}
