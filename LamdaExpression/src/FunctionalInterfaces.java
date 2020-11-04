import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalInterfaces {
	public void SupplierExample() {
		Supplier<String> supplier = () -> "jahangir";
		System.out.println(supplier.get());

		Supplier<Integer> supplier1 = () -> new Integer((int) (Math.random() * 1000));
		System.out.println(supplier1.get());

		Supplier<Long> supplier2 = () -> new Long((long) (Math.random() * 1000));
		System.out.println(supplier2.get());

		Supplier<Boolean> supplier3 = () -> new Boolean(true);
		System.out.println(supplier3.get());

		Supplier<Entity> supplier4 = () -> new Entity("sample entity", 1);
		System.out.println(supplier4.get());

		//
		Supplier<Integer> randomNumbers = () -> new Random().nextInt(10);
		Stream.generate(randomNumbers).limit(5).forEach(str -> System.out.println(str));
		Stream.generate(randomNumbers).limit(5).forEach(System.out::println);
	}

	public void ConsumerExample() {
		Consumer<String> consumer1 = s -> System.out.println(s);
		consumer1.accept("Jahangir");

		Consumer<Entity> consumer2 = s -> System.out.println(s);
		consumer2.accept(new Entity("sample entity", 2));

		Consumer<String> firstC = x -> System.out.println(x.toLowerCase());
		Consumer<String> secondC = y -> System.out.println(y.toUpperCase());

		Consumer<String> result = firstC.andThen(secondC);
		result.accept("Jahangir");

		List<Student> students = createStudentList();
		// Creating Consumer for student object which will be used in forEach
		// method of
		// list
		Consumer<Student> consumerStudents = s -> System.out.println(s);
		students.forEach(consumerStudents);
	}

	public void PredicateExample() {
		Predicate<Integer> predicate = i -> i > 100;
		boolean greaterCheck = predicate.test(200);
		System.out.println("is 200 greater than 100: " + greaterCheck);
		
		List<Student> students = createStudentList();
		Predicate<List<Student>> predicate1 = l -> l.stream().filter(s -> s.getGender().equals("M")).collect(Collectors.toList()).isEmpty();
		System.out.println(predicate1.test(students));
		
		Predicate<Integer> predicate2 = i -> i > 100;
		Predicate<Integer> predicate3 = i -> i < 300;
		
		//and
		Predicate<Integer> andPredicate = predicate2.and(predicate3);
		System.out.println("200 lies between 100 and 300: "+  andPredicate.test(200));
		
		//or
		Predicate<Integer> orPredicate = predicate2.or(predicate3);
		System.out.println("200 lies between 100 and 300: "+ orPredicate.test(200));
		
		//negate
		Predicate<Integer> predicate4 = i -> i > 100;		
		Predicate<Integer> NegatePredicate = predicate4.negate();
		System.out.println("30 is less than 100: "+ NegatePredicate.test(30));
		
		//equal
		Predicate<String> predicate5 = Predicate.isEqual("test1");		
		System.out.println(predicate5.test("test1"));
		System.out.println(predicate5.test("test2"));
	}

	private List<Student> createStudentList() {
		List<Student> studentList = new ArrayList<>();
		Student s1 = new Student(1, "Jahangir", "M", 19);
		Student s2 = new Student(2, "John", "M", 17);
		Student s3 = new Student(3, "Mary", "F", 14);
		Student s4 = new Student(4, "Martin", "M", 21);
		Student s5 = new Student(5, "Monica", "F", 16);
		Student s6 = new Student(6, "Ally", "F", 20);

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		return studentList;
	}
}

class Entity {
	String name;
	int type;

	public Entity(String name, int type) {
		super();
		this.name = name;
		this.type = type;
	}
}
