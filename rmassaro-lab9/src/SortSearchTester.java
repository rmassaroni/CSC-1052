/**
 * Sorting and Searching Test Program
 */
public class SortSearchTester
{
	private final static String[] original = {"Nicole", "Daniel","Owen",
		"Emma","Tyler","Nicole","David","Keith","Yamill","Basia","John",
		"Lorin","Will","Kyle","Robert","Maya","Maxwell","Jaimie","Layna",
		"Isabella","Ria","Melissa","Tom","Koba"};
	
	/**
	 * Utility method to make a copy of an array.
	 * 
	 * @param list Array to be copied
	 * @return Copy of array
	 */
	private static String[] copyList(String[] list)
	{
		String[] copy = new String[list.length];
		for (int i = 0; i < list.length; i++)
		{
			copy[i] = list[i];
		}
		return copy;
	}
	
	/**
	 * Utility method to report whether or not
	 * an array is in sorted order.
	 * 
	 * @param list Array to be checked
	 * @return true if array is sorted, false otherwise
	 */
	private static boolean isSorted(String[] list)
	{
		for (int i = 1; i < list.length; i++)
		{
			if (list[i-1].compareTo(list[i]) > 0)
				return false;
		}
		return true;
	}
	
	/**
	 * Utility method to print an array.
	 * 
	 * @param list Array to be printed
	 */
	private static void printList(String[] list)
	{
		for (String value : list)
			System.out.print(value + " ");
		System.out.println();
	}
	
	/**
	 * Main test program.
	 */
	public static void main(String[] args)
	{
		// Selection Sort
		String[] list = copyList(original);
		System.out.println("Selection sort before sorting: " + isSorted(list));
		System.out.print("Before: ");
		printList(list);
		SortSearch.selectionSort(list);
		System.out.print("Sorted: ");
		printList(list);
		System.out.println("Selection sort after sorting:  " + isSorted(list));
		System.out.println();
		
		// Insertion Sort
		list = copyList(original);
		System.out.println("Insertion sort before sorting: " + isSorted(list));
		System.out.print("Before: ");
		printList(list);
		SortSearch.insertionSort(list);
		System.out.print("Sorted: ");
		printList(list);
		System.out.println("Insertion sort after sorting:  " + isSorted(list));
		System.out.println();
		
		// Bubble Sort
		list = copyList(original);
		System.out.println("Bubble sort before sorting: " + isSorted(list));
		System.out.print("Before: ");
		printList(list);
		SortSearch.bubbleSort(list);
		System.out.print("Sorted: ");
		printList(list);
		System.out.println("Bubble sort after sorting:  " + isSorted(list));
		System.out.println();
		
		// Quick Sort
		list = copyList(original);
		System.out.println("Quick sort before sorting: " + isSorted(list));
		System.out.print("Before: ");
		printList(list);
		SortSearch.quickSort(list);
		System.out.print("Sorted: ");
		printList(list);
		System.out.println("Quick sort after sorting:  " + isSorted(list));
		System.out.println();
	  
		// Binary Search
		list = copyList(original);
		SortSearch.selectionSort(list);
		System.out.println("Binary search finds Tom at position " + 
				SortSearch.binarySearch(list,  "Tom"));
		for (int i = 0; i < list.length; i++)
			System.out.println("Binary search finds " + original[i] + " at position " + 
				SortSearch.binarySearch(list,  original[i]));
	}

}
