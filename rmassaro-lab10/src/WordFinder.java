import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Class that finds sets of words that exhibit various characteristics,
 * such as length, first letter, and double-letters. A java.util.HashSet
 * should be used when a set is needed.
 * 
 * @author Robert Massaroni
 *
 */
public class WordFinder {
	/**
	 * Returns a set of all words from the original set of the corresponding length.
	 * @param words set of words
	 * @param length length of words to include
	 * @return set of words of the right length
	 */
	public Set<String> wordsOfLength(Set<String> words, int length) {
		
		//For an extra challenge, I put a lot of time into learning how to compress these methods into one line of code.
		//NOTES & EXPERIMENTS
//		Set<String> set = new HashSet<String>();
//		words.forEach((s) -> set.add(s));
//		words.forEach(set::add);
//		words.forEach((s) -> {if(s.length() == length) set.add(s);}); //WORKS
//		words.forEach((String s) -> (s.length() == length) ? set.add(s) : set.add(s)); //WILL NOT WORk
//		words.stream().forEach(s -> set.add(s));
//		words.stream().forEach(set::add);
//		words.stream().forEach((s) -> {if(s.length() == length) set.add(s);}); //WORKS
//		words.stream().forEach((String s) -> (s.length() == length) ? set.add(s) : set.add(s)); //WILL NOT WORK
//		//Consumers and predicates
//		set = words.stream().filter((String s) -> (s.length() == length)).collect(Collectors.toSet()); //WORKS
//		words.forEach(s -> set.add(s.length() == length ? s : null)); //WORKS
		
		return words.stream().filter(s -> (s.length() == length)).collect(Collectors.toSet());
	}
	
	/**
	 * Returns a set of words from the original set starting with the specified,
	 * letter. The case of the letter should be ignored.
	 * @param words set of words
	 * @param letter first letter of words to include
	 * @return set of words starting with certain letter
	 */
	public Set<String> wordsStartingWithLetter(Set<String> words, char letter) {
		
//		//ALSO WORKS
//		Set<String> set = new HashSet<String>();
//		words.stream().forEach(s -> {if(s.toLowerCase().startsWith(String.valueOf(letter).toLowerCase())) set.add(s);});
//		return set;
		
	    return words.stream().filter(s -> s.toLowerCase().startsWith(String.valueOf(letter).toLowerCase())).collect(Collectors.toSet());
	}
	
	/**
	 * Returns a set of words from the original set that contain a
	 * double (two in a row) of the specified letter. Ignore case.
	 * @param words set of words
	 * @param letter letter that appears twice in a row in each word
	 * @return set of words containing the specified double letter
	 */
	public Set<String> wordsContainingDoubleLetter(Set<String> words, char letter) {
		return words.stream().filter(s -> s.toLowerCase().contains(String.valueOf(letter).toLowerCase() + String.valueOf(letter).toLowerCase())).collect(Collectors.toSet());
	}
	
	/**
	 * Returns a set of all words that contain any double letters.
	 * @param words set of words
	 * @return set containing all words with double letters in them
	 */
	public Set<String> allWordsContainingDoubleLetters(Set<String> words) {
		return words.stream().filter(s -> s.matches(".*([a-zA-Z])\\1.*")).collect(Collectors.toSet());
	}
	
	/**
	 * Returns an array of all sets of words containing double letters,
	 * one set for each letter of the alphabet. There should be a set
	 * for all words containing "aa", one for "bb", etc.
	 * @param words set of words
	 * @return array of sets, one for each doubled letter in the alphabet
	 */
	@SuppressWarnings("unchecked") //Not sure how to complete this method without type warnings.
	public Set<String>[] allWordSetsContainingDoubleLetters(Set<String> words) {
		

		//WORKS
		return IntStream.rangeClosed('a', 'z').mapToObj(c -> wordsContainingDoubleLetter(words, (char) c)).toArray(Set[]::new);	
//		return IntStream.range(0, 26).mapToObj(c -> wordsContainingDoubleLetter(words, (char) ('a' + c))).toArray(Set[]::new);
		
		
		//COMPUTEIFABSENT
//		Map<String, List<String>> doubleLetterMap = new TreeMap<>();
//		words.stream().forEach(s -> {
//			for(int i = 0; i < s.length() - 1; i++)
//				if(s.charAt(i) == s.charAt(i + 1))
//					doubleLetterMap.computeIfAbsent(String.valueOf(s.charAt(i)) + s.charAt(i), k -> new ArrayList<>()).add(s);
//		});	
		
		
		//ASSUMING EMPTY ARRAYS ARE INCLUDED
		
		//WORKS
//		List<Set<String>> list = new ArrayList<Set<String>>();
//		for(char c = 'a'; c <='z'; c++)
//			list.add(wordsContainingDoubleLetter(words, c));
//		return list.toArray(new Set[0]);
////		return list.toArray(Set[]::new); //DOES NOT WORK
		
		
		//WORKS (with warning)
//		@SuppressWarnings("rawtypes")
//		Set[] sets = {wordsContainingDoubleLetter(words, 'a'), wordsContainingDoubleLetter(words, 'b'), wordsContainingDoubleLetter(words, 'c'), wordsContainingDoubleLetter(words, 'd'), wordsContainingDoubleLetter(words, 'e'), wordsContainingDoubleLetter(words, 'f'), wordsContainingDoubleLetter(words, 'g'), wordsContainingDoubleLetter(words, 'h'), wordsContainingDoubleLetter(words, 'i'), wordsContainingDoubleLetter(words, 'j'), wordsContainingDoubleLetter(words, 'k'), wordsContainingDoubleLetter(words, 'l'), wordsContainingDoubleLetter(words, 'm'), wordsContainingDoubleLetter(words, 'n'), wordsContainingDoubleLetter(words, 'o'), wordsContainingDoubleLetter(words, 'p'), wordsContainingDoubleLetter(words, 'q'), wordsContainingDoubleLetter(words, 'r'), wordsContainingDoubleLetter(words, 's'), wordsContainingDoubleLetter(words, 't'), wordsContainingDoubleLetter(words, 'u'), wordsContainingDoubleLetter(words, 'v'), wordsContainingDoubleLetter(words, 'w'), wordsContainingDoubleLetter(words, 'x'), wordsContainingDoubleLetter(words, 'y'), wordsContainingDoubleLetter(words, 'z')};
//		return sets;	
	}

	/**
	 * Returns a set containing all words with two, different double-letters.
	 * @param sets array of all double-letter sets
	 * @return set of all words containing two double-letters
	 */
	public Set<String> wordsContainingTwoDoubleLetters(Set<String>[] sets) {
		return Arrays.stream(sets).flatMap(Set::stream).collect(Collectors.groupingBy(word -> word, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() >= 2).map(Map.Entry::getKey).collect(Collectors.toSet());
	}
	
	/**
	 * Returns a set containing all words with three, different double-letters.
	 * @param sets array of all double-letter sets
	 * @return set of all words containing three double-letters
	 */
	public Set<String> wordsContainingThreeDoubleLetters(Set<String>[] sets) {
		return Arrays.stream(sets).flatMap(Set::stream).collect(Collectors.groupingBy(word -> word, Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() >= 3).map(Map.Entry::getKey).collect(Collectors.toSet());
	}
}
