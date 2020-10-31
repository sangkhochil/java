import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class RunnableTask implements Runnable {

	CyclicBarrier cyclicBarrier;
	long sleepTime;

	RunnableTask(CyclicBarrier cyclicBarrier, long sleepTime) {
		this.cyclicBarrier = cyclicBarrier;
		this.sleepTime = sleepTime;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(sleepTime);
			System.out.println(Thread.currentThread().getName() + " is waiting for " + (cyclicBarrier.getParties() - cyclicBarrier.getNumberWaiting() - 1) + " other threads to reach common barrier point");
			/*
			 * when 3 parties will call await() method (i.e. common barrier
			 * point) CyclicBarrrierEvent will be triggered and all waiting
			 * threads will be released.
			 */
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}

		System.out.println("As " + cyclicBarrier.getParties() + " threads have reached common barrier point "
				+ Thread.currentThread().getName() + " has been released");
	}

}
