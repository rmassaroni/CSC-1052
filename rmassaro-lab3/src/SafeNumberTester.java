
public class SafeNumberTester
{
	public static void main(String[] args)
	{
		System.out.println("First Try:");
		try
		{
			SafeNumber sn = new SafeNumber(-100);
			System.out.println("The new safe number is: " + sn.getNumber());
		}
		catch (LessThanMinException e)
		{
			System.out.println(e.getMessage());
		}
		catch (GreaterThanMaxException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("First Try finished.\n");

		System.out.println("Second Try:");
		try
		{
			SafeNumber sn = new SafeNumber(100);
			System.out.println("The new safe number is: " + sn.getNumber());
		}
		catch (LessThanMinException e)
		{
			System.out.println(e.getMessage());
		}
		catch (GreaterThanMaxException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Second Try finished.\n");

		System.out.println("Third Try:");
		try
		{
			SafeNumber sn = new SafeNumber(20);
			System.out.println("The new safe number is: " + sn.getNumber());

			sn.decrement(100);
			System.out.println("The number after decrement is: " + sn.getNumber());

		}
		catch (LessThanMinException e)
		{
			System.out.println(e.getMessage());
		}
		catch (GreaterThanMaxException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Third Try finished.\n");

		System.out.println("Fourth Try:");
		try
		{

			SafeNumber sn = new SafeNumber(20);
			System.out.println("The new safe number is: " + sn.getNumber());

			sn.increment(100);
			System.out.println("The number after increment is: " + sn.getNumber());

		}
		catch (LessThanMinException e)
		{
			System.out.println(e.getMessage());
		}
		catch (GreaterThanMaxException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Fourth Try finished.\n");

		System.out.println("Final Try:");
		try
		{

			SafeNumber sn = new SafeNumber(20);
			System.out.println("The new safe number is: " + sn.getNumber());

			sn.increment(10);
			System.out.println("The number after increment is: " + sn.getNumber());
			sn.decrement(30);
			System.out.println("The number after decrement is: " + sn.getNumber());

		}
		catch (LessThanMinException e)
		{
			System.out.println(e.getMessage());
		}
		catch (GreaterThanMaxException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("Final Try finished.\n");
	}
}
