import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayList {
	public void Basic() {
		ArrayList employeeNameList = new ArrayList();
		System.out.println(employeeNameList.size());
		employeeNameList.add("John");
		employeeNameList.add("Alam");
		employeeNameList.add("Ritu");
		employeeNameList.add("Ami");

		System.out.println("Employee list:");

		Iterator iter = employeeNameList.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
