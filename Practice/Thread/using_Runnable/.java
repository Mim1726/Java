
class MyRunnable implements Runnable{
    public void run(){
        System.out.println("Thread is running: "+Thread.currentThread().getName());
    }
}

public class Main{
    public static void main(String[] args){
        MyRunnable myRunnable=new MyRunnable();
        Thread t1=new Thread(myRunnable);
        t1.start();
    }
}

/*
output:
"Thread is running: Thread-0"
*/
