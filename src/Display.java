import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Scanner;

public class Display {

    // This method gets the gallows ASCII art, splits it into sections and stores it in an array

    public static String[] getGallowsTextArray(){
	Path path = Path.of("gallows.txt");
	String[] gallowsArray = new String[]{};

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

    // This method will print the Main Menu
    public static void printHangman(int strikes){
	System.out.println(getGallowsTextArray()[strikes]);
    }

    //Print menu method
    public static void printMenu(){
	System.out.println("Select a difficulty:");
	System.out.println("1 - Easy    [3-4 letter words]");
	System.out.println("2 - Medium  [5-6 letter words]");
	System.out.println("3 - Hard    [7-8 letter words]" );
	System.out.println("0 - Quit");
    }

    //Prompt user for guess
    public static String promptGuess(){

	String guess;
	String allowedValues = "abcdefghijklmnopqrstuvwxyz";

	while (true){
	    System.out.println("Guess a letter: ");
	    Scanner scanner = new Scanner(System.in);

	    // Add code to ensure user guesses only alphabetical characters
	    // Make sure they are cast to lower case

	    guess = scanner.next();

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

    public static String playAgain(){
	System.out.println("Would you like to play again?");
	System.out.println("1 - Play again!");
	System.out.println("0 - Quit");
	Scanner scanner = new Scanner(System.in);
	return scanner.nextLine();

    }

    public static void quitGame(){
	System.out.println("Thanks for playing!");
	System.exit(0);
    }
}
