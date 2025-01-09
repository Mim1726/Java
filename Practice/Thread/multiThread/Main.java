class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running: " + i);
            try {
                Thread.sleep(500); // Pause thread for 500ms
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread(); // Create thread 1
        MyThread t2 = new MyThread(); // Create thread 2

        t1.setName("Thread 1"); // Set thread name
        t2.setName("Thread 2");

        t1.start(); // Start thread 1
        t2.start(); // Start thread 2
    }
}
