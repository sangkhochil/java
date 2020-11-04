import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskExample {
	public void Example1() {
		MultiTaskCallable Task1 = new MultiTaskCallable(10, 20, 2000l);
		MultiTaskCallable Task2 = new MultiTaskCallable(20, 40, 4000l);

		FutureTask<Integer> futureTask1 = new FutureTask<>(Task1);
		FutureTask<Integer> futureTask2 = new FutureTask<>(Task2);

		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(futureTask1);
		executor.execute(futureTask2);

		while (true) {
			try {
				if (!futureTask1.isDone()) {
					System.out.println("FutureTask1 output=" + futureTask1.get());
				}
				if (!futureTask2.isDone()) {
					System.out.println("Waitng for futureTask2 for completion");
					System.out.println("FutureTask2 output=" + futureTask2.get());
				}
				if (futureTask1.isDone() && futureTask2.isDone()) {
					System.out.println("Completed both the FutureTasks, shutting down the executors");
					executor.shutdown();
					return;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	public void Example2() {
		RunnableFutureTask myrunnableobject1 = new RunnableFutureTask(1000);
		RunnableFutureTask myrunnableobject2 = new RunnableFutureTask(2000);

		FutureTask<String> futureTask1 = new FutureTask<>(myrunnableobject1, "FutureTask1 is complete");
		FutureTask<String> futureTask2 = new FutureTask<>(myrunnableobject2, "FutureTask2 is complete");
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.submit(futureTask1);
		executor.submit(futureTask2);

		while (true) {
			try {
				if (futureTask1.isDone() && futureTask2.isDone()) {

					System.out.println("Both FutureTask Complete");
					executor.shutdown();
					return;
				}

				if (!futureTask1.isDone()) {
					System.out.println("FutureTask1 output = " + futureTask1.get());
				}

				System.out.println("Waiting for FutureTask2 to complete");
				String s = futureTask2.get(250, TimeUnit.MILLISECONDS);

				if (s != null) {
					System.out.println("FutureTask2 output=" + s);
				}
			}

			catch (Exception e) {
				System.out.println("Exception: " + e);
			}
		}
	}

}
