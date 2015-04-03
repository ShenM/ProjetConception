
import java.util.GregorianCalendar;

public class Musique extends Document {

	private GenreMusical genre;

	public Musique(String titre, String auteur, GregorianCalendar dateParution, GenreMusical genre) {
		super(titre, auteur, dateParution);	
		this.genre=genre;

	}
	

	public GenreMusical getGenre() {
		return genre;
	}

	public void setGenre(GenreMusical genre) {
		this.genre = genre;
	}
	

}