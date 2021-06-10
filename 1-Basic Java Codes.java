Part 01: Basics
Book: 
Java The Complete Reference by Herbert Schildt
. Java: Object oriented programming
. Properties of OOP :
	. Encapsulation
	. Inheritance
	. Polymorphism
. Process oriented model (Procedure oriented programming)
	. C
. POP: C
	. Global data
	    . function 1
	    . function 2
	. Code oriented programming
	. structure contains only data
** Image

Java:
. Program: Combined form of modules
. Data oriented program
. Struct contains methods and data

Properties of Java:
. Encapsulation: The data can be kept private / public, the use of data under a class can be        restricted.
 Class:
	. data
	. method
** Image

class classDemo
{
    int a = 7, b = 2;
    private int p = 5, q = 9;
    
    int add(int x, int y)
    {
        return x + y;
    }
    
    private int multipy(int l, int m)
    {
        return l * m;
    }
    
}

1.
class Example
{
    public static void main(String args[])
    {
        classDemo ob = new classDemo();
        int z = ob.add(4, 2);
        
        // Can access
        System.out.println(z);
        System.out.println(ob.a + " " + ob.b);
        
        // Can't access private method and variables
        // int m = ob.multipy(2, 7);
        // System.out.println(m);
        // System.out.println(ob.p + " " + ob.q);
    }
}

/*
6
7 2
*/

Inheritance: Through this process object acquires the properties of another object.

2.
class animal
{
    int a = 8, b = 9;
    int method(int x, int y)
    {
        return x + y;
    }
}

// mamal inherits the properties of animal class
class mamal extends animal
{
    int p, q;
    int multipy(int x, int y)
    {
        return x * y;
    }
    
    public static void main(String args[])
    {
        mamal ob = new mamal();
        // can access data from animal class through inheritance
        System.out.println(ob.a + " " + ob.b);
    }
    
}

/*
8 9
*/

History of Java:
. Trade-off:
	1. Ease-of-use vs power
	2. Safety vs efficiency
	3. Rigidity vs extensibility
. Machine Language: BASIC, FORTRAN, COBAL
- not structured
- not powerful

. PASCAL
- structured but not enought features for long codes

. C:
- efficient, structured
- applicable for wide range of code

. OOP: C++
- not supported by all OS (Operating system)
- absence of portability

Java Buzzwords:
- Portability
- Simple: C / C++ syntax
- Object oriented programming
- Robust: handling unexpected termination and handling unexpected actions
- Multi-threaded
- Architecture - neutral
- Interpreted and high performance
- Secure
- Distributed
	- Networking
	- Protocol
- Dynamic

** image

Lab:

3.
class Example
{
	public static void main(String args[]){
		System.out.println("Hello, world");
	}
}

. Program starts from a call to main method
. System.out.println("Hello, world");
	- println() : method
	- out : class object
	- System: class
. We can call static class through reference
. For external class: 
	- import java.util;
. Auto / built in: 
	- java.lang
. Compund statement: block in java

Part 02: Class
Class:
class cse18
{
	variables
	methods
	constructors
	instance blocks
	static blocks
}

. Variable:
-- local
-- instance
-- static

. Type:
-- primitive
-- enum
-- class
-- array

* Local variables
1. Declaration: Constructor, method (static, instance), block(static, instance)
2. Scope: It can be accessed from where it has been declared
3. Memory allocation / release: 
-- When a method is called
-- In case of static when class is called
-- In case of instance when object is called

* Instance variable:
1. Declaration: Inside the class but outside the constructor/ method/ block
2. Scope: It can be accessed inside the class
3. Memory allocation:
-- When an object is created : CSE18 ob = new CSE18();
4. Memory will be released when there will be no reference to the object
5. Instance variable can be accessed directly (without creating object) from instance area
6. Object is needed to be created to access instance variable from static area

class cse18
{
    // instance variable
    // Memory will be allocated each time object is created
    int c;
    // Memory will be allocated once
    static int a;
    
    void function()
    {
        // Instance area
    }
    
    public static void main(String args[])
    {
        // Static area
    }
    
}

* Static variable:
1. Declaration: Inside the class but outside the constructor/ method/ block with static modifier
2. Scope: It can be accessed both in static and instance area without creating object by class reference
3. Memory allocation/ release: When class is declared memory is allocated

* Default value of variables:
Primitive type : Default value
1. int - 0
2. short - 0
3. long - 0
4. byte - 0
5. float - 0.0
6. double - 0.0
7. char - ' ' (single white space)
8. boolean - false
. These values are assigned by JVM

**
. Default value of class type variable is NULL
. main method is run by JVM
. default value is assigned for instance and static variable

* Accessing static variables:
1. Whithout class reference
2. With class reference (recommanded)
3. With object declaration

class cse18
{
	static int a = 7;
	public static void main(String args[]){
		SOP(a);
		SOP(cse18.a)
	}
}

* Difference between class and object:
1. Class is logical entity whereas object is physical entity
2. Multiple object based on same class
3. Keyword: class (For class), new (For object)

* Instance vs Static:
class cse18
{
    int a = 17;
    static int b = 25;
    
    public static void main(String args[])
    {
        cse18 ob = new cse18();
        // Accessing instance variable through object
        System.out.println(ob.a);
        
        // Accessing static varialbe by different approach
        System.out.println(b);
        System.out.println(cse18.b);
        System.out.println(ob.b);
        
        ob.a = 8;
        ob.b = 9;
        System.out.println(ob.a); // 8
        System.out.println(cse18.b); // 9
        
        cse18 ob2 = new cse18();
        System.out.println(ob2.a); // 17 because memory is allocated each time when object is created
        System.out.println(ob2.b);  // 9 because memory is allocated once when class is declared 
     
        
    }
    
}

** 
class student{
	int id;
	String name;
	Static string institute; // Institute name remains unchanged so memory is declared once
}

. text file -> (compiler)-> byte code -> (jvm)-> output
. cd - change directory

 Part 03: Method
* Method:
-- static method
-- instance method

CSE.java -> (compile) -> CSE.class (byte code) -> (jvm) -> output
. jvm loads bytecode into memory
. jvm allocated memory for static variables and static methods
. jvm starts execution from main methods
. jvm throws exception (optional) (??)

Method: public static void main(String args[])
. Modifier-list Return-type Method-name (Parametre-list)
-- Modifier-list: public, static
-- Return-type: void
-- Method-name: main
-- Parametre-list: String args[]

. Method signature: Method-name (Parametre-list)

class person
{
    
}

class employee
{
    
}

class student
{
    
}

class cse18
{
    // primitive type variable
    void m3(int p, int q)
    {
        System.out.println("m3 method");
        System.out.println(p + q);
    }
    
    // class type variable
    public static void m1(person p, employee e)
    {
        System.out.println("m1 method");
    }
    
    static void m2(student s)
    {
        System.out.println("m2 method");
        
    }
    
    public static void main(String args[])
    {
        student s = new student();
        cse18 ob = new cse18();
        
        ob.m3(4, 6);
        // can access static method from static area directly or through class reference
        m2(s);
        cse18.m2(s);
    }
}
/*
m3 method
10
m2 method
m2 method
*/

. Only one method can prevail with particular method signature
. Inner method concept is not allowed in java.

class cse18
{
    int p = 100, q = 200;
    
    void m1(int a, int b)
    {
        System.out.println("Inside m1");
        System.out.println(a + b);
        p = 500;
        q = 600;
    }
    
    void m2()
    {
        System.out.println("Inside m2");
        System.out.println(p + q);
    }
    
    public static void main(String args[])
    {
        cse18 ob = new cse18();
        ob.m1(3, 5);
        // values of p, q will change
        ob.m2();
        
        cse18 ob2 = new cse18();
        // As new object is created new memory will be allocated for p, q and their value will be as it was before any change
        ob2.m2();
    }
}
/*
Inside m1
8
Inside m2
1100
Inside m2
300
*/


***
class cse18
{
    int a = 7, b = 9;
    
    void m1(int a, int b)
    {
        System.out.println(a + b);
        
        // this keyword refers to the variable in the class outside method m1
        System.out.println(this.a + this.b);
    }
    
    public static void main(String args[])
    {
        cse18 ob = new cse18();
        ob.m1(2, 90);
    }
}
/*
92
16
*/

***
class student
{
    
}

class cse18
{
    int a = 15, b = 20;
    
    // return type is class
    // parametre is of type class
    student m1(cse18 c)
    {
        System.out.println(a + b);
        // return object of student class
        return new student();
    }
    
    public static void main(String args[])
    {
        cse18 ob = new cse18();
        cse18 ob2 = new cse18();
        student ob3 = ob.m1(ob2);
    }
}

// 35

***
class cse18
{
    int a = 15, b = 20;
    static int c = 5, d = 6;
    
    // return type is class
    cse18 m1()
    {
        a = 1; b = 2;
        c = 7; d = 8;
        
        // return a object of class cse18
        return this;
    }
    
    public static void main(String args[])
    {
        cse18 ob = new cse18();
        cse18 ob1 = ob.m1();
        
        System.out.println(ob1.a + ob1.b);
        System.out.println(ob1.c + ob1.d);
        
        cse18 ob2 = new cse18();
        System.out.println(ob2.a + ob2.b);
        System.out.println(ob2.c + ob2.d);
    }
}
/*
3
15
35
15
*/

. Method overloading * (Method name same, parameter list differ)

Part 04: Constructor
* Constructor:
-- no return type
-- name is same as class
-- none, one or more parameter
-- when a object is created it is executed

class cse18
{
    // if constructor is not defined then default constructor will execute
    // constructor
    cse18()
    {
        System.out.println("Inside cse18() constructor");
    }
    
    // constructor
    cse18(int a, int b)
    {
        System.out.println(a + b);
    }
    
    public static void main(String args[])
    {
        cse18 ob = new cse18();
        cse18 ob1 = new cse18(4, 5);
    }
    
    
}
/*
Inside cse18() constructor
9
*/

***
class cse18
{
    int id, batch;
    String name;
    
    // Constructor without parameter
    cse18()
    {
        id = 100;
        batch = 1018;
        name = "Jakir";
    }
    
    // Constructor with parameter
    cse18(int i, int b, String n)
    {
        id = i;
        batch = b;
        name = n;
    }
    
    void m1()
    {
        System.out.println(id + " " + batch + " " + name);
    }
    
    public static void main(String args[])
    {
        cse18 ob1 = new cse18();
        ob1.m1();
        
        cse18 ob2 = new cse18(10, 2017, "Jak");
        ob2.m1();
        
    }
}
/*
100 1018 Jakir
10 2017 Jak
*/

***
class cse18
{
    cse18()
    {
        // call the constructor with 1 argument : cse18(int a)
        this(20);
        System.out.println("0-argument constructor");
    }
    
    cse18(int a)
    {
        this(30, 70);
        System.out.println("1-argument constructor");
    }
    
    cse18(int a, int b)
    {
        System.out.println("2-argument constructor");
    }
    
    public static void main(String args[])
    {
        cse18 ob = new cse18();
    }
}
/*
2-argument constructor
1-argument constructor
0-argument constructor
*/

. When a constructor is called from another constructor this(...) should be the first executable line in that constructor. (multiple this(...) can't be in constructor)

cse18{
	this(7);
	this(4, 8);
}
It is not allowed. 

Part 05: Block
* Instance block:
. Syntax:
{
//logic
}
* Instance block is executed before constructor
***
class cse18
{
    cse18()
    {
        System.out.println("0-argument constructor");
    }
    
    {
        System.out.println("Instance block 1");
    }
    
    cse18(int a)
    {
        System.out.println("1-argument constructor");
    }
    
    {
        System.out.println("Instance block 2");
    }
    
    public static void main(String args[])
    {
        cse18 ob = new cse18();
        cse18 ob1 = new cse18(3);
    }
}
/*
Instance block 1
Instance block 2
0-argument constructor
Instance block 1
Instance block 2
1-argument constructor
*/
. If object is created multiple time instance block will execute multiple time before constructor

* Static block:
Syntax:
static {
// logic
}
. Static blocks will execute first

***
class cse18
{
    cse18()
    {
        System.out.println("0-argument constructor");
    }
    
    {
        System.out.println("Instance block 1");
    }
    
    static
    {
        System.out.println("Static block 1");
    }
    
    cse18(int a)
    {
        System.out.println("1-argument constructor");
    }
    
    {
        System.out.println("Instance block 2");
    }
    
    static
    {
        System.out.println("Static block 2");
    }
    
    public static void main(String args[])
    {
        cse18 ob = new cse18();
        cse18 ob1 = new cse18(3);
    }
}
/*
Static block 1
Static block 2
Instance block 1
Instance block 2
0-argument constructor
Instance block 1
Instance block 2
1-argument constructor
*/

. Static block is executed when bytecode is loaded
. If object is not created then only static block will execute.
***
class cse18
{
    cse18()
    {
        System.out.println("0-argument constructor");
    }
    
    {
        System.out.println("Instance block 1");
    }
    
    static
    {
        System.out.println("Static block 1");
    }
    
    cse18(int a)
    {
        System.out.println("1-argument constructor");
    }
    
    {
        System.out.println("Instance block 2");
    }
    
    static
    {
        System.out.println("Static block 2");
    }
    
    public static void main(String args[])
    {
       
    }
}
/*
Static block 1
Static block 2
*/

*** 
class cse
{
    static
    {
        System.out.println("Static block in class cse");
    }
}

class cse18
{
    cse18()
    {
        System.out.println("0-argument constructor");
    }
    
    {
        System.out.println("Instance block 1");
    }
    
    static
    {
        System.out.println("Static block 1");
    }
    
    cse18(int a)
    {
        System.out.println("1-argument constructor");
    }
    
    {
        System.out.println("Instance block 2");
    }
    
    static
    {
        System.out.println("Static block 2");
    }
    
    public static void main(String args[])
    {
        cse18 ob = new cse18();
        cse ob1 = new cse();
    }
}
/*
Static block 1
Static block 2
Instance block 1
Instance block 2
0-argument constructor
Static block in class cse
*/
. Where main method is , firstly their all code is executed

Part 06: Inheritance
* Inheritance
-- Reduce redundancy
-- Decrease the length of code

class A
{
    void m1()
    {
        System.out.println("m1 method");
    }
    
    void m2()
    {
        System.out.println("m2 method");
    }
}

class B extends A
{
    void m3()
    {
        System.out.println("m3 method");
    }
    
    void m4()
    {
        System.out.println("m4 method");
    }
    
    public static void main(String args[])
    {
        B ob = new B();
        
        // B in herits the property of class A
        ob.m1();
        ob.m4();
    }
}

// C is sub/ child/ derived class
// B is parent/ super/ base class
class C extends B
{
    void m5()
    {
        System.out.println("m5 method");
    }
}
/*
m1 method
m4 method
*/

* At a time one class can only extend one class
. Multilevel strecture: A <- B <- C <- D  ( here D extends C)
. Some class can be extended by multiple class:
	- A <- B, A <- C, A <- D 
. final key word is used before class name so that this class cann't be extended by other class
final class B {
	//logic
}
. By default object class is inherited by other classes (handed by compiler)
. Parent of all class is object class. So they can use methods of parents class (get Class(), equals()..)
. super keyword

class A
{
    A()
    {
        System.out.println("0-arg constructor in A");
    }
    
    {
        System.out.println("Instance block in A");
    }
    
    static 
    {
        System.out.println("Static block in A");
    }
    
    A(int a)
    {
        System.out.println("1-arg constructor in A");
    }
}

class B extends A
{
    B()
    {
        this(17);
        System.out.println("0-arg constructor in B");
    }
    
    B(int a)
    {
        System.out.println("1-arg constructor in B");
    }
    
    public static void main(String args[])
    {
        B ob = new B();
    }
}

// firstly parent class will be executed then child class
. As we don't use super , 0-argument constructor is called by default
/*
Static block in A
Instance block in A
0-arg constructor in A
1-arg constructor in B
0-arg constructor in B
*/

*** 
class A
{
    A()
    {
        System.out.println("0-arg constructor in A");
    }
    
    {
        System.out.println("Instance block in A");
    }
    
    static 
    {
        System.out.println("Static block in A");
    }
    
    A(int a)
    {
        System.out.println("1-arg constructor in A");
    }
}

class B extends A
{
    B()
    {
        super(17);
        System.out.println("0-arg constructor in B");
    }
    
    B(int a)
    {
        System.out.println("1-arg constructor in B");
    }
    
    public static void main(String args[])
    {
        B ob = new B();
    }
}

// firstly parent class will be executed then child class
/*
Static block in A
Instance block in A
1-arg constructor in A
0-arg constructor in B
*/

. Super keyword is used to access specific constructor from parent class
***
class A
{
    A()
    {
        System.out.println("0-arg constructor in A");
    }
    
    {
        System.out.println("Instance block in A");
    }
    
    static 
    {
        System.out.println("Static block in A");
    }
    
    A(int a)
    {
        System.out.println("1-arg constructor in A");
    }
}

class B extends A
{
    B()
    {
        super(17);
        System.out.println("0-arg constructor in B");
    }
    
    B(int a)
    {
        System.out.println("1-arg constructor in B");
    }
    
    public static void main(String args[])
    {
        B ob = new B();
    }
    
    {
        System.out.println("Instance block in B");
    }
    
    static 
    {
        System.out.println("Static block in B");
    }
}

// firstly parent class will be executed then child class
/*
Static block in A
Static block in B
Instance block in A
1-arg constructor in A
Instance block in B
0-arg constructor in B
*/

Part 07: Overriding
* Overriding:
Rules:
-- Method signature is same
-- return type same
-- If final modifier is used before a method then it can't be overridden
-- If method or variable name is same from two different class then then we can access them through object of appropriate class.
-- Overriding is only applicable for instance method

***
class parent
{
    int a = 7;
    void m1()
    {
        System.out.println("m1 method of class parent");
    }
}

class child extends parent
{
    int a = 7;
    void m1()
    {
        System.out.println("m1 method of class child");
    }
    
    public static void main(String args[])
    {
        child ob = new child();
        ob.m1();
        
        parent ob2 = ob;
        ob2.m1();
        
        parent ob1 = new parent();
        ob1.m1();
        
        //child ob3 = ob1; incorrect, parent can't be assigned to child
    }
}
/*
m1 method of class child
m1 method of class child
m1 method of class parent
*/

***
class parent
{
    private int a = 7;
    private void m1()
    {
        System.out.println("m1 method of class parent");
    }
}

class child extends parent
{
    int a = 7;
    void m1()
    {
        System.out.println("m1 method of class child");
    }
    
    public static void main(String args[])
    {
        parent ob = new parent();
        //ob.m1(); can't access private method
        child ob1 = new child();
        ob1.m1();
    }
}
/*
m1 method of class child
*/
. private method can't be overridden

. Modifier:
1. public - Can be accessed from any package
2. protected - Within the same package or through inheritance
3. default - Within the package only
4. private - Within the class only
( Access area decreases from top to bottom)

***
class A
{
    public void m1()
    {
        System.out.println("Hello, world");
    }
}

class B extends A
{
    // Error 
    // m1() method can't be overridden using weaker modifier protected
    protected void m1()
    {
        System.out.println("Hello");
    }
}
. In case of overriding, the area of coverage of the modifier must be greater or equal to that of the inherited method.

Part 08: Abstract Class
Properties:
1. Abstract method has no body
2. If there is a abstract method in a class then the class must be abstract and abstract keyword should be used. Bust object cann't be created of that class.
3. If a class extends an abstract class but doesn't give body to abstract class, then that class also must be abstract.

***
abstract class A
{
    // abstract method
    abstract void m1();
    void m2()
    {
        System.out.println("Hello, world");
    }
}

class B extends A
{
    void m1()
    {
        System.out.println("Hello, Jakir");
    }
    
    public static void main(String args[])
    {
        B ob = new B();
        ob.m1();
        ob.m2();
    }
}
/*
Hello, Jakir
Hello, world
*/

***
abstract class A
{
    abstract void m1();
    A()
    {
        System.out.println("Constructor in A");
    }
    
    static
    {
        System.out.println("Static block A");
    }
    
    {
        System.out.println("Instance block A");
    }
}

abstract class B extends A
{
    B()
    {
        System.out.println("Constructor in B");
    }
    
    static
    {
        System.out.println("Static block B");
    }
    
    {
        System.out.println("Instance block B");
    }
}

class C extends B
{
    void m1()
    {
        System.out.println("m1 in C");
    }
    
    C()
    {
        System.out.println("Constructor in C");
    }
    
    static
    {
        System.out.println("Static block C");
    }
    
    {
        System.out.println("Instance block C");
    }
    
    public static void main(String args[])
    {
        C ob = new C();
        ob.m1();
    }
}
/*
Static block A
Static block B
Static block C
Instance block A
Constructor in A
Instance block B
Constructor in B
Instance block C
Constructor in C
m1 in C  
*/

* Nested Class:
***
class A
{
    int a = 7;
    private int b = 3;
    
    void m1()
    {
        B ob = new B();
        ob.m2();
        
        System.out.println(a + b + ob.c);
    }
    
    // non-static nested class
    class B
    {
        int c = 8;
        void m2()
        {
            // from instance area can access instance variables of A directly
            System.out.println(a + b + c);
        }
        
    }
    
    // static nested class
    // area is static
    static class C
    {
        int d = 9;
        A ob1 = new A();
        void m3()
        {
	// non-static variable a, b can't be access directly from static class C, so we have to   	create object of A
      	System.out.println(ob1.a + ob1.b + d);
        }
    }
    
    public static void main(String args[])
    {
        A ob = new A();
        ob.m1();
        // cann't create object of B which is a non static class from static area
        // so can't access m2() from here
        
    }
    
}
//18
//18

. Types:
-- Non-static nested class (inner class)
-- Static nested class

. Non-static Inner class can access elements directly from outer class. (even private elements)
.Objects has to be created to access elements of inner nested class to outer nested class
. Static nested class can access elements from outer nested class by creating objects

* Local nested class:

class A
{
    int a = 8, b = 9;
    private int c = 7;
    
    void m1()
    {
        class B{
            int d = 5;
            void m2()
            {
                // can access elements of outer class
                System.out.println(a + b + c + d);
            }
            
        }
        
        B ob = new B();
        ob.m2();
    }
    
    public static void main(String args[])
    {
        A ob = new A();
        ob.m1();
    }
}

// 29

***

class A
{
    int a = 7;
    private int b = 3;
    
    A m1()
    {
        return this;
    }
    
    class B{
        int c = 6;
        
        B m2()
        {
            return this;
        }
    }
    
    public static void main(String args[])
    {
        A ob1 = new A();
        A ob2 = ob1.m1();
        
    }
}

Builder Pattern

. It is very important concept.*
***

public class Person
{
    private String name;
    private String phoneNumber;
    private String address;
    private Integer age;
    
    //private Person(Builder builder)
    Person(Builder builder)
    {
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.age = builder.age;
    }
    
    public static Builder getBuilder()
    {
        //return new Person.Builder();
        return new Builder();
    }
    
    void printInformation()
    {
        System.out.println("Name: " + name);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
    }
}

//public static class Builder
class Builder
{
    //private String name;
    //private String phoneNumber;
    //private String address;
    //private Integer age;
    
    String name;
    String phoneNumber;
    String address;
    Integer age;
    
    Builder withName(String name)
    {
        this.name = name;
        return this;
    }
    
    Builder withPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
        return this;
    }
    
    Builder withAddress(String address)
    {
        this.address = address;
        return this;
    }
    
    Builder withAge(Integer age)
    {
        this.age = age;
        return this;
    }
    
    Person build()
    {
        return new Person(this);
    }
    
}

class C
{
    public static void main(String args[])
    {
       // left to right execution
        Person ob = Person.getBuilder().withName("Jakir").withPhoneNumber("01721142225").withAddress("Mymensingh").withAge(22).build();
        ob.printInformation();
    }
}
// Note: Here the commented line were in the code of class, but they aren't working. So, I modified them to run the code

/*
Name: Jakir
Phone number: 01721142225
Address: Mymensingh
Age: 22
*/

* Abstract class:

abstract class A
{
    abstract void m1();
    
    void m2()
    {
        System.out.println("m2 method - A");
    }
}

class B extends A
{
    void m1()
    {
        System.out.println("m1 method - B");
    }
}

class C extends A
{
    void m1()
    {
        System.out.println("m1 method - C");
    }
    
    
}

class Main
{
    public static void main(String args[])
    {
        // A is abstract class so we can't create object of A
        // But we can create reference of A
        A a;
        
        B b = new B();
        // Assinging object of B to the reference variable of A
        // So all elements of B can be accessed through a
        a = b;
        a.m1();
        
        // We can also access methods of A through a
        a.m2();
        
        C c = new C();
        a = c;
        // we can access m1() method of C through a
        a.m1();
       
        
        
    }
}
/*
m1 method - B
m2 method - A
m1 method - C
*/


***
. Checks for divisibility by 3, 5 and 7

import java.util.Scanner;

interface InputDataInterface
{
    void divisibleBy3(DataEvent d);
    void divisibleBy5(DataEvent d);
    void divisibleBy7(DataEvent d);
}

class DataEvent
{
    private int value;
    
    DataEvent(int value)
    {
        this.value = value;
    }
    
    int getValue()
    {
        return value;
    }
}

class A implements InputDataInterface
{
    A()
    {
        UserInputTracker.addDataListener(this); 
    }

    public void divisibleBy3(DataEvent d)
    {
        System.out.println("d.getValue()t : is divisible by 3" );
    }

    public void divisibleBy5(DataEvent d)
    {
        System.out.println("d.getValue()t : is divisible by 5" );
    }

    public void divisibleBy7(DataEvent d)
    {
        System.out.println("d.getValue()t : is divisible by 7" );
    }
    
}

class UserInputTracker
{
    // Variables of InputDataInterface will be created
    static InputDataInterface ob[] = new InputDataInterface[10];
    static int cnt = 0;
    
    static void addDataListener(InputDataInterface e){
        ob[cnt++] = e;
    }
    
    static void callListeners(int value){
        DataEvent d = new DataEvent(value);
        
        for (int i = 0; i < cnt; i++){
            if (value % 3 == 0){
                ob[i].divisibleBy3(d);
            }
            
            if (value % 5 == 0){
                ob[i].divisibleBy5(d);
            }
            
            if (value % 7 == 0){
                ob[i].divisibleBy7(d);
            }
        }
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int in;
        new A();
        
        while (true){
            in = sc.nextInt();
            callListeners(in);
        }
    }
}

Part 09: Interface

Interface:

interface A
{
    // Variable in interface is by default public, static and final
    // final variable is Capitalized
    int VAR = 7;
    
    // Methods in interface is dy default public and abstract
    void m1();
    void m2();
}

// implements keyword is used in interface
class B implements A
{
    // In case of overridden method coverage area must be greater or equal
    // that why method is public
    public void m1()
    {
        System.out.println("m1 method in B");
    }
    
    public void m2()
    {
        System.out.println("m2 method in B");
    }
}

class C implements A
{
    public void m1()
    {
        System.out.println("m1 method in C");
    }
    
    public void m2()
    {
        System.out.println("m2 method in C");
    }
    
    public static void main(String args[])
    {
        // Can't create object of interface.
        // Can create reference
        A a;
        
        B b = new B();
        a = b;
        a.m1(); // m1, m2 in B
        a.m2();
        
        C c = new C();
        a = c;
        // m1, m2 in C
        a.m1();
        a.m2();
        
    }
}
/*
m1 method in B
m2 method in B
m1 method in C
m2 method in C
*/

***
interface It1{
    void m1();
    void m2();
    void m3();
}

// A is abstract class because it doesn't give body to all methods of It1
abstract class A implements It1{
    public void m1(){
        System.out.println("m1 in A");
    }
}

Inheritance vs Interface
. Interface support multiple inheritance but class doesn't.
. Class:
	class A extends B
	class A implements It1
	class A implements It1, It2
. Interface:
	. interface It1 extends It2
	. interface It1 extends It2, It3, It4
. class A extends B implements It1, It2 (class can extends another class and implements interface same time)
***

interface A{
    void m1();
}

interface B extends A{
    void m2();
}

interface C{
    void m3();
}

interface D extends A, B, C{
    void m4();
    // 4 unique prototype exist (method)
}

Nested Interface

interface It1{
    interface It2{
        void m1();
        void m2();
    }
    void m1();
    void m2();
}

// dot(.) is used to access inner interface 
class Test implements It1, It1.It2{
    
    // Though It1 and It2 combinely contains 4 methods but only two of them contain unique prototype
    // So we only have to give body to only 2 methods
    public void m1(){
        System.out.println("m1 - Text");
    }
    
    public void m2(){
        System.out.println("m2 Text");
    }
    
    
}

// Interface can be inside class
class C{
    interface It3{
        void m1();
      
    }
    
    void m4(){
        System.out.println("m4 - C");
    }
}

// dot(.) is used to access inner interface through class
class Test1 implements C.It3{
    public void m1(){
        System.out.println("m1 - test");
    }
}

***
Interface variable:

interface It1{
    int VAR = 8;
    void m1();
}

interface It2{
    int VAR = 9;
    void m2();
    void m1();
}

class Test implements It1, It2{
    public void m1(){
        System.out.println("m1 - Test");
    }
    
    public void m2(){
        System.out.println("m2 - Test");
    }
    
    public static void main(String args[]){
        Test ob = new Test();
       // As VAR present in both It1 and It2, we have to specify which VAR we want to access
        System.out.println(It1.VAR);
        System.out.println(It2.VAR);
    }
}
/*
8
9
*/

Adapter Class

. Adapter class gives empty body to every method of the interface. So, it's become easier to override only desired method by extending the adapter class.

***
interface It1{
    void m1();
    void m2();
    void m3();
}

// A is adapter class
class A implements It1{
    public void m1(){
    }
    
    public void m2(){
        
    }
    
    public void m3(){
        
    }
    
    class B extends A{
        // Overridden method
        // m1 and m2 are the desired method
        public void m1(){
            System.out.println("m1 - B");
        }
        
        public void m2(){
            System.out.println("m2 - B");
        }
        
       
    }
}








