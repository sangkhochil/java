import java.util.HashSet;

public class MyHashSet {
	// In case of primitive types
	public void Basic() {
		HashSet nameSet = new HashSet();
		nameSet.add("John");
		nameSet.add("David");
		nameSet.add("Carlos");
		nameSet.add("John");
		System.out.println("size of nameSet=" + nameSet.size());
		System.out.println(nameSet);
	}

	// In case of Custom Objects
	public void CustomObject() {
		HashSet countrySet = new HashSet();
		Country bang1 = new Country();
		bang1.setName("Bangladesh");

		Country bang2 = new Country();
		bang2.setName("Bangladesh1");

		countrySet.add(bang1);
		countrySet.add(bang2);

		System.out.println("size of nameSet=" + countrySet.size());
		System.out.println(countrySet);
	}
}