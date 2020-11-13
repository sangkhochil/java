
public class Exception4 {
	public static void main(String[] args) {
		System.out.println(exceptionTest());
	}

	public static int exceptionTest() {
		int i = 6;
		try {
			i = 50;
			return i;
		} finally {
			i = 20;
			System.out.println("In finally block");
			return i;
		}

	}
}