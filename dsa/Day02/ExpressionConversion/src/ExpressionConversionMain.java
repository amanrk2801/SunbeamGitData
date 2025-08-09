import java.util.Stack;

public class ExpressionConversionMain {
	
	public static int priority(char opr) {
		switch(opr) {
		case '$':	return 10;
		case '*':	return 9;
		case '/':	return 9;
		case '%':	return 9;
		case '+':	return 8;
		case '-':	return 8;
		}
		return 0;
	}
	
	public static String infixToPostfix(String infix) {
		//0. create stack to push operators
		Stack<Character> st = new Stack<Character>();
		//0. create string for postfix expression
		StringBuilder postfix = new StringBuilder();
		//1. traverse expression from left to right
		for(int i = 0 ; i < infix.length() ; i++) {
			//2. extract character of ith index
			char ele = infix.charAt(i);
			//3. if element is operand, append it to postfix
			if(Character.isDigit(ele))
				postfix.append(ele);
			//4. if element is '(', then push
			else if(ele == '(')
				st.push(ele);
			//5. if element is ')', pop and append
			else if(ele == ')') {
				while(st.peek() != '(')
					postfix.append(st.pop());
				st.pop();		// to discard '(' and ')'
			}
			//6. if element is operator
			else {
				while( !st.isEmpty() && priority(st.peek()) >= priority(ele))
					postfix.append(st.pop());
				// push current element
				st.push(ele);
			}
		}
		//7. pop remaining elements and append
		while(!st.isEmpty())
			postfix.append(st.pop());
		//8. return postfix expression
		return postfix.toString();
	}

	public static void main(String[] args) {
		String infix = "1$9+3*4-(6+8/2)+7";
		
		System.out.println("Infix : " + infix);
		
		String postfix = infixToPostfix(infix);
		System.out.println("Postfix : " + postfix);

	}

}
