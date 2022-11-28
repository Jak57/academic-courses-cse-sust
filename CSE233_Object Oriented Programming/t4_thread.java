1.
    
class MyThread extends Thread{
    public void run(){
        for(int i = 0; i < 15; i++){
            System.out.println("User-defined thread: " + i);
        }
    }
}
class ThreadDemo{
    public static void main(String args[]){
        MyThread t = new MyThread();
        t.start();
        
        for(int i = 0; i < 10; i++){
            System.out.println("Main thread: " + i);
        }
    }
}


2.
class MyThread extends Thread{
    public void run(){
        for(int i = 0; i < 15; i++){
            System.out.println("User-defined thread: " + i);
        }
    }
}
class ThreadDemo{
    public static void main(String args[]){
        MyThread t = new MyThread();
        t.run();
        
        for(int i = 0; i < 10; i++){
            System.out.println("Main thread: " + i);
        }
    }
}
3.
class MyThread extends Thread{
    public void start(){
        for(int i = 0; i < 15; i++){
            System.out.println("User-defined thread: " + i);
        }
    }
}
class ThreadDemo{
    public static void main(String args[]){
        MyThread t = new MyThread();
        t.start();
        
        for(int i = 0; i < 10; i++){
            System.out.println("Main thread: " + i);
        }
    }
}
4.
class MyThread extends Thread{
    public void start(){
        super.start();
        for(int i = 0; i < 5; i++){
            System.out.println("User-defined thread: " + i);
        }
    }
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Hello " + i);
        }
    }
}
class ThreadDemo{
    public static void main(String args[]){
        MyThread t = new MyThread();
        t.start();
        
        for(int i = 0; i < 7; i++){
            System.out.println("Main thread: " + i);
        }
    }
}
6.
class MyThread extends Thread{
  
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Hello " + Thread.currentThread().getName());
        }
    }
    
    public void run(int a){
        for(int i = 0; i < 5; i++){
            System.out.println("Run with parameter");
        }
    }
}
class ThreadDemo{
    public static void main(String args[]){
        MyThread t = new MyThread();
        t.start();
        
        for(int i = 0; i < 7; i++){
            System.out.println("Main thread: " + Thread.currentThread().getName());
        }
    }
}
7.
class MyThread extends Thread{
  
    public void run(){
        for(int i = 0; i < 5; i++){
          
           m1();
           m2();
        }
    }
    public void m1(){
        System.out.println("SUST " + Thread.currentThread().getName());
    }
    public void m2(){
        System.out.println("CSE " + Thread.currentThread().getName());
    }
    
    
}
class ThreadDemo{
    public static void main(String args[]){
        MyThread t = new MyThread();
        t.start();
        
        for(int i = 0; i < 7; i++){
            System.out.println("Main thread: " + Thread.currentThread().getName());
        }
    }
}
8.
class MyThread extends Thread{
  
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("SUST " + Thread.currentThread().getName());
        }
    }

    
    
}
class ThreadDemo{
    public static void main(String args[]){
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        
        t1.start();
        t2.start();
        t3.start();
        
        for(int i = 0; i < 7; i++){
            System.out.println("Main thread: " + Thread.currentThread().getName());
        }
    }
}
9.
class MyThread extends Thread{
  
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("SUST " + i + " " +Thread.currentThread().getName());
        }
    }

    
    
}

class MyThread2 extends Thread{
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("CSE " + i + " " + Thread.currentThread().getName());
        }
        
    }
}
class ThreadDemo{
    public static void main(String args[]){
        MyThread t1 = new MyThread();
        MyThread2 t2 = new MyThread2();
       
      
        t1.start();
        t2.start();
       
        
        for(int i = 0; i < 4; i++){
            System.out.println("Main thread: " + i + " " + Thread.currentThread().getName());
        }
    }
}
10.
class MyThread extends Thread{
  
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("SUST " + Thread.currentThread().getName());
        }
    }

    
    
}

class ThreadDemo{
    public static void main(String args[]){
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
       
      
        t1.start();
        t2.start();
       
        System.out.println(Thread.activeCount());
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        
        System.out.println(t1.getName());
        t1.setName("Jak");
        System.out.println(t1.getName());
        
        System.out.println(t2.getName());
        t2.setName("Lee");
        System.out.println(t2.getName());
        
        Thread.currentThread().setName("Wook");
        System.out.println(Thread.currentThread().getName());
        
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        System.out.println(Thread.activeCount());
    }
}
11.
class MyThread extends Thread{
  
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("SUST " + Thread.currentThread().getName());
        }
    }   
}

class MyThread2 extends Thread{
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Batch18 " + Thread.currentThread().getName());
        }
    }
}

class ThreadDemo{
    public static void main(String args[]){
        MyThread ob = new MyThread();
        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(ob);
        
        MyThread ob1 = new MyThread();
        Runtime r1 = Runtime.getRuntime();
        r1.addShutdownHook(ob1);
        
        MyThread2 t = new MyThread2();
        t.start();
        
        try{
            for(int i = 0; i < 5; i++){
                System.out.println("Main Thread " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException ie){
            System.out.println("CSE");
        }
    }
}
12.
class MyThread extends Thread{
  
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("SUST " + Thread.currentThread().getName());
        }
    }   
}

class MyThread2 extends Thread{
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println("Batch18 " + Thread.currentThread().getName());
        }
    }
}

class ThreadDemo{
    public static void main(String args[]){
        MyThread ob = new MyThread();
        Runtime r = Runtime.getRuntime();
        r.addShutdownHook(ob);
        
        MyThread ob1 = new MyThread();
        Runtime r1 = Runtime.getRuntime();
        r1.addShutdownHook(ob1);
        
        MyThread2 t = new MyThread2();
        t.start();
        
        try{
            for(int i = 0; i < 5; i++){
                if(i == 2)
                    System.exit(0);
                System.out.println("Main Thread " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException ie){
            System.out.println("CSE");
        }
    }
}
13.
class MyThread extends Thread{
    
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }

        }
    }
    

}
class ThreadDemo{
    public static void main(String args[]){
        MyThread ob1 = new MyThread();
        MyThread ob2 = new MyThread();
        
        
        ob1.start();
        
        try{
           
            ob1.join();
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
       
        ob2.start();
        
        for(int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
14.
class MyThread implements Runnable{
    public void run(){
        for(int i = 0; i < 5; i++){
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
    }
}
class ThreadDemo{
    public static void main(String args[]){
        MyThread ob = new MyThread();
        Thread t = new Thread(ob);
        t.start();
        
        for(int i = 0; i < 5; i++){
            try{
                System.out.println(Thread.currentThread().getName() + ": " + i);
                Thread.sleep(1000);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
        }
        
    }
}
15.
class Callme{
    public synchronized void  call(String str){
        System.out.println("[" + str + " " + Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
        System.out.println("]" + " " + Thread.currentThread().getName());
    }
}
class Caller implements Runnable{
    
    Callme target;
    String str;
    Thread t;
    public Caller(Callme targ, String msg){
        target = targ;
        str = msg;
        t = new Thread(this);
        t.start();
    }
    
    public void run(){
        target.call(str);
    }
}

class ThreadDemo{
    public static void main(String args[]){
        Callme target = new Callme();
        
        Caller ob1 = new Caller(target, "Hello");
        Caller ob2 = new Caller(target, "World");
        Caller ob3 = new Caller(target, "Synchronized");
        
        
       /* Caller ob1 = new Caller(target, "Hello");
        try{
            ob1.t.join();
            Caller ob2 = new Caller(target, "World");
            ob2.t.join();
            Caller ob3 = new Caller(target, "Synchronized");
            ob3.t.join();
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }*/
    }
  
    

}
16.
class Callme{
    public synchronized void call(String str){
        for(int i = 0; i < 5; i++){
            System.out.print("[" + str);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
            System.out.println("]" + " " + Thread.currentThread().getName());
        }
       
    }
    public synchronized void printNumbers(String str){
        for(int i = 0; i < 5; i++){
            System.out.print("[" + str);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ie){
                ie.printStackTrace();
            }
            System.out.println("]" + " " + Thread.currentThread().getName());
        }
    }
}
class Caller implements Runnable{
    Callme target;
    String str;
    Thread t;
    int i;
    
    public Caller(Callme targ, String msg, int a){
        target = targ;
        str = msg;
        i = a;
        t = new Thread(this);
        t.start();
    }
    public void run(){
        if(i % 2 == 0)
            target.call(str);
        else
            target.printNumbers(str);
    }
}
class ThreadDemo{
    public static void main(String args[]){
        Callme target = new Callme();
        
        Caller ob1 = new Caller(target, "Hello", 2);
        Caller ob2 = new Caller(target, "World", 5);
        Caller ob3 = new Caller(target, "Synchronized", 3);
        
       // Caller ob1 = new Caller(new Callme(), "Hello");
       // Caller ob2 = new Caller(new Callme(), "World");
        //Caller ob3 = new Caller(new Callme(), "Synchronized");
    }
}








