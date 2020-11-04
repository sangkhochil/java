
public class ReadDataFromFile implements Runnable {
	private String fileName;
	private String taskName;
	public ReadDataFromFile(String fileName, String taskName) {
		super();
		this.fileName = fileName;
		this.taskName = taskName;
	}
	
	@Override
	public void run() {
		System.out.println("["+ taskName + "] reading data from " + fileName + " by " + Thread.currentThread().getName());
		for(int i=1; i<=10; i++){
			System.out.println("["+taskName + "] reading "+fileName+" line: "+ i);
		}
		System.out.println("["+ taskName + "] read data  successfully " + fileName + ": " + fileName + " by " + Thread.currentThread().getName());
	}	
}
