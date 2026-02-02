
import java.util.Random;

import static java.lang.Thread.sleep;

public class Producer implements Runnable {
    Random random = new Random();
    private final Box box;
    private final int n_prodotti;

    public Producer(Box box, int n_prodotti){
        this.box = box;
        this.n_prodotti = n_prodotti;
    }

    @Override
    public void run() {
        for(int i=0;i<n_prodotti;i++){
            int prodotto = random.nextInt(100);
            try {
                box.semaphore_producer.acquire(); //parte quando il consumer gli dice che ha scritto il valore in scatola
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            Box.scatola = prodotto;
            System.out.println("Producer: " + Box.scatola);
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            box.semaphore_consumer.release(); //dice al consumer che ha messo un valore nella scatola
        }
    }
}