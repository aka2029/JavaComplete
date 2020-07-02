//	PostFixToInfix

package lecturew19;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "abc*+d-";
		java.util.Stack<String> stack = new java.util.Stack<>();
		for(int i = 0; i<expression.length(); i++) {
			char single = expression.charAt(i);
			if(Character.isAlphabetic(single) 
					|| Character.isDigit(single)) {
				stack.push(String.valueOf(single));
			}
			else {
				if(!stack.isEmpty()) {
					String second= stack.pop();
					String first = stack.pop();
					String exp  = first + single + second;
					stack.push(exp);
				}
			}
			
		}
		if(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

}
