import java.io.IOException;
import javax.sound.sampled.*;
import java.io.File;


//Class to play audio on an action
public class MyAudio 
{
    Clip clip;
    AudioInputStream audioInputStream;
    String audioFilePath = "./src/AudioFiles/blap.wav";


    //creates the objects for the audio file to be played
    public MyAudio() 
    {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(audioFilePath).getAbsoluteFile());
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            clip.open(audioInputStream);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Plays the audio file 
    public void play()
    {
        //Sets the position back to the beginning
        clip.setFramePosition(0);

        //check to see if the clip is already playing
        if(!clip.isRunning())
        {
            //clip is not running then this block runs
            clip.start();
        }
        else
        {
            //clip is running this block runs, stops the current audio, resets to 0, and plays audio
            clip.stop();
            clip.setFramePosition(0);
            clip.start();
        }
    }
}
