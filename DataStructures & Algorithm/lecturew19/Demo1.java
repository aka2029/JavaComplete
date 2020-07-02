//	InfixtoPostFix

package lecturew19;

public class Demo1 {

	static int isPrecedence(char single) {
		switch (single) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		java.util.Stack<Character> operatorStack = new java.util.Stack<>();
		String expression = "a+b*c-d";
		for (int i = 0; i < expression.length(); i++) {
			// System.out.println(single);
			char single = expression.charAt(i);
			if (Character.isAlphabetic(single) || Character.isDigit(single)) {
				System.out.print(single);
			} else {
				if (operatorStack.isEmpty()) {
					operatorStack.push(single);
				} else {
					char stackTopElement = operatorStack.peek();
					if (isPrecedence(single) > isPrecedence(stackTopElement)) {
						operatorStack.push(single);
					} else {
						stackTopElement = operatorStack.pop();
						while (!operatorStack.isEmpty() && (isPrecedence(stackTopElement) >= isPrecedence(single))) {
							System.out.print(stackTopElement);
							stackTopElement = operatorStack.pop();
						}
						System.out.print(stackTopElement);
						operatorStack.push(single);
					}
				}
			}
		}
		while (!operatorStack.isEmpty()) {
			System.out.print(operatorStack.pop());
		}

	}

}
