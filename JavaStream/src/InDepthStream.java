import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InDepthStream {

	private List<Employee> empList = Arrays.asList(Employee.getAll());

	public InDepthStream() {

	}

	public void example_1() {
		empList.stream().forEach(e -> System.out.println(e.salary));
		System.out.println("salary increament 10%");
		empList.stream().forEach(e -> {
			e.salaryIncrement(10.0);
			System.out.println(String.format("%.1f", e.salary));
		});
	}

	// map() api
	// stream map() api lets convert an object to something else.
	public void example_2() {
		empList.stream().map(e -> e.getName()).collect(Collectors.toList()).forEach(System.out::println);
	}

	// collect()
	// one of the common way to get stuff out of the stream once we are done all
	// processing.
	public void example_3() {
		empList.stream().collect(Collectors.toList()).forEach(System.out::println);
	}

	// filter()
	// produce new stream from original stream with filtered data
	public void example_4() {
		empList.stream().filter(e -> e.getId() >= 2).forEach(e -> System.out.println(e.name));
		empList.stream().map(e -> e.getId()).filter(e -> e.intValue() >= 2).forEach(System.out::println);
	}

	//	findFirst()
	//	findFirst() returns an Optional for the first entry in the stream; 
	public void example_5() {
		Integer[] empIds = { 1, 2, 3, 4 };
		Employee emp = Stream.of(empIds).map(Employee::getById).filter(e -> e != null)
				.filter(e -> e.getSalary() >= 200000).findFirst().orElse(null);
		System.out.println(emp);
	}
	
	//toArray()
	public void example_6() {
		Employee[] array = empList.stream().toArray(Employee[]::new);
		Stream.of(array).forEach(System.out::println);
	}
	
	//flatMap()
	//flatMap lets to flatten  the data structure to simplify further operations
	public void example_7() {
		List<Integer> l1 = List.of(1,2,3);
		List<Integer> l2 = List.of(2,3,4);
		List<Integer> l3 = List.of(3,4,5);
		
		Stream.of(l1,l2,l3).forEach(e-> System.out.println(e));
		Stream.of(l1,l2,l3).distinct().flatMap(Collection::stream).forEach(System.out::println);
	}
}
