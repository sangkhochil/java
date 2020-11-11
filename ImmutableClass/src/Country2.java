import java.util.ArrayList;

public final class Country2 {

	private final String countryName;
	private final ArrayList listOfStates;

	public Country2(String countryName, ArrayList listOfStates) {
		this.countryName = countryName;
		ArrayList tempList = new ArrayList();

		for (int i = 0; i < listOfStates.size(); i++) {
			tempList.add(listOfStates.get(i));
		}
		this.listOfStates = tempList;
	}

	public String getCountryName() {
		return countryName;
	}

	public ArrayList getListOfStates() {
		return (ArrayList) listOfStates.clone();
	}
}