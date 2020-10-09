import java.util.Iterator;
import java.util.TreeSet;

public class MyTreeSet {
	public void Basic() {
		CountryTreeSet bangladeshCountry = new CountryTreeSet("Bangladesh");
		CountryTreeSet chinaCountry = new CountryTreeSet("China");
		CountryTreeSet nepalCountry = new CountryTreeSet("Nepal");
		CountryTreeSet bhutanCountry = new CountryTreeSet("Bhutan");
		CountryTreeSet indiaCountry2 = new CountryTreeSet("India");
		CountryTreeSet nepalCountry2 = new CountryTreeSet("Nepal");

		TreeSet countryTreeSet = new TreeSet();
		countryTreeSet.add(bangladeshCountry);
		countryTreeSet.add(chinaCountry);
		countryTreeSet.add(nepalCountry);
		countryTreeSet.add(bhutanCountry);
		countryTreeSet.add(indiaCountry2);
		countryTreeSet.add(nepalCountry2);

		Iterator counIter = countryTreeSet.iterator();
		while (counIter.hasNext()) {
			System.out.println(((CountryTreeSet) counIter.next()).countryName);
		}
		System.out.println("===========================");
	}

	public void Trick() {
		Employee employeeOne = new Employee();
		Employee employeeTwo = new Employee();
		employeeOne.name = "John";
		employeeTwo.name = "Martin";
		TreeSet employeeSet = new TreeSet();
		employeeSet.add(employeeOne);
		employeeSet.add(employeeTwo);
		Iterator empIt = employeeSet.iterator();
		while (empIt.hasNext()) {
			System.out.println(((Employee) empIt.next()).name);
		}
		System.out.println("===========================");
	}
	public void Trick1() {
		Employee1 employeeOne = new Employee1();
		Employee1 employeeTwo = new Employee1();
		employeeOne.name = "John";
		employeeTwo.name = "Martin";
		TreeSet employeeSet = new TreeSet();
		employeeSet.add(employeeOne);
		employeeSet.add(employeeTwo);
		Iterator empIt = employeeSet.iterator();
		while (empIt.hasNext()) {
			System.out.println(((Employee1) empIt.next()).name);
		}
		System.out.println("===========================");
	}
	public void Trick2() {
		Employee1 employeeOne = new Employee1();
		Employee1 employeeTwo = new Employee1();
		employeeOne.name = "John";
		employeeTwo.name = "John";
		TreeSet employeeSet = new TreeSet();
		employeeSet.add(employeeOne);
		employeeSet.add(employeeTwo);
		Iterator empIt = employeeSet.iterator();
		while (empIt.hasNext()) {
			System.out.println(((Employee1) empIt.next()).name);
		}
		System.out.println("===========================");
	}
}

class CountryTreeSet implements Comparable {

	String countryName;

	public CountryTreeSet(String countryName) {
		super();
		this.countryName = countryName;
	}

	@Override
	public int compareTo(Object arg0) {
		CountryTreeSet country = (CountryTreeSet) arg0;

		return (this.countryName.compareTo(country.countryName));
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}

class Employee implements Comparable {
	public String name;

	public int compareTo(Object o) {
		return 0;
	}
}

class Employee1 implements Comparable {
	public String name;

	public int compareTo(Object o) {
		return 1;
	}
}
