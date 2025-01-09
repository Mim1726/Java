class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t = new MyThread(); // Create a thread object
        t.start(); // Start the thread, which calls the `run()` method
    }
}
