import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * This class is used to play sound effects when different things
 * happen in the game. There are separate sound effects for...
 *  - A correct letter was guessed
 *  - An incorrect letter was guessed
 *  - Win condition has been met
 *  - Lose condition has been met
 * @author Andrew Howell
 */

public class SoundEffects{
    /**
     * This method plays an audio clip when a correct letter has been guessed
     * */
    public static void playCorrectAudio (){
	try{
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/correct.wav").getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	    audioInputStream.close();
	}
	catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
	    System.out.println("Audio exception occurred.");
	    exception.printStackTrace();
	    System.exit(-1);
	}
    }

    public static void playIncorrectAudio (){
	/**
	 * This method plays an audio clip when an incorrect letter has been guessed
	 * */
	try{
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/incorrect.wav").getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	    audioInputStream.close();
	}
	catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
	    System.out.println("Audio exception occurred.");
	    exception.printStackTrace();
	    System.exit(-1);
	}
    }

    public static void playWinAudio(){
	/**
	 * This method plays an audio clip when the win condition has been met
	 * */
	try{
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/win_game.wav").getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	    audioInputStream.close();
	}
	catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
	    System.out.println("Audio exception occurred.");
	    exception.printStackTrace();
	    System.exit(-1);
	}
    }

    public static void playLoseAudio(){
	/**
	 * This method plays an audio clip when the lose condition has been met
	 * */
	try{
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/lose_game.wav").getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	    audioInputStream.close();
	}
	catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
	    System.out.println("Audio exception occurred.");
	    exception.printStackTrace();
	    System.exit(-1);
	}
    }

}
