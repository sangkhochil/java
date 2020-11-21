# Collections

### 1. What can be output of below code
```java
 
class Country {
	private String name;

	Country(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}

public class CollClient {

	public static void main(String[] str) {
		HashSet myMap = new HashSet();
		String s1 = new String("Bangladesh");
		String s2 = new String("Bangladesh");
		Country s3 = new Country("USA");
		Country s4 = new Country("USA");
		myMap.add(s1);
		myMap.add(s2);
		myMap.add(s3);
		myMap.add(s4);
		System.out.println(myMap);
	}
}
```
Answer: USA USA Bangladesh

Explanation:
As String class overrides hashcode and equals method, it won’t allow the same string twice in HashSet, but we did not implement hashcode and equals method for Country class, 
so each object will have different hashcode hence can be inserted in HashSet.

### 2. What can be output of below code
```java
 

public class Employee {
	public String name;

	@Override
	public int hashCode() {
		return 31;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	public static void main(String args[]) {
		Employee employeeOne = new Employee();
		Employee employeeTwo = new Employee();
		employeeOne.name = "Jahangir";
		employeeTwo.name = "Alam";
		HashSet employeeSet = new HashSet();
		employeeSet.add(employeeOne);
		employeeSet.add(employeeTwo);
		System.out.println(employeeSet.size());
	}
}
```
Answer: 1

Explanation : As equals method always return true and hashcode return constant as 31. So when we try to put employeeTwo in HashSet when it will check for equals method, 
it will always return true, so employeeTwo won’t be added to HashSet

### 3. What can be output of below code
```java
public class Employee {
	public String name;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public static void main(String args[]) {
		Employee employeeOne = new Employee();
		Employee employeeTwo = new Employee();
		employeeOne.name = "John";
		employeeTwo.name = "John";
		HashSet employeeSet = new HashSet();
		employeeSet.add(employeeOne);
		employeeSet.add(employeeTwo);
		System.out.println(employeeSet.size());
	}
}
```
Answer: 2

Explanation :
As we did not implement hashcode method, each object will have different hashcode(memory address) by default, so second object will also be added to employeeSet and size of HashSet will be 2

### 4. What can be output of below code
```java
public class Employee implements Comparable {
	public String name;

	public int compareTo(Object o) {
		return 0;
	}

	public static void main(String args[]) {
		Employee employeeOne = new Employee();
		Employee employeeTwo = new Employee();
		employeeOne.name = "John";
		employeeTwo.name = "Martin";
		TreeSet employeeSet = new TreeSet();
		employeeSet.add(employeeOne);
		employeeSet.add(employeeTwo);
		Iterator empIt = employeeSet.iterator();
		while (empIt.hasNext()) {
			System.out.println(empIt.next().name);
		}
	}
}
```
Answer: B. John

Explanation :
As we can see we have overridden compareTo method in Employee class and always return 0.
Following steps will take place:

- First element with “John” will be added to employeeSet.
- When we will added second element with martin, compareTo method will get called with employeeOne.compareTo(employeeTwo) and it will return 0.
- As compareTo method returns 0, employeeOne is equals to employeeTwo, so employeeTwo will not be added to treeSet.
- So output of above program is “John”

### 5. How to sort a collection of custom Objects in Java?
We need to implement comparable interface to custom object class(Lets say Country) and then implement compareTo(Object o) method which will be used for sorting. It will provides default way of sorting custom objects.
If we want to sort custom object (Lets say country) on different attributes such as name,population etc.We can implement Comparator interface and can be used for sorting.

### 6. What will be output of below code
```java
public class CollQuestion {
	public static void main(String... args) {
		Queue q = new LinkedList();
		q.add("Delhi");
		q.add("Mumbai");
		q.add("Pune");
		show(q);
	}

	public static void show(Queue q) {
		q.add(new Integer(100));
		while (!q.isEmpty())
			System.out.print(q.poll() + " ");
	}
}
```
Correct Answer: Delhi Mumbai Pune 100

Explanation:
As show method done not have any generic attached to it, integer can be also added to queue in show method.

### 7. What will be output of below code
```java
public class Employee {
	public String name;
	public int age;

	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public static void main(String args[]) {

		List employees = new ArrayList();
		Employee emp1 = new Employee("John", 26);
		Employee emp2 = new Employee("Martin", 23);
		Employee emp3 = new Employee("John", 20);
		Employee emp4 = new Employee("Martin", 19);
		Employee emp5 = new Employee("Arpit", 27);

		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		System.out.println("List before sorting : ");
		for (Employee e : employees) {
			System.out.println(e.name + " - " + e.age);
		}
	}
}
```
We have list of employees, now we need to sort them on the basis of name then age. It means if names are equals, then sort it by age.

Answer:
Write a anonymous comparator to sort it by name then age.
```java
Collections.sort(employees,new Comparator() {
 
   @Override
   public int compare(Employee o1, Employee o2) {
    // TODO Auto-generated method stub
    if(o1.name.compareTo(o2.name)==0)
    {
     return o1.age - o2.age;
    }
    else
    {
     return o1.name.compareTo(o2.name);
    }
   }
  });
```

### 8. How HashMap works in java
How HashMap works in java

### 9. What will be output of below code
```java
public class Employee {
	public String name;

	@Override
	public int hashCode() {
		return 31;
	}

	public static void main(String args[]) {
		Employee employeeOne = new Employee();
		Employee employeeTwo = new Employee();
		employeeOne.name = "John";
		employeeTwo.name = "John";
		HashSet employeeSet = new HashSet();
		employeeSet.add(employeeOne);
		employeeSet.add(employeeTwo);
		System.out.println(employeeSet.size());
	}
}
```
Answer: 2

Explanation :
As we did not override equals method here, it will have default implementation which return true if objects point to same reference (==) but here, as we have created two different object as employeeOne and employeeTwo, size of HashSet will be 2

### 10. Difference between Comparator and Comparable in java?

#### Reference's ####
01. https://java2blog.com/
02. https://howtodoinjava.com
03. https://www.journaldev.com
04. https://www.geeksforgeeks.org/
05. https://www.baeldung.com/

