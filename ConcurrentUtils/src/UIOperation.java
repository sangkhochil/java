import java.util.concurrent.CountDownLatch;

public class UIOperation implements Runnable {

	CountDownLatch latch;

	UIOperation(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Initializing UI Operation");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done with UI Initialization");
		latch.countDown();
	}

}