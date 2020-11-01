
public class SemaphoreExample {
	public void Example1() {
		final BoundedArrayList ba = new BoundedArrayList(5);
		Runnable runnable1 = new Runnable() {

			@Override
			public void run() {
				try {
					ba.add("John");
					ba.add("Martin");
					ba.add("Adam");
					ba.add("Prince");
					ba.add("Tod");
					System.out.println("Available Permits : " + ba.getSemaphore().availablePermits());
					ba.add("Tony");
					System.out.println("Final list: " + ba.getArraylist());
				} catch (InterruptedException ie) {

				}
			}
		};
		Runnable runnable2 = new Runnable() {
			@Override
			public void run() {
				try {
					System.out.println("Before removing elements: " + ba.getArraylist());
					Thread.sleep(5000);
					ba.remove("Martin");
					ba.remove("Adam");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread t1 = new Thread(runnable1);
		Thread t2 = new Thread(runnable2);
		t1.start();
		t2.start();
	}
}
