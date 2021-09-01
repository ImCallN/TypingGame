//Timer class to keep track of how long the timer is on for and return the time
public class MyTimer
{
    private long startTime;
    private long endTime;

    public MyTimer()
    {
    }

    //method to get the time at the start
    public void startTimer()
    {
        startTime = System.currentTimeMillis();
    }

    //method to get the time at the end
    public void endTimer()
    {
        endTime = System.currentTimeMillis();
    }

    //total time that it took is endTime - startTime, and then divide by 1000 to convert to seconds
    public long getTime()
    {
        return (endTime - startTime)/1000;
    }
}