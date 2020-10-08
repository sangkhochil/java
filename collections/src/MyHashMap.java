import java.util.HashMap;

public class MyHashMap {
	public void Add() {
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(1, "Alam");
		hashmap.put(2, "John");
		hashmap.put(3, "Devid");
		hashmap.put(4, "Dhaka");
		hashmap.put(null, "null value");
		hashmap.put(5, null);
		hashmap.put(null, null);

		System.out.println(hashmap);
	}

	public void Remove() {
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();

		hashmap.put("Bike", 120);
		hashmap.put("Car", 220);
		hashmap.put("Truck", 160);
		hashmap.put("Activa", 140);
		System.out.println(hashmap);

		// Remove truck key
		Integer speed = hashmap.remove("Truck");
		System.out.println("===============================");
		System.out.println("Vehicle Truck with max speed " + speed + " removed from HashMap");
		System.out.println(hashmap);
		System.out.println("================================");

		// Remove Car if value is 200
		boolean isCarRemoved = hashmap.remove("Car", 200);
		// Car key won't be removed as associated value is 220
		System.out.println("Did car removed from HashMap: " + isCarRemoved);
		System.out.println(hashmap);
		System.out.println("===============================");

		// Remove Car if value is 200
		boolean isActivaRemoved = hashmap.remove("Activa", 140);
		// Activa key will be removed as associated value is 140
		System.out.println("Did activa removed from HashMap: " + isActivaRemoved);
		System.out.println(hashmap);
		System.out.println("===============================");
	}

	public void Operation() {
		HashMap<String, String> hashmap = new HashMap<>();
		
		boolean empty = hashmap.isEmpty();
		System.out.println("is hashmap empty: " + empty);
		
		hashmap.put("Arpit", "Tech");
		hashmap.put("John", "Sales");
		hashmap.put("Martin", "HR");
		hashmap.put("Vaibhav", "Tech");

		System.out.println(hashmap);
		System.out.println("size of hashmap: " + hashmap.size());
		
		System.out.println("Martin's department: " + hashmap.get("Martin"));
		System.out.println("Robin's department: " + hashmap.get("Robin"));

		if (hashmap.containsKey("John")) {
			System.out.println("hashmap has John as key");
		}

		if (hashmap.containsValue("Sales")) {
			System.out.println("hashmap has Sales as value");
		}
		
		hashmap.clear();
		System.out.println(hashmap);
	}
}
