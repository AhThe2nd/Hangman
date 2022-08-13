import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * This class is used to play background music while the game is running.
 * Currently, there is only one song, and it is set to loop.
 * @author Andrew Howell
 */

public class BackgroundMusic {
    /**
     * This method plays some background music on a continuous loop from the time
     * the program starts until it is terminated.
     * */
    public static void playBGM (){
	try{
	    // Use an AudioInputStream to specify the correct file to play
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/bgm.wav").getAbsoluteFile());

	    // Store the audio file in a Clip object
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);

	    // Play the audio
	    clip.start();

	    // Loop the audio forever
	    clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
	    System.out.println("Audio exception occurred.");
	    exception.printStackTrace();
	    System.exit(-1);
	}
    }

}
