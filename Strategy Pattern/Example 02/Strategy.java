
/*

Characteristic:
    1. We will separate code that changes from code that remains same.
    2. We will wrap the code with interface/abstraction that we will change


context : code that will remain unchanged
behaviour/strategy : code that will change

Suppose we are making a game where a person can kick, punch, jump and roll. But he can kick and jump in different style.
That means jump and kick can be changed in different situation. So this is our strategy because these can be changed.

We can keep evrery kind of jump and kick method in Fighter class. But this is a bad design because there can be many cases 
where a person don't have to perform front kick or any other kick or any jump style from the given jump style, but he is extending
all the methods if we keep these methods in Figher class.

Again we can use class for every single jump and kick style. But this won't give us any facility as a person can kick and jump in 
multiple style and person class can't extend more than one class accrording to OOP. So we have to use interface to solve this problem.

To understand the solution see the below code.

Note that if we want, we can avoid multiple classes for different kick and jump style in the below code and we can keep the method of
different style in kick interface and jump interface and the interfaces can be implemented by Person. But this is a bad design also.
If we do this, code duplicity will happen. Suppose person01 and person02 both have only front kick style and long jump style.Then we
have to implement the same method that means we have to write the same code for the two classes.

*/
  
interface KickBehavior
{
    public void kick();
}

class FrontKick implements KickBehavior
{
    public void kick()
    {
        System.out.println("Front Kick");
    }
}
class SideKick implements KickBehavior
{
    public void kick()
    {
        System.out.println("Side Kick");
    }
}
class BackKick implements KickBehavior
{
    public void kick()
    {
        System.out.println("Back Kick");
    }
}
  

interface JumpBehavior
{
    public void jump();
}
class ShortJump implements JumpBehavior
{
    public void jump()
    {
        System.out.println("Short Jump");
    }
}
class LongJump implements JumpBehavior
{
    public void jump()
    {
        System.out.println("Long Jump");
    }
}
  

abstract class Fighter
{
    KickBehavior kickBehavior;
    JumpBehavior jumpBehavior;
  
    public Fighter(KickBehavior kickBehavior,
                   JumpBehavior jumpBehavior)
    {
        this.jumpBehavior = jumpBehavior;
        this.kickBehavior = kickBehavior;
    }
    public void punch()
    {
        System.out.println("Default Punch");
    }
    public void kick()
    {
        kickBehavior.kick();
    }
    public void jump()
    {
  
        jumpBehavior.jump();
    }
    public void roll()
    {
        System.out.println("Default Roll");
    }
    public void setKickBehavior(KickBehavior kickBehavior)
    {
        this.kickBehavior = kickBehavior;
    }
    public void setJumpBehavior(JumpBehavior jumpBehavior)
    {
        this.jumpBehavior = jumpBehavior;
    }
    public abstract void display();
}

class Person01 extends Fighter
{
    public Person01(KickBehavior kickBehavior,
               JumpBehavior jumpBehavior)
    {
        super(kickBehavior,jumpBehavior);
    }
    public void display()
    {
        System.out.println("Person01");
    }
}
class Person02 extends Fighter
{
    public Person02(KickBehavior kickBehavior,
               JumpBehavior jumpBehavior)
    {
        super(kickBehavior,jumpBehavior);
    }
    public void display()
    {
        System.out.println("Person02");
    }
}

  

public class Strategy {

    public static void main(String[] args) {
        JumpBehavior shortJump = new ShortJump();
        JumpBehavior LongJump = new LongJump();
        KickBehavior FrontKick = new FrontKick();
        KickBehavior BackKick = new BackKick();
  
        Fighter Person01 = new Person01(FrontKick,shortJump);
        Person01.display();
  
        Person01.punch();
        Person01.kick();
        Person01.jump();
  
        Person01.setJumpBehavior(LongJump);
        Person01.setKickBehavior(BackKick);
        Person01.jump();
        Person01.kick();
    }
}