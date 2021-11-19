/*

Facade pattern violates open closed principle.Command pattern is modified version of Facade pattern.

Think of your algorithm lab class. Suppose there exists automation system.There is a programmable remote which can be used to turn on 
and off various items in this like lights, fan, projector, pc etc.Now what we want to achieve is a design that provides loose coupling
and remote control should not have much information about a particular device.

This can be done using Command pattern. See the code below. It solves Facade pattern problem of violating open closed principle.
Suppose now we want to add feature to turn on and off the AC in our lab.We don't have to make any changes in SimpleRemoteControl
class. We just have to add class for AC.So command pattern open for extension and closed for modification.

*/
interface Command{
    public void execute();
}

class Light{
    String name;
    Light(String name){
        this.name = name;

    }
    public void on(){
        System.out.println(name + " is on");
    }
    public void off(){
        System.out.println(name + " is off");
    }
}
class LightOnCommand implements Command{
    Light light;
  
    public LightOnCommand(Light light){
       this.light = light;
    }
    public void execute(){
       light.on();
    }
}
class LightOffCommand implements Command{
    Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    public void execute(){
         light.off();
    }
}
class Fan{
    String name;
    Fan(String name){
        this.name = name;

    }

    void start(){
        System.out.println(name + " has started");
    }

    void stop(){
        System.out.println(name + " has stopped");
    }
}
class FanStartCommand implements Command{
    Fan fan;
  
    public FanStartCommand(Fan fan){
       this.fan = fan;
    }
    public void execute(){
       fan.start();
    }
}
class FanStopCommand implements Command{
    Fan fan;
  
    public FanStopCommand(Fan fan){
       this.fan = fan;
    }
    public void execute(){
       fan.stop();
    }
}

class Projector{
    String name;
    Projector(String name){
        this.name = name;

    }

    void  up(){
        System.out.println(name + " screen is up");
    }

    void down(){
        System.out.println(name + " screen is down");
    }
}

class ProjectorUpCommand implements Command{
    Projector projector;
  
    public ProjectorUpCommand(Projector projector){
       this.projector = projector;
    }
    public void execute(){
       projector.up();
    }
}

class ProjectorDownCommand implements Command{
    Projector projector;
  
    public ProjectorDownCommand(Projector projector){
       this.projector = projector;
    }
    public void execute(){
       projector.down();
    }
}
class Pc{
    String name;
    Pc(String name){
        this.name = name;

    }

    void TurnOn(){
        System.out.println(name + " is turned on");
    }

    void TurnOff(){
        System.out.println(name + " is turned off");
    }
}

class PcTurnOn implements Command{
    Pc pc;
  
    public PcTurnOn(Pc pc){
       this.pc = pc;
    }
    public void execute(){
       pc.TurnOn();
    }
}

class PcTurnOff implements Command{
    Pc pc;
  
    public PcTurnOff(Pc pc){
       this.pc = pc;
    }
    public void execute(){
       pc.TurnOff();
    }
}
class SimpleRemoteControl{
    Command slot;  
  
    public void setCommand(Command command){
        slot = command;
    }
  
    public void buttonWasPressed(){
        slot.execute();
    }
}
public class CommandPattern {
    public static void main(String args[]){
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light("Light 1");
        Fan fan = new Fan("Fan 1");
        Projector projector = new Projector("Projector");
        Pc pc = new Pc("Pc 1");
  
        remote.setCommand(new LightOnCommand(light));
        remote.buttonWasPressed();
        remote.setCommand(new FanStartCommand(fan));
        remote.buttonWasPressed();
        remote.setCommand(new ProjectorDownCommand(projector));
        remote.buttonWasPressed();
        remote.setCommand(new PcTurnOn(pc));
        remote.buttonWasPressed();

        System.out.println("\n");

        remote.setCommand(new LightOffCommand(light));
        remote.buttonWasPressed();
        remote.setCommand(new FanStopCommand(fan));
        remote.buttonWasPressed();
        remote.setCommand(new ProjectorUpCommand(projector));
        remote.buttonWasPressed();
        remote.setCommand(new PcTurnOff(pc));
        remote.buttonWasPressed();
    }
}
