/*

Template method design pattern is to define an algorithm as a skeleton of operations and leave the details to be implemented by 
the child classes. The overall structure and sequence of the algorithm are preserved by the parent class. 

In Template pattern:
    1. AbstractClass contains the templateMethod() which should be made final so that it cannot be overridden. This template method
       makes use of other operations available in order to run the algorithm but is decoupled for the actual implementation of these 
       methods. All operations used by this template method are made abstract, so their implementation is deferred to subclasses.
    2. ConcreteClass implements all the operations required by the templateMethod that were defined as abstract in the parent class. 
       There can be many different ConcreteClasses.

Suppose there is a shop from where we can buy product in online and offline. In online and offline product selection, payment and
delivery method are different from each other. But wraping gift is same for both cases.There we can use template pattern.To understand 
template pattern see the code below.

Here So the overall algorithm used to process an order is defined in the base class and used by the subclasses. 
But the way individual operations are performed varies depending on the subclass.

*/
abstract class OrderProcessTemplate{
    public boolean isGift;
 
    public abstract void doSelect();
    public abstract void doPayment();
    public abstract void doDelivery();
 
    public final void giftWrap(){
        try{
            System.out.println("Gift wrap successful");
        }
        catch (Exception e){
            System.out.println("Gift wrap unsuccessful");
        }
    }
 
 
    public final void processOrder(boolean isGift){
        doSelect();
        doPayment();
        if (isGift) {
            giftWrap();
        }
        doDelivery();
    }
}

class OnlineOrder extends OrderProcessTemplate{
    @Override
    public void doSelect(){
        System.out.println("Item added to online shopping cart");
        System.out.println("Get gift wrap preference");
        System.out.println("Get delivery address.");
    }
 
    @Override
    public void doPayment(){
        System.out.println("Online Payment through Netbanking, card or Paytm");
    }
 
    @Override
    public void doDelivery(){
        System.out.println("Ship the item through post to delivery address");
    }
 
}
class StoreOrder extends OrderProcessTemplate{

    @Override
    public void doSelect(){
        System.out.println("Customer chooses the item from shelf.");
    }
 
    @Override
    public void doPayment(){
        System.out.println("Pays at counter through cash/POS");
    }
 
    @Override
    public void doDelivery(){
        System.out.println("Item delivered to in delivery counter.");
    }
}
public class Template {
    public static void main(String args[]){
        OrderProcessTemplate OnlineOrder = new OnlineOrder();
        OnlineOrder.processOrder(true);
        System.out.println();
        OrderProcessTemplate storeOrder = new StoreOrder();
        storeOrder.processOrder(true);
    }
    
}
