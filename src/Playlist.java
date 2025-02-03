import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Playlist {
    private AudioPlayer[] songs = new AudioPlayer[10];

    public Playlist(String[] songTitle) 
        throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        for (int i = 0;i < 10; i++) {
            songs[i] = new AudioPlayer(songTitle[i]);
        }
    }
}
