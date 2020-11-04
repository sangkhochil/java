
public class Movie {
	String movieName;
	long duration;
	
	public Movie(String movieName, long duration) {
		this.movieName = movieName;
		this.duration = duration;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString(){
		return "[Movie Name: " +this.movieName + ", Duration :" + this.duration + "]";
	}
}
