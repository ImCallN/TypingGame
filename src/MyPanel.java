import javax.swing.*;
import java.awt.*;


public class MyPanel extends JPanel 
{
    
    public static JTextArea userInputDisplay;                                               //The textarea where the user's input will be displayed, but only if it is correct
    public static JLabel complete;                                                          //Label to pop up on screen when you complete the sentence correctly
    public static JButton retry = new JButton("Retry?");
    private MyKeyListener customListener = new MyKeyListener();                             //Our custom KeyListener class that we made 
    private ImageIcon background = new ImageIcon("./src/Images/background2.jpeg");        //Image for our background
    private Image backgroundImage = background.getImage();
    private GridLayout gridLayout = new GridLayout(0,1);
    //Constructor
    public MyPanel() 
    {
        //Settings of the Panel
        setVisible(true);  
        setFocusable(true);

        //Adding a gridLayout
        setLayout(gridLayout);

        //Sentence JLabel Settings
        JLabel sentence = new JLabel(customListener.getMainString());
        sentence.setForeground(Color.GREEN);
        sentence.setFont(new Font("Times New Roman", Font.BOLD, 20));

        //Complete JLabel
        complete = new JLabel();
        complete.setVisible(false);
        complete.setFont(new Font("Times New Roman", Font.BOLD, 20));
        complete.setForeground(Color.PINK);

        //TextArea Settings
        userInputDisplay = new JTextArea();
        userInputDisplay.setBounds(20,20,50,10);
        userInputDisplay.setOpaque(false);
        userInputDisplay.setForeground(Color.black);
        userInputDisplay.setEditable(false);
        userInputDisplay.setFont(new Font("Times New Roman", Font.BOLD, 20));

        //Retry Button settings
        retry.setVisible(false);
        retry.addActionListener(new MyActionListener());

        //Second Layout

        //Adding all components to JPanel
        add(sentence, CENTER_ALIGNMENT);
        add(complete, CENTER_ALIGNMENT);
        add(userInputDisplay);
        add(retry);
        addKeyListener(customListener);
    }

    //Deals with the background Image
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }


    //Static methods to access the JTextArea in our JPanel from our KeyListener class
    public static void updateJTextArea(String string)
    {
        userInputDisplay.append(string);
    }

    public static void updateJLabel(String string)
    {
        complete.setText(string);
        complete.setVisible(true);
    } 

    public static void revealButton()
    {
        retry.setVisible(true);
    }
}