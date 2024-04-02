/**
 * GreaterThanMaxException represents an exception when SafeNumber is greater than Max.
 * 
 * @author Your Name
 *
 */

public class GreaterThanMaxException extends Exception
{
	/**
	 * Constructor, invoke the Exception constructor
	 */
	public GreaterThanMaxException()
	{
		super();
	}

	/**
	 * Constructor, invoke the Exception constructor
	 * 
	 * @param message
	 */
	public GreaterThanMaxException(String message)
	{
		super(message);
	}
}
