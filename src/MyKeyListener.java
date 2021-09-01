import java.awt.event.*;

public class MyKeyListener implements KeyListener 
{
    private int positionCounter = 0;                                                //keeps track of which char we are are on
    private ReadFile rf = new ReadFile("./src/Sentences./TestSentences.txt");       //points at the file for where we get our sentence
    private String mainString = rf.chooseRandomLine();                              //the sentence that is returned from the above line
    private boolean start = true;                                                   //flag to start our timer
    private MyTimer customTimer = new MyTimer();                                    //Our custom Timer object
    private char passedChar;                                                        //Our char that is passed from key
    private MyAudio audioAlert = new MyAudio();                                     //Our audio player

    //Getter to return mainString
    public String getMainString()
    {
        return mainString;
    }

    //Setter for passedChar
    public void setChar(char passedChar)
    {
        this.passedChar = passedChar;
    }
    
    //Getter for the char passedChar
    public char getChar()
    {
        return passedChar;
    }

    //Overriding the interface methods here
    @Override
    //Our main method that does most of the work for the whole app
    public void keyTyped(KeyEvent e) 
    {
        if(start)
        {
            //start the timer
            customTimer.startTimer();
            start = false;
        }
    
        //Checks to make sure that we haven't gone past string length
        if(positionCounter < mainString.length())
        {
            //check the typed char against the char at the position counter
            if(e.getKeyChar() == mainString.charAt(positionCounter))    
            {
                //Send updated info to the JPanel and update the JTextArea
                MyPanel.updateJTextArea(Character.toString(e.getKeyChar()));
                positionCounter++;                                      
            }
            else audioAlert.play();
        }

        //message to display upon completion of the sentence
        if(positionCounter == mainString.length())
        {    
            //stop the timer
            customTimer.endTimer();

            //Send info to the JPanel
            int multiplier = 60 / (int)customTimer.getTime();
            MyPanel.updateJLabel("WPM: " + (positionCounter /5) * multiplier + ", Time: " + customTimer.getTime());
            //The math for the wpm is (60 / time) * (characters / 5)
            MyPanel.revealButton();

        }    
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
    
}
