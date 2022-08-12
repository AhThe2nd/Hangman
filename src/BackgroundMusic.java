import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BackgroundMusic {

    public static void playBGM (){
	try{
	    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("audio/bgm.wav").getAbsoluteFile());
	    Clip clip = AudioSystem.getClip();
	    clip.open(audioInputStream);
	    clip.start();
	    clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	catch (UnsupportedAudioFileException | IOException | LineUnavailableException exception){
	    System.out.println("Audio exception occurred.");
	    exception.printStackTrace();
	    System.exit(-1);
	}
    }

}
