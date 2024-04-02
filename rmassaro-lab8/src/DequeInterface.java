/**
 * Double-ended Queue or Dequeue interface storing
 * element of generic type T.
 */
public interface DequeInterface<T> {
	/**
	 * Adds an element to the front of the queue.
	 * @param element
	 * @throws QueueOverflowException if queue is full
	 * Note: we are implementing a linked deque so your queue will never throw 
	 * an QueueOverflowException
	 */
	void enqueueFront(T element) throws QueueOverflowException; 
    
    /**
     * Adds element to the rear of the queue.
     * @param element
     * @throws QueueOverflowException if queue is full
	 * Note: we are implementing a linked deque so your queue will never throw 
	 * an QueueOverflowException
     */
	void enqueueRear(T element) throws QueueOverflowException;
   
   /**
    * Removes front element from the queue and returns it.
    * @return front element
    * @throws QueueUnderflowException if the queue is empty
    */
   T dequeueFront() throws QueueUnderflowException;
  
   /**
    * Removes rear element from the queue and returns it.
    * @return rear element
    * @throws QueueUnderflowException
    */
   T dequeueRear() throws QueueUnderflowException;
   
   /**
    * Returns true if this queue is full; otherwise, returns false. 
    * @return true if full, false otherwise
    */
   boolean isFull();
   
   /**
    * Returns true if this queue is empty; otherwise, returns false.
    * @return true if empty, false otherwise
    */
   boolean isEmpty();
   
   /**
    * Returns the number of elements in this queue. 
    * @return number of elements
    */
   int size();
}