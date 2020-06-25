package lecturew18;

class DStack {
	private int array[];
	private int top;
	private final int DEFAULT_CAPACITY;
	private double loadFactor = 0.75;

	DStack() {
		DEFAULT_CAPACITY = 10;
		top = -1;
		array = new int[DEFAULT_CAPACITY];
	}

	DStack(int capacity, double loadFactor) {
		this.loadFactor = loadFactor;
		DEFAULT_CAPACITY = capacity;
		top = -1;
		array = new int[DEFAULT_CAPACITY];
	}

	private int getSize() {
		return top + 1;
	}

	private boolean isEmpty() {
		return getSize() == 0;
	}

	public void push(int data) {
		if (getSize() == array.length) {
			int incrementSize = (int) (array.length * loadFactor);
			int temp[] = new int[array.length + incrementSize];
			for (int i = 0; i < array.length; i++) {
				temp[i] = array[i];
			}
			array = temp;
			// throw new RuntimeException("Stack is Full");
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

public class DynamicStack {
	public static void main(String[] args) {
		DStack stack = new DStack(5, 0.25);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.display();
		System.out.println("Top " + stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.display();

	}
}
