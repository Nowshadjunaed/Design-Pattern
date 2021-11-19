/*

Suppose a bike company faced huge loss. So they sold their company to a car company.
The car company don't want to change the code base of bike company as the code is clean and bug free.
So they decided to make an adapter to convert the bike class to car class such that they can use bike class property and
behaviour using car class property and behavior and they can use bike class object like a car class.

In this case, Adapter design pattern is used. The solution of the problem given below.

*/

abstract class Car{
    double weight_kg;
    double milage;
    Car(double weight_kg,double milage){
        this.weight_kg = weight_kg;
        this.milage = milage;
    }
    abstract void start();
    abstract void steer(int left_right);

}

class Mclaren extends Car{
    Mclaren(){
        super(1500,30.87);
    }
    @Override
    void start(){
        System.out.println("Mclaren is starting");
    }
    @Override
    void steer(int left_right){
        System.out.println("steering " + left_right);
    }
    
}

abstract class Bike{
    double weight_pound;
    double kilometer_per_litre;
    Bike(double weight_pound,double kilometer_per_litre){
        this.weight_pound = weight_pound;
        this.kilometer_per_litre = kilometer_per_litre;
    }
    abstract void begin();
    abstract void control(int left_right);
    
}


class Suzuki extends Bike{
    Suzuki(){
        super(1200,110.87);
    }
    @Override
    void begin(){
        System.out.println("Suzuki is beginning");
    }
    @Override
    void control(int left_right){
        System.out.println("controlling " + left_right);
    }
    
}

class BikeToCarAdapter extends Car{
    Bike bike;
    BikeToCarAdapter(Bike bike){
        super(bike.weight_pound/2.20462,bike.kilometer_per_litre*0.6213);
        this.bike = bike;
    }

    @Override
    void start(){
        bike.begin();
    }
    @Override
    void steer(int left_right){
        bike.control(left_right);
    }

}

public class AdapterExample01 {
    public static void main(String[] args) {
        Car mclaren = new Mclaren();
        Car suzuki = new BikeToCarAdapter(new Suzuki());
        mclaren.start();
        mclaren.steer(5);

        suzuki.start();
        suzuki.steer(10);
       
    }
    
}
