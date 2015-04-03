
import java.util.GregorianCalendar;

public class Logiciel extends Document {

	private GenreLogiciel genre;

	public Logiciel(String titre, String auteur, GregorianCalendar dateParution, GenreLogiciel genre) {
		super(titre, auteur, dateParution);
		this.genre=genre;

	}


	public GenreLogiciel getGenre() {
		return genre;
	}

	public void setGenre(GenreLogiciel genre) {
		this.genre = genre;
	}
	

}