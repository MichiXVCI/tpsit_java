import java.util.concurrent.Semaphore;
import java.util.ArrayDeque;
import java.util.Queue;

public class Box {

    public Queue<Integer> queue = new ArrayDeque<>();
    public int dim = 5;

    public Semaphore coda_vuota = new Semaphore(dim);
    public Semaphore semaphore_producer = new Semaphore(1);
    public Semaphore semaphore_consumer = new Semaphore(0);

    public void produci(int value) throws InterruptedException {
        coda_vuota.acquire();   // aspetta uno spazio libero
        semaphore_producer.acquire();   // entra in sezione critica

        queue.offer(value);
        System.out.println("Prodotto: " + value);

        semaphore_producer.release();   // esce dalla sezione critica
        semaphore_consumer.release();    // segnala che c'è un elemento
    }
    public int consuma() throws InterruptedException {
        semaphore_consumer.acquire();    // aspetta un elemento
        semaphore_producer.acquire();   // entra in sezione critica

        int value = queue.poll();
        System.out.println("Consumato: " + value);

        semaphore_consumer.release();   // esce dalla sezione critica
        semaphore_producer.release();   // segnala uno spazio libero

        return value;
    }
}