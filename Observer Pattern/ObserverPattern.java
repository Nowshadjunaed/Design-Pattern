/*

The Observer Pattern defines a one to many dependency between objects so that one object changes state, 
all of its dependents are notified and updated automatically.

To understand observer pattern, first you need to understand the subject and observer objects.The relation between subject and observer
can easily be understood as an analogy to magazine subscription.

    1. A magazine publisher(subject) is in the business and publishes magazines (data).
    2. If you(user of data/observer) are interested in the magazine you subscribe(register), and if a new edition is published 
       it gets delivered to you.
    3. If you unsubscribe(unregister) you stop getting new editions.
    4. Publisher doesn’t know who you are and how you use the magazine, it just delivers it to you because you are a 
       subscriber(loose coupling).

Suppose we are building a cricket app which have two display elements CurrentScoreDisplay and AverageScoreDisplay.
CricketData has all the data and whenever data changes the display elements are notified.The solution of this problem given below.
If we add more display elements, we don't have to change the code in CricketData class.It automatically notifies all the display elements.

*/
import java.util.ArrayList;


interface Subject
{
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObservers();
}
class CricketData implements Subject{

    int runs;
    int wickets;
    float overs;
    ArrayList<Observer> observerList;
  
    public CricketData() {
        observerList = new ArrayList<Observer>();
    }
  
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }
  
    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }
  
    @Override
    public void notifyObservers()
    {
       
        for(Observer ob : observerList)
        {
            ob.update(runs,wickets,overs);
        }
    }
  
    private int getLatestRuns()
    {
        return 90;
    }
  

    private int getLatestWickets()
    {
        return 2;
    }
  
    private float getLatestOvers()
    {
        return (float)10.2;
    }
  

    public void dataChanged()
    {
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();
        notifyObservers();
    }
}

interface Observer
{
    public void update(int runs, int wickets,float overs);
}

class AverageScoreDisplay implements Observer{
    private float runRate;
    private int predictedScore;
  
    public void update(int runs, int wickets,float overs){
        this.runRate =(float)runs/overs;
        this.predictedScore = (int)(this.runRate * 50);
        display();
    }
  
    public void display(){
        System.out.println("\nAverage Score Display: \n"
                           + "Run Rate: " + runRate +
                           "\nPredictedScore: " +
                           predictedScore);
    }
}

class CurrentScoreDisplay implements Observer{
    private int runs, wickets;
    private float overs;
  
    public void update(int runs, int wickets,float overs){
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }
  
    public void display(){
        System.out.println("\nCurrent Score Display:\n"
                           + "Runs: " + runs +
                           "\nWickets:" + wickets +
                           "\nOvers: " + overs );
    }
}
public class ObserverPattern{

    public static void main(String[] args) {


        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();
  
        CricketData cricketData = new CricketData();
  
        cricketData.registerObserver(averageScoreDisplay);
        cricketData.registerObserver(currentScoreDisplay);

        cricketData.dataChanged();
  
        cricketData.unregisterObserver(averageScoreDisplay);
  
        cricketData.dataChanged();
    }
    
}
