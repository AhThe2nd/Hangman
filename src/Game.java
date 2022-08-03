public class Game {
    public static void main(String[] args) {
	System.out.println("Welcome to Hangman!");
	printMenu();
    }

    //Print menu method
    public static void printMenu(){
	System.out.println("Select a difficulty:");
	System.out.println("1 - Easy    [3-4 letter words]");
	System.out.println("2 - Medium  [5-6 letter words]");
	System.out.println("3 - Hard    [7-8 letter words]" );
	System.out.println("0 - Quit");
    }
}
