/*

Prototype pattern allows us to hide the complexity of making new instances from the client. The concept is to copy an existing object
or make clone of an existing object rather than creating a new instance from scratch.This approach saves costly resources and time,
especially when object creation is a heavy process.

Instead of using prototype pattern, we make clone of an existing object in a naive approach.For that we have to assign the value of every 
attributes of current object to the cloned object attribute but this is time consuming and there is another problem.If current object
has private attribute, we can't access them from outside of that class.So assigning this private attribute values to the cloned object
attribute is a problem here.

Suppose we are making a game and there is some villains who attack protagonist.So if we make an object of villain, we can use it for
making clone which will act as other villains.This can be done using prototype pattern. Now see the code below to understand how
prototype pattern works.

*/
interface VillainPrototype{
    Villain Villain_clone();
}

abstract class Villain implements VillainPrototype{
    abstract void attackProtagonist();
}

class VillainType1 extends Villain{
    private int hp, mp;
    VillainType1(int hp,int mp){
        super();
        this.hp = hp;
        this.mp = mp;
    }

    void attackProtagonist(){
        System.out.println("Attacking Protagonist");
    }
    public Villain Villain_clone(){
        return new VillainType1(this.hp,this.mp);
    }

    @Override
    public String toString() {
        String str = "hp: " + this.hp + " mp: " + this.mp;
        return str;
    }


}
public class Prototype {
    public static void main(String args[]){
        Villain v = new VillainType1(100, 150);
        System.out.println(v);
        Villain clone = v.Villain_clone();
        System.out.println(clone);
    }
    
}
