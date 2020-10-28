
public class InterThreadCommunication2 {
	public void InterThreadCommunication(){
		Thread T1 = new Thread(new InterThread(), "Thread1");
		Thread T2 = new Thread(new InterThread(), "Thread2");
		T1.start();
		T2.start();
	}
}

class InterThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		synchronized(this) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i = 1; i<=10; i++)
				System.out.println(Thread.currentThread().getName() + " -> " + i);
			notify();
		}
	}
	
}
