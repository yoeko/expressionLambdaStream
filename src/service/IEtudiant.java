/**
 * Interface IEtudiant
 */
package service;

import metier.Etudiant;

/**
 * @author KODZO
 * @author YOEKO
 * @author LOIK
 *
 */
public interface IEtudiant {

	void creerEtudiant(Etudiant etudiant);
	void supprimerEtudiant(Etudiant etudiant);
	void modifierEtudiant(Etudiant etudiant);
	void listerEtudiant();
	void lireUnEtudiant(Integer numero);
}
