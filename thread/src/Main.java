
public class Main {

	public static void main(String[] args) {
		
	}
	
	public void Test1() {
		Thread myThread = new Thread(new MyThread());
		myThread.start();
		System.out.println("finished thread");
	}
	
	public void Test2() { //main thread wait until come back from child thread. 
		Thread myThread = new Thread(new MyThread());
		myThread.start();
		try {
			myThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("finished thread");
	}
	
	public void Test3() { // main thread 3000 ms then proceed next on the main thread.
		Thread myThread = new Thread(new MyThread());
		myThread.start();
		try {
			myThread.join(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("finished thread");
	}
}
