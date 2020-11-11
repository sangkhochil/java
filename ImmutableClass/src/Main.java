import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		without_clone();
		with_clone();
		with_deepcopy_and_clone();
	}
	
	private static void without_clone(){
		ArrayList listOfStates = new ArrayList();
		listOfStates.add("Dhaka");
		listOfStates.add("Khulna");
		listOfStates.add("Rajshahi");

		Country country = new Country("Bangladesh", listOfStates);
		System.out.println("Country : " + country.getCountryName());
		System.out.println("List of states : " + country.getListOfStates());
		country.getListOfStates().add("Rangpur");
		listOfStates.add("Chottagram");
		System.out.println("Updated List of states : " + country.getListOfStates());
	}
	
	private static void with_clone(){
		ArrayList listOfStates = new ArrayList();
		listOfStates.add("Dhaka");
		listOfStates.add("Khulna");
		listOfStates.add("Rajshahi");

		Country1 country = new Country1("Bangladesh", listOfStates);
		System.out.println("Country : " + country.getCountryName());
		System.out.println("List of states : " + country.getListOfStates());
		country.getListOfStates().add("Rangpur");
		listOfStates.add("Chottagram");
		System.out.println("Updated List of states : " + country.getListOfStates());
	}
	
	private static void with_deepcopy_and_clone(){
		ArrayList listOfStates = new ArrayList();
		listOfStates.add("Dhaka");
		listOfStates.add("Khulna");
		listOfStates.add("Rajshahi");

		Country2 country = new Country2("Bangladesh", listOfStates);
		System.out.println("Country : " + country.getCountryName());
		System.out.println("List of states : " + country.getListOfStates());
		country.getListOfStates().add("Rangpur");
		listOfStates.add("Chottagram");
		System.out.println("Updated List of states : " + country.getListOfStates());
	}
}
