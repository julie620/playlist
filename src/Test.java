import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Test {
    public static void main(String[] args) 
        throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Playlist myPlaylist = new Playlist();
        myPlaylist.playthrough();
    }
}