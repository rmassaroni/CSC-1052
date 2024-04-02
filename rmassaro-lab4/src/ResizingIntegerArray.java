 /**
 * ResizingIntegerArray represents an array of integers that grows and shrinks.
 *
 * @author Robert Massaroni
 *
 */
public class ResizingIntegerArray implements IntegerArray
{
	// TODO: Declare a private int array as an instance variable
	private int[] myarray;

	
	// Constructor.
	public ResizingIntegerArray()
	{
		// TODO: initialize the instance variable array as size 0
		myarray = new int[0];
	}

	/**
	 * Add an item to the array. After adding the item,
	 * the array will be one item longer than before.
	 *
	 * @param item the item (value) to add to the array
	 */
	public void add(int item)
	{
		int[] newArray = new int[myarray.length + 1];
		for(int i = 0; i < myarray.length; i ++) {
			newArray[i] = myarray[i];
		}
		newArray[myarray.length] = item;
		myarray = newArray;
	}

	/**
	 * Remove an item from the array. After removing the item,
	 * the array will be one item shorter than before.
	 *
	 * @param item the item (value) to remove from the array
	 */
	public void remove(int item)
	{
		boolean found = false;
		int index = -1;
		for(int i = 0; i < myarray.length; i++) {
			if(myarray[i] == item) {
				found = true;
				index = i;
				i = myarray.length;
			}
		}
		if(found) {
			int[] newArray = new int[myarray.length - 1];
			int j = 0;
			for(int i = 0; i < myarray.length; i++) {
				if(i == index) {
					
				}
				else {
					newArray[j] = myarray[i];
					j++;
				}
			}
			myarray = newArray;
		}
		
		
	}

	/**
	 * Returns the count of items in the array.
	 * @return number of items in the array.
	 */
	public int size()
	{
		return myarray.length;
	}

	/**
	 * Returns a string representation of the array, delimited by commas.
	 * @return comma-delimited string representation of the array
	 */
	public String toString()
	{
		String s = "";
		for(int i = 0; i < myarray.length; i++) {
			s += myarray[i];
			if(i < myarray.length - 1) {
				s += ",";
			}
		}
		return s;
	}
}
