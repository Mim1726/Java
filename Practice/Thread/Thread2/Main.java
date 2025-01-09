class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable(); // Create a runnable object
        Thread t = new Thread(r); // Pass the runnable to the thread
        t.start(); // Start the thread
    }
}
