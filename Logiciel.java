import java.util.ArrayList;
import java.util.Date;

public class Logiciel extends Document {

	private GenreLogiciel genre;

	public Logiciel(String titre, ArrayList<String> auteur, Date dateParution, GenreLogiciel genre) {
		super(titre, auteur, dateParution);
		this.genre=genre;
	}

	public GenreLogiciel getGenre() {
		return genre;
	}

	public void setGenre(GenreLogiciel genre) {
		this.genre = genre;
	}
	
	@Override
	public int getDureeEmprunt() {
		return 5;
	}

}