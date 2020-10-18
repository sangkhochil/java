
public class Main {

	public static void main(String[] args) {
		new Main().Test4();
	}
	
	public void Test1() {
		Thread myThread = new Thread(new MyThread(), "Thread1");
		myThread.start();
		System.out.println("main thread");
	}
	
	public void Test2() { //main thread wait until come back from child thread. 
		Thread myThread = new Thread(new MyThread(), "Thread2");
		myThread.start();
		try {
			myThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread");
	}
	
	public void Test3() { // main thread 3000 ms then proceed next on the main thread.
		Thread myThread = new Thread(new MyThread(), "Thread3");
		myThread.start();
		try {
			myThread.join(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread");
	}
	
	public void Test4() {
		Thread myThread = new Thread(new MyThread2(), "Thread4");
		myThread.start();
		try {
			myThread.join(2000, 500); //2000 milliseconds plus 500 nanoseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("main thread");
	}
}
