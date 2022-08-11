import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.HashMap;

public class Word {

    // Method to select a random word based on chosen difficulty.
    // Place word in a list
    // Only choose a word if it isn't already in the list

    public static String getWord(int difficulty, ArrayList<String> usedWords){
	String word = "";
	Path textFile = null;
	boolean goodChoice = false;

	switch(difficulty){
	    case 1:
		textFile = Path.of("easy_words.txt");
		goodChoice = true;
		break;
	    case 2:
		textFile = Path.of("medium_words.txt");
		goodChoice = true;
		break;
	    case 3:
		textFile = Path.of("hard_words.txt");
		goodChoice = true;
		break;
	    case 0:
		System.out.println("Goodbye. Thanks for playing!");
		System.exit(0);
	    default:
		System.out.println(difficulty + " is not a valid option, please try again.");
	}

	if (goodChoice){
	    try{
		String allWords = Files.readString(textFile);
		String[] allWordsArray = allWords.split("\n");
		word = selectRandomWord(allWordsArray, usedWords);
	    }
	    catch (IOException ioe){
		ioe.printStackTrace();
	    }
	}
	return word;
    }

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
