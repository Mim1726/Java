
class MyThread extends Thread{
    public void run(){
        System.out.println("Thread is running: "+Thread.currentThread().getName());
    }
}

public class Main{
    public static void main(String[] args){
        MyThread t1=new MyThread();
        t1.start();
    }
}

/*
output:
"Thread is running: Thread-0"
*/
