
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
