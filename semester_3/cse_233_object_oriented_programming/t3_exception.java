1.
import java.io.*;

class TryCatchDemo {

  
    public static void main(String[] args) {
        //Unchecked-Exception
        
        System.out.println("SUST");
        //ArithmaticException
       // System.out.println(10/0);
        System.out.println("CSE");
        
        String str = "Batch18";
        //StringIndexOutOfBoundsException
        //System.out.println(str.charAt(20));
        
        int arr[] = {19, 3, 5, 6};
        
        System.out.println(arr[0]);
        //ArrayIndexOutOfBoundsException
       // System.out.println(arr[89]);
       
       Integer i = Integer.valueOf("10");
       //NumberFormatException
      // Integer i = Integer.valueOf("ten");
       System.out.println(i);
       
       //Checked-Exception
       //FileNotFoundExceptiion
       //FileInputStream ob = new FileInputStream("abc.txt");
       
      // Error(Special Unchecked exception) 
     //Error can not be handled
      //java.lang.OutOfMemoryError
      //int[] arr1 = new int[1000000000];
    }
    
}


2.

public class TryCatchDemo {
 
    public static void main(String[] args) {
        try{
            System.out.println("SUST");
            System.out.println(10/0);
            System.out.println("CSE");
        }
        //System.out.println("Hello");
        catch(Exception ie){
            System.out.println("Batch18");
            try{
                System.out.println(10/0);
            }
            catch(ArithmeticException i){
                    System.out.println("Hi");
            }
            System.out.println("Sylhet");
        }
        System.out.println("Bangladesh");
    }
    
}
3.
import java.util.*;
public class TryCatchDemo {
 
    public static void main(String[] args) {
        try{
            System.out.println("Enter a number: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            
            System.out.println(10/a);
            System.out.println("JakLee".charAt(19));
            System.out.println("CSE");
        }
        catch(ArithmeticException ie){ //RuntimeException, Throwable, Exceptioin
            System.out.println("Batch18");

        }
         catch(StringIndexOutOfBoundsException ie){ 
            System.out.println("Batch15");

        }
        System.out.println("Bangladesh");
    }
    
}
4.
import java.util.*;
public class TryCatchDemo {
 
    public static void main(String[] args) {
        try{
            System.out.println("Enter a number: ");
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            
            System.out.println(10/a);
            System.out.println("JakLee".charAt(19));
            System.out.println("CSE");
        }
       
        catch(ArithmeticException ie){ //RuntimeException
            System.out.println("Batch18");
            System.out.println(ie); //toString() method will be called

        }
        catch(Exception e){
            System.out.println("Bangladesh");
        }
        //Exception before ArithmeticException is invalid
     
    }
    
}
5.
import java.util.*;
public class TryCatchDemo {
    
    void m3(){
        try{
            System.out.println(10/0);
        }
        catch(ArithmeticException e){
            e.printStackTrace();
            
            System.out.println("SUST");
            System.out.println(e.toString());
            System.out.println(e.getMessage());
            System.out.println("CSE");
        }
        
    }
    /*
    void m3(){
        system.out.println(10/0);
        System.out.println("SUST");
    }
    */
    
    void m2(){
        m3();
    
    }
    void m1(){
        m2();
       
    }
 
    public static void main(String[] args) {
        TryCatchDemo t = new TryCatchDemo();
        t.m1();
        System.out.println("Bangladesh");
       
     
    }
    
}
6.
import java.util.*;
public class TryCatchDemo {
    
    void m3(){
        System.out.println(10/0);
        
    }

    
    void m2(){
        m3();
    
    }
    void m1(){
       // m2();
        try{
            m2();
            
        }
        catch(ArithmeticException e){
            System.out.println("SUST");
        }
       
    }
 
    public static void main(String[] args) {
        TryCatchDemo t = new TryCatchDemo();
        t.m1();
   
        System.out.println("Bangladesh");
       
     
    }
    
}
10.
import java.util.*;
import java.io.*;

public class TryCatchDemo {
    
    void m3(){
        try{
            FileInputStream f = new FileInputStream("TryCatch.txt");
            System.out.println("DEF");
            System.out.println("CSE");
        }
        catch(FileNotFoundException e){
            System.out.println("ABC");
            System.out.println("SUST");
        }
        
    }

    
    void m2(){
        m3();
    
    }
    void m1(){
       
        try{
            m2();           
        }
        catch(ArithmeticException e){
            System.out.println("SUST");
        }
       
    }
 
    public static void main(String[] args) {
        TryCatchDemo t = new TryCatchDemo();
        t.m1();          
     
    }
    
}
11.
import java.util.*;
import java.io.*;

public class TryCatchDemo {
 
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
             
            int a = sc.nextInt();
            System.out.println(10/a);

            System.out.println("SUST".charAt(0));
            int arr[] = {10, 45, 3};
            System.out.println(arr[90]);  
        }
        catch(ArithmeticException | ArrayIndexOutOfBoundsException e){
            System.out.println("CSE");
        }
        catch(StringIndexOutOfBoundsException | NullPointerException e){
            System.out.println("Batch18");
        }
        System.out.println("Sylhet");
        
     
    }

    

    
}
12.
import java.util.*;
import java.io.*;

public class TryCatchDemo {
 
    public static void main(String[] args) {
        try{
            FileInputStream fc = new FileInputStream("abc.txt");
            Thread.sleep(1000);
        }
        catch(FileNotFoundException | InterruptedException e){
            System.out.println("CSE");            
        }
     
        System.out.println("Sylhet");
        
     
    }

    

    
}
13.
import java.util.*;
import java.io.*;

public class TryCatchDemo {
 
    public static void main(String[] args) {
        try{
            System.out.println(10/0);
            FileInputStream fc = new FileInputStream("abc.txt");
            Thread.sleep(1000);
        }
        //catch(FileNotFoundException | IOException e)  //Invalid
        catch(FileNotFoundException | InterruptedException | ArithmeticException e){
            System.out.println("CSE");            
        }
     
        System.out.println("Sylhet");
        
     
    }

    

    
}
14.
class TryCatchDemo{
    public static void main(String args[]){
        try{
            System.out.println("SUST");
            System.out.println(10/0);
        }
        catch(ArithmeticException ie){
            System.out.println("CSE");
        }
        finally{
            System.out.println("Batch18");
        }
        
        try{
            int arr[] = {3, 5, 3};
            System.out.println(arr[0]);
        } 
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("IICT");
        }
        finally{
            System.out.println("Campus");
        }
      
        System.out.println("Remaining part");
    }
}
15.
class TryCatchDemo{
    public static void main(String args[]){
        try{
            System.out.println("SUST");
            System.out.println(10/0);
        }   
        catch(ArithmeticException e){
            System.out.println("CSE");
            //System.out.println(10/0);
        }
        finally{
            System.out.println(10/0);
            System.out.println("Batch18");
            
        }
             
        System.out.println("Remaining part");
    }
}
16.
class TryCatchDemo{
    public static void main(String args[]){
       // System.out.println(10/0);
        try{
            System.out.println("SUST");   
             System.exit(0);         
        }   
        catch(ArithmeticException e){
            System.out.println("CSE");       
        }
        finally{
           
            System.out.println("Batch18");            
        }
             
        System.out.println("Remaining part");
    }
}
17.
class TryCatchDemo{
    public static void main(String args[]){
        
        try{
            System.out.println("SUST");            
        }   
        catch(ArithmeticException e){
            System.out.println("CSE"); 
            System.out.println("Hello".charAt(78));
        }
        finally{
           int arr[] = {1, 5, 6};
           System.out.println(arr[89]);                    
        }
             
        System.out.println("Remaining part");
    }
}
18.
class TryCatchDemo{
    
    int m1(){
        try{
            return 10;
        }
        catch(ArithmeticException e){
            return 20;
        }
        finally{
            return 30;
        }
    }
    public static void main(String args[]){
        TryCatchDemo ob = new TryCatchDemo();
        int x = ob.m1();
        
        System.out.println(x);
    }
}
19.
import java.util.*;

class TryCatchDemo{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        
        try{
            System.out.println(10/a);
            try{
                System.out.println("SUST".charAt(0));
            }
            catch(StringIndexOutOfBoundsException ie){
                System.out.println("CSE");
            }
        }
        catch(ArithmeticException ie){
            System.out.println("Batch18");
        }
        finally{
            System.out.println("Sylhet");
        }
        System.out.println("IICT");
    }
}
20.
class TryCatchDemo{
    public static void main(String args[]){
        st-1, st-2;
        try{
            st-3, st-4;  
            try{
                st-5, st-6;
            }
            catch(Exception e){
                st-7, st-8;
            }
        }       
        catch(Exception e){
            st-9, st-10;  
            try{
                st-11, st-12;
            }
            catch(Exception e){
                st-13, st-14;
            }
        }
        finally{
            st-15, st-16;
        }
        st-17, st-18;
    }

}
21.
class TryCatchDemo{
    void m3(){
        //System.out.println(10/0);
        try{
            System.out.println(10/0);
        }
        catch(ArithmeticException e){
            System.out.println("CSE");
           
        }
            
    }
    void m2(){
        m3();        
    }   
    void m1(){
       m2();         
    }
    public static void main(String args[]){
        TryCatchDemo ob = new TryCatchDemo();
        try{
            ob.m1();
        }
        catch(ArithmeticException ie){
            System.out.println("SUST");
        }
    }
}
22.
import java.io.*;

class TryCatchDemo{
    void m3() throws FileNotFoundException{
        FileInputStream fc = new FileInputStream("abc.txt");                              
    }
    void m2() throws FileNotFoundException{
        m3();        
    }   
    void m1() throws FileNotFoundException{
       m2();         
    }
    public static void main(String args[]){
        TryCatchDemo ob = new TryCatchDemo();
        try{
            ob.m1();
        }
        catch(FileNotFoundException ie){
            System.out.println("SUST");
        }
    }
}
23.
import java.io.*;

class TryCatchDemo{
    void m3() throws InterruptedException{
        Thread.sleep(1000);
    }
    void m2() throws InterruptedException{
        m3();        
    }   
    void m1() throws InterruptedException{
       m2();         
    }
    public static void main(String args[]){
        TryCatchDemo ob = new TryCatchDemo();
        try{
            ob.m1();
        }
        catch(InterruptedException ie){
            System.out.println("SUST");
        }
    }
}
24.
import java.io.*;

class TryCatchDemo{
    void m3() throws InterruptedException, FileNotFoundException{
        System.out.println("SUST");
        FileInputStream fc = new FileInputStream("abc.txt");
        Thread.sleep(1000);
        System.out.println("CSE");
    }
    void m2() throws InterruptedException, FileNotFoundException{
        m3();        
    }   
    void m1() throws InterruptedException, FileNotFoundException{
       m2();         
    }
    public static void main(String args[]){
        TryCatchDemo ob = new TryCatchDemo();
        try{
            ob.m1();
        }
        catch(Exception ie){
            System.out.println("IICT");
        }
    }
}
25.
import java.io.*;

class TryCatchDemo{
    void m3() throws InterruptedException, FileNotFoundException{ //Exception
        System.out.println("SUST");
        FileInputStream fc = new FileInputStream("abc.txt");
        Thread.sleep(1000);
        System.out.println("CSE");
    }
    void m2() throws FileNotFoundException{
        try{
            m3();
        }
        catch(InterruptedException ie){
            System.out.println("Hello");
        }        
    }   
    void m1() throws FileNotFoundException{
       m2();         
    }
    public static void main(String args[]){
        TryCatchDemo ob = new TryCatchDemo();
        try{
            ob.m1();
        }
        catch(FileNotFoundException ie){ //Exception
            System.out.println("IICT");
        }
    }
}
26.
import java.util.*;

class MyCheckedException extends Exception{
    MyCheckedException(String str){
        super(str);
    }
}

class TryCatchDemo{
    //int a;
    void m1(int a) throws Exception{
        if(a < 25)
            System.out.println("OK");       
        else
            throw new MyCheckedException("Out of range"); // throw new ArithmeticException("Out of range");
        System.out.println("SUST");
            
    }
    public static void main(String args[]){
        TryCatchDemo ob = new TryCatchDemo();
        Scanner sc = new Scanner(System.in);
        
       int a = sc.nextInt();
      
       try{
           ob.m1(a);
       }
       catch(Exception ie){
           System.out.println("CSE");
           System.out.println(ie);
           System.out.println(ie.getMessage());
       }
    }
}
27.
import java.util.*;

class MyUnCheckedException extends RuntimeException{
    MyUnCheckedException(String str){
        super(str);
    }
}

class TryCatchDemo{
 
    void m1(int a){
        if(a < 25)
            System.out.println("OK");       
        else{
            throw new MyUnCheckedException("Unchecked exception");
           //throw new NullPointerException("null pointer exception");
        }
                
        System.out.println("SUST");           
    }
    public static void main(String args[]){
        TryCatchDemo ob = new TryCatchDemo();
        Scanner sc = new Scanner(System.in);
        
       int a = sc.nextInt();
      
       try{
           ob.m1(a);
       }
       catch(Exception ie){
           System.out.println("CSE");
           System.out.println(ie);
           System.out.println(ie.getMessage());
       }
    }
}




