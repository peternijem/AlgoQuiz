
import java.util.Stack;

//Java program to implement a stack that supports
//getMaximum() in O(1) time and O(1) extra space.

public class StackO1Max {

	// A user defined stack that supports getMin() in
	// addition to push() and pop()
	public static class MyStack {
		Stack<Integer> s;
		Integer maxEle;

		// Constructor
		MyStack() { 
			s = new Stack<Integer>(); 
		}

		// Prints minimum element of MyStack
		void getMax() {
			// Get the minimum number in the entire stack
			if (s.isEmpty()) {
				System.out.println("Stack is empty");
			}
			// variable maxEle stores the maximum element
			// in the stack.
			else {
				System.out.println("Maximum Element in the " +
						" stack is: " + maxEle);
			}
		}

		// prints top element of MyStack
		void peek() {
			if (s.isEmpty()) {
				System.out.println("Stack is empty ");
				return;
			}

			Integer t = s.peek(); // Top element.

			System.out.print("Top Most Element is: ");

			// If t > maxEle means maxEle stores
			// value of t.
			if (t > maxEle) {
				System.out.println(maxEle);
			} else {
				System.out.println(t);
			}
		}

		// Removes the top element from MyStack
		void pop() {
			if (s.isEmpty()) {
				System.out.println("Stack is empty");
				return;
			}

			System.out.print("Top Most Element Removed: ");
			Integer t = s.pop();

			// Maximum will change as the maximum element
			// of the stack is being removed.
			if (t > maxEle) {
				System.out.println(maxEle);
				maxEle = 2*maxEle - t;
			} else {
				System.out.println(t);
			}
		}

		// Insert new number into MyStack
		void push(Integer x) {
			if (s.isEmpty()) {
				maxEle = x;
				s.push(x);
				System.out.println("Number Inserted: " + x);
				return;
			}

			// If new number is less than original maxEle
			if (x > maxEle) {
				s.push(2*x - maxEle);
				maxEle = x;
			}

			else {
				s.push(x);
			}
			System.out.println("Number Inserted: " + x);
		}
	}

	public static void main(String[] args) {
		StackO1Max.MyStack s = new StackO1Max.MyStack();
		s.push(3);
		s.push(5);
		s.getMax();
		s.push(2);
		s.push(1);
		s.getMax();
		s.push(7);
		s.getMax();
		s.pop();
		s.getMax();
		s.pop();
		s.peek();
	}

}

