/**
 * Defines the interface to a stack.
 *
 * @author Rephactor Java
 * @version 1.0
 */
public interface Stack<T>
{
    /**  
     * Adds the specified element to the top of the stack. 
     * @param element element to be pushed onto the stack
     */
    public void push(T element);
  
    /**  
     * Removes and returns the top element from the stack. 
     * @return the element removed from the stack
     */
    public T pop();

    /**  
     * Returns the top element of the stack without removing it. 
     * @return the element on top of the stack
     */
    public T peek();
  
    /**  
     * Returns true if this stack contains no elements and false otherwise. 
     * @return true if the stack is empty
     */
    public boolean isEmpty();

    /** 
     * Gets the number of elements in the stack. 
     * @return the number of elements in the stack
     */
    public int size();

    /**  
     * Gets a string representation of the stack. 
     * @return a string representation of the stack
     */
    public String toString();
}
