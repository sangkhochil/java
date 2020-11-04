
public class InterThreadCommunication1 {
	
	boolean wait = false;
	
	public void interThreadCommunication() {
		
		Object lock = new Object();
		
		Thread T1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				synchronized (lock) {
					try {
						if(wait){
							System.out.println(Thread.currentThread().getName() + " waiting");
							lock.wait();
							System.out.println(Thread.currentThread().getName() + " release block");
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for(int i=1; i<=10; i++) {						
						System.out.println(Thread.currentThread().getName()+ " running index = " + i);
						wait = true;
						lock.notify();
					}
					
					System.out.println(Thread.currentThread().getName() + " notified");
				}				
			}
		}, "Thread1");
		
		Thread T2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				synchronized (lock) {
					try {
						if(!wait){
							System.out.println(Thread.currentThread().getName() + " waiting");
							lock.wait();
							System.out.println(Thread.currentThread().getName() + " release block");
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					for(int i=1; i<=10; i++) {						
						System.out.println(Thread.currentThread().getName()+ " running index = " + i);
						wait = false;
						lock.notify();
					}
					
				}				
			}
		}, "Thread2");
		
		T1.start();
		T2.start();				
	}
}
