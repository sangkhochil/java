import java.util.HashSet;

public class Employee {
	public String name;

	@Override
	public int hashCode() {
		System.out.println("hashCode");
		return 31;
	}	

	public static void main(String args[]) {
		Employee employeeOne = new Employee();
		//System.out.println(employeeOne);
		Employee employeeTwo = new Employee();
		//System.out.println(employeeTwo);
		employeeOne.name = "John";
		employeeTwo.name = "John";
		HashSet employeeSet = new HashSet();
		employeeSet.add(employeeOne);
		employeeSet.add(employeeTwo);
		System.out.println(employeeSet.size());
	}
}
