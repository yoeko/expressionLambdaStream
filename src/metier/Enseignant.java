/**
 * la classe Enseignant
 */
package metier;

/**
 * 
 * @author KODZO
 * @author YOEKO
 * @author LOIK
 *
 */
public class Enseignant extends Personne {

	// attributs

	private String telephone;

	// contructeur

	public Enseignant(int idPersonne, String nom, String prenom, String email, String adresse, String telephone,
			String telephone2) {
		super(idPersonne, nom, prenom, email, adresse, telephone);
		telephone = telephone2;
	}

	// getter et setter

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	// tostring
	
	@Override
	public String toString() {
		return "Enseignant [telephone=" + telephone + ", getIdPersonne()=" + getIdPersonne() + ", getNom()=" + getNom()
				+ ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail() + ", getAdresse()=" + getAdresse()
				+ "]";
	}

}
