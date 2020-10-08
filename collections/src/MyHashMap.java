import java.util.HashMap;

public class MyHashMap {
	public void Add() {
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(1, "Alam");
		hashmap.put(2, "John");
		hashmap.put(3, "Devid");
		hashmap.put(4, "Dhaka");

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
}
