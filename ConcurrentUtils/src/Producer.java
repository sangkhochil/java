import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	BlockingQueue queue = null;
	int count;
	public Producer(BlockingQueue queue, int count) {
		super();
		this.queue = queue;
		this.count = count;
	}

	@Override
	public void run() {
		for (int i = 1; i <= count; i++) {
			System.out.println("Produced item " + i);
			try {
				queue.put("item " + i);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

}