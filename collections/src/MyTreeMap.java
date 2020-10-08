import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class MyTreeMap {
	public void Add() {
		TreeMap<String, String> countryMap = new TreeMap<String, String>();
		countryMap.put("India", "Delhi");
		countryMap.put("Japan", "Tokyo");
		countryMap.put("France", "Paris");
		countryMap.put("Russia", "Moscow");

		System.out.println("-----------------------------");
		System.out.println("Iterating TreeMap Using keySet() and for each loop");
		for (String countryKey : countryMap.keySet()) {
			System.out.println("Country:" + countryKey + " and  Capital:" + countryMap.get(countryKey));

		}
		System.out.println("-----------------------------");
		TreeMap<Integer, String> countryMap1 = new TreeMap<Integer, String>();
		countryMap1.put(12, "Delhi");
		countryMap1.put(5, "Tokyo");
		countryMap1.put(23, "Paris");
		countryMap1.put(2, "Moscow");

		System.out.println("-----------------------------");
		System.out.println("Iterating TreeMap Using keySet() and for each loop");
		for (Integer countryKey : countryMap1.keySet()) {
			System.out.println("Country:" + countryKey + " and  Capital:" + countryMap1.get(countryKey));

		}
		System.out.println("-----------------------------");
	}

	public void CustomSortingForCustomClass() {
		Country india = new Country("India", 1000);
		Country japan = new Country("Japan", 10000);

		Country france = new Country("France", 2000);
		Country russia = new Country("Russia", 20000);

		Comparator comparator = new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				return o2.getName().compareTo(o1.getName());
			}
		};

		System.out.println("Sorting TreeMap in reverse order of country name");
		TreeMap<Country, String> countryMap = new TreeMap<Country, String>(comparator);
		countryMap.put(india, "Delhi");
		countryMap.put(japan, "Tokyo");
		countryMap.put(france, "Paris");
		countryMap.put(russia, "Moscow");

		Iterator countryCapitalIter = countryMap.keySet().iterator();
		while (countryCapitalIter.hasNext()) {
			Country countryObj = (Country) countryCapitalIter.next();
			String capital = countryMap.get(countryObj);
			System.out.println(countryObj.getName() + "----" + capital);
		}
		
		System.out.println("Sorting TreeMap in asending order of country name");
		Country1 india1 = new Country1("India", 1000);
		Country1 japan1 = new Country1("Japan", 10000);
		Country1 france1 = new Country1("France", 2000);
		Country1 russia1 = new Country1("Russia", 20000);
		TreeMap<Country1, String> countryMap1 = new TreeMap<Country1, String>();
		countryMap1.put(india1, "Delhi");
		countryMap1.put(japan1, "Tokyo");
		countryMap1.put(france1, "Paris");
		countryMap1.put(russia1, "Moscow");

		Iterator countryCapitalIter1 = countryMap1.keySet().iterator();
		while (countryCapitalIter1.hasNext()) {
			Country1 countryObj = (Country1) countryCapitalIter1.next();
			String capital = countryMap1.get(countryObj);
			System.out.println(countryObj.getName() + "----" + capital);
		}
	}

	public void Remove() {

	}

	public void Operation() {

	}
}
