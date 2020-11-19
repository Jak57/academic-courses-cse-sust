1.
    
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


2.
abstract class AbstractA{
    //abstract void m1();
    void m2(){
        System.out.println("SUST");
    }
}

public class AbstractClass extends AbstractA{
    void m1(){
        System.out.println("CSE");
    }
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        ob.m1();
        ob.m2();
    }
}
3.
abstract class AbstractA{
    abstract void m1();
    void m2(){
        System.out.println("SUST");
    }
}

public class AbstractClass extends AbstractA{
    void m1(){
        System.out.println("CSE");
    }
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        AbstractA ob2 = ob;
        ob2.m1(); //jodi AbstractA class a m1() method na thakto tahole child class er referance 	ob2 diye m1 access kora jeto na
        ob2.m2();
    }
}
4.
abstract class AbstractA{
    abstract void m1();
    void m2(){
        System.out.println("SUST");
    }
}

class Demo extends AbstractA{
    void m1(){
        System.out.println("IICT");
    }
}

public class AbstractClass extends AbstractA{
    void m1(){
        System.out.println("CSE");
    }
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        AbstractA ob2 = ob;
        ob2.m1(); 
       
        Demo ob1 = new Demo();
        AbstractA ob3 = ob1;
        ob1.m1();
    }
}
//
CSE
IICT
INTERFACE
5.
interface InterfaceA{
    void m1(); // variable final, static
    void m2(); //public, abstract //100% abstract
    
}

public class AbstractClass implements InterfaceA{
    
    public void m1(){
        System.out.println("SUST");
    }
    
    public void m2(){ //access modifier >=
        System.out.println("CSE");
    }
    
  
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        ob.m1();
        ob.m2();
        
        InterfaceA ob1 = ob;
        ob.m1();
        ob.m2();
    }
}
6.
interface InterfaceA{
    void m1(); // variable final, static
    void m2(); //public, abstract //100% abstract
    
}

class ImplementClass implements InterfaceA{
    public void m1(){
        System.out.println("Hello");
    }
    
    public void m2(){
        System.out.println("World");
    }
}

public class AbstractClass implements InterfaceA{
    
    public void m1(){
        System.out.println("SUST");
    }
    
    public void m2(){ //access modifier >=
        System.out.println("CSE");
    }
    
  
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        ImplementClass ob3 = new ImplementClass();
        
        InterfaceA ob2 = ob3;
        ob2.m1();
        ob2.m2();
        
        InterfaceA ob1 = ob;
        ob1.m1();
        ob1.m2();
        
        
    }
}
7.
interface InterfaceA{
    void m1();
    void m2();
    void m3();
}

abstract class A implements InterfaceA{
    public void m1(){
        System.out.println("SUST");
    }
}

abstract class B extends A{
    public void m2(){
        System.out.println("CSE");
    }
}

class AbstractClass extends B{
    public void m3(){
        System.out.println("IICT");
    }
    
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        
        ob.m1();
        ob.m2();
        ob.m3();
    }
}
8.
interface A{
    void m1();
}

interface B{
    void m2();
}

interface D{
    void m4();
}

interface C extends A, B, D{
    void m3();
}

class AbstractClass implements C{
   
    public void m1(){
        System.out.println("SUST");
    }
    public void m2(){
        System.out.println("CSE");
    }
    
    public void m3(){
        System.out.println("IICT");
    }
    
    public void m4(){
        System.out.println("Sylhet");
    }
    
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        ob.m1();
        ob.m2();
        ob.m3();
        ob.m4();
    }
}
9.
interface A{
    void m1();
}

interface B{
    void m2();
}

class AbstractClass implements A, B{
   
    public void m1(){
        System.out.println("SUST");
    }
    public void m2(){
        System.out.println("CSE");
    }
     
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        ob.m1();
        ob.m2();
       
    }
}
10.
interface A{
    void m1();
    void m2();
    void m3();
}

interface B{
    void m2();
    void m3();
    
}

class AbstractClass implements A, B{
   
    //unique methods 3
    public void m1(){
        System.out.println("SUST");
    }
    public void m2(){
        System.out.println("CSE");
    }
    
    public void m3(){
        System.out.println("IICT");
    }
   
     
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        ob.m1();
        ob.m2();
        ob.m3();
    }
}
11.
interface A{
    void m1();
    void m2();
}

class E implements A{
    public void m1(){
        System.out.println("Hello");
    }
    public void m2(){
        System.out.println("World");
    }
}

interface B{
    void m2();
    void m3();
    
}

class AbstractClass implements A, B{
   
    public void m1(){
        System.out.println("SUST");
    }
    public void m2(){
        System.out.println("CSE");
    }
    
    public void m3(){
        System.out.println("IICT");
    }
   
     
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        E ob1 = new E();
        ob1.m1();
        ob1.m2();
        ob.m1();
        ob.m2();
        ob.m3();
    }
}
12
interface A{
    void m1();
}

interface B{
    void m2();
}

class C{
    void m3(){
        System.out.println("SUST");
    }
}
class AbstractClass extends C implements A, B{
    
    public void m1(){
        System.out.println("CSE");
    }
    
    public void m2(){
        System.out.println("IICT");
    }
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        
        ob.m1();
        ob.m3();
        ob.m2();
    }
}
13.
interface A{
    interface B{
        void m1();
        void m2();
    }
    void m2();
    void m1();
}

class AbstractClass implements A, A.B{ //unique method 2
    
    public void m2(){
        System.out.println("SUST");
    }
    
    public void m1(){
        System.out.println("CSE");
    }
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        ob.m2();
        ob.m1();
    }
}
14.
interface A{
    interface B{
        void m1();
        void m2();
    }
    
}

class C{
    interface D{
        void m3();
       
    }
    
    void m4(){
        System.out.println("Sylhet");
    }
}

class AbstractClass extends C implements A, A.B, C.D{ //unique method 2
    
    public void m2(){
        System.out.println("SUST");
    }
    
    public void m1(){
        System.out.println("CSE");
    }
    
    public void m3(){
        System.out.println("IICT");
    }
    public static void main(String args[]){
        AbstractClass ob = new AbstractClass();
        ob.m2();
        ob.m1();
        ob.m3();
        ob.m4();
    }
}



