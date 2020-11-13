import java.math.BigDecimal;

public class GCCollectorExample {
	public static void main(String args[]) {
		createObjects();
	}

	private static void createObjects() {
		long count = 0;
		while (true) {
			System.out.println("running...");
			BigDecimal shortLivedBigDecimal1 = new BigDecimal(count++);
		}
	}
}