
public class Main {

	public static void main(String[] args) {
		
		 Book book = new Book(); 
		 Thread reader1 = new Thread(new BookReader(book),"reader thread-1"); 
		 Thread reader2 = new Thread(new BookReader(book),"reader thread-2");
//		 reader1.setPriority(Thread.MAX_PRIORITY);
//		 reader2.setPriority(Thread.MIN_PRIORITY);
		 reader1.start(); 
		 reader2.start();
		 
		 //to make sure two reader thread goes to waiting state. 
		 try { 
			 Thread.sleep(100); 
		 }
		 catch (InterruptedException e) { 
			 e.printStackTrace(); 
		}
		 
		 Thread writter = new Thread(new WriterBook(book), "writter thread");
		 writter.start();
	}
}
