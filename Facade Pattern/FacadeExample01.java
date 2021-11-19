/*

Think of your algorithm lab class.Before starting the lab all light,fan,projector,pc should be turned on.And after end of the class all
should be turned off.Now you want a simple interface which done all the things for you.More specifically, you don't have to use light,
fan,projector and pc class object and their method to do this work.You just need a simple interface which will do all of the work
and you have to just use the simple interface's object and method to do all of your work.

To design this interface see the code below.In the below code Facade class is the interface of whom we are talking about.

***Note that Facade pattern violates open closed principle.And to solve this problem we use command pattern.

*/

import java.util.ArrayList;

class Light{
    String name;
    Light(String name){
        this.name = name;

    }

    void on(){
        System.out.println(name + " is on");
    }

    void off(){
        System.out.println(name + " is off");
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

class Facade{
    ArrayList<Light> light_arr = new ArrayList<>();
    ArrayList<Fan> fan_arr = new ArrayList<>();
    Projector projector;
    ArrayList<Pc> pc_arr = new ArrayList<>();

    void addLight(Light light){
        light_arr.add(light);
    }
    void addFan(Fan fan){
        fan_arr.add(fan);
    }

    void setProjector(Projector projector){
        this.projector = projector;
    }

    void addPc(Pc pc){
        pc_arr.add(pc);
    }

    void start_class(){
        for(Light light : light_arr) light.on();
        for(Fan fan : fan_arr) fan.start();
        for(Pc pc : pc_arr) pc.TurnOn();
        projector.down();
    }

    void stop_class(){
        for(Light light : light_arr) light.off();
        for(Fan fan : fan_arr) fan.stop();
        for(Pc pc : pc_arr) pc.TurnOff();
        projector.up();
    }

}
public class FacadeExample01 {
    public static void main(String args[]){
        Facade facade = new Facade();
        facade.addLight(new Light("Light 1"));
        facade.addLight(new Light("Light 2"));

        facade.addFan(new Fan("Fan 1"));
        facade.addFan(new Fan("Fan 2"));

        facade.addPc(new Pc("Pc 1"));
        facade.setProjector(new Projector("projector"));

        facade.start_class();

        System.out.println("\n");

        facade.stop_class();
        

    }
    
}