import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	switch(strikes){
	    case 0:
		System.out.println(getGallowsTextArray()[0]);
		break;
	    case 1:
		System.out.println(getGallowsTextArray()[1]);
		break;
	    case 2:
		System.out.println(getGallowsTextArray()[2]);
		break;
	    case 3:
		System.out.println(getGallowsTextArray()[3]);
		break;
	    case 4:
		System.out.println(getGallowsTextArray()[4]);
		break;
	    case 5:
		System.out.println(getGallowsTextArray()[5]);
		break;
	    case 6:
		System.out.println(getGallowsTextArray()[6]);
		break;
	    default:
		System.out.println("Unknown error. Default value reached in switch statement");
		break;
	}
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
