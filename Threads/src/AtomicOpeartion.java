import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOpeartion {
	public void Example1() {
		//SimpleThread pt = new SimpleThread();
		AtomicThread pt = new AtomicThread();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Processing count=" + pt.getCount());
	}
}

class SimpleThread implements Runnable {
	private int count = 0;

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				Thread.sleep(i * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " " + i);
			count++;
		}
	}

	public int getCount() {
		return this.count;
	}
}

class SincronizedThread implements Runnable {
	private int count = 0;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 1; i < 5; i++) {
				try {
					Thread.sleep(i * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " " + i);
				count++;
			}
		}
	}

	public int getCount() {
		return this.count;
	}
}

class AtomicThread implements Runnable {
	private AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 1; i < 5; i++) {
				count.incrementAndGet();
			}
		}
	}

	public int getCount() {
		return this.count.intValue();
	}
}