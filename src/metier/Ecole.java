/**
 * Classe Ecole
 */
package metier;

/**
 * @author KODZO
 * @author YOEKO
 * @author LOIK
 *
 */
public class Ecole {

	// propri�t�s

	private String nomEcole;
	private String emailEcole;
	private String adresseEcole;
	private String telephoneEcole;
	private String directeur;

	// constructeur

	public Ecole(String nomEcole, String emailEcole, String adresseEcole, String telephoneEcole, String directeur) {
		super();

		this.nomEcole = nomEcole;
		this.emailEcole = emailEcole;
		this.adresseEcole = adresseEcole;
		this.telephoneEcole = telephoneEcole;
		this.directeur = directeur;
	}

	// getters et setters

	public String getNomEcole() {
		return nomEcole;
	}

	public void setNomEcole(String nomEcole) {
		this.nomEcole = nomEcole;
	}

	public String getEmailEcole() {
		return emailEcole;
	}

	public void setEmailEcole(String emailEcole) {
		this.emailEcole = emailEcole;
	}

	public String getAdresseEcole() {
		return adresseEcole;
	}

	public void setAdresseEcole(String adresseEcole) {
		this.adresseEcole = adresseEcole;
	}

	public String getTelephoneEcole() {
		return telephoneEcole;
	}

	public void setTelephoneEcole(String telephoneEcole) {
		this.telephoneEcole = telephoneEcole;
	}

	public String getDirecteur() {
		return directeur;
	}

	public void setDirecteur(String directeur) {
		this.directeur = directeur;
	}

	// tostring

	@Override	
	public String toString() {
		return "Ecole [nomEcole=" + nomEcole + ", emailEcole=" + emailEcole + ", adresseEcole=" + adresseEcole
				+ ", telephoneEcole=" + telephoneEcole + ", directeur=" + directeur + "]";
	}

}
