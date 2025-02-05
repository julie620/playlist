/***************************************************************************************
*    Title: How to play an Audio file using Java
*    Author: Garg, V
*    Date: 2022
*    Code version: unknown
*    Availability: https://www.geeksforgeeks.org/play-audio-file-using-java/
*
***************************************************************************************/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
    Long currentFrame;
    Clip clip;

    String status;
    
    AudioInputStream audioInputStream;
    private String filePath;

    public AudioPlayer(String filePath)
        throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        this.filePath = filePath;

        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

        clip = AudioSystem.getClip();

        clip.open(audioInputStream);
    }

    public void gotoChoice(int c) 
            throws IOException, LineUnavailableException, UnsupportedAudioFileException { 
        switch (c) { 
            case 1: 
                pause(); 
                break; 
            case 2: 
                resumeAudio(); 
                break; 
            case 3: 
                restart(); 
                break; 
            case 4:
                skip(); //added previous option
                break;
            case 5: 
                skip(); 
                break; 
            case 6: 
                System.out.println("Enter time (" + 0 +  
                ", " + clip.getMicrosecondLength() + ")"); 
                Scanner sc = new Scanner(System.in); 
                long c1 = sc.nextLong(); 
                jump(c1); 
                break; 
        } 
    } 

    public void play()  
    { 
        clip.start(); 
          
        status = "play"; 
    } 
       
    public void pause()  
    { 
        if (status.equals("paused"))  
        { 
            System.out.println("audio is already paused"); 
            return; 
        } 
        this.currentFrame =  
        this.clip.getMicrosecondPosition(); 
        clip.stop(); 
        status = "paused"; 
    } 

    public void resumeAudio() 
    throws UnsupportedAudioFileException, IOException, LineUnavailableException { 
        if (status.equals("play"))  
        { 
            System.out.println("Audio is already "+ 
            "being played"); 
            return; 
        } 
        clip.close(); 
        resetAudioStream(); 
        clip.setMicrosecondPosition(currentFrame); 
        this.play(); 
    } 

    public void restart() 
    throws IOException, LineUnavailableException, UnsupportedAudioFileException { 
        clip.stop(); 
        clip.close(); 
        resetAudioStream(); 
        currentFrame = 0L; 
        clip.setMicrosecondPosition(0); 
        this.play(); 
    } 
      
    public void skip() 
        throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        if (status.equals("paused")) {
            clip.close(); 
            resetAudioStream(); 
            clip.setMicrosecondPosition(currentFrame); 
            this.play(); 
        } 
        clip.stop(); 
        clip.close(); 
        resetAudioStream(); 
        currentFrame = 0L; 
        clip.setMicrosecondPosition(0);
    } 

    public void jump(long c) 
        throws UnsupportedAudioFileException, IOException, LineUnavailableException { 
        if (c > 0 && c < clip.getMicrosecondLength())  
        { 
            clip.stop(); 
            clip.close(); 
            resetAudioStream(); 
            currentFrame = c; 
            clip.setMicrosecondPosition(c); 
            this.play(); 
        } 
    } 
      
    public void resetAudioStream() 
        throws UnsupportedAudioFileException, IOException, LineUnavailableException { 
        audioInputStream = AudioSystem.getAudioInputStream( 
        new File(filePath).getAbsoluteFile()); 
        clip.open(audioInputStream); 
    } 

/**********************************************************************************************
*    END OF CITED CODE
**********************************************************************************************/

    public int getChoice() 
        throws IOException, LineUnavailableException, UnsupportedAudioFileException{ 

        System.out.println("1. pause"); 
        System.out.println("2. resume"); 
        System.out.println("3. restart");
        System.out.println("4. previous"); 
        System.out.println("5. skip"); 
        System.out.println("6. Jump to specific time");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        return choice;
    }

    public long getPostion() {
        return clip.getMicrosecondPosition();
    }

    public long getLength() {
        return clip.getMicrosecondLength();
    }

    public String getStatus() {
        return status;
    }
}
