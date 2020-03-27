/**
 * la classe "cours"
 */
package metier;

/**
 * @author KODZO
 * @author YOEKO
 * @author LOIK
 *
 */
public class Cours {

	// propriétés

	private String themeCours;
	private int nombreHeure;

	// constructeur

	public Cours(String themeCours, int nombreHeure) {
		super();
		this.themeCours = themeCours;
		this.nombreHeure = nombreHeure;
	}

	// getters et setters

	public String getThemeCours() {
		return themeCours;
	}

	public void setThemeCours(String themeCours) {
		this.themeCours = themeCours;
	}

	public int getNombreHeure() {
		return nombreHeure;
	}

	public void setNombreHeure(int nombreHeure) {
		this.nombreHeure = nombreHeure;
	}

	// tostring

	@Override
	public String toString() {
		return "Cours [themeCours=" + themeCours + ", nombreHeure=" + nombreHeure + "]";
	}

}
