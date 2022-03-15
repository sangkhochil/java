import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStream {

	// Creating stream different way
	// 1. from collection
	// 2. from arrays
	// 3. from an arbitrary number of objects
	// 4. generate infinite/finite streams

	public void Example() {

		List<Movie> movies = List.of(new Movie("a", 10), new Movie("b", 15), new Movie("c", 20));
		// 1.
		// Imperative programming
		int count1 = 0;
		for (Movie movie : movies) {
			if (movie.getLikes() >= 10)
				count1++;
		}
		System.out.println(count1);

		// Declarative programming(more specific functional programming)
		var count2 = movies.stream().filter(movie -> movie.getLikes() >= 10).count();
		System.out.println(count2);

		// 2.
		System.out.println("--------------------------");
		int[] array = { 1, 2, 3, 4 };
		Arrays.stream(array).forEach(a -> System.out.println(a));

		// 3.
		System.out.println("--------------------------");
		Stream.of(1, 2, 3, 4).forEach(a -> System.out.println(a));

		System.out.println("--------------------------");
		var stream = Stream.generate(() -> Math.random());
		stream.limit(5).forEach(a -> System.out.println(a));

		System.out.println("--------------------------");
		Stream.iterate(1, n -> n + 1).limit(10).forEach(a -> System.out.println(a));

		System.out.println("--------------------------");
	}
}
