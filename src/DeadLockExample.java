public class DeadLockExample {
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1: initialize ");
                synchronized (lock1) {
                    System.out.println("Thread 1 is waiting for - lock 2");
                    synchronized (lock2) {
                        System.out.println("Thread 1");
                    }
                }
            }
        });

        Thread thread2 =new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 2: initialize");
                synchronized (lock2) {
                    System.out.println("Thread 2 is waiting for - lock 1");
                    synchronized (lock1) {
                        System.out.println("Thread 1");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
