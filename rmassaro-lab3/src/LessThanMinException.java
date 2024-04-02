/**
 * LessThanMinException represents an exception when SafeNumber is less than Min.
 * 
 * @author Your Name
 *
 */

public class LessThanMinException extends Exception
{
	/**
	 * Constructor, invoke the Exception constructor
	 */
	public LessThanMinException()
	{
		super();
	}

	/**
	 * Constructor, invoke the Exception constructor
	 * 
	 * @param message
	 */
	public LessThanMinException(String message)
	{
		super(message);
	}
}
