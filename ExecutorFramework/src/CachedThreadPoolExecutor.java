import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CachedThreadPoolExecutor {
	public void Example1(){
		ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
		for(int i=1; i<=10; i++){
			ReadDataFromFile readFile = new ReadDataFromFile("file-"+i, "task-"+i);
			System.out.println(String.format("[task-%d] added to read file-%d", i, i));
			executor.execute(readFile);
		}
		executor.shutdown();
	}
}
