import java.util.Stack;
// Java program to check if all the parenthesis expression is valid.
// Supported parenthesis: "()", "[]", "{}", "||"

public class CheckParenthesis {

	public static boolean isValid(String str) {
		if (str.isEmpty()) {
			return true;
		}

		Stack<Character> stack = new Stack<Character>();
		boolean toPop = false;
		for (int i = 0; i < str.length(); i++) {
			char current = str.charAt(i);
			if (current == '{' || current == '(' || current == '[') {
				stack.push(current);
			}
			
			if(current == '|') {
				if(!toPop) {
					stack.push(current);
					toPop = true;
					continue;
				}
			}

			if (current == '}' || current == ')' || current == ']' ) {

				if (stack.isEmpty()) {
					return false;
				}
				char last = stack.peek();
				if (current == '}' && last == '{' || 
						current == ')' && last == '(' ||
						current == ']' && last == '[') {

					stack.pop();
				} else {
					return false;
				}
			}
			
			if(current == '|') {
				if(toPop) {
					if (stack.isEmpty()) {
						return false;
					}
					char last = stack.peek();
					if(last == '|' && current == last) {
						stack.pop();
						toPop = false;
					} else {
						return false;
					}
				}
			}
		}

		return stack.isEmpty();
	}

	public static void main(String arg[]){
		String str = "((()))";
		boolean res = CheckParenthesis.isValid(str); //true
		System.out.println(String.format("'%s' is %s expression", str, res ? "valid" : "invalid"));

		str = "((())))";
		res = CheckParenthesis.isValid(str); //false
		System.out.println(String.format("'%s' is %s expression", str, res ? "valid" : "invalid"));

		str = "[((({})))]";
		res = CheckParenthesis.isValid(str); //true
		System.out.println(String.format("'%s' is %s expression", str, res ? "valid" : "invalid"));

		str = "[((({})))";
		res = CheckParenthesis.isValid(str); //false
		System.out.println(String.format("'%s' is %s expression", str, res ? "valid" : "invalid"));

		str = "|([])|";
		res = CheckParenthesis.isValid(str); //true
		System.out.println(String.format("'%s' is %s expression", str, res ? "valid" : "invalid"));

		str = "||((({})))";
		res = CheckParenthesis.isValid(str); //true
		System.out.println(String.format("'%s' is %s expression", str, res ? "valid" : "invalid"));

	}
}
