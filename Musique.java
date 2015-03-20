import java.util.ArrayList;
import java.util.Date;

public class Musique extends Document {

	private GenreMusical genre;

	public Musique(String titre, ArrayList<String> auteur, Date dateParution, GenreMusical genre) {
		super(titre, auteur, dateParution);	
		this.genre=genre;

	}
	public GenreMusical getGenre() {
		return genre;
	}

	public void setGenre(GenreMusical genre) {
		this.genre = genre;
	}
	
	@Override
	public int getDureeEmprunt() {
		return 5;
	}

}