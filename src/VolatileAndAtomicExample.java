import java.util.concurrent.atomic.AtomicBoolean;

public class VolatileAndAtomicExample extends Thread{
    // private static volatile boolean isTrue = false; // Burda volatile istifade etdiyimiz zaman thread real deyeri gorecek
    // ve
  private static AtomicBoolean isTrue = new AtomicBoolean(false);
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int a = 0;
                while (!isTrue.get()) {
                    a++;
                }
            }
        });
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        isTrue.set(true);

    }

}
