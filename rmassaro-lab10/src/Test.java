import java.util.stream.IntStream;

public class Test {
	public static void main(String[] args) {
		System.out.println(IntStream.rangeClosed('a', 'z').toArray()[10]);
	}
}
