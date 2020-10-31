import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
	public void Example1() {
		BlockingQueue queue = new ArrayBlockingQueue(10);
		Producer producer = new Producer(queue, 50);
		Consumer consumer = new Consumer(queue, 50);
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
