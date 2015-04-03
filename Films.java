import java.util.GregorianCalendar;

public class Films extends Document {

	private GenreFilm genre;

	public Films(String titre, String auteur, GregorianCalendar dateParution, GenreFilm genre) {
		super(titre, auteur, dateParution);
		this.genre=genre;
		
	}


	public GenreFilm getGenre() {
		return genre;
	}

	public void setGenre(GenreFilm genre) {
		this.genre = genre;
	}
	


	

}