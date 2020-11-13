
public class Exception2 {
	public static void main(String[] args) {
		System.out.println(exceptionTest());
	}

	public static int exceptionTest() {
		int i = 6;
		try {
			throw new NullPointerException();
		} catch (Exception e) {
			i = 10;
			return i;
		} finally {
			i = 20;
			System.out.println("In finally block");
		}
	}
}
