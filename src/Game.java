import java.util.*;

public class Game {
    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	ArrayList<String> usedWords = new ArrayList<>();
	    // Game logic

	    //MAIN LOOP
	    while (true){
		// print welcome message
		System.out.println("Welcome to hangman!");
		int strikes = 0;
		boolean goodGuess = false;

		// Get player to select a difficulty
		Display.printMenu();
		int difficulty = scanner.nextInt();
		String word = Word.getWord(difficulty, usedWords).trim();

		// Print word for debugging help
		System.out.println("Word chosen: " + word);

		// Display progress
		String[] wordArray = word.split("");
		String[] progressArray = "*".repeat(Math.max(0, word.length())).split("");

		// SUB LOOP
		while (true){
		    // Loop to keep guessing
		    System.out.println("Word: " + Arrays.toString(progressArray));

		    // Reset good guess flag
		    goodGuess = false;
		    String guess = Display.promptGuess();

		    // Check if the guess is in the word
		    for (int i = 0; i < wordArray.length; i++){
			if (guess.equals(wordArray[i])){
			    progressArray[i] = guess;
			    goodGuess = true;
			}
		    }

		    // Create a list to check for asterisks
		    List<String> progressList = Arrays.asList(progressArray);

		    if (goodGuess && !progressList.contains("*")){
			System.out.println("You win!" + " The word was " + word);
			break;
		    }
		    else if (!goodGuess){
			strikes++;
			Display.printHangman(strikes);

			if (strikes >= 6){
			    System.out.println("You lose! Play again?");
			    // Method to play again.
			}
		    }
		}
	    }
    }
}
