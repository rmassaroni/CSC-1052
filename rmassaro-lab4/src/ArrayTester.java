/**
 * ArrayTester that tests the ResizingIntegerArray class
 */
public class ArrayTester
{
	public static void main(String[] args)
	{
		ResizingIntegerArray array = new ResizingIntegerArray();
		System.out.println("expect: " + "");
		System.out.println("actual: " + array.toString());
		
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
		System.out.println("expect: " + "1,2,3,4,5");
		System.out.println("actual: " + array.toString());
		
		System.out.println("expect size: " + 5);
		System.out.println("actual size: " + array.size());
		
		array.remove(3);
		System.out.println("expect: " + "1,2,4,5");
		System.out.println("actual: " + array.toString());
		
		array.add(2);
		array.add(3);
		array.add(2);
		array.remove(2);
		System.out.println("expect: " + "1,4,5,2,3,2");
		System.out.println("actual: " + array.toString());
		
		array.remove(1);
		array.remove(2);
		array.remove(3);
		array.remove(4);
		array.remove(5);
		System.out.println("expect: " + "2");
		System.out.println("actual: " + array.toString());
		
		System.out.println("expect size: " + 1);
		System.out.println("actual size: " + array.size());
	}

}
