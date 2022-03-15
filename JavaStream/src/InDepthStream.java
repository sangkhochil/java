import java.util.Arrays;
import java.util.List;

public class InDepthStream {
	private Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0), new Employee(2, "Bill Gates", 200000.0),
			new Employee(3, "Mark Zuckerberg", 300000.0) };

	private List<Employee> empList = Arrays.asList(arrayOfEmps);

	public InDepthStream() {

	}

	public void example_1() {
		empList.stream().forEach(e -> System.out.println(e.salary));
		System.out.println("salary increament 10%");
		empList.stream().forEach(e -> {			
			e.salaryIncrement(10.0);
			System.out.println(String.format("%.1f", e.salary));
		});
	}
}
