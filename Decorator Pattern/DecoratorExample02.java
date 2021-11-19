/*

Suppose we are building an application for a pizza store.Assume they offer four types of pizzas namely Peppy Paneer, Farmhouse,
Margherita and Chicken Fiesta.Each pizza has different cost.Customer can also ask for several toppings such as Fresh Tomato, Paneer,
Jalapeno, Capsicum, Barbeque etc.For each toppings, customer has to pay extra.

In this case Decorator pattern is used.Using these pattern, We will able to decorate the pizza with Fresh Tomato, Paneer,Capsicum etc.
To know the solution see the code below.

Now if we want to add another another toppings to our store.We can simply create a class for this toppings and we don't have to make
any changes to the remaining code.

*/
abstract class Pizza{
    String description = "Unkknown Pizza";
  
    public String getDescription(){
        return description;
    }
  
    public abstract int getCost();
}

class PeppyPaneer extends Pizza{
    public PeppyPaneer() {
        description = "PeppyPaneer";
    }
    public int getCost() {  
        return 100;
    }
}
class FarmHouse extends Pizza{
    public FarmHouse() {
        description = "FarmHouse";
    }
    public int getCost() {
        return 200;
    }
}
class Margherita extends Pizza{
    public Margherita()  {
        description = "Margherita";
    }
    public int getCost() {
        return 100; 
    }
}
class ChickenFiesta extends Pizza{
    public ChickenFiesta() {
        description = "ChickenFiesta";
    }
    public int getCost() {
        return 200;
    }
}
class SimplePizza extends Pizza{
    public SimplePizza() {
        description = "SimplePizza";
    }
    public int getCost() {
        return 50;
    }
}

abstract class ToppingsDecorator extends Pizza{
    public abstract String getDescription();
}

class FreshTomato extends ToppingsDecorator{

    Pizza pizza;
    public FreshTomato(Pizza pizza) {
        this.pizza = pizza;
    }
    public String getDescription() {
        return pizza.getDescription() + ", Fresh Tomato ";
    }
    public int getCost() {
        return 40 + pizza.getCost();
    }
}
class Barbeque extends ToppingsDecorator
{
    Pizza pizza;
    public Barbeque(Pizza pizza) {
        this.pizza = pizza;
    }
    public String getDescription() {
        return pizza.getDescription() + ", Barbeque ";
    }
    public int getCost() {
        return 90 + pizza.getCost();
    }
}

class Paneer extends ToppingsDecorator{
    Pizza pizza;
    public Paneer(Pizza pizza)  {
        this.pizza = pizza;
    }
    public String getDescription() {
        return pizza.getDescription() + ", Paneer ";
    }
    public int getCost()  {
        return 70 + pizza.getCost();
    }
}
public class DecoratorExample02 {

    public static void main(String args[]){
        Pizza pizza = new Margherita();
        System.out.println( pizza.getDescription() + " Cost :" + pizza.getCost());
  
        Pizza pizza2 = new FarmHouse();
  
        pizza2 = new FreshTomato(pizza2);
  
        pizza2 = new Paneer(pizza2);
  
        System.out.println( pizza2.getDescription() + " Cost :" + pizza2.getCost());
        
   }
    
}
