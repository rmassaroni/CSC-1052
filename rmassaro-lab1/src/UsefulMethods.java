import java.util.Arrays;

public class UsefulMethods {
	public static void main(String[] args) {
		int[] maxTest = {4, 3, 5, 10, 12, 5, 6};
		System.out.println(arrayMax(maxTest));
		
		int[] halfTest1 = {1, 2, 3, 4, 5, 6};
		System.out.println(Arrays.toString(arrayHalf(halfTest1)));
		
		int[] halfTest2 = {1, 2, 3, 4, 5, 6, 7};
		System.out.println(Arrays.toString(arrayHalf(halfTest2)));
		
		String pig1 = "pig";
		System.out.println(pigify(pig1));
		
		String pig2 = "broom";
		System.out.println(pigify(pig2));
		
		String pig3 = "apple";
		System.out.println(pigify(pig3));
	}
	
	static int arrayMax(int[] arr) {
		int max = arr[0];
		
		for(int num : arr) {
			if(num > max) {
				max = num;
			}
		}
		
		return max;
	}
	
	static int[] arrayHalf(int[] arr) {
		int length = arr.length/2;
		if(arr.length % 2 > 0) {
			length++;
		}
		
		int[] newArray = new int[length];
		
		for(int i = 0; i < length; i++) {
			newArray[i] = arr[i];
		}
		
		return newArray;
	}
	
	static String pigify(String word) {
		int vowelIndex = 0;
		char currentLetter = word.charAt(0);
		boolean searching = true;
		while(searching && vowelIndex < word.length()) {
			currentLetter = word.charAt(vowelIndex);
			if(currentLetter == 'a' || currentLetter == 'e' || currentLetter == 'i' || currentLetter == 'o' || currentLetter == 'u') {
				searching = false;
			}
			else {
				vowelIndex++;
			}
		}
		
		
		
		String newWord = word.substring(vowelIndex);
		
		if(vowelIndex != 0) {
			newWord += "ay";
		}
		else {
			newWord += "yay";
		}
		
		return newWord;
	}
}
