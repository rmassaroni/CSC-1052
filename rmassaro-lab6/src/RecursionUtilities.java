/**
 * Recursive utility methods that perform various tasks.
 * 
 * @author Robert Massaroni
 *
 */
public class RecursionUtilities
{
	/**
	 * Given base and n that are both 1 or more, compute recursively (no loops) 
	 * the value of base to the nth power, so powerN(3, 2) is 9 (3 squared).
	 * 
	 *   powerN(3,1) ->  3
	 *   powerN(3,2) ->  9
	 *   powerN(3,3) ->  27
	 */	
	public int powerN(int base, int n)
	{
		if(n != 0) {
			return base * powerN(base, n - 1);
		}
		else {
			return 1;
		}
	}	

	/**
	 * Given a string, compute recursively (no loops) the String in reverse.
	 * 
	 *	 reverseString("madam") ->  madam
	 *	 reverseString("Recursion rocks, haha") ->  ahah ,skcor noisruceR
	 *	 reverseString("This1 is2 a3 string4") ->  4gnirts 3a 2si 1sihT
	 */		
	public String reverseString(String str)
	{
		if(str.length() > 1) {
			char c = str.charAt(str.length() - 1);
			return c + reverseString(str.substring(0, str.length() - 1));	
		}
		else {
			return str;
		}
					
	}

	/**
	 * Write a recursive method named countToBy that accepts integer 
	 * parameters countTo and by and that produces output indicating how to count
	 * to countTo in increments of by, separated by commas. For example, to count 
	 * to 10 by 1 you'd say countToBy(10, 1). Here are some examples:
	 * 
	 *   countToBy(10,1);   count to 10 by 1s ->  1, 2, 3, 4, 5, 6, 7, 8, 9, 10
	 *   countToBy(25,4);   count to 25 by 4s ->  1, 5, 9, 13, 17, 21, 25
	 *   countToBy(30,4);   count to 30 by 4s ->  2, 6, 10, 14, 18, 22, 26, 30
	 *   countToBy(34,5);   count to 34 by 5s ->  4, 9, 14, 19, 24, 29, 34
	 *   countToBy(3,6);    count to 3 by 6s  ->  3
	 *   countToBy(17,3);   count to 17 by 3s ->  2, 5, 8, 11, 14, 17
	 * 
	 * Notice that the increment does not have to be 1, such as when 
	 * counting to 25 by 4s. The count must always end at countTo, but notice 
	 * that it will not always be possible to start counting at 1, 
	 * as shown in the output when countTo is 30 and by is 4. But the first 
	 * number should always be in the range of 1 to by inclusive. 
	 * It is possible that only one number will be printed, as shown in 
	 * the output when countTo is 3 and by is 6.
	 */
	public String countToBy(int countTo, int by)
	{
		if(countTo > by) {
			return countToBy(countTo - by, by) + ", " + Integer.toString(countTo);
		}
		else {
			return Integer.toString(countTo);
		}
		
	}
	
	/**
	 * Write a recursive method named evenDigits that accepts an integer 
	 * parameter n and returns a new integer containing only the even digits
	 * from n, in the same order. If n does not contain any even digits, 
	 * return 0.
	 * 
	 * For example, the call of evenDigits(8342116) should return 8426 
	 * and the call of evenDigits(35179) should return 0.
	 */
	public int evenDigits(int n)
	{
		if(n >= 1) {
			if(n % 2 == 0) {
				return evenDigits(n / 10) * 10 + n % 10;
			}
			else {
				return evenDigits(n / 10);
			}
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Given an array of integer, compute recursively the number of times that the value 
	 * 11 appears in the array. We'll use the convention of considering only 
	 * the part of the array that begins at the given index. 
	 * In this way, a recursive call can pass index+1 to move down the array. 
	 * The initial call will pass in index as 0.
	 * 
	 *	 array11(11, 4, 6], 0) ->  1
	 *	 array11([11, 11], 0) ->  2
	 *	 array11([1, 2, 3, 4], 0) ->  0
	 */
	public int array11(int[] chars, int index)
	{
		if(index < chars.length) {
			if(chars[index] == 11) {
				return 1 + array11(chars, index + 1);
			}
			else {
				return array11(chars, index + 1);
			}
		}
		else {
			return 0;
		}
		
	}
	
	/**
	 * Write a recursive method zigzag that accepts an integer parameter n 
	 * and returns a String as follows. The middle character of the
	 * output should always be an asterisk ("*"). If you are asked to write 
	 * out an even number of characters, then there will be two asterisks in
	 * the middle ("**"). Before the asterisk(s) you should write out 
	 * less-than characters ("<"). After the asterisk(s) you should write 
	 * out greater-than characters (">"). For example, the following calls 
	 * produce the following String output:
	 * 
	 *   zigzag(1) =>  *
	 *   zigzag(2) =>  **
	 *   zigzag(3) =>  <*>
	 *   zigzag(4) =>  <**>
	 *   zigzag(5) =>  <<*>>
	 */
	public String zigzag(int n)
	{
		if(n == 1) {
			return "*";
		}
		else if(n == 2) {
			return "**";
		}
		else {
			return "<" + zigzag(n - 2) + ">";
		}
	}

	/**
	 * Given a String, compute recursively (no loops) whether or not the String
	 * is a palindrome. The String may contain letter and non-letter characters.
	 * All non-letter characters should be ignored.=
	 * A palindrome is a word that is the same spelled forward or in reverse.
	 *   isPalindrome("madam") -> true
	 *   isPalindrome("Amy, must I jujitsu my ma?") -> true
	 *   isPalindrome("hi") -> false
	 */
	public boolean isPalindrome(String str)
	{	
		int min = 0;
		int max = str.length() - 1;
		
		if(min < max) {
			if(!Character.isLetter(str.charAt(min))) {
				return isPalindrome(str.substring(1));
			}
			if(!Character.isLetter(str.charAt(max))) {
				return isPalindrome(str.substring(0, str.length() - 1));
			}
			if(str.toLowerCase().charAt(0) == str.toLowerCase().charAt(str.length() - 1)) {
				return isPalindrome(str.substring(1, str.length() - 1));
			}
			else if(str.toLowerCase().charAt(0) != str.toLowerCase().charAt(str.length() - 1)) {
				return false;
			}
		}
		return true;
		
		
		
	}

	/**
	 * Given a string, return recursively a "cleaned" string where adjacent,
	 * identical chars that are the same have been reduced to a single char. 
	 * So "yyzzza" yields "yza".
	 * 
	 *   stringClean("yyzzza") ->  yza
	 *   stringClean(Hello") ->  Helo
	 *   stringClean("abbbcdd") ->  abcd
	 */
	public String stringClean(String str)
	{
		char c = str.charAt(str.length() - 1);
		if(str.length() > 1) {
			if(str.indexOf(c) > -1 && str.indexOf(c) < str.length() - 1) {
				return stringClean(str.substring(0, str.length() - 1));
			}
			else {
				return stringClean(str.substring(0, str.length() - 1)) + str.charAt(str.length() - 1);
			}
		}
		else {
			return str;
		}
	}
	
	/**
	 * The Fibonacci sequence is famous in mathematics and has a recursive definition. 
	 * The first two values in the sequence are 0 and 1 (essentially 2 base cases).
	 * Each subsequent value is the sum of the previous two values, so the whole 
	 * sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on. 
	 * Define a recursive fibonacci(n) method that returns the nth Fibonacci 
	 * number, with n=0 representing the start of the sequence.
	 *  
	 *  fibonacci(0) -> 0
	 *  fibonacci(1) -> 1
	 *  fibonacci(2) -> 1
	 *  fibonacci(3) -> 2
	 *  ...etc...
	 */
	public int fibonacci(int n)
	{
		if(n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
}
