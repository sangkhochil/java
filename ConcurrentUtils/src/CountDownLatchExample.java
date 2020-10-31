import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
	public void Example1() {
		try {
			CountDownLatch latch = new CountDownLatch(3);

			// Initializing three dependent thread i.e. UI, database and logging

			UIOperation uiInitialization = new UIOperation(latch);
			Thread uiThread = new Thread(uiInitialization);

			DataBaseOperation dataBaseInitialization = new DataBaseOperation(latch);
			Thread databaseThread = new Thread(dataBaseInitialization);

			LoggingOperation loggingInitialization = new LoggingOperation(latch);
			Thread loggingThread = new Thread(loggingInitialization);

			uiThread.start();
			databaseThread.start();
			loggingThread.start();
			// Main thread will wait until above threads get completed
			latch.await();

			System.out.println("Initialization has been completed, main thread can proceed now");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
