package com.problem2;

import java.util.HashSet;

public class Problem2 {
	public void Test() {
		Country countryOne = new Country();
		Country countryTwo = new Country();
		countryOne.name = "India";
		countryTwo.name = "Nepal";
		HashSet<Country> countrySet = new HashSet<>();
		countrySet.add(countryOne);
		countrySet.add(countryTwo);
		System.out.println(countrySet.size());
	}
}

class Country {
	public String name;

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}