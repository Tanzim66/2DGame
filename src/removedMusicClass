import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JOptionPane;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
@SuppressWarnings("restriction")
public class Music {
	InputStream music;
	
	AudioStream audios;
	
	public void musicPlay() {		
			try {
				music = new FileInputStream(new File("C:\\Users\\tanzi\\eclipse-workspace\\ICS Game\\song.wav"));
				audios = new AudioStream(music);
				AudioPlayer.player.start(audios);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR");
			}
        }
	public void musicStop() {
        	try {
				AudioPlayer.player.stop(audios);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "ERROR");
			}
	}
}
