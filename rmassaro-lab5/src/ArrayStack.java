import java.util.Arrays;

/**
 * An array implementation of a stack, operating on a generic type T.
 * The bottom element of the stack is stored at index 0.
 *
 * @author Rephactor Java
 * @version 1.0
 */
public class ArrayStack<T> implements Stack<T>
{
    private final static int DEFAULT_CAPACITY = 20;

    private int top;  
    private T[] stack;
  
    /**
     * Sets up an empty stack using the default capacity.
     */
    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Sets up an empty stack using the specified capacity.
     * @param initialCapacity the initial size of the array 
     */
    public ArrayStack(int initialCapacity)
    {
        top = -1;
        stack = (T[])(new Object[initialCapacity]);
    }

    /**
     * Adds the specified element to the top of the stack. The array
     * capacity is expanded if necessary.
     * @param element generic element to be pushed onto the stack
     */
    public void push(T element)
    {
        if (size() == stack.length) 
            stack = Arrays.copyOf(stack, stack.length * 2);
		
        top++;
        stack[top] = element;
    }

    /**
     * Removes and returns the element at the top of the stack. 
     * @return element removed from top of stack
     * @throws EmptyStackException if the stack is empty 
     */
    public T pop() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException("An attempt was made to pop an empty stack.");

        T result = stack[top];
        stack[top] = null; 
        top--;

        return result;
    }
   
    /**
     * Returns a reference to the element at the top of the stack, without
     * removing it from the stack.  
     * @return element on top of stack
     * @throws EmptyStackException if the stack is empty
     */
    public T peek() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException("An attempt was made to access the top of an empty stack.");

        return stack[top];
    }

    /**
     * Returns true if the stack is empty and false otherwise. 
     * @return true if the stack is empty
     */
    public boolean isEmpty()
    {
        return top == -1;
    }
 
    /**
     * Gets the number of elements in the stack.
     * @return the number of elements in the stack
     */
    public int size()
    {
        return top + 1;
    }

    /**
     * Gets a string representation of the stack. Modified from
     * original version in Rephactor topic.
     * @return a string representation of the stack
     */
    public String toString()
    {
        String str = "[";
        if (!isEmpty())
        {
        	str += stack[0];
        	if (stack.length > 1)
        	{
        		for (int i = 1; i < size(); i++)
        			str += ", " + stack[i];
        	}
        }
        str += "]";
        return str;
    }
}
