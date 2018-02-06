package LAB_04;

import java.util.LinkedList;

public class PostfixNotation {

	private LinkedList<String> list = new LinkedList<>();
	private String expression;

	public PostfixNotation() {
		
	}

	public String fix(String str) {
		this.expression = str.replace(" ", "");
		String toReturn = "";
		Boolean write = false;
		Boolean inParenthesis = false;
		for (int i = 0; i < expression.length(); i++) {

			Character curr = expression.charAt(i);
			if (Character.isDigit(curr) && !write)
				toReturn += curr;
			else if (Character.isDigit(curr) && write) {
				toReturn += curr + list.pop();
				write = false;
			} else if (curr.equals('(')) {
				inParenthesis = true;
				list.push("(");
			}
			else if (curr.equals(')')) {
				while (list.pop().equals('('))
					list.pop();
				inParenthesis = false;
			} else {
				list.push(curr + "");
				write = true;
			}
		}
		return toReturn;
	}
	
	public static void main(String[] args) {
		
		PostfixNotation calculator = new PostfixNotation();
		
		System.out.println(calculator.fix("5 + 2 / 4 * 8"));
	}

}
