import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the RecursionUtilities class methods.
 * 
 * To run all tests: right-click on class name, Run As > JUnit Test
 * To run one test: right-click on method name, Run As > JUnit Test
 *
 */
public class RecursionUtilitiesTests
{
	RecursionUtilities recursionUtils;

	@BeforeEach
	public void setUp()
	{
		recursionUtils = new RecursionUtilities();
	}

	@Test
	void testPowerN1()
	{
		assertEquals(3, recursionUtils.powerN(3, 1));
	}

	@Test
	void testPowerN2()
	{
		assertEquals(9, recursionUtils.powerN(3, 2));
	}

	@Test
	void testPowerN3()
	{
		assertEquals(27, recursionUtils.powerN(3, 3));
	}

	@Test
	void testPowerN4()
	{
		assertEquals(10, recursionUtils.powerN(10, 1));
	}

	@Test
	void testPowerN5()
	{
		assertEquals(100, recursionUtils.powerN(10, 2));
	}

	@Test
	void testPowerN6()
	{
		assertEquals(1000, recursionUtils.powerN(10, 3));
	}

	@Test
	void testPowerN7()
	{
		assertEquals(32, recursionUtils.powerN(2, 5));
	}

	@Test
	public void testReverseString1()
	{
		String s = "This1 is2 a3 string4";
		assertEquals("4gnirts 3a 2si 1sihT", recursionUtils.reverseString(s));
	}

	@Test
	public void testReverseString2()
	{
		String s = "kayak";
		assertEquals("kayak", recursionUtils.reverseString(s));
	}

	@Test
	public void testReverseString3()
	{
		String s = "Algo 1052";
		assertEquals("2501 oglA", recursionUtils.reverseString(s));
	}

	@Test
	public void testReverseString4()
	{
		String s = "Recursion rocks, haha";
		assertEquals("ahah ,skcor noisruceR", recursionUtils.reverseString(s));
	}

	@Test
	public void testReverseString5()
	{
		String s = "XyZaabbcc123";
		assertEquals("321ccbbaaZyX", recursionUtils.reverseString(s));
	}

	@Test
	public void testReverseString6()
	{
		String s = "Blockchain";
		assertEquals("niahckcolB", recursionUtils.reverseString(s));
	}

	@Test
	public void testReverseString7()
	{
		String s = "Driverless cars";
		assertEquals("srac sselrevirD", recursionUtils.reverseString(s));
	}

	@Test
	void testcountToBy()
	{
		assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9, 10", recursionUtils.countToBy(10, 1));
	}

	@Test
	void testcountToBy2()
	{
		assertEquals("1, 5, 9, 13, 17, 21, 25", recursionUtils.countToBy(25, 4));
	}

	@Test
	void testcountToBy3()
	{
		assertEquals("2, 6, 10, 14, 18, 22, 26, 30", recursionUtils.countToBy(30, 4));
	}

	@Test
	void testcountToBy4()
	{
		assertEquals("4, 9, 14, 19, 24, 29, 34", recursionUtils.countToBy(34, 5));
	}

	@Test
	void testcountToBy5()
	{
		assertEquals("3", recursionUtils.countToBy(3, 6));
	}

	@Test
	void testcountToBy6()
	{
		assertEquals("2, 5, 8, 11, 14, 17", recursionUtils.countToBy(17, 3));
	}

	@Test
	void testevenDigits1()
	{
		assertEquals(8426, recursionUtils.evenDigits(8342116));
	}

	@Test
	void testevenDigits2()
	{
		assertEquals(0, recursionUtils.evenDigits(35179));
	}

	@Test
	void testevenDigits3()
	{
		assertEquals(24, recursionUtils.evenDigits(1234));
	}

	@Test
	void testevenDigits4()
	{
		assertEquals(666, recursionUtils.evenDigits(779991666));
	}

	@Test
	void testevenDigits5()
	{
		assertEquals(2, recursionUtils.evenDigits(7123));
	}

	@Test
	void testevenDigits6()
	{
		assertEquals(2666, recursionUtils.evenDigits(771237666));
	}

	@Test
	void testevenDigits7()
	{
		assertEquals(0, recursionUtils.evenDigits(777777));
	}

	@Test
	public void testArray111()
	{
		int[] a = { 11, 1, 3, 4, };
		assertEquals(1, recursionUtils.array11(a, 0));
	}

	@Test
	public void testArray112()
	{
		int[] a = { 11, 11 };
		assertEquals(2, recursionUtils.array11(a, 0));
	}

	@Test
	public void testArray113()
	{
		int[] a = { 1, 3, 4, 5 };
		assertEquals(0, recursionUtils.array11(a, 0));
	}

	@Test
	public void testArray114()
	{
		int[] a = { 11 };
		assertEquals(1, recursionUtils.array11(a, 0));
	}

	@Test
	public void testArray115()
	{
		int[] a = { 1 };
		assertEquals(0, recursionUtils.array11(a, 0));
	}

	@Test
	public void testArray116()
	{
		int[] a = {};
		assertEquals(0, recursionUtils.array11(a, 0));
	}

	@Test
	public void testArray117()
	{
		int[] a = { 11, 1, 3, 4, 11, 5 };
		assertEquals(2, recursionUtils.array11(a, 0));
	}

	@Test
	public void testzigzag1()
	{
		assertEquals("<**>", recursionUtils.zigzag(4));
	}

	@Test
	public void testzigzag2()
	{
		assertEquals("<<*>>", recursionUtils.zigzag(5));
	}

	@Test
	public void testzigzag3()
	{
		assertEquals("<<**>>", recursionUtils.zigzag(6));
	}

	@Test
	public void testzigzag4()
	{
		assertEquals("<<<*>>>", recursionUtils.zigzag(7));
	}

	@Test
	public void testzigzag5()
	{
		assertEquals("<<<**>>>", recursionUtils.zigzag(8));
	}

	@Test
	public void testzigzag6()
	{
		assertEquals("<<<<*>>>>", recursionUtils.zigzag(9));
	}

	@Test
	public void testzigzag7()
	{
		assertEquals("<<<<**>>>>", recursionUtils.zigzag(10));
	}

	@Test
	public void testIsPalindrome1()
	{
		String s = "madam";
		assertEquals(true, recursionUtils.isPalindrome(s));
	}

	@Test
	public void testIsPalindrome2()
	{
		String s = "madamXYZ";
		assertEquals(false, recursionUtils.isPalindrome(s));
	}

	@Test
	public void testIsPalindrome3()
	{
		String s = "racecar";
		assertEquals(true, recursionUtils.isPalindrome(s));
	}

	@Test
	public void testIsPalindrome4()
	{
		String s = "palindrome";
		assertEquals(false, recursionUtils.isPalindrome(s));
	}

	@Test
	public void testIsPalindrome5()
	{
		String s = "A man, a plan, a canal – Panama";
		assertEquals(true, recursionUtils.isPalindrome(s));
	}

	@Test
	public void testIsPalindrome6()
	{
		String s = "Madam, I'm Adam";
		assertEquals(true, recursionUtils.isPalindrome(s));
	}

	@Test
	public void testIsPalindrome7()
	{
		String s = "Sir, I demand, I am a maid named Iris.";
		assertEquals(true, recursionUtils.isPalindrome(s));
	}

	@Test
	public void testIsPalindrome8()
	{
		String s = "";
		assertEquals(true, recursionUtils.isPalindrome(s));
	}

	@Test
	public void testIsPalindrome9()
	{
		String s = "g";
		assertEquals(true, recursionUtils.isPalindrome(s));
	}

	@Test
	public void testStringClean1()
	{
		String s = "yyzzza";
		assertEquals("yza", recursionUtils.stringClean(s));
	}

	@Test
	public void testStringClean2()
	{
		String s = "Hello";
		assertEquals("Helo", recursionUtils.stringClean(s));
	}

	@Test
	public void testStringClean3()
	{
		String s = "abbbcdd";
		assertEquals("abcd", recursionUtils.stringClean(s));
	}

	@Test
	public void testStringClean4()
	{
		String s = "XXabcYY";
		assertEquals("XabcY", recursionUtils.stringClean(s));
	}

	@Test
	public void testStringClean5()
	{
		String s = "hi";
		assertEquals("hi", recursionUtils.stringClean(s));
	}

	@Test
	public void testFibonacci1()
	{
		assertEquals(0, recursionUtils.fibonacci(0));
	}

	@Test
	public void testFibonacci2()
	{
		assertEquals(1, recursionUtils.fibonacci(1));
	}

	@Test
	public void testFibonacci3()
	{
		assertEquals(1, recursionUtils.fibonacci(2));
	}

	@Test
	public void testFibonacci4()
	{
		assertEquals(2, recursionUtils.fibonacci(3));
	}

	@Test
	public void testFibonacci5()
	{
		assertEquals(3, recursionUtils.fibonacci(4));
	}

	@Test
	public void testFibonacci6()
	{
		assertEquals(5, recursionUtils.fibonacci(5));
	}

	@Test
	public void testFibonacci7()
	{
		assertEquals(8, recursionUtils.fibonacci(6));
	}

	@Test
	public void testFibonacci8()
	{
		assertEquals(13, recursionUtils.fibonacci(7));
	}
}
