import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class FixedThreadPoolExecutor {
	public void Example1(){
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newFixedThreadPool(5);
		for(int i=1; i<=10; i++){
			ReadDataFromFile readFile = new ReadDataFromFile("file-"+i, "task-"+i);
			System.out.println(String.format("[task-%d] added to read file-%d", i, i));
			executor.execute(readFile);
		}
		executor.shutdown();
	}
}
