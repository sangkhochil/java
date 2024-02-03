# Immutable

### 1. What is immutable class?
Immutable objects are those objects whose state can not be changed once created. Class whose objects possess this characteristic can be termed as immutable class.
For example all wrraper class : String , Integer, Boolean, Double.

### 2. What are steps for creating an immutable class?
Make our class final : 
- If we make our class final, no class will be able to extend it, hence will not be able override methods of this class.
- Declare all instance variable with private and final : 
- If we make instance variable private, no outside class will be able to access instance variables and if we make them final, we can not change it.
- declare no to setter methods :
- Don’t create setter method for any instance variables, hence there will be no explicit way to change state of instance variables.
- Initialize all variables in constructor :
- we can initialize variables in constructor. we need to take special care while working with mutable object. we need to do deep copy in case of immutable objects.
- Perform cloning of mutable objects while returning from getter method:
- If we return clone of object from getter method, it won’t return original object, so your original object will remain intact.

### 3. Can we answer if below Employee class is immutable or not? If not what will we do to make it immutable?
```java
public final class Employee {
	private final String name;
	private final ArrayList addresses;

	public Employee(String name, ArrayList addresses) {
		super();
		this.name = name;
		ArrayList tempAdd = new ArrayList();
		for (int i = 0; i < addresses.size(); i++) {
			tempAdd.add(addresses.get(i));
		}
		this.addresses = tempAdd;
	}

	public String getName() {
		return name;
	}

	public ArrayList getAddresses() {
		return addresses;
	}
}
```
Employee class is not an immutable class because we can still perform employee.getAddresses().add(“New address”) and it will be added to employee’s addresses list.

If you change above getAddresses() method to below method, Employee class will become immutable.
```java
public ArrayList getAddresses() {
  return (ArrayList) addresses.clone();
 }
```

### 4. Can we provide example of immutable class?
Yes.  all wrraper class : String , Integer, Boolean, Double.
custom immutable class
```java
public final class Country {
    // declared private final instance variable
 private final String countryName;
 // Mutable object
 private final ArrayList listOfStates;
 
 public Country(String countryName, ArrayList listOfStates) {
  super();
  this.countryName = countryName;
  // Creating deep copy for mutable object
  ArrayList tempList = new ArrayList();
 
  for (int i = 0; i < listOfStates.size(); i++) {
   tempList.add(listOfStates.get(i));
  }
  this.listOfStates = tempList;
 }
 
 public String getCountryName() {
     // Do not need to do cloning as it is immutable object
  return countryName;
 }
 
 public ArrayList getListOfStates() {
     // Returning cloned object 
  return (ArrayList) listOfStates.clone();
 }
}
```

### 5. Do immutable classes thread safe? If yes then how?
Immutable classes are thread safe because we can not change state of immutable objects

### 6. What precautions we need to take if we are working with mutable instance variables?
If we are working with mutable instance variable(addresses list in above Employee class) then do following:

- Do deep copy mutable variable in constructor.
- Return clone of instance variable from getter of that instance variable rather than actual variable.

### 7. Why immutable objects are considered to be good keys for HashMap?
Immutable object’s hashcode won’t change, so it makes key retrieval faster as we can cache different hashcode for different keys

### 8. Can you give some good examples of immutable classes?
String, Integer, Long, Double, Character, Boolean etc and much more. Date is not an immutable class.



#### Reference's ####
01. https://java2blog.com/
02. https://howtodoinjava.com
03. https://www.journaldev.com
04. https://www.geeksforgeeks.org/
05. https://www.baeldung.com/

