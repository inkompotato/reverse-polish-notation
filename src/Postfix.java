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
		ifx = ifx.trim().replaceAll("\\s", "");
		char[] expr = ifx.toCharArray();
		String result ="";
		Stack <Character> p = new Stack<>();
		for (int i = 0; i < expr.length; i++) {
			if (expr[i] >= 48 && expr[i] <= 57)
				result+=(Character.getNumericValue(expr[i]));
			if (expr[i] == '(')
				p.push(expr[i]);
			if (expr[i] == ')') {
				while (!p.peek().equals('(')) {
					result += p.peek();
					p.pop();
				}
				p.pop();
			}
			if (expr[i] == '*' || expr[i] == '-' || expr[i] == '+' || expr[i] == '/' || expr[i] == '^') {
				while (!p.isEmpty() && !(checkPrecedence(p.peek(), expr[i]) || (expr[i] == '^' && p.peek().equals('^')))) {
					result += p.peek();
					p.pop();
				}
				p.push(expr[i]);
			}
		}

		while (!p.isEmpty()){
			result+=p.peek();
			p.pop();
		}
		
		
		return result;
		
	}

	private boolean checkPrecedence(char top, char next) {
		return getPrec(top) < getPrec(next);
	}

	private int getPrec(char operator){
		switch (operator) {
			case '(' : return 0;
			case ')' : return 0;
			case '+' : return 1;
			case '-' : return 1;
			case '*' : return 2;
			case '/' : return 2;
			case '^' : return 3;
			default: return 0;
		}
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
