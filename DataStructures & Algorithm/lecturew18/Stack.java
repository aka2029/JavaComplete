package lecturew18;

public class Stack {
	private int array[];
	private int top;
	private final int DEFAULT_CAPACITY;

	Stack() {
		DEFAULT_CAPACITY = 10;
		top = -1;
		array = new int[DEFAULT_CAPACITY];
	}

	Stack(int capacity) {
		DEFAULT_CAPACITY = capacity;
		top = -1;
		array = new int[DEFAULT_CAPACITY];
	}

	private int getSize() {
		return top + 1;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	public void push(int data) {
		if (getSize() == array.length) {
			throw new RuntimeException("Stack is Full");
		}
		top++;
		array[top] = data;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		int value = array[top];
		array[top] = 0;
		top--;
		return value;

	}

	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return array[top];
	}

	public void display() {
		System.out.println("**********************");
		for (int i = top; i >= 0; i--) {
			System.out.println(array[i]);
		}
	}
}
