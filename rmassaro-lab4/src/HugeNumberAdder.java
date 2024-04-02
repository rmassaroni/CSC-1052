/**
 * HugeNumberAdder that adds two unlimited-length integers,
 * represented as strings.
 
 * @author Robert Massaroni
 *
 */
public class HugeNumberAdder
{
	/**
	 * Adds together two unlimited-length integers, represented as
	 * strings, returning the sum of the two. The values might be
	 * of different lengths, but should be assumed to always have
	 * a non-negative value.
	 * @param number1 first number (string) to add
	 * @param number2 second number (string) to add
	 * @return string representing the sum of the two numbers
	 */
	public static String add(String number1, String number2)
	{
		String n1 = number1;
		String n2 = number2;
		if(n1.length() > n2.length()) {
//			System.out.println(n1.length()-n2.length());
			for(int i = 0; i < number1.length() - number2.length(); i++) {
				n2 = "0" + n2;
//				System.out.println(n1);
			}
		}
		else {
			for(int i = 0; i < number2.length() - number1.length(); i++) {
				n1 = "0" + n1;
			}
		}
//		System.out.println(n1);
//		System.out.println(n2);
		int[] a1 = new int[n1.length()];
		int[] a2 = new int[n2.length()];
		for(int i = 0; i < n1.length(); i++) {
			a1[i] = Character.getNumericValue(n1.charAt(i));
//			System.out.print(n1.charAt(i));
			a2[i] = Character.getNumericValue(n2.charAt(i));
		}
		int[] a3 = new int[n1.length()];
		for(int i = 0; i < a3.length; i++) {
			
			a3[i] = a1[i] + a2[i];
//			System.out.print(a1[i] + " + " + a2[i] + " = " + a3[i] + " ");
		}
		boolean simplified = false;
		while(simplified == false) {
			boolean foundTooBig = false;
			for(int i = 1; i < a3.length; i++) {
				if(a3[i] >= 10) {
					a3[i - 1] += 1;
					a3[i] -= 10;
					foundTooBig = true;
				}
			}
			if(!foundTooBig) {
				simplified = true;
			}
		}
		
		String s = "";
		for(int i = 0; i < a3.length; i++) {
			s += a3[i] + "";
		}
		
		return s;
	}
	
	/**
	 * Main method to test the add method above. No changes should
	 * be made to this method other than adding additional tests.
	 */
	public static void main(String[] args)
	{
		String n1 = "9746354637282847561872929184362084759202";
		String n2 = "74521000284565";
		String total = add(n1, n2);

		System.out.print(n1 + " + " + n2 + " = ");
		System.out.println(total);
		System.out.println();
		
		String n3 = "99999999999999999999999999999999999999999965";
		String n4 = "35";
		total = add(n3, n4);
		
		System.out.print(n3 + " + " + n4 + " = ");
		System.out.println(total);
		System.out.println();
		
		String n5 = "2";
		String n6 = "2";
		total = add(n5, n6);
		
		System.out.print(n5 + " + " + n6 + " = ");
		System.out.println(total);
	}

}
