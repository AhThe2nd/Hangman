import java.util.*;

public class Game {
    public static void main(String[] args) {
	/**
	 * This is the main method of the program. All game flow logic can be found here.
	 */

	// Start background music
	BackgroundMusic.playBGM();

	// Declare array lists that will store used words and guessed letters
	ArrayList<String> usedWords = new ArrayList<>();
	ArrayList<String> guessedLetters = new ArrayList<>();

	// Game logic
	    //MAIN LOOP
	    while (true){
		System.out.println("Welcome to hangman!");

		// Reset some initial variables
		int strikes = 0;
		boolean goodGuess = false;      // This flag is true if the letter is in the word
		boolean uniqueGuess = false;    // This flag is true if the letter has not been guessed before
		guessedLetters.clear();

		// Get player to select a difficulty
		String difficulty = Display.printMenu();
		String word = Word.getWord(difficulty, usedWords).trim();

		// Uncomment to print word for debugging help
		// System.out.println("Word chosen: " + word);

		// Display progress
		String[] wordArray = word.split("");
		String[] progressArray = "_".repeat(Math.max(0, word.length())).split("");

		// SUB LOOP (This loop runs as the user is guessing letters)
		while (true){
		    // Print blanks showing progress using the progressArray from line 33
		    StringBuilder stringBuilder = new StringBuilder();
		    stringBuilder.append("Word: ");

		    for (String letter : progressArray){
			stringBuilder.append(letter).append("   ");
		    }
		    System.out.println(stringBuilder);

		    // Reset good guess and unique guess flags
		    goodGuess = false;
		    uniqueGuess = false;

		    // Prompt the user to guess a letter
		    String guess = Display.promptGuess();

		    // Check if letter has been used before
		    if (guessedLetters.contains(guess)){
			System.out.println("You already guessed that. Guess a new letter!");
		    }
		    else{
			guessedLetters.add(guess);
			uniqueGuess = true;
		    }

		    // Check if the guess is in the word
		    for (int i = 0; i < wordArray.length; i++){
			if (guess.equals(wordArray[i]) && uniqueGuess){

			    // Fill in correct letters in progress array
			    progressArray[i] = guess;
			    goodGuess = true;
			    SoundEffects.playCorrectAudio();
			}
			else if (guess.equals(wordArray[i]) && !uniqueGuess){
			    goodGuess = true;
			}
		    }

		    // Create a list to check for remaining _ characters
		    List<String> progressList = Arrays.asList(progressArray);

		    /*
		    If the guess is good, unique, and there are no more _ characters in
		    the progressArray, then we have met the win condition.
		     */
		    if (goodGuess && uniqueGuess && !progressList.contains("_")){
			System.out.println("You win!" + " The word was: " + word);
			SoundEffects.playWinAudio();

			// Display the letters that have been guessed.
			StringBuilder guessedLettersString = new StringBuilder();
			guessedLettersString.append("Guessed letters: ");

			for (String letter : guessedLetters){
			    guessedLettersString.append(letter).append("   ");
			}
			System.out.println(guessedLettersString);

			// Ask the player to play again or quit
			String choice = Display.playAgain();
			if (choice.equals("1")){
			    break;
			}
			else if (choice.equals("0")){
			    Display.quitGame();
			}
		    }

		    // Increase the number of strikes if it is not a good guess
		    else if (!goodGuess){
			strikes++;
			Display.printHangman(strikes);
			SoundEffects.playIncorrectAudio();

			// If the strikes ever become equal to, or greater than, 6, we have met the Lost condition
			if (strikes >= 6){
			    System.out.println("You lose! The word was: " + word);
			    SoundEffects.playLoseAudio();
			    String choice = Display.playAgain();
			    if (choice.equals("1")){
				break;
			    }
			    else if (choice.equals("0")){
				Display.quitGame();
			    }
			    break;
			}
		    }
		}
	    }
    }
}
