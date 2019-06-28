import java.util.Scanner;

public class PigLatin {

	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {

		run();
		System.exit(0);

	} /* End of main. */

	public static void run() {

		boolean userWannaContinue;
		do {
			/* Enter the number of sides for a pair of dice */
			String[] wordTobePigLatined = getUserInput();

			/* Pig Latin Translation */
			// pigLatin(wordTobePigLatined.toLowerCase());
			for (String stringItem : wordTobePigLatined)
				pigLatin(stringItem);
			/* user wants to go on? */
			userWannaContinue = getUserChoice();

		} while (userWannaContinue);
		System.out.println("Exiting...!");
	}

	public static String[] getUserInput() {
		String userWord;
		System.out.println("\nPlease enter a word to pig latin translate:");
		userWord = scnr.nextLine();
		assert (!userWord.isEmpty()) : "Error! Input Not Vaild. Try again";

		String[] arrOfStr = userWord.split(" ");

		return arrOfStr;

	}

	public static void pigLatin(String userWord) {

		char firstLetter = userWord.charAt(0);
		if (firstLetter == 'a' || firstLetter == 'A' || firstLetter == 'e' || firstLetter == 'E' || firstLetter == 'i'
				|| firstLetter == 'I' || firstLetter == 'o' || firstLetter == 'O' || firstLetter == 'u'
				|| firstLetter == 'U') {
			// System.out.println("This word starts with a vowel");
			System.out.println(userWord + "way");
		} else {
			int index = getIndexOfFirstVowel(userWord);
			if (index == -1) {
				System.out.println(userWord + "  ...no translation");
			} else {
				// System.out.println("This word starts with a consonant");
				String WordBeforeVowel = userWord.substring(0, index);
				String WordAfterVowel = userWord.substring(index);
				System.out.println(WordAfterVowel + WordBeforeVowel + "ay");
			}
		}
	}

	public static boolean getUserChoice() {
		System.out.println("Translate another word? (y/n)");
		char userChoice = scnr.next().charAt(0);
		scnr.nextLine();

		if (userChoice == 'y' || userChoice == 'Y') {
			return true;
		} else {
			return false;
		}

	}

	public static int getIndexOfFirstVowel(String userWord) {

		final String vowelDelimiters = "aeiouAEIOU";
		final String numbersDelimiters = "1234567890";
		final String symbolsDelimiters = "!@#$%^&*()+=~";

		for (int index = 0; index < userWord.length(); index++) {
			if (numbersDelimiters.contains(String.valueOf(userWord.charAt(index)))) {
				return -1;
			}
		}
		for (int index = 0; index < userWord.length(); index++) {
			if (symbolsDelimiters.contains(String.valueOf(userWord.charAt(index)))) {

				return -1;
			}
		}
		for (int index = 0; index < userWord.length(); index++) {
			if (vowelDelimiters.contains(String.valueOf(userWord.charAt(index)))) {
				return index;
			}
		}
		return -1;
	}

}
