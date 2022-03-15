
public class Movie {
	String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	int likes;
	
	public int getLikes() {
		return likes;
	}
	public Movie(String title, int likes) {
		this.title = title;
		this.likes = likes;
	}	
}
