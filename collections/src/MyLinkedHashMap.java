
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

public class MyLinkedHashMap {
	public void Add() {
		LinkedHashMap<Integer, String> LinkedHashMap = new LinkedHashMap<Integer, String>();
		LinkedHashMap.put(10, "Alam");
		LinkedHashMap.put(9, "John");
		LinkedHashMap.put(11, "Devid");
		LinkedHashMap.put(4, "Dhaka");
		LinkedHashMap.put(null, "null value");
		LinkedHashMap.put(3, null);
		LinkedHashMap.put(null, null);

		for (Map.Entry me : LinkedHashMap.entrySet()) {
			System.out.println("Key: " + me.getKey() + " & Value: " + me.getValue());
		}
		System.out.println("===============================");
		Iterator iterator = LinkedHashMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry me2 = (Map.Entry) iterator.next();
			System.out.println("Key: " + me2.getKey() + " & Value: " + me2.getValue());
		}
		System.out.println(LinkedHashMap);
		System.out.println("===============================");
	}

	public void Remove() {
		LinkedHashMap<String, Integer> LinkedHashMap = new LinkedHashMap<String, Integer>();

		LinkedHashMap.put("Bike", 120);
		LinkedHashMap.put("Car", 220);
		LinkedHashMap.put("Truck", 160);
		LinkedHashMap.put("Activa", 140);
		System.out.println(LinkedHashMap);

		// Remove truck key
		Integer speed = LinkedHashMap.remove("Truck");
		System.out.println("===============================");
		System.out.println("Vehicle Truck with max speed " + speed + " removed from LinkedHashMap");
		System.out.println(LinkedHashMap);
		System.out.println("================================");

		// Remove Car if value is 200
		boolean isCarRemoved = LinkedHashMap.remove("Car", 200);
		// Car key won't be removed as associated value is 220
		System.out.println("Did car removed from LinkedHashMap: " + isCarRemoved);
		System.out.println(LinkedHashMap);
		System.out.println("===============================");

		// Remove Car if value is 200
		boolean isActivaRemoved = LinkedHashMap.remove("Activa", 140);
		// Activa key will be removed as associated value is 140
		System.out.println("Did activa removed from LinkedHashMap: " + isActivaRemoved);
		System.out.println(LinkedHashMap);
		System.out.println("===============================");
	}

	public void Operation() {
		LinkedHashMap<String, String> LinkedHashMap = new LinkedHashMap<>();

		boolean empty = LinkedHashMap.isEmpty();
		System.out.println("is LinkedHashMap empty: " + empty);

		LinkedHashMap.put("Arpit", "Tech");
		LinkedHashMap.put("John", "Sales");
		LinkedHashMap.put("Martin", "HR");
		LinkedHashMap.put("Vaibhav", "Tech");

		System.out.println(LinkedHashMap);
		System.out.println("size of LinkedHashMap: " + LinkedHashMap.size());

		System.out.println("Martin's department: " + LinkedHashMap.get("Martin"));
		System.out.println("Robin's department: " + LinkedHashMap.get("Robin"));

		if (LinkedHashMap.containsKey("John")) {
			System.out.println("LinkedHashMap has John as key");
		}

		if (LinkedHashMap.containsValue("Sales")) {
			System.out.println("LinkedHashMap has Sales as value");
		}

		LinkedHashMap.clear();
		System.out.println(LinkedHashMap);
	}
}
