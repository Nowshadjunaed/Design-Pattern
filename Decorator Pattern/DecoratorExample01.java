/*

The decorator pattern attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to
subclassing for extending functionality.

The decorator pattern can be used to make it possible to extend (decorate) the functionality of a certain object at runtime.
It is like wrapping a gift, putting it in a box, and wrapping the box.

Suppose there is a coffee shop from where one can buy darkroast coffee,houseblend coffee and if he/she wants, he can add
additional condiment to the coffee.For example he/she can add Sweetnuts, Chocolate and for every additional condiment
he/she has to make extra payment.

In this case Decorator pattern is used.Using these pattern, We will able to decorate the coffee with sweetnuts, chocolate etc.
To know the solution see the code below.

Assume that we want to add Red eye coffee. For that we can just add a RedEye class and we dont't have to make any changes to any other
remaining code.If we want another condiment.We can just create a class for that condiment and we don't have to make changes in the
remaining code.To add oreo condiment, We just have to add oreo class to my code which will extend Condiment class.

Here we are just wrapping our coffee with condiments.

*/
abstract class Coffee{
    abstract public String toString();
    abstract int cost();

}

class DarkRoast extends Coffee{

    @Override
    public String toString() {
        return "Finest Dark Roast ";
    }

    @Override
    int cost() {
        return 100;
    }

}

class HouseBlend extends Coffee{

    @Override
    public String toString() {
        return "Finest HouseBlend ";
    }

    @Override
    int cost() {
        return 120;
    }

}
abstract class Condiment extends Coffee{
    Coffee coffee;
}
class SweetNuts extends Condiment{

    SweetNuts(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public String toString() {
        return coffee + "SweetNuts ";
    }
    int cost(){
        return coffee.cost() + 30;
    }

}

class Chocolate extends Condiment{

    Chocolate(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public String toString() {
        return coffee + "Chocolate ";
    }
    int cost(){
        return coffee.cost() + 50;
    }

}
public class DecoratorExample01 {
    
    public static void main(String[] args) {
        Coffee coffee = new DarkRoast();
        System.out.printf("%s <> %d\n",coffee,coffee.cost());

        coffee = new SweetNuts(coffee);
        System.out.printf("%s <> %d\n",coffee,coffee.cost());

        coffee = new Chocolate(coffee);
        System.out.printf("%s <> %d\n",coffee,coffee.cost());

    }
}
