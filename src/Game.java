import java.util.*;


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
	    String[] wordArray = word.split("");
	    String[] progressArray = "*".repeat(Math.max(0, word.length())).split("");

	    // Print both arrays
	    System.out.println("Word chosen as array: " + Arrays.toString(wordArray));
	    System.out.println("Progress as array: " + Arrays.toString(progressArray));


	    // Get a guess from a player
	    String guess = Display.promptGuess();

	    // Check if the guess is in the word
	    for (int i = 0; i < wordArray.length; i++){
		if (guess.equals(wordArray[i])){
		    progressArray[i] = guess;
		}
	    }
	    System.out.println(Arrays.toString(progressArray));



	}
    }
}
