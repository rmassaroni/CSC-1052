/**
 * BigOTests that times array max-finding algorithms. 
 * @author Your Name
 *
 */
public class BigOTests
{
	/**
	 * Times finding the maximum value in a 1D array of a specified size
	 * @param n size of array
	 */
	private static void time1DArray(int n)
	{
		// declare 1D array of size n
		int[] values = new int[n];
		
		
		// initialize array with random values
		for(int i = 0; i < n; i++) {
			values[i] = (int)(Math.random() * 100);
		}
		// start timer
		long start = System.nanoTime();
		//System.out.println(start);
		// find maximum value in array
		int maxvalue = values[0];
		for(int i = 1; i < n; i++) {
			if(values[i] > maxvalue) {
				maxvalue = values[i];
			}
		}
		// stop timer
		long stop = System.nanoTime();
		// print timing (number of nanoseconds)
		System.out.println(stop - start);//?
	}
	
	/**
	 * Times finding the maximum value in a 2D array of a specified size
	 * @param n size of array
	 */
	private static void time2DArray(int n)
	{
		int[][] values = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				values[i][j] = (int)(Math.random() * 100);
			}
		}
		long start = System.nanoTime();
		int maxvalue = values[0][0];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(values[i][j] > maxvalue) {
					maxvalue = values[i][j];
				}
			}
			
		}
		long stop = System.nanoTime();
		// print timing (number of nanoseconds)
		System.out.println(stop - start);//?
		
	}
	
	/**
	 * Times finding the maximum value in a 3D array of a specified size
	 * @param n size of array
	 */
	private static void time3DArray(int n)
	{
		int[][][] values = new int[n][n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int ii = 0; ii < n; ii++) {
					values[i][j][ii] = (int)(Math.random() * 100);
				}
			}
		}
		long start = System.nanoTime();
		int maxvalue = values[0][0][0];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int ii = 0; ii < n; ii++) {
					if(values[i][j][ii] > maxvalue) {
						maxvalue = values[i][j][ii];
					}
				}
			}
		}
		long stop = System.nanoTime();
		
		System.out.println(stop - start);
	}
	
	/**
	 * Main method that runs all tests for a specified array size.
	 * @param args
	 */
	public static void main(String[] args)
	{
		final int n = 100000; // change this for each size of array and rerun
		
		time1DArray(n);
		time2DArray(n);
		time3DArray(n);
	}
}
