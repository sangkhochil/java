public class Employee {

	private String employeeName;
	private int age;

	public Employee(String employeeName, int age) {
		this.employeeName = employeeName;
		this.age = age;

	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return getEmployeeName() + " : " + getAge();
	}
}
