/**
 * 
 */
package metier;

import java.util.Date;

/**
 * @author KODZO
 * @author YOEKO
 * @author LOIK
 *
 */
public class Etudiant extends Personne{

	// attributs

	private String dateNaissanceEtudiant;
	
	// constructeur

	public Etudiant(int idPersonne, String nom, String prenom, String email, String adresse, String telephone,
			String dateNaissanceEtudiant) {
		super(idPersonne, nom, prenom, email, adresse, telephone);
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}

	public Etudiant(String nom, String prenom, String email, String adresse, String telephone,
			String dateNaissanceEtudiant) {
		super(nom, prenom, email, adresse, telephone);
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}
	
	// getters et setters

	public String getDateNaissanceEtudiant() {
		return dateNaissanceEtudiant;
	}

	public void setDateNaissanceEtudiant(String dateNaissanceEtudiant) {
		this.dateNaissanceEtudiant = dateNaissanceEtudiant;
	}

	// tostring

	@Override
	public String toString() {
		return "Etudiant [dateNaissanceEtudiant=" + dateNaissanceEtudiant + ", getIdPersonne()=" + getIdPersonne()
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getEmail()=" + getEmail()
				+ ", getAdresse()=" + getAdresse() + ", getTelephone()=" + getTelephone() + "]";
	}
}
