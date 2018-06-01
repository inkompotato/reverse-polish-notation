
public class postfix_test {

	public static void main(String[] args) {
		Postfix p = new Postfix();
		String pfx = ("1 2 + 3 4 / + 5 + 6 7 8 + * +");
		System.out.println(p.evaluate(pfx));

		System.out.println(p.infixToPostfix("1 + 2 + 3 / 4 + 5 + 6 * ( 7 + 8 )"));

	}

}
