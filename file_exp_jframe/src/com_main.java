import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class com_main {

	public static void main(String[] args) {
		File file=new File("gamestartup.wav");
		Clip clip=null;
		try {
			
			AudioInputStream audiostream=AudioSystem.getAudioInputStream(file);
			clip=AudioSystem.getClip();
			clip.open(audiostream);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		clip.start();
		clip.loop(clip.LOOP_CONTINUOUSLY);
		com_welcome a=new com_welcome();

	}

}
