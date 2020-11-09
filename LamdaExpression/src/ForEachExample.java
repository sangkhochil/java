import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ForEachExample {
	public void Example() {
		HashMap<String, String> countryMap = new HashMap<String, String>();
		countryMap.put("Bangladesh", "Dhaka");
		countryMap.put("Japan", "Tokyo");
		countryMap.put("France", "Paris");
		countryMap.put("Russia", "Moscow");

		countryMap.forEach((k, v) -> System.out.println("Country:" + k + " Capital : " + v));

		ArrayList nameList = new ArrayList();
		nameList.add("Jahangir");
		nameList.add("John");
		nameList.add("Martin");
		nameList.add("Alam");

		nameList.forEach(item -> System.out.println(item));
		
		List list = getEmployees();
		
		Collections.sort(list, new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getEmployeeName().compareTo(o2.getEmployeeName());
			}
		});
		
		System.out.println(list);
		Collections.sort(list, (Employee o1, Employee o2) -> o1.getEmployeeName().compareTo(o2.getEmployeeName()));
		System.out.println(list);
	}

	private List getEmployees() {
		List employeesList = new ArrayList();
		Employee e1 = new Employee("John", 35);
		Employee e2 = new Employee("Adam", 22);
		Employee e3 = new Employee("alam", 28);
		Employee e4 = new Employee("John", 30);
		Employee e5 = new Employee("Grace", 38);
		Employee e6 = new Employee("Jahangir", 25);
		employeesList.add(e1);
		employeesList.add(e2);
		employeesList.add(e3);
		employeesList.add(e4);
		employeesList.add(e5);
		employeesList.add(e6);
		return employeesList;
	}
}
