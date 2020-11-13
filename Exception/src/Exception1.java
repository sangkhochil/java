
public class Exception1 {
	public static void main(String[] args) {
		System.out.println(exceptionTest());
	}

	public static int exceptionTest() {
		int i = 6;
		try {
			return i;
		} catch (Exception e) {
			i = 10;
		} finally {
			System.out.println("In finally block");
		}
		return i;
	}
}