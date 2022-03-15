import java.util.stream.Stream;

public class Employee {
	private static Employee[] arrayOfEmps = { new Employee(1, "Jeff Bezos", 100000.0), new Employee(2, "Bill Gates", 200000.0),
			new Employee(3, "Mark Zuckerberg", 300000.0) };
	
	int id;
	String name;
	double salary;

	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void salaryIncrement(double rate) {
		this.salary = (1 + (rate / 100)) * this.salary;
	}
	
	public static Employee getById(int id) {
		return Stream.of(arrayOfEmps).filter(e->e.getId() == id).findFirst().orElse(null);
	}
	
	public static Employee[] getAll() {
		return arrayOfEmps;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
