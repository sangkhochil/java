package com.problem1;

import java.util.HashMap;

public class Problem1 {
	public void Test() {
		HashMap<Country, String> countryMap = new HashMap<>();
		Country country = new Country("Bangladesh", 10000);
		Country country1 = new Country("Bangladesh", 10000);
		Country country2 = new Country("USA", 10000);
		countryMap.put(country, "Dhaka");
		countryMap.put(country, "Tangail"); // same hash value replace the existing value of key.
		countryMap.put(country1, "Rajshahi"); // equal method return true and same hash value so, not add to map but replace the existing value of key.
		countryMap.put(country2, "Washington DC"); //add new item
		country.name = "Dummy";
		System.out.println("Capital of Bangladesh is: " + countryMap.get(country)); // during get hash value would be different due to changes of name and return null
	}
}

class Country {
	String name;
	long population;
	//static int x = 1;

	Country(String name, long population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (population ^ (population >>> 32));
		return result; // + x++;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (population != other.population)
			return false;
		return true;
	}
}