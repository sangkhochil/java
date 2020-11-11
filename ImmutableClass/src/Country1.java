import java.util.ArrayList;

public final class Country1 {

	private final String countryName;
	private final ArrayList listOfStates;

	public Country1(String countryName, ArrayList listOfStates) {
		this.countryName = countryName;
		this.listOfStates = listOfStates;
	}

	public String getCountryName() {
		return countryName;
	}

	public ArrayList getListOfStates() {
		return (ArrayList)listOfStates.clone();
	}
}