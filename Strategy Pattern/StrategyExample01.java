/*

Characteristic:
    1. We will separate code that changes from code that remains same.
    2. We will wrap the code with interface/abstraction that we will change


context : code that will remain unchanged
behaviour/strategy : code that will change

In the below code, Add and Multiply classes are our strategy. These class will be modified according to the client's wish.
So I have separeted them.On the other hand, Calculator class will not be changed.Suppose now we need a feature of substraction.
We can simply add a class for this feature and it will implement the Operation interface.And for that we don't have to make
modification in Calculator class.We can easily take the advantage of any feature/strategy using Calculator class.


*/
interface Operation{
    int performOperation(int num1,int num2);
}
class Add implements Operation{
    Operation op;
    public int performOperation(int num1,int num2){
        return num1+num2;
    }
    void SetOperation(Operation op){
        this.op = op;
    }

}

class Multiply implements Operation{
    Operation op;
    public int performOperation(int num1,int num2){
        return num1*num2;
    }
    void SetOperation(Operation op){
        this.op = op;
    }

}

class Calculator{
    Operation op;
    int performOperation(int num1,int num2){
        return op.performOperation(num1, num2);
    }

    void SetOperation(Operation op){
        this.op = op;
    }
}

public class StrategyExample01 {

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.SetOperation(new Add());
        System.out.println(cal.performOperation(10, 20));
        cal.SetOperation(new Multiply());
        System.out.println(cal.performOperation(10, 20));
    }
    
}
