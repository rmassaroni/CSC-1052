import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Test program for MyLinkedList.
 */
public class MyLinkedListTester
{
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("The path for the names.txt file is relative to this: " + System.getProperty("user.dir"));

        // Create a scanner to read from the file of names.
        // You may need to modify the path for the file.
        Scanner in = new Scanner(new File("bin/names.txt"));
        
        // Construct the linked list
        MyLinkedList myList = new MyLinkedList();

        // Read each line in the file and add to the linked list
        while (in.hasNextLine())
        {
            String name = in.nextLine();
            
            // Print out each name - GET RID OF THIS
//            System.out.println(name);
            
            // Add each name to myList here
            // IMPLEMENT THIS
            myList.addToFront(name);
        }
        
        // Confirm that all names were read and added to the list
        System.out.println("Expect: size is " + 18239);
        System.out.println("Actual: size is " + myList.size());
        System.out.println();
        
        // Make sure the list contains the best name
        System.out.println("Expect: Has best name? " + true);
        System.out.println("Actual: Has best name? " + myList.contains("Tom"));
        System.out.println();

        // 1. Test countOfNamesStartingWith
        System.out.println("Expect: Number of S names is " + 1765);
        System.out.println("Actual: Number of S names is " + myList.countOfNamesStartingWith('S'));
        System.out.println();

        // 2. Test avgLettersInNamesStartingWith
        System.out.println("Expect: Avg letters in J names is " + 6.3867986798679866);
        System.out.println("Actual: Avg letters in J names is " + myList.avgLettersInNamesStartingWith('J'));
        System.out.println();
    
        // 3. Test countOfNamesContaining
        System.out.println("Expect: Names containing E is " + 10055);
        System.out.println("Actual: Names containing E is " + myList.countOfNamesContaining('E'));
        System.out.println();
    
        // 4. Test alphabeticallyFirstName
        System.out.println("Expect: First name is " + "Aadil");
        System.out.println("Actual: First name is " + myList.alphabeticallyFirstName());
        System.out.println();
    
        // 5. Test alphabeticallyFirstNameStartingWith
        System.out.println("Expect: First C name is " + "Cabrina");
        System.out.println("Actual: First C name is " + myList.alphabeticallyFirstNameStartingWith('C'));
        System.out.println();
    
        // 6. Test alphabeticallyLastNameStartingWith
        System.out.println("Expect: Last X name is " + "Xzavier");
        System.out.println("Actual: Last X name is " + myList.alphabeticallyLastNameStartingWith('X'));
        System.out.println();
    
        // 7. Test shortestName
        System.out.println("Expect: Shortest name is " + "Ko");
        System.out.println("Actual: Shortest name is " + myList.shortestName());
        System.out.println();

        // 8. Test shortestNameStartingWith
        System.out.println("Expect: Shortest T name is " + "Tj");
        System.out.println("Actual: Shortest T name is " + myList.shortestNameStartingWith('T'));
        System.out.println();
        
        // 9. Test longestName
        System.out.println("Expect: Longest name is " + "Johnchristopher");
        System.out.println("Actual: Longest name is " + myList.longestName());
        System.out.println();
        
        // 10. Test getNthName
        int[] positions = {1000, 13455, 18239, 77, 1, 11111};
        String[] names = {"Traven", "Shondra", "name not found", "Chinda", "Pratima", "Tarrin"};
        for (int i = 0; i < positions.length; i++)
        {
            System.out.println("Expect: Name " + positions[i] + " is " + names[i]);
            System.out.println("Actual: Name " + positions[i] + " is " + myList.getNthName(positions[i]));
            System.out.println();
        }
    }
}
