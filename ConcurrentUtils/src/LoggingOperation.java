import java.util.concurrent.CountDownLatch;

public class LoggingOperation implements Runnable {

	CountDownLatch latch;

	LoggingOperation(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Initializing Logging");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done with Logging Initialization");
		latch.countDown();
	}

}