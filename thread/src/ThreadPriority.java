
public class ThreadPriority {
	public void Example1(){
		Thread t1 = new Thread(new ThreadPrioritize(),"Thread1");
		Thread t2 = new Thread(new ThreadPrioritize(),"Thread2");
		Thread t3 = new Thread(new ThreadPrioritize(),"Thread3");
		
		System.out.println("Main thread priority: "+ Thread.currentThread().getPriority());
		System.out.println("T1: "+ t1.getPriority());
		System.out.println("T2: "+ t2.getPriority());
		System.out.println("T3: "+ t3.getPriority());
		
		t1.setPriority(1);
		t2.setPriority(6);
		t3.setPriority(3);
		
		System.out.println("T1: "+ t1.getPriority());
		System.out.println("T2: "+ t2.getPriority());
		System.out.println("T3: "+ t3.getPriority());
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class ThreadPrioritize implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}	
}