import java.util.List;

/*
 * Automated test program to verify the SpellChecker class.
 * 
 * Do not make any permanent changes to this file.
 *
 */

public class SpellCheckerTester
{
	// Path to the dictionary file (adjust path as needed)
	private final static String DICTIONARY = "bin/word_freq_en.txt";
	
	// Some initial words to check to verify the listMisspellings method
	private final static String[] CHECK = {"one", "twoo", "three", "foor", "five", "sxx", "sevn", "eihgt", "nine", "ten"};
	
	// Lists of misspelled words and the expected suggestions for each
	private final static String[] WORDS = {"absense", "abacus", "accross", "colender", "cap",
			"florescent", "fourty", "grammer", "greeting", "interupt", "ocasion",
			"persistant", "recieve", "religous", "reluctant", "supplement",
			"suprise", "tiny", "twelth", "tyme", "weird", "wich"};
	private final static String[] SUGGEST = {"[absence]", "[across]", "[calender, colander]",
			"[fluorescent]", "[fourth, forty]", "[grammar, grammes, gramme]", "[interrupt]", "[occasion]",
			"[persistent]", "[relieve]", "[religious]",
			"[surprise, sunrise]", "[twelfth]", "[time, type, tame]", "[with, which, wish]"};
	
	public static void main(String[] args)
	{
		System.out.println("===== SpellCheckerTester =====");
		SpellChecker checker = new SpellChecker(DICTIONARY);
		
		// Make sure the dictionary fully loaded
		System.out.println("Dictionary size expect: " + 97565);
		System.out.println("Dictionary size actual: " + checker.size());
		System.out.println();
		
		// Make sure the edit distance method works correctly (it should)
		System.out.println("Edit distance \"werd\" to \"word\" expect: " + 1);
		System.out.println("Edit distance \"werd\" to \"word\" actual: " + checker.editDistance("werd", "word"));
		System.out.println("Edit distance \"wierd\" to \"weird\" expect: " + 2);
		System.out.println("Edit distance \"wierd\" to \"weird\" actual: " + checker.editDistance("wierd", "weird"));
		System.out.println("Edit distance \"wooder\" to \"water\" expect: " + 3);
		System.out.println("Edit distance \"wooder\" to \"water\" actual: " + checker.editDistance("wooder", "water"));
		System.out.println("Edit distance \"monday\" to \"tuesday\" expect: " + 4);
		System.out.println("Edit distance \"monday\" to \"tuesday\" actual: " + checker.editDistance("monday", "tuesday"));
		System.out.println("Edit distance \"monday\" to \"wednesday\" expect: " + 5);
		System.out.println("Edit distance \"monday\" to \"wednesday\" actual: " + checker.editDistance("monday", "wednesday"));
		System.out.println("Edit distance \"wazzup\" to \"what is up\" expect: " + 6);
		System.out.println("Edit distance \"wazzup\" to \"what is up\" expect: " + checker.editDistance("wazzup", "what is up"));
		System.out.println();
		
		// Check the listMisspellings method
		System.out.println("Misspellings found expect: " + "[twoo, foor, sxx, sevn, eihgt]");
		System.out.println("Misspellings found actual: " + checker.listMisspellings(CHECK));
		System.out.println();
		
		// Initial check of makeSuggestions method
		System.out.println("Suggestions for \"helpo\" expect: " + "[help, helps, hello]");
		System.out.println("Suggestions for \"helpo\" actual: " + checker.makeSuggestions("helpo"));
		System.out.println();
		
		// Check the getFrequencyForWord method
		System.out.println("Frequencies for suggestions should be in descending order:");
		System.out.println("Frequency for \"help\" expect: " + 199252187);
		System.out.println("Frequency for \"help\" actual: " + checker.getFrequencyForWord("help"));
		System.out.println("Frequency for \"helps\" expect: " + 21796407);
		System.out.println("Frequency for \"helps\" actual: " + checker.getFrequencyForWord("helps"));
		System.out.println("Frequency for \"hello\" expect: " + 5614899);
		System.out.println("Frequency for \"hello\" actual: " + checker.getFrequencyForWord("hello"));
		System.out.println();
		
		// Check the listMisspellings method
		List<String> misspellings = checker.listMisspellings(WORDS);
		System.out.println("Misspellings found in word list expect: " + 13);
		System.out.println("Misspellings found in word list actual: " + misspellings.size());
		System.out.println();
		
		// Check the makeSuggestions method with default edit distance and total suggestions
		System.out.println("Up to 3 suggestions for misspelled words using max edit distance of 1:");
		for (int i = 0; i < misspellings.size(); i++)
		{
			String badword = misspellings.get(i);
			System.out.println("Suggestions for \"" + badword + "\" expect: " + SUGGEST[i]);
			System.out.println("Suggestions for \"" + badword + "\" actual: " + checker.makeSuggestions(badword));
		}
		System.out.println();
		
		// Check the makeSuggestions method with edit distance of 2 and up to 3 total suggestions (the default)
		System.out.println("Up to 3 suggestions for misspelled words using max edit distance of 2:");
		checker.setMaxEditDistance(2);
		System.out.println("Suggestions for \"epelhant\" expect: " + "[elephant, repellant]");
		System.out.println("Suggestions for \"epelhant\" actual: " + checker.makeSuggestions("epelhant"));
		System.out.println();

		System.out.println("Up to 7 suggestions for misspelled words using max edit distance of 3:");
		checker.setTotalSuggestions(7);
		checker.setMaxEditDistance(3);
		System.out.println("Suggestions for \"epelhant\" expect: " + "[plant, peasant, elegant, elephant, elephants, appellant, pendant]");
		System.out.println("Suggestions for \"epelhant\" actual: " + checker.makeSuggestions("epelhant"));
	}

}
