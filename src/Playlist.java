import java.io.File;
import java.io.IOException;


import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Playlist{
    private AudioPlayer[] songs;
    private File[] files;
    private String[] songTitle;
    private int playlistLength;

    public Playlist() 
        throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        getFileName("C:\\Users\\julia\\OneDrive\\Desktop\\Coding_Projects\\CS240\\L3\\Playlist\\src\\Songs");
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
        try { 
            for (int i = 0; i < songs.length; i++) {
                
                AudioPlayer currentSong = songs[i]; 

                currentSong.play(); 
                System.out.println("Current Song: " + files[i].getName());

                while (currentSong.getLength() != currentSong.getPostion()) {
                    int c = currentSong.getChoice();
                    currentSong.gotoChoice(c);
                    if (c == 4) { 
                        //sets up index to play previous song
                        i -= 2;  
                        break; 
                    } else if(c == 5) {
                        break;
                    }
                }  
            }
        } catch (Exception ex)  { 
            System.out.println("Error with playing sound."); 
            ex.printStackTrace(); 
        } 
    }
}
