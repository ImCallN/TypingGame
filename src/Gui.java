import javax.swing.*;
import java.awt.*;

//Our JFrame Class that just creates the window and populates it with the JPanel class of MyPanel
public class Gui extends JFrame
{
   public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();        //Grabs our screen dimensions
   public static MyPanel j = new MyPanel();

   public Gui()
   {
      //JFrame settings
      setSize((int)screenSize.getWidth()/2, (int)screenSize.getHeight()/2);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setResizable(false);
      setLocationRelativeTo(null);

      //Adding the content to the JFrame
      
      add(j);      
   }
}