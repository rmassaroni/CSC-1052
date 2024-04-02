/**
 * Defines the interface to an integer array.
 */
public interface IntegerArray
{
	/**
	 * Adds the specified item (value) to the array.
	 * @param item item to be added to the array.
	 */
	public void add(int item);
	
	/**
	 * Removes the specified item (value) from the array.
	 * This only removes the first matching value found.
	 * If no matching item is found, the array remains the same.
	 * @param item item to be removed from the array.
	 */
	public void remove(int item);
	
	/**
	 * Size (number of items) of the array.
	 * @return the number of items in the array.
	 */
	public int size();
	
	/**
	 * Returns a string representation of the array as a
	 * comma-delimited list, e.g.: 1,3,4,78,4,99
	 * @return a string representation of the array
	 */
	public String toString();
}
