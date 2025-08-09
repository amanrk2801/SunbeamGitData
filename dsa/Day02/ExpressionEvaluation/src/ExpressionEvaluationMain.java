import java.util.Stack;

public class ExpressionEvaluationMain {
	
	public static int calculate(int op1, char opr, int op2) {
		switch(opr) {
		case '+':	return op1 + op2;
		case '-':	return op1 - op2;
		case '*':	return op1 * op2;
		case '/':	return op1 / op2;
		case '%':	return op1 % op2;
		case '$':	return (int)Math.pow(op1, op2);
		}
		return 0;
	}
	
	public static int postfixEvaluation(String postfix) {
		//0. create stack to push operands
		Stack<Integer> st = new Stack<Integer>();
		//1. traverse expression from left to right
		for(int i = 0 ; i < postfix.length() ; i++) {
			//2. extract element from string (ith index)
			char ele = postfix.charAt(i);
			//3. if element is operand then push it on stack
			if(Character.isDigit(ele))
				st.push(ele - '0');		// to convert element into numeric form
			//4. if element is operator, pop two elements from stack
			else {
				int op2 = st.pop();	// first popped will become second operand
				int op1 = st.pop();	// second popped will become first operand
				//5. calculate result of op1 and op2
				int res = calculate(op1, ele, op2);
				//6. push result on stack
				st.push(res);
			}
		}
		//7. return result of expression
		return st.pop();
	}
	
	public static int prefixEvaluation(String postfix) {
		//0. create stack to push operands
		Stack<Integer> st = new Stack<Integer>();
		//1. traverse expression from right to left
		for(int i = postfix.length()-1 ; i >= 0 ; i--) {
			//2. extract element from string (ith index)
			char ele = postfix.charAt(i);
			//3. if element is operand then push it on stack
			if(Character.isDigit(ele))
				st.push(ele - '0');		// to convert element into numeric form
			//4. if element is operator, pop two elements from stack
			else {
				int op1 = st.pop();	// first popped will become second operand
				int op2 = st.pop();	// second popped will become first operand
				//5. calculate result of op1 and op2
				int res = calculate(op1, ele, op2);
				//6. push result on stack
				st.push(res);
			}
		}
		//7. return result of expression
		return st.pop();
	}

	public static void main(String[] args) {
		String postfix = "456*3/+9+7-";
		String prefix = "-++4/*56397";
		
		int result = postfixEvaluation(postfix);
		System.out.println("Postfix expression : " + postfix);
		System.out.println("Result : " + result);
		
		result = prefixEvaluation(prefix);
		System.out.println("Prefix expression : " + prefix);
		System.out.println("Result : " + result);
		

	}

}
