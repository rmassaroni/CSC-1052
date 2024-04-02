/**
 * Represents a problem caused by accessing an empty stack.
 *
 * @author Rephactor Java
 * @version 1.0
 */
public class EmptyStackException extends RuntimeException
{
    /**
     * Sets up an exception with no message.
     */
	public EmptyStackException()
	{
		super();
	}

    /**
     * Sets up an exception with the specified message.
     * @param message the message associated with the exception 
     */
	public EmptyStackException(String message)
	{
		super(message);
	}
}
