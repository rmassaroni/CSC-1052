/**
 * StackUtil program that contains three utility methods for
 * working with stacks.
 * 
 * @author Robert Massaroni
 *
 */
public class StackUtil
{
	/**
	 * Reverses the contents of a Stack object in place.
	 * @param stack the Stack to reverse
	 */
	public static void reverse(Stack<String> stack)
	{
		Stack<String> s = new ArrayStack<String>();
		Stack<String> temp = new ArrayStack<String>();
		
		int size = stack.size();
		for(int i = 0; i < size; i++) {
			s.push(stack.pop());
		}
		for(int i = 0; i < size; i++) {
			temp.push(s.pop());
		}
		
		for(int i = 0; i < size; i++) {
			stack.push(temp.pop());
		}
	}
	
	/**
	 * Makes a copy of a Stack object, and not simply a reference.
	 * Any changes made later to the copy will not be made to the 
	 * original, and vice versa.
	 * @param stack the stack to copy
	 * @return a copy of the original stack
	 */
	public static Stack<String> copy(Stack<String> stack)
	{
		Stack<String> s = new ArrayStack<String>();
		Stack<String> s2 = new ArrayStack<String>();
		int size = stack.size();
		for(int i = 0; i < size; i++) {
			s.push(stack.pop());
			s2.push(s.peek());
		}
		for(int i = 0; i < size; i++) {
			stack.push(s2.pop());
		}
		reverse(s);
		return s;
	}
	
	/**
	 * Iteratively remove all adjacent doubles in the stack until
	 * no adjacent doubles remain. Some examples include:
	 * [a, b, c]             => [a, b, c]
	 * [a, b, b, c]          => [a, c]
	 * [a, a, b, b, c]       => [c]
	 * [a, b, b, a, c]       => [c]
	 * [a, b, c, c, b, a, d] => [d]
	 * @param stack the initial stack
	 * @return true if any doubles were removed
	 */
	public static boolean removeDoubles(Stack<String> stack)
	{

		Stack<String> original = copy(stack);
		Stack<String> noDoubles = new ArrayStack<String>();
		
		while(stack.size() > 0) {
			String potentialDouble = stack.pop();
			int counter = 0;
			Stack<String> copy = copy(original);
			while(copy.size() > 0) {
				if(copy.pop().equals(potentialDouble)) {
					counter++;
				}
			}
			if(counter == 1) {
				noDoubles.push(potentialDouble);
			}
		}
		
		while(noDoubles.size() > 0) {
			stack.push(noDoubles.pop());
		}
		
		if(original.size() > stack.size()) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * main method containing tests. Additional tests can be added
	 * but the existing tests should not be modified.
	 */
	public static void main(String[] args)
	{
		// Starting point
		ArrayStack<String> myStack = new ArrayStack<String>();
		myStack.push("one");
		myStack.push("two");
		myStack.push("three");
		myStack.push("four");
		myStack.push("four");
		myStack.push("three");
		myStack.push("five");
		System.out.println("Start expect: " + "[one, two, three, four, four, three, five]");
		System.out.println("Start actual: " + myStack);
		System.out.println();
		
		// Test reverse
		reverse(myStack);
		System.out.println("Rev expect: " + "[five, three, four, four, three, two, one]");
		System.out.println("Rev actual: " + myStack);
		System.out.println();
		
		// Test copy
		Stack<String> copyStack = copy(myStack);
		String popped = copyStack.pop(); // pop top from the copy
		System.out.println("Popped expect: " + "one");
		System.out.println("Popped actual: " + popped);
		// Make sure original is unchanged
		System.out.println("Orig expect: " + "[five, three, four, four, three, two, one]");
		System.out.println("Orig actual: " + myStack);
		// Verify the copy is correct
		System.out.println("Copy expect: " + "[five, three, four, four, three, two]");
		System.out.println("Copy actual: " + copyStack);
		System.out.println();
		
		// Test remove doubles
		removeDoubles(myStack);
		System.out.println("Remove doubles expect: " + "[five, two, one]");
		System.out.println("Remove doubles actual: " + myStack);
	}
}
