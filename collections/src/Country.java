
public class Country {

	String name;
	long population;

	public Country(String name, long population) {
		super();
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

//	@Override
//	public int compareTo(Country o) {
//		return this.getName().compareTo(o.getName());
//	}
}

class Country1 implements Comparable<Country1>{

	String name;
	long population;

	public Country1(String name, long population) {
		super();
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
	public int compareTo(Country1 o) {
		return this.getName().compareTo(o.getName());
	}
}