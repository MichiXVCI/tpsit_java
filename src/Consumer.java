public class Consumer implements Runnable {
    private final Box box;

    public Consumer(Box box){
        this.box = box;
    }
    @Override
    public void run(){

        for(int i=0;i<20;i++){

            try {
                box.semaphore_consumer.acquire(); //aspetta che il producer finisca

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            //Per controllare se il producer aspetta che il consumer prelevi il valore dalla scatola

            System.out.println("Consumer: "+ Box.scatola);
            System.out.println();

            box.semaphore_producer.release(); //dice al producer che ha finito di usare scatola

        }
    }
}