import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;

/**
 * This class is used to get random words from the word list files
 * included with the game. Words can be easy, medium, or hard
 * depending on their length.
 * @author Andrew Howell
 */

public class Word {

    /**
     * This method finalizes the process of selecting a random word, based on difficulty, that hasn't been
     * used yet during this session. It leverages selectRandomWord() to accomplish this.
     * @param difficulty The difficulty setting string chosen by the player
     * @param usedWords An ArrayList containing the words that have already been chosen during this session
     * @return A string containing a random word from the word lists based on difficulty and if it's been used before
     * */
    public static String getWord(String difficulty, ArrayList<String> usedWords){
	String word = "";
	Path textFile = null;
	boolean goodChoice = false;   // Used to check if player has chosen a valid menu option

	// This switch statement chooses a word list based on the difficulty entered by the player
	switch(difficulty){
	    case "1":
		textFile = Path.of("easy_words.txt");
		goodChoice = true;
		break;
	    case "2":
		textFile = Path.of("medium_words.txt");
		goodChoice = true;
		break;
	    case "3":
		textFile = Path.of("hard_words.txt");
		goodChoice = true;
		break;
	    case "0":
		Display.quitGame();
	    default:
		System.out.println(difficulty + " is not a valid option, please try again.");
	}

	/*
	If the user has entered a valid menu option, the program will split the appropriate difficulty
	word list by newline characters and select one from the array at random
	 */
	if (goodChoice){
	    try{
		String allWords = Files.readString(textFile);
		String[] allWordsArray = allWords.split("\n");
		word = selectRandomWord(allWordsArray, usedWords);
	    }
	    catch (IOException ioe){
		ioe.printStackTrace();
	    }
	    catch (Exception e){
		System.out.println("General exception occurred");
		e.printStackTrace();
	    }
	}
	return word;
    }

    /**
     * This method will pick a random word from an array of words and ensure it is not
     * included in an ArrayList of used words. This method is called from getWord()
     * to finalize the word selection process
     * @param words A string array containing all the possible words
     * @param usedWords A list of all words that have been used in this session
     * @return A random word from the word lists
     * */
    public static String selectRandomWord(String[] words, ArrayList<String> usedWords){
	String randomWord;
	while (true){
	    // Select a random word
	    Random rand = new Random();
	    randomWord = words[rand.nextInt(words.length - 1)];

	    // Only proceed if it isn't in the list already
	    if (!usedWords.contains(randomWord)){
		usedWords.add(randomWord);
		break;
	    }
	}
	return randomWord;
    }
}
