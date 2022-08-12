import java.util.*;

public class Game {
    public static void main(String[] args) {

	// Start background music
	BackgroundMusic.playBGM();

	Scanner scanner = new Scanner(System.in);
	ArrayList<String> usedWords = new ArrayList<>();
	ArrayList<String> guessedLetters = new ArrayList<>();

	// Game logic
	    //MAIN LOOP
	    while (true){
		// print welcome message
		System.out.println("Welcome to hangman!");

		// Reset some initial variables
		int strikes = 0;
		boolean goodGuess = false;
		boolean uniqueGuess = false;
		guessedLetters.clear();

		// Get player to select a difficulty
		Display.printMenu();
		int difficulty = scanner.nextInt();
		String word = Word.getWord(difficulty, usedWords).trim();

		// Print word for debugging help
		// System.out.println("Word chosen: " + word);

		// Display progress
		String[] wordArray = word.split("");
		String[] progressArray = "_".repeat(Math.max(0, word.length())).split("");

		// SUB LOOP
		while (true){
		    // Loop to keep guessing

		    // Print blanks showing progress
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
			    progressArray[i] = guess;
			    goodGuess = true;
			    SoundEffects.playCorrectAudio();
			}
			else if (guess.equals(wordArray[i]) && !uniqueGuess){
			    goodGuess =true;
			}
		    }

		    // Create a list to check for remaining _ characters
		    List<String> progressList = Arrays.asList(progressArray);

		    if (goodGuess && uniqueGuess && !progressList.contains("_")){
			System.out.println("You win!" + " The word was: " + word);
			SoundEffects.playWinAudio();

			StringBuilder guessedLettersString = new StringBuilder();
			guessedLettersString.append("Guessed letters: ");

			for (String letter : guessedLetters){
			    guessedLettersString.append(letter);
			}

			System.out.println(guessedLettersString);

			String choice = Display.playAgain();
			if (choice.equals("1")){
			    break;
			}
			else if (choice.equals("0")){
			    Display.quitGame();
			}
		    }
		    else if (!goodGuess){
			strikes++;
			Display.printHangman(strikes);
			SoundEffects.playIncorrectAudio();

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

// TO DO: Ensure user only enters valid options during menus.
// TO DO: Fix bug where if user guesses duplicate letter they still get a strike
// TO DO: Don't play incorrect sound if it's the losing guess, only the Price is Right sound
// TO DO: Clean up Scanner resources?
// TO DO: ReadME.md
