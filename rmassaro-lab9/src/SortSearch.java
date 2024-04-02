/**
 * Search and Sort Methods.
 * 
 * @author Robert Massaroni
 *
 */
public class SortSearch
{
	/**
	 * Performs a binary search by reducing the search range within the array
	 * after each comparison.
	 *
	 * @param list the array to be searched
	 * @param target the value being searched for
	 * @return the index of the target value if found, or -1 if not
	 */
	public static int binarySearch(String[] list, String target)
	{
		// implement me
		int first = 0;
		int last = list.length - 1;
//		boolean foundTarget = false;
		
		for(int i = 0; i < list.length; i++) {
			int middle = (last - first)/2;
			if(list[i].equals(target)) {
				return i;
			}
			else if(middle > 1 && Character.valueOf(Character.toLowerCase(list[middle].charAt(0))) > Character.valueOf(Character.toLowerCase(target.charAt(0)))) {
				last = middle - 1;
			}
			else {
				first = middle + 1;
			}
		}
		return -1;
	}
	
	/**
	 * Performs a selection sort on the specified string array.
	 *
	 * @param list the array to be sorted
	 */
	public static void selectionSort(String[] list)
	{
		// implement me
		int min;
		String temp;

	    for (int i = 0; i < list.length - 1; i++)
	    {
	        min = i;
	        for (int j = i + 1; j < list.length; j++)
	            if(list[j].compareTo(list[min]) < 0)
	            	  min = j;

	        // swap the values
	        temp = list[i];
	        list[i] = list[min];
	        list[min] = temp;
	    }
	}
	
	/**
	 * Performs an insertion sort on the specified string array.
	 *
	 * @param list the array to be sorted
	 */
	public static void insertionSort(String[] list)
	{
		// implement me
		for (int i = 1; i < list.length; i++)
	    {
	        int j = i;
	        while (j > 0 && list[j - 1].compareTo(list[j]) > 0)
	        {
	            // Swap adjacent values
	            String temp = list[j];
	            list[j] = list[j - 1];
	            list[j - 1] = temp;

	            j--;
	        }
	    }
	}
	
	/**
	 * Performs a bubble sort on the specified string array.
	 *
	 * @param list the array to be sorted
	 */
	public static void bubbleSort(String[] list)
	{
		// implement me
		for (int j = 0; j < list.length; j++) {
		   	   for (int i = j + 1; i < list.length; i++) {
				// comparing adjacent strings
				if (list[i].compareTo(list[j]) < 0) {
					String temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
			   }}
	}
	
	/**
	 * Performs a quick sort on the specified string array.
	 *
	 * @param list the array to be sorted
	 */
	public static void quickSort(String[] list)
	{
		// implement me
		quickSort(list, 0, list.length - 1);
	}

	/**
	 * Recursively performs a quick sort on the segment of the
	 * specified string array from the the low to high elements.
	 * @param list the array to be sorted
	 * @param low the lowest index of the segment
	 * @param high the highest index of the segment
	 */
	public static void quickSort(String[] list, int low, int high)
	{
		// implement me
		if (low >= 0 && high >= 0 && low < high)
	    {
	        // Partition the elements and get the index of the pivot.
	        int pivotIndex = partition(list, low, high);

	        // Sort the two partitions.
	        quickSort(list, low, pivotIndex - 1);   // left side of pivot
	        quickSort(list, pivotIndex + 1, high);  // right side of pivot
	    }
	}

	/**
	 * Partitions the segment of the specified string array
	 * from the low to high elements, returning the index of
	 * the pivot element. After partitioning, the array looks like this:
	 *	 L L L L L L L L P G G G G
	 * Values that are less than (L) or greater than (G) the pivot
	 * value (P) are moved before or after the pivot in the array.
	 * The index of the pivot is returned.
	 * @param list the array to be sorted
	 * @param low the lowest index of the segment
	 * @param high the highest index of the segment
	 * @return the index of the pivot element
	 */
	private static int partition(String[] list, int low, int high)
	{
		// implement me
		String pivotValue = list[high];

	    // Start pivotIndex at the low end of the partition.
	    int pivotIndex = low - 1;

	    // Examine all elements in the partition, moving low elements
	    // before the current pivot position.
	    for (int i = low; i <= high; i++)
	    {
	    	if(list[i].compareTo(pivotValue) <= 0)
	        {
	            pivotIndex++;

	            // Swap the low element with the value at the current
	            // pivot index.
	            String temp = list[pivotIndex];
	            list[pivotIndex] = list[i];
	            list[i] = temp;
	        }
	    }

	    return pivotIndex;
	}
}

