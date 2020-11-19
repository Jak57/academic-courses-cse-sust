abstract class AbstractA{
    abstract void m1();
    void m2(){
        System.out.println("SUST");
    }
}

class AbstractClass extends AbstractA{
    void m1(){
        System.out.println("CSE");
    }
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        ob.m1();
        ob.m2();
    }
}
