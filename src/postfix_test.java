
public class postfix_test {

	public static void main(String[] args) {
		Postfix p = new Postfix();
		String pfx = ("1444 22 + 34 45 / + 5 + 643 7 458 + * +");
		System.out.println(p.evaluate2(pfx));

		System.out.println(p.infixToPostfix("12 + 256 + 32 / 41 + 5 + 666 * ( 7 + 81 )"));
		System.out.println(p.evaluate2(p.infixToPostfix("12 + 256 + 32 / 41 + 5 + 666 * ( 7 + 81 )")));

		p.input();

	}

}
