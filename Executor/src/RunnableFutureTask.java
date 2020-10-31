import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableFutureTask implements Runnable {
	private final long waitTime; 
	  
    public RunnableFutureTask(int timeInMillis) 
    { 
        this.waitTime = timeInMillis; 
    } 
  
    @Override
    public void run() 
    { 
        try {
            Thread.sleep(waitTime);           
            System.out.println(Thread.currentThread().getName()); 
        } 
  
        catch (InterruptedException ex) { 
            Logger.getLogger(RunnableFutureTask.class.getName()).log(Level.SEVERE, null, ex); 
        } 
    } 
}
