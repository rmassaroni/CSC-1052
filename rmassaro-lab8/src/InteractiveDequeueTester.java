
/**
 * Interactive tool for testing LinkedDequeue implementation.
 */
import java.util.Scanner;

public class InteractiveDequeueTester
{
	public static void main(String[] args)
	{
		DequeInterface<String> queue = new LinkedDeque<String>();
		Scanner scan = new Scanner(System.in);

		int operation; // indicates user's choice of operation

		String enqueueString = "", dequeueString = ""; // used by operations

		// Handle test cases
		boolean keepGoing = true;

		while (keepGoing)
		{
			System.out.println("\nChoose an operation:");
			System.out.println("1: enqueueFront(element)");
			System.out.println("2: enqueueRear(element)");
			System.out.println("3: String dequeueFront()");
			System.out.println("4: String dequeueRear()");
			System.out.println("5: boolean isFull()");
			System.out.println("6: boolean isEmpty()");
			System.out.println("7: int size()");
			System.out.println("8: toString()");
			System.out.println("9: [q]uit");
			System.out.print(">");

			if (scan.hasNextInt())
			{
				operation = scan.nextInt();
				scan.nextLine(); // discard newline after int
			}
			else
			{
				if (scan.nextLine().toLowerCase().equals("q"))
					keepGoing = false;
				else
					System.out.println("Sorry, you need to enter a number. Try again.");
				continue;
			}

			switch (operation)
			{
			case 1: // enqueue
				System.out.println("Enter string to enqueue front:");
				enqueueString = scan.nextLine();
				System.out.println("enqueueFront(\"" + enqueueString + "\")");
				try
				{
					queue.enqueueFront(enqueueString);
				}
				catch (QueueOverflowException QOFException)
				{
					System.out.println("Overflow Exception: " + QOFException.getMessage());
				}
				break;

			case 2:
				System.out.println("Enter string to enqueue rear:");
				enqueueString = scan.nextLine();
				System.out.println("enqueueRear(\"" + enqueueString + "\")");
				try
				{
					queue.enqueueRear(enqueueString);
				}
				catch (QueueOverflowException QOFException)
				{
					System.out.println("Overflow Exception: " + QOFException.getMessage());
				}

				break;

			case 3:
				// dequeue
				System.out.println("dequeueFront()");
				try
				{
					dequeueString = queue.dequeueFront();
				}
				catch (QueueUnderflowException QUFException)
				{
					System.out.println("Underflow Exception: " + QUFException.getMessage());
					break;
				}
				System.out.println("Result: " + dequeueString + " was returned.");// isFull

				break;

			case 4:
				System.out.println("dequeueRear()");
				try
				{
					dequeueString = queue.dequeueRear();
				}
				catch (QueueUnderflowException QUFException)
				{
					System.out.println("Underflow Exception: " + QUFException.getMessage());
					break;
				}
				System.out.println("Result: " + dequeueString + " was returned.");// isFull
				break;

			case 5:
				System.out.println("isFull(): " + queue.isFull());
				break;

			case 6:
				// isEmpty
				System.out.println("isEmpty(): " + queue.isEmpty());
				break;

			case 7: // size
				System.out.println("size(): " + queue.size());
				break;

			case 8: // toString
				System.out.println("toString(): " + queue);
				break;
				
			case 9: // top testing
				keepGoing = false;
				break;

			default:
				System.out.println("Invalid choice. Try again.");
			}
		}

		System.out.println("End of Interactive Dequeue Tester");
		System.out.println();
		scan.close(); // close the Scanner
	}
}