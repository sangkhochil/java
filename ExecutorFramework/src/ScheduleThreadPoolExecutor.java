import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolExecutor {
	public void Example1() throws InterruptedException {
		System.out.println("Current Time = " + new Date());

		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

		for (int i = 1; i <= 3; i++) {
			// Thread.sleep(2000);
			RunnableTask task = new RunnableTask("Task " + i);
			scheduledThreadPool.schedule(task, 5, TimeUnit.SECONDS);
		}

		// Thread.sleep(10000);

		scheduledThreadPool.shutdown();
		System.out.println("Completed all threads");
	}

	public void Example2() throws InterruptedException {
		System.out.println("Current Time = " + new Date());

		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

		for (int i = 1; i <= 3; i++) {
			Thread.sleep(2000);
			RunnableTask task = new RunnableTask("Task " + i);
			scheduledThreadPool.scheduleAtFixedRate(task, 5, 10, TimeUnit.SECONDS);
		}

		Thread.sleep(15000);

		scheduledThreadPool.shutdown();
		while (!scheduledThreadPool.isTerminated()) {
			// wait for all tasks to finish
		}
		System.out.println("Completed all threads");
	}

	public void Example3() throws InterruptedException {
		System.out.println("Current Time = " + new Date());

		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);

		for (int i = 1; i <= 3; i++) {
			Thread.sleep(2000);
			RunnableTask task = new RunnableTask("Task " + i);
			scheduledThreadPool.scheduleWithFixedDelay(task, 5, 10, TimeUnit.SECONDS);
		}
		
		Thread.sleep(30000);

		scheduledThreadPool.shutdown();
		while (!scheduledThreadPool.isTerminated()) {
			// wait for all tasks to finish
		}
		System.out.println("Completed all threads");
	}

}
