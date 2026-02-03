public class Consumer implements Runnable {
    private final Box coda;

    public Consumer(Box coda) {
        this.coda = coda;
    }
    @Override
    public void run() {
        try {
            while (true) {
                coda.consuma();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}