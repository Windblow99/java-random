package design.methods.lecture.pkg3;

public class StrategyPatternDemo {

    public static void main(String[] args) {
        //incorporate the singleton
        
        calculator calc = new calculator(new add());
        
        calc.performCalc(10, 5);
        
        calc.setOp(new mul());
        
        calc.performCalc(10, 5);
        
        calc.setOp(new sub());
        
        calc.performCalc(10, 5);
    }
    
}

class calculator{
    operand op;
    
    public calculator(operand op){
        this.op = op;
    }
    
    public void setOp(operand op){
        this.op = op;
    }
    
    public void performCalc(int x, int y){
        //programming to an interface/abstraction
        System.out.println("Answer is : " + op.calc(x, y));
    }
}

interface operand {
    public int calc(int x, int y);
}

//class newfunctionality implements operand {
//    public int calc(int x, int y){
//        //expand something else here
//    }
//}

class add implements operand {
    public int calc(int x, int y){
        return x+y;
    }
}

class sub implements operand {
    public int calc(int x, int y){
        return x-y;
    }
}

class mul implements operand {
    public int calc(int x, int y){
        return x*y;
    }
}

class div implements operand {
    public int calc(int x, int y){
        return x/y;
    }
}