import java.util.Scanner;

public class WaitAndNotifyExample {
    static Object obj = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1 is starting..");
                try {
                    synchronized (obj) {
                        obj.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread 1 continue..");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Thread 2 is starting..");
                System.out.println("You should press enter!");
                    scanner.nextLine();
                    synchronized (obj) {
                        obj.notify();
                    }
            }
        });

        thread1.start();
        thread2.start();
    }
}
