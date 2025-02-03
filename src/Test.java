import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try
        { 
            String filePath = 
                "/C://Users//julia//OneDrive//Desktop//Coding Projects//CS240//L3//Playlist//src//Like to Be You.wav/"; 
            AudioPlayer audioPlayer =  new AudioPlayer(filePath); 
              
            audioPlayer.play(); 
            Scanner input = new Scanner(System.in); 
              
            while (true) 
            { 
                System.out.println("1. pause"); 
                System.out.println("2. resume"); 
                System.out.println("3. restart"); 
                System.out.println("4. stop"); 
                System.out.println("5. Jump to specific time"); 
                int c = input.nextInt(); 
                audioPlayer.gotoChoice(c); 
                if (c == 4) 
                break; 
            } 
            input.close(); 
        }  
          
        catch (Exception ex)  
        { 
            System.out.println("Error with playing sound."); 
            ex.printStackTrace(); 
          
          } 
    }
}
