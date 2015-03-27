import java.util.ArrayList;
import java.util.Date;

public class Livre extends Document {
	
	private int numISBN;
	private GenreLitteraire genre;

	public Livre(String titre, ArrayList<String> auteur, Date dateParution, int numISBN, GenreLitteraire genre) {
		super(titre, auteur, dateParution);
		this.numISBN= numISBN;
		this.genre=genre;
		
	}
	public int getNumISBN() {
		return numISBN;
	}
	public void setNumISBN(int numISBN) {
		this.numISBN = numISBN;
	}
	public GenreLitteraire getGenre() {
		return genre;
	}
	public void setGenre(GenreLitteraire genre) {
		this.genre = genre;
	}
	

}