import java.util.Stack;


public class Postfix {

	private Stack s = new Stack();

	public int evaluate(String pfx) {
		pfx = pfx.trim().replaceAll("\\s", "");
		char[] expr = pfx.toCharArray();
		for (int i = 0; i < expr.length; i++) {
			if (expr[i] >= 48 && expr[i] <= 57)
				s.push(Character.getNumericValue(expr[i]));
			if (expr[i] == '*')
				multiply();
			if (expr[i] == '-')
				substract();
			if (expr[i] == '+')
				add();
			if (expr[i] == '/')
				divide();
			if (expr[i] == '^')
				power();
		}

		return (int) s.peek();
	}
	
	public String infixToPostfix (String ifx){
		int result;
		
		
		
		
		
		return ifx;
		
	}

	private void power() {
		int op2 = (int) s.peek();
		s.pop();
		int op1 = (int) s.peek();
		s.pop();
		int result = (int) Math.pow(op1, op2);
		s.push(result);
	}

	private void divide() {
		int op2 = (int) s.peek();
		s.pop();
		int op1 = (int) s.peek();
		s.pop();
		int result = op1 / op2;
		s.push(result);
	}

	private void add() {
		int op2 = (int) s.peek();
		s.pop();
		int op1 = (int) s.peek();
		s.pop();
		int result = op1 + op2;
		s.push(result);
	}

	private void substract() {
		int op2 = (int) s.peek();
		s.pop();
		int op1 = (int) s.peek();
		s.pop();
		int result = op1 - op2;
		s.push(result);
	}

	private void multiply() {
		int op2 = (int) s.peek();
		s.pop();
		int op1 = (int) s.peek();
		s.pop();
		int result = op1 * op2;
		s.push(result);
	}
}
