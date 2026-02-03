import java.util.Random;
import static java.lang.Thread.sleep;

public class Producer implements Runnable {
    Random random = new Random();
    private final Box coda;

    public Producer(Box coda) {
        this.coda = coda;
    }
    @Override
    public void run() {
        int value = 1;
        try {
            while (true) {
                coda.produci(random.nextInt(100));
                sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}