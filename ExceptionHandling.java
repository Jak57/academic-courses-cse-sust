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
