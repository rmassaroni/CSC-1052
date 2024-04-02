/**
 * Automated Tester of a LinkedDequeue implementation.
 */
public class AutomatedDequeueTester
{
	public static void main(String[] args)
	{
		// Reusable element variable
		String elem;

		// Create an empty dequeue
		DequeInterface<String> dequeue = new LinkedDeque<String>();
		System.out.println("Expect: Initial dequeue: " + "[]");
		System.out.println("Actual: Initial dequeue: " + dequeue);

		// Test enqueueFront
		dequeue.enqueueFront("one");
		dequeue.enqueueFront("two");
		dequeue.enqueueFront("three");
		System.out.println("Expect: enqueueFront: " + "[one, two, three]");
		System.out.println("Actual: enqueueFront: " + dequeue);
		
		// Test enqueueRear
		dequeue.enqueueRear("FOUR");
		dequeue.enqueueRear("FIVE");
		dequeue.enqueueRear("SIX");
		System.out.println("Expect: enqueueRear: " + "[SIX, FIVE, FOUR, one, two, three]");
		System.out.println("Actual: enqueueRear: " + dequeue);
		
		// Test dequeueFront
		elem = dequeue.dequeueFront();
		System.out.println("Expect: dequeueFront: removed " + "three" + " " + "[SIX, FIVE, FOUR, one, two]");
		System.out.println("Actual: dequeueFront: removed " + elem + " " + dequeue);

		// Test dequeueRear
		elem = dequeue.dequeueRear();
		System.out.println("Expect: dequeueRear: removed " + "SIX" + " " + "[FIVE, FOUR, one, two]");
		System.out.println("Actual: dequeueRear: removed " + elem + " " + dequeue);
		
		// Test sequence
		dequeue.enqueueFront("A");
		elem = dequeue.dequeueRear();
		dequeue.enqueueRear("B");
		dequeue.enqueueFront("C");
		dequeue.enqueueRear("D");
		elem = dequeue.dequeueFront();
		elem = dequeue.dequeueRear();
		dequeue.enqueueFront("E");
		System.out.println("Expect: sequence: " + "[B, FOUR, one, two, A, E]");
		System.out.println("Actual: sequence: " + dequeue);

		// Test size
		System.out.println("Expect: size: " + "6");
		System.out.println("Actual: size: " + dequeue.size());

		// Test isFull
		System.out.println("Expect: isFull: " + "false");
		System.out.println("Actual: isFull: " + dequeue.isFull());
		
		// Test isEmpty
		System.out.println("Expect: isEmpty: " + "false");
		System.out.println("Actual: isEmpty: " + dequeue.isEmpty());
		while (!dequeue.isEmpty())
		{
			dequeue.dequeueFront();
		}
		System.out.println("Expect: isEmpty: " + "true");
		System.out.println("Actual: isEmpty: " + dequeue.isEmpty());
	}
}