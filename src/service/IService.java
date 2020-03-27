/**
 * 
 */
package service;

import metier.Cours;
import metier.Etudiant;

/**
 * 
 * @author zeuhias
 *
 */
@FunctionalInterface
public interface IService {

	void associerCoursEtudiant(Etudiant etudiant, Cours cours);
}
