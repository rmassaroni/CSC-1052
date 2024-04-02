import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordFinderTester
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// Uncomment this line if needed to help find path to words.txt file
		//System.out.println("The path for the words.txt file is relative to this: " + System.getProperty("user.dir"));

		// Create a scanner to read from the file of words.
		// You may need to modify the path for the file.
		Scanner scan = new Scanner(new File("bin/words.txt"));

		// Read the words from the file
		Set<String> words = new HashSet<String>();
		while (scan.hasNextLine())
		{
			words.add(scan.nextLine());
		}
		System.out.println("Expect total words: " + 61336);
		System.out.println("Actual total words: " + words.size());
		
		// Declare the WordFinder object
		WordFinder finder = new WordFinder();
		
		// How many 4 letter words?
		Set<String> fourLetterWords = finder.wordsOfLength(words, 4);
		System.out.println("Expect 4-letter words: " + 2343);
		System.out.println("Actual 4-letter words: " + fourLetterWords.size());

		// What are 21 letter words?
		Set<String> twentyOneLetterWords = finder.wordsOfLength(words, 21);
		System.out.println("Expect 21-letter words: " + "[disestablishmentarian, disproportionableness]");
		System.out.println("Actual 21-letter words: " + twentyOneLetterWords);
		
		// How many words starting with Z?
		Set<String> zWords = finder.wordsStartingWithLetter(words, 'Z');
		System.out.println("Expect Z words: " + 94);
		System.out.println("Actual Z words: " + zWords.size());		

		// How many words contain double-L?
		Set<String> doubleAWords = finder.wordsContainingDoubleLetter(words, 'A');
		System.out.println("Expect double-A words: " + 13);
		System.out.println("Actual double-A words: " + doubleAWords.size());				
		
		// How many words contain double-letters?
		Set<String> doubleLetterWords = finder.allWordsContainingDoubleLetters(words);
		System.out.println("Expect double-letter words: " + 14010);
		System.out.println("Actual double-letter words: " + doubleLetterWords.size());
		
		// Get all sets of double letters by letter
		Set<String>[] allDoubles = finder.allWordSetsContainingDoubleLetters(words);
		System.out.println("Expect double letter sets: " + 26);
		System.out.println("Actual double letter sets: " + allDoubles.length);
		
		// How many words contain two different double-letters?
		Set<String> diffDoubleLetterWords = finder.wordsContainingTwoDoubleLetters(allDoubles);
		System.out.println("Expect two diff double-letters words: " + 670);
		System.out.println("Actual two diff double-letters words: " + diffDoubleLetterWords.size());
		
		// What are 6-letter long words with two double-letters?
		Set<String> sixDoubleDoubles = finder.wordsOfLength(diffDoubleLetterWords, 6);
		System.out.println("Expect six letter double doubles: " + 15 + " [puttee, woolly, access, appall, xxviii, toffee, lessee, settee, tattoo, coolly, coffee, halloo, bootee, tippee, abbess]");
		System.out.println("Actual six letter double doubles: " + sixDoubleDoubles.size() + " " + sixDoubleDoubles);
		
		// How many words contain three different double-letters?
		Set<String> tripleDoubleLetterWords = finder.wordsContainingThreeDoubleLetters(allDoubles);
		System.out.println("Expect three diff double-letters words: " + 24);
		System.out.println("Actual three diff double-letters words: " + tripleDoubleLetterWords.size());
		
		// What B-words contain three different double-letters?
		Set<String> bWords = finder.wordsStartingWithLetter(words, 'B');
		bWords.retainAll(tripleDoubleLetterWords);
		System.out.println("Expect three double letter B words: " + 3 + " [bitterroot, bookkeeper, bookkeeping]");
		System.out.println("Actual three double letter B words: " + bWords.size() + " " + bWords);
	}

}
