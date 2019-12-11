import java.util.Random;
import java.util.Stack;

public class ProducerConsumer {
    Stack buffer = new Stack<Integer>();
    static final int N = 10;
    int count = 0;
    Random random = new Random();

    void producer() throws InterruptedException {
        int item;
        while (true) {
            item = random.nextInt(100);
            if (count == N) {
                wait();
            }
            System.out.println("Produced: " + item + "items");
            buffer.push(item);
            count++;
            if (count == 1) {
                notify();
            }
        }
    }
    void consumer() throws InterruptedException {
        int item;
        while (true) {
            if (count == 0) {
                wait();
            }
            item = (int) buffer.pop();
            System.out.println("Consumed: " + item + "items");
            count--;
            if (count == N -1){
                notify();
            }
        }
    }
}
