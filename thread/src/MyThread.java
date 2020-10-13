
public class MyThread implements Runnable {

	@Override
	public void run() {
		System.out.println("runing mythread");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
