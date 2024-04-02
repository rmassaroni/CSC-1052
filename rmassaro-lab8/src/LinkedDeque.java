import java.util.ArrayList;
import java.util.List;

/**
 * Linked-List based Dequeue.
 * 
 * @author Robert Massaroni
 *
 */
public class LinkedDeque<T> implements DequeInterface<T>
{
	private DLLNode<T> front;
	private DLLNode<T> rear;
	private int numElements = 0;

	LinkedDeque()
	{
		// implement me
		front = null;
		rear = null;
		numElements = 0;
	}

	/**
	 * Adds an element to the front of the queue.
	 * 
	 * @param element
	 * @throws QueueOverflowException if queue is full
	 * Note: this is a linked dequeue so your queue can never
	 * actually overflow and throw a QueueOverflowException
	 */
	@Override
	public void enqueueFront(T element) throws QueueOverflowException
	{
		// implement me
		DLLNode<T> temp = new DLLNode<T>(element);
		
		if(isEmpty()) {
			rear = temp;
		}
		else {
			temp.setBack(front);
			front.setForward(temp);
		}
		
		front = temp;
		numElements++;
	}

	/**
	 * Adds element to the rear of the queue.
	 * 
	 * @param element
	 * @throws QueueOverflowException if queue is full
	 * Note: this is a linked dequeue so your queue can never
	 * actually overflow and throw a QueueOverflowException
	 */
	@Override
	public void enqueueRear(T element) throws QueueOverflowException
	{
		// implement me
		DLLNode<T> temp = new DLLNode<T>(element);
		
		if(isEmpty()) {
			front = temp;
		}
		else {
			temp.setForward(rear);
			rear.setBack(temp);
		}
		
		rear = temp;
		numElements++;
	}

	/**
	 * Removes an element from the front of the queue.
	 * @return The element that was removed
	 */
	@Override
	public T dequeueFront() throws QueueUnderflowException
	{
		// implement me
        if(isEmpty()) {
        	throw new QueueUnderflowException("");
        }
        T element = front.getElement();
        numElements--;
        front = front.getBack();

		return element;
	}

	/**
	 * Removes an element from the rear of the queue.
	 * @return The element that was removed
	 */
	@Override
	public T dequeueRear() throws QueueUnderflowException
	{
		// implement me
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		T element = rear.getElement();
		rear = rear.getForward();
		numElements--;
		
		return element;
	}

	/**
	 * Reports whether or not the queue is full.
	 * Note: because this is a linked dequeue, it can never fill up.
	 * @return true if the queue is full, false otherwise
	 */
	@Override
	public boolean isFull()
	{
		// implement me
		return false;
	}

	/**
	 * Reports whether or not the queue is empty.
	 * @return true if the queue is empty, false otherwise
	 */
	@Override
	public boolean isEmpty()
	{
		// implement me
		return numElements == 0;
	}

	/**
	 * Returns a count of the number of elements in the queue.
	 * @return Number of elements in queue
	 */
	@Override
	public int size()
	{
		// implement me
		return numElements;
	}
	
	/**
	 * Returns a string representation of the queue elements.
	 * @return String representation of the queue
	 */
	@Override
	public String toString()
	{
		// This method is already implemented.
		// No changes are needed.
		List<T> elements = new ArrayList<T>();
		while (!isEmpty())
		{
			T element = dequeueRear();
			elements.add(element);
		}
		for (T element : elements)
		{
			enqueueFront(element);
		}
		return elements.toString();
	}
}
