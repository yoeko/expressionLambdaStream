/**
 * la classe Personne
 */
package metier;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KODZO
 * @author YOEKO
 * @author LOIK
 *
 */
public class Personne {

	// attributs

	private int idPersonne;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	private String telephone;
	private List<Cours> cours = new ArrayList<Cours>();

	// constructeurs

	public Personne(int idPersonne, String nom, String prenom, String email, String adresse, String telephone) {
		super();
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	public Personne(String nom, String prenom, String email, String adresse, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	// getters et setters

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Cours> getCours() {
		return cours;
	}

	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}

	// tostring

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", adresse=" + adresse + ", telephone=" + telephone + "]";
	}

}
