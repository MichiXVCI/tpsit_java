import java.util.concurrent.Semaphore;

public class Box {

    public Semaphore semaphore_producer = new Semaphore(1);
    public Semaphore semaphore_consumer = new Semaphore(0);

    static public int scatola;
}