
public class WriterBook implements Runnable {
	Book book;
	public WriterBook(Book book) {
		this.book = book;
	}
	@Override
	public void run() {
		synchronized (book) {
			System.out.println("Running "+ Thread.currentThread().getName());
			try {
				Thread.sleep(100);
				book.notify();
				//book.notifyAll();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
	}
}
