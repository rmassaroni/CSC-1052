
/**
 * SafeNumber represents an integer with the value between MIN and MAX.
 * 
 * @author Robert Massaroni
 *
 */

public class SafeNumber
{
	public final int MIN = -50;
	public final int MAX = 50;

	private int number;

	/**
	 * Constructor takes an integer n and initializes the number if the value is between MIN and MAX. Otherwise, throw
	 * exceptions and set the number to 0.
	 * 
	 * @param n
	 * @exception GreaterThanMaxException if n is greater than MAX.
	 * @exception LessThanMinException if n is less than MIN.
	 * 
	 */
	public SafeNumber(int n) throws GreaterThanMaxException, LessThanMinException
	{
		if(n < MAX && n > MIN) {
			this.number = n;
		}
		else if(n > MAX) {
			this.number = 0;
			throw new GreaterThanMaxException("number " + n + " is greater than MAX " + MAX);
			
		}
		else {
			this.number = 0;
			throw new LessThanMinException("number " + n + " is less than MIN " + MIN);
			
		}
		
	}

	/**
	 * getNumber returns the current value of number.
	 * 
	 */
	public int getNumber()
	{
		return number;
	}

	/**
	 * Increments the number by n, update the value of number if the new value is between MIN and MAX. Otherwise, throw
	 * exceptions.
	 * 
	 * @param n
	 * @exception GreaterThanMaxException if new value is greater than MAX.
	 * 
	 */
	public void increment(int n) throws GreaterThanMaxException
	{
		if(number + n < MAX) {
			number += n;
		}
		else {
			throw new GreaterThanMaxException("result " + (number + n) + " is greater than MAX " + MAX);
		}
	}

	/**
	 * Decrements the number by n, update the value of number if the new value is between MIN and MAX. Otherwise, throw
	 * exceptions.
	 * 
	 * @param n
	 * @exception LessThanMinException if new value is less than MIN.
	 * 
	 */
	public void decrement(int n) throws LessThanMinException
	{
		if(number - n > MIN) {
			number -= n;
		}
		else {
			throw new LessThanMinException("result " + (number - n) + " is less than MIN " + MIN);
		}
	}
}
