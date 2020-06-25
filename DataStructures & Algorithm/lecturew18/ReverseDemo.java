package lecturew18;

public class ReverseDemo {
	static void reverseStack(Stack org, Stack temp, int index) {
		if (org.isEmpty()) {
			return;
		}
		int topValue = org.pop();
		reverseStack(org, temp, index + 1);
		temp.push(topValue);
		if (index == 0) {
			while (!temp.isEmpty()) {
				org.push(temp.pop());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lecturew18.Stack stack = new lecturew18.Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.display();
		System.out.println("Reverse Stack");
		reverseStack(stack, new Stack(), 0);
	}
}
