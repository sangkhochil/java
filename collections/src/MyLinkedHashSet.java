import java.util.Iterator;
import java.util.LinkedHashSet;

public class MyLinkedHashSet {
	public void Basic() {
		LinkedHashSet countryHashSet = new LinkedHashSet();
		countryHashSet.add("Bangladesh");
		countryHashSet.add("Japan");
		countryHashSet.add("France");
		countryHashSet.add("Russia");
		countryHashSet.add("India");
		countryHashSet.add("France");
		countryHashSet.add("United Kingdom");

		System.out.println("-----------------------------");

		System.out.println("Iterating LinkedHashSet");
		System.out.println("-----------------------------");
		Iterator empIt = countryHashSet.iterator();
		while (empIt.hasNext()) {
			System.out.println(empIt.next());
		}
		System.out.println("-----------------------------");
	}
}
