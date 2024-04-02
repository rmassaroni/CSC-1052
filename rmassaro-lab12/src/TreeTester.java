import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TreeTester {
	public static void main(String[] args) {
		TreeTester t = new TreeTester();
		t.testWordOrder();
		t.testRandomNumbers();
		t.testMoreNumbers();
	}
	
	
	@SuppressWarnings("resource")
	public void testWordOrder() {
		System.out.print("Testing Word Order ====================================\nEnter a sentence: ");
		String[] words = new Scanner(System.in).nextLine().split("\\W+");
		MyBST<String> bst = new MyBST<>();
		for(String s : words)
			bst.add(s);
		bst.printInOrder(" ");
		System.out.println("\n=======================================================");
	}
	
	public void testRandomNumbers() {
		System.out.println("Testing Random Numbers ===================================");
		MyBST<Integer> bst = new MyBST<>();
		Random random = new Random(1000);
		for(int i = 0; i < 1000; i++)
			bst.add(random.nextInt(1000) + 1);
		for(int i = 0; i < 20; i++) {
			int x = random.nextInt(1000) + 1;
			if(bst.contains(x))
				System.out.println("Tree contains " + x);
			else
				System.out.println("Tree does not contain " + x);
		}
	}
	
	public void testMoreNumbers() {
		System.out.println("Testing More Numbers ================================");
		MyBST<Integer> bst = new MyBST<>();
		Random random = new Random();
		ArrayList<Integer> ints = new ArrayList<>();
		int sum = 0;
		for(int i = 0; i < 1000; i++) {
			int x = random.nextInt(1000) + 1;
			bst.add(x);
			ints.add(x);
			sum += x;
		}
		System.out.println("Average: " + (sum / bst.size()));
		int count = 0;		
		for(Integer value : ints)
			if(value < sum / bst.size())
				count++;
		System.out.println(count + " numbers less than " + sum / bst.size());
		System.out.println("========================================================");
	}
}
