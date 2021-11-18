/*

Singleton pattern is a design pattern which restricts a class to instantiate its multiple objects. It is nothing but a way of defining 
a class. Class is defined in such a way that only one instance of the class is created in the complete execution of a program 
or project. It is used where only a single instance of a class is required to control the action throughout the execution.

Characteristics:
    1. It should have only one instance
    2. Instance should be globally accessible
    
Suppose there is a chocolate factory and in this factory there is only one chocolateboiler.So you have to write code such a way that
no more than one instace of ChocolateBoiler is created.

To know the solution see the code given below.

*/

import java.util.Random;

class SimpleThread implements Runnable{

    String name;

    SimpleThread(String name){
        this.name = name;
    }
    @Override
    public void run() {
        ChocolateBoiler boiler = ChocolateBoiler.getUniqueInstance(name);
        boiler.fill();
        System.out.println(boiler.getStatus(name));
    }

}
class ChocolateBoiler{
    private boolean empty, boiled;

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }

    int signature;

    private static ChocolateBoiler uniqueInstance = null;

    @Override
    public String toString() {
        return "ChocolateBoiler <" + signature + ">";
    }

    private ChocolateBoiler(){
        empty = true;
        boiled = false;
        signature = new Random().nextInt(10000000);

        try{
            Thread.sleep(1500);
        }catch(Exception e){}

        System.out.println("Created ChocolateBoiler <" + this + ">");
    }

    public String getStatus(String msg){
        return msg+ " <> " + this + " < empty: " + this.empty + " boiled: " + this.boiled + ">";
    }

    /*

    public synchronized static ChocolateBoiler getUniqueInstance(String msg){
        if(uniqueInstance==null){
            System.out.println(msg + " Sync method : Creating chocolateboiler for the first and last time");
            uniqueInstance = new ChocolateBoiler();
        }
        else
        {
            System.out.println(msg + " Unique instance exists!!!");
        }
        return uniqueInstance;
    }

    */

    /*

        The upper commented part of the code is absolutely okay. But we won't use it as synchronized method is not optimized.
        Instead of it, we will use synchronized block as given below.

    */

    public static ChocolateBoiler getUniqueInstance(String msg){
        if(uniqueInstance==null){
            synchronized(ChocolateBoiler.class){
                if(uniqueInstance == null){
                    System.out.println(msg + " Sync method : Creating chocolateboiler for the first and last time");
                    uniqueInstance = new ChocolateBoiler();
                } 
            }
        }
        else
        {
            System.out.println(msg + " Unique instance exists!!!");
        }
        return uniqueInstance;
    }

    public synchronized void fill(){
        if(isEmpty()){
            System.out.println(this + " >> filling chocolate and milk");
            empty = false;
        }
        else{
            System.out.println(this + " >> can't fill because boiler is not empty");
        }
    }

    public void boil(){
        if(!isEmpty() && !isBoiled()){
            System.out.println(this + " >> boiling chocolate and milk");
            boiled = true;
        }
        else{
            if(isEmpty()) System.out.println("Can't boil beacuse boiler is empty");
            else System.out.println(this + " >> can't boil because already boiled");
        }
    }
    public void drain(){
        if(!isEmpty() && isBoiled()){
            System.out.println(this + " >> Draining chocolate bars");
            empty = true;
        }
        else{
            if(isEmpty()) System.out.println("Can't drain beacuse boiler is empty");
            else System.out.println(this + " >> can't drain because not boiled yet");
        }
    }

    
}
public class Singleton {
    public static void main(String[] args) {
       Thread thread1 = new Thread(new SimpleThread("Thread 1"));
       Thread thread2 = new Thread(new SimpleThread("Thread 2"));

       thread1.start();
       thread2.start();

    }

    
}
