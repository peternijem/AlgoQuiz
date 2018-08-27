/* A Java program to evaluate a given expression where tokens are separated.
by space.
Test Cases:
"10 2 + 6 *" -> 72
"100 2 * 12 +" -> 212
"1 2 * 3 4 5 + * +" -> 29
 */
import java.util.Stack;

public class EvaluateStringExp2 {


	public static int evaluate(String expression) {
		
		if(expression == null || expression.isEmpty()) {
			return -1;
		}
	
		char[] tokens = expression.toCharArray();

		// Stack for numbers: 'values'
		Stack<Integer> values = new Stack<Integer>();

		for (int i = 0; i < tokens.length; i++) {
			// Current token is a whitespace, skip it
			if (tokens[i] == ' ') {
				continue;
			}

			// Current token is a number, push it to stack for numbers
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();
				// There may be more than one digits in number
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);

				values.push(Integer.parseInt(sbuf.toString()));
			}

			// Current token is an operator.
			else if (tokens[i] == '+' || tokens[i] == '-' ||
					tokens[i] == '*' || tokens[i] == '/') {

				if(values.size() < 2) { //make sure that the expression is valid
					return -1;
				}
				values.push(applyOp(tokens[i], values.pop(), values.pop()));
			}
			
		}

		// Top of 'values' contains result, return it
		return values.pop();
	}

	// A utility method to apply an operator 'op' on operands 'a' 
	// and 'b'. Return the result.
	public static int applyOp(char op, int b, int a) {
		switch (op)
		{
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new
				UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return -1;//make sure that the expression is valid
	}

	// Driver method to test above methods
	public static void main(String[] args) {
		System.out.println(EvaluateStringExp2.evaluate("10 2 + 6 *")); // 72
		System.out.println(EvaluateStringExp2.evaluate("100 2 * 12 +")); // 212
		System.out.println(EvaluateStringExp2.evaluate("1 2 * 3 4 5 + * +"));// 29
	}
}
