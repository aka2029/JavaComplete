//	NGE - Next Greatest Element

package lecturew19;

import java.util.Stack;

public class Demo3 {
	public static void main(String[] args) {
		int arr[] = {4,5,2,25};
		Stack<Integer> stack = new Stack<>();
		for(int currentElement : arr) {
			while(!stack.isEmpty() && currentElement>stack.peek()) {
				int topElement = stack.pop();
				System.out.println(topElement+" --> "+currentElement);
			}
			stack.push(currentElement);
			
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop()+" --> -1");
		}
	}
}
