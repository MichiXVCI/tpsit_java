
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {

        Box box = new Box();

        for(int i=0;i<5;i++){
            Producer p = new Producer(box);
            Thread t1 = new Thread(p);
            t1.start();
        }

        Consumer c = new Consumer(box);
        Thread t2 = new Thread(c);
        t2.start();

    }
}