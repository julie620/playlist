import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Test {
    public static void main(String[] args) 
        throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        //runs python script to convert any MP3 files to WAV
        String command ="py C:\\Users\\julia\\OneDrive\\Desktop\\Coding_Projects\\CS240\\L3\\Playlist\\src\\mp3Convert.py";
        Process process = Runtime.getRuntime().exec(command);

        InputStreamReader reader = new InputStreamReader((process.getInputStream()));
        BufferedReader buffer = new BufferedReader((reader));
        String line;
        while ((line = buffer.readLine()) != null) {
            System.out.println(line);
        }
        buffer.close();
        reader.close();
    
        Playlist myPlaylist = new Playlist();
        myPlaylist.playthrough();
    
    }
}

