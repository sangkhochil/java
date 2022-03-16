import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
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

	// findFirst()
	// findFirst() returns an Optional for the first entry in the stream;
	public void example_5() {
		Integer[] empIds = { 1, 2, 3, 4 };
		Employee emp = Stream.of(empIds).map(Employee::getById).filter(e -> e != null)
				.filter(e -> e.getSalary() >= 200000).findFirst().orElse(null);
		System.out.println(emp);
	}

	// toArray()
	public void example_6() {
		Employee[] array = empList.stream().toArray(Employee[]::new);
		Stream.of(array).forEach(System.out::println);
	}

	// flatMap()
	// flatMap lets to flatten the data structure to simplify further operations
	public void example_7() {
		List<Integer> l1 = List.of(1, 2, 3);
		List<Integer> l2 = List.of(2, 3, 4);
		List<Integer> l3 = List.of(3, 4, 5);

		Stream.of(l1, l2, l3).forEach(e -> System.out.println(e));
		Stream.of(l1, l2, l3).distinct().flatMap(Collection::stream).forEach(System.out::println);
	}

	// peek()
	// when we need multiple operation for each element on stream, we can use peek
	// for intermediate operator for applied any terminal operation
	public void example_8() {
		empList.stream().peek(e -> e.salaryIncrement(10)).peek(e -> e.salaryFormate()).peek(System.out::println)
				.collect(Collectors.toList());

	}

	// Some operations are deemed short-circuiting operations.
	// Short-circuiting operations allow computations on infinite streams to
	// complete in finite time:
	
	//Here, we use short-circuiting operations skip() to skip first 3 elements, 
	//and limit() to limit to 5 elements from the infinite stream generated using iterate().
	public void example_9() {
		Stream short_circuite = Stream.iterate(2, i -> i * 2);
		
		short_circuite
			.skip(3)
			.limit(5)
			.forEach(System.out::println);
	}
	//	Lazy Evaluation
	//	One of the most important characteristics of Java streams is that they allow for significant optimizations through lazy evaluations.
	//
	//	Computation on the source data is only performed when the terminal operation is initiated, and source elements are consumed only as needed.
	//
	//	All intermediate operations are lazy, so they’re not executed until a result of a processing is actually needed.
	
	public void example_10() {
		Integer[] empIds = { 1, 2, 3, 4 };
		Employee emp = Stream.of(empIds).map(Employee::getById).filter(e->e!=null).filter(e->e.salary>=200000).findFirst().orElse(null);
		System.out.println(emp);
	}
	
	public void example_11() {
		System.out.println("byName:");
		empList.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).forEach(System.out::println);
		System.out.println("byId:");
		empList.stream().sorted((e1,e2)->e1.getId() - e2.getId()).forEach(System.out::println);
		System.out.println("bySalary:");
		empList.stream().sorted((e1,e2)-> (int)(e1.getSalary() - e2.getSalary())).forEach(System.out::println);
	}
	
	public void example_12() {
		Employee emp = empList.stream().min((e1, e2) -> e1.getId() - e2.getId()).orElseThrow(NoSuchElementException::new);
		System.out.println(emp);
		
		emp = empList.stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow(NoSuchElementException::new);
		System.out.println(emp);
	}
	
	public void example_13() {
		 List<Integer> intList = Arrays.asList(2, 5, 3, 2, 4, 3);
		 List<Integer> distinct_list = intList.stream().distinct().collect(Collectors.toList());
		 System.out.println(distinct_list);
	}
	
	public void example_14() {
		List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
	    
	    boolean allEven = intList.stream().allMatch(i -> i % 2 == 0);
	    System.out.println(allEven);
	    boolean oneEven = intList.stream().anyMatch(i -> i % 2 == 0);
	    System.out.println(oneEven);
	    boolean noneMultipleOfThree = intList.stream().noneMatch(i -> i % 3 == 0);
	    System.out.println(noneMultipleOfThree);
	}
	
	public void example_15() {
		int value = empList.stream().mapToInt(Employee::getId).max().orElseThrow(NoSuchElementException::new);
		System.out.println(value);
		
		Double avarage = empList.stream().mapToDouble(Employee::getSalary).average().orElseThrow(NoSuchElementException::new);
		System.out.println(avarage);
		
		Double sum = empList.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
		System.out.println(sum);
	}
}
