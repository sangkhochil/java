import java.util.ArrayList;

public final class Country {

	private final String countryName;
	private final ArrayList listOfStates;

	public Country(String countryName, ArrayList listOfStates) {
		this.countryName = countryName;
		this.listOfStates = listOfStates;
	}

	public String getCountryName() {
		return countryName;
	}

	public ArrayList getListOfStates() {
		return listOfStates;
	}
}