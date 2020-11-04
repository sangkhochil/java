import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousFunction {
	public void Example1() {
		Movie m1 = new Movie("Inception", 110);
		Movie m2 = new Movie("GodFather", 200);
		Movie m3 = new Movie("Forest Gump", 130);
		Movie m4 = new Movie("Avengers", 150);

		List<Movie> listOfMovies = new ArrayList<Movie>();
		listOfMovies.add(m1);
		listOfMovies.add(m2);
		listOfMovies.add(m3);
		listOfMovies.add(m4);

		System.out.println("Before Sort by name : ");
		for (int i = 0; i < listOfMovies.size(); i++) {
			Movie movie = (Movie) listOfMovies.get(i);
			System.out.println(movie);

		}
		// Sort by movieName
		// Anonymous Comparator
		// old way
		Collections.sort(listOfMovies, new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.getMovieName().compareTo(o2.getMovieName());
			}
		});
		
		System.out.println("After Sort by name : ");
		for (int i = 0; i < listOfMovies.size(); i++) {
			Movie movie = (Movie) listOfMovies.get(i);
			System.out.println(movie);
		}
		
		 // Using lambda expression
	    Collections.sort(listOfMovies, (o1, o2) -> Long.compare(o1.getDuration(), o2.getDuration()));
	    
	    System.out.println("After Sort by duration : ");
		for (int i = 0; i < listOfMovies.size(); i++) {
			Movie movie = (Movie) listOfMovies.get(i);
			System.out.println(movie);
		}
	}
}
