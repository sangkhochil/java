import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	int i = 0;
	BlockingQueue queue = null;
	int count;

	public Consumer(BlockingQueue queue, int count) {
		super();
		this.queue = queue;
		this.count = count;
	}

	@Override
	public void run() {

		while (true) {
			i++;
			try {
				System.out.println("Consumed " + queue.take());
				if (i == count) {
					System.out.println("finished");
					return;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}