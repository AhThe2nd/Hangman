import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

/**
 * This class is used to print text to the screen including menus,
 * prompts, game progress, and ASCII Art of the gallows
 * @author Andrew Howell
 */


public class Display {

    /**
     * This method takes gallows.txt and splits it at the delimiter character #
     * Each string is stored in an array that represents each progressive
     * level of the hangman.
     * @return A string array of gallows ASCII art
     * */
    public static String[] getGallowsTextArray(){
	Path path = Path.of("gallows.txt");
	String[] gallowsArray = new String[]{};

	// Read the gallows.txt file to an array using a # delimiter
	try {
	    String gallows = Files.readString(path);
	    gallowsArray = gallows.split("#");
	}
	catch (IOException ex) {
	    ex.printStackTrace();
	}
	catch (Exception e){
	    System.out.println("Unknown exception occurred. Terminating.");
	    e.printStackTrace();
	    System.exit(-1);
	}
	return gallowsArray;
    }

    /**
     * This method will print the gallows ASCII art based on the number of strikes.
     * @param strikes The number of mistakes the player has made
     * */
    public static void printHangman(int strikes){
	System.out.println(getGallowsTextArray()[strikes]);
    }

    /**
     * This method displays the main menu to the user and prompts them to choose a difficulty
     * @return A string containing the choice the user made in the main menu
     * */
    public static String printMenu(){

	String choice;

	while (true){
	    System.out.println("Select a difficulty:");
	    System.out.println("1 - Easy    [3-4 letter words]");
	    System.out.println("2 - Medium  [5-6 letter words]");
	    System.out.println("3 - Hard    [7-8 letter words]" );
	    System.out.println("0 - Quit");

	    Scanner scanner = new Scanner(System.in);
	    choice = scanner.nextLine();

	    // Ensure that the choice made was a valid menu option
	    if (choice.equals("0") || choice.equals("1") || choice.equals("2") || choice.equals("3")){
		break;
	    }
	    else{
		System.out.println("Please enter a valid option!");
	    }
	}
	return choice;
    }

    /**
     * This method gets a letter stored as a string as a guess inputted by the user.
     * It will check to ensure that the user has entered a single alphabetical character
     * and will prompt them to try again if not.
     * @return A string containing the letter that the user guessed
     * */
    public static String promptGuess(){

	String guess;
	String allowedValues = "abcdefghijklmnopqrstuvwxyz";   // Used to ensure player only enters alphabetical characters

	while (true){

	    // Prompt user for a guess
	    System.out.println("Guess a letter... ");
	    Scanner scanner = new Scanner(System.in);
	    guess = scanner.next();

	    // Ensure that the guess is a single alphabetical character
	    if (guess.length() > 1){
		System.out.println("Please only enter one letter per guess!");
	    }
	    else if (!allowedValues.contains(guess.toLowerCase())){
		System.out.println("Please only enter letters!");
	    }
	    else{
		guess = guess.toLowerCase();
		break;
	    }
	}
	return guess;
    }

    /**
     * This method will take a choice from the user as input and will ensure that the user
     * only chooses a valid menu option.
     * @return A string containing the user's menu choice
     * */
    public static String playAgain(){

	String choice;

	// Prompt the user to play again or quit
	while (true){
	    System.out.println("Would you like to play again?");
	    System.out.println("1 - Play again!");
	    System.out.println("0 - Quit");
	    Scanner scanner = new Scanner(System.in);

	    choice = scanner.nextLine();

	    // Ensure that the choice is a valid menu option
	    if (choice.equals("0") || choice.equals("1")){
		break;
	    }
	    else{
		System.out.println("Please select a valid option!");
	    }
	}
	return choice;
    }

    /**
     * This method will thank the user for playing and terminate the program.
     * */
    public static void quitGame(){
	System.out.println("Thanks for playing!");
	System.exit(0);
    }
}
