
public class BookReader implements Runnable {
	Book book;

	public BookReader(Book book) {
		this.book = book;
	}

	@Override
	public void run() {

		synchronized (book) {
			System.out.println("waiting " + Thread.currentThread().getName());
			try {
				book.wait();
				System.out.println("Notified & Running " + Thread.currentThread().getName());
				book.notify();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class DemoClass {
	private final static Object lock = new Object();

	public void demoMethod() {
		synchronized (lock) {
			// other thread safe code
		}
	}
}