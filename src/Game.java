import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	System.out.println("Welcome to Hangman!");

	while (true){
	    Display.printMenu();
	    int difficulty = scanner.nextInt();
	    String word = Word.getWord(difficulty).trim();
	    System.out.println("Word chosen: " + word);

	    // Store game word as a char array and progress as a char array
	    System.out.println(word);
	    char[] wordArray = word.toCharArray();
	    char[] progressArray = "*".repeat(Math.max(0, word.length())).toCharArray();

	    // Print both arrays
	    System.out.println("Word chosen as array: " + Arrays.toString(wordArray));
	    System.out.println("Progress as array: " + Arrays.toString(progressArray));

	    // Look into using an ArrayList<Pair> where the Pair<Character, Boolean>

	}
    }
}
