
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Stream map(Function mapper) returns a stream consisting of the results of applying the given function to the elements of this stream.
//
//Stream map(Function mapper) is an intermediate operation. These operations are always lazy. Intermediate operations are invoked on a Stream instance and after they finish their processing, they give a Stream instance as output.

public class StreamMap {
	public void Example() {
		List<Movie> movies = List.of(
				new Movie("a", 10), 
				new Movie("b", 15), 
				new Movie("c", 20));
		
		movies.stream()
			.map(movie -> movie.getTitle())
			.forEach(m -> System.out.println(m));
		
		List<Integer> list = Arrays.asList(1,2,3,4);
		list.stream()
			.map(number -> number*3)
			.forEach(number -> System.out.println(number));
		
		//lowercase -> uppercase
		List<String> lowercase = Arrays.asList("geeks", "gfg", "g", "e", "e", "k", "s");
		List<String> uppercase = lowercase.stream()
			.map(s -> s.toUpperCase())
			.collect(Collectors.toList());
		System.out.println(uppercase);
				
		
		//flatmap
		var stream = Stream.of(List.of(1,2,3), List.of(4,5,6));
		
		stream
			.forEach(l -> System.out.println(l));
		
		stream
			.flatMap(l -> l.stream())
			.forEach(v -> System.out.println(v));
		
		// stream has already been operated upon or closed -> this exception
		// overcome exception by using get, it's return same stream.
		
		Supplier<Stream<String>> streamSupplier 
		  = () -> Stream.of("A", "B", "C", "D");
		  
		Optional<String> result1 = streamSupplier.get().findAny();
		System.out.println(result1.get());
		
		Optional<String> result2 = streamSupplier.get().findFirst();
		System.out.println(result2.get());
		
	}
}
