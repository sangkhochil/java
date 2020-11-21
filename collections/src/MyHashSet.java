import java.util.HashSet;

public class MyHashSet {
	// In case of primitive types
	public void Basic() {
		HashSet nameSet = new HashSet();
		nameSet.add("John");
		nameSet.add("David");
		nameSet.add("Carlos");
		nameSet.add("John");
		nameSet.add(123);
		nameSet.add(123);
		nameSet.add(true);
		nameSet.add(true);
		nameSet.add(false);
		nameSet.add(12.3);
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
		Country bang3 = new Country();
		bang3.setName("Bangladesh1");
		System.out.println("exist: "+ countrySet.contains(bang3));
	}
}