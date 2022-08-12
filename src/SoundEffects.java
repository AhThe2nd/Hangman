import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundEffects{

    public static void playCorrectAudio (){
	try{
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/correct.wav").getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	}
	catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
	    System.out.println("Audio exception occurred.");
	    exception.printStackTrace();
	    System.exit(-1);
	}
    }

    public static void playIncorrectAudio (){
	try{
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/incorrect.wav").getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	}
	catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
	    System.out.println("Audio exception occurred.");
	    exception.printStackTrace();
	    System.exit(-1);
	}
    }

    public static void playWinAudio(){
	try{
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/win_game.wav").getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	}
	catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
	    System.out.println("Audio exception occurred.");
	    exception.printStackTrace();
	    System.exit(-1);
	}
    }

    public static void playLoseAudio(){
	try{
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/lose_game.wav").getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	}
	catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
	    System.out.println("Audio exception occurred.");
	    exception.printStackTrace();
	    System.exit(-1);
	}
    }

}
