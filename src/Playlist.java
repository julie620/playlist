import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Playlist{
    private AudioPlayer[] songs;
    private File[] files;
    private String[] songTitle;
    private int playlistLength;
    private String choice;

    public Playlist() 
        throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        getFileName("C:\\Users\\julia\\OneDrive\\Desktop\\Coding Projects\\CS240\\L3\\Playlist\\src\\Songs");
        songs = new AudioPlayer[playlistLength];
        for (int i = 0 ;i < playlistLength; i++) {
            songs[i] = new AudioPlayer(songTitle[i]);
        }
    }

    public void getFileName(String folderName) {
        File folder = new File(folderName);
        files = folder.listFiles();

        playlistLength = files.length;
        songTitle = new String[playlistLength];

        for (int i = 0; i < playlistLength; i++) {
            songTitle[i] = files[i].getAbsolutePath();
        }
    }

    public void playthrough() {
        try
        { 
            for (int i = 0; i < songs.length; i++) {
                AudioPlayer currentSong = songs[i]; 
                
                currentSong.play(); 
                System.out.println(files[i].getName());
                Scanner input = new Scanner(System.in); 
                
                while (currentSong.getLength() != currentSong.getPostion()) { 
                    System.out.println("1. pause"); 
                    System.out.println("2. resume"); 
                    System.out.println("3. restart"); 
                    System.out.println("4. skip"); 
                    System.out.println("5. Jump to specific time"); 
                    choice = input.nextLine();
                    int c = Integer.parseInt(choice); 
                    currentSong.gotoChoice(c); 
                    if (c == 4) {   
                        break; 
                    }
                }
            }
        }  
          
        catch (Exception ex)  
        { 
            System.out.println("Error with playing sound."); 
            ex.printStackTrace(); 
          
          } 
    }
}
