import java.io.*;
import java.nio.file.*;
public class ReadFile 
{
    String filename;
    long lineNum;
    Path path;
    public ReadFile(String filename)
    {
        this.filename = filename;
        lineNum = 0;
    }


    //Method to return the number of lines in a file
    private long getLines()
    {
        path = Paths.get(filename);
        try{
            lineNum = Files.lines(path).count();
        }
        catch (IOException e)
        {
            System.out.println("Could not create specified path");
        }
        return lineNum;
    }


    //Method to return a random line in our file
    public String chooseRandomLine() 
    {
        int num = getRandomNum(0, (int)getLines());
        String randomLine = "";
        try {
            randomLine = Files.readAllLines(Paths.get(filename)).get(num);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return randomLine;
    }

    //Method to generate a random number in a range
    private int getRandomNum(int min, int max)
    {
        return (int) ((Math.random() * (max - min)) + min);
    }    
}
