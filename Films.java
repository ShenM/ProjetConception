import java.util.ArrayList;
import java.util.Date;

public class Films extends Document {

	private GenreFilm genre;

	public Films(String titre, ArrayList<String> auteur, Date dateParution, GenreFilm genre) {
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