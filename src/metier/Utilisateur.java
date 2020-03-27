/**
 * la classe Utilisateur
 */
package metier;

/**
 * @author KODZO
 * @author YOEKO
 * @author LOIK
 *
 */
public class Utilisateur {

	// propri�t�s

	private int idUser;
	private String login;
	private String password;
	private String profil;

	// constructeur
	public Utilisateur(String login, String password, String profil) {
		super();
		this.login = login;
		this.password = password;
		this.profil = profil;
	}

	public Utilisateur(int idUser, String login, String password, String profil) {
		super();
		this.idUser = idUser;
		this.login = login;
		this.password = password;
		this.profil = profil;
	}



	// getters et setters
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	// toString
	@Override
	public String toString() {
		return "Utilisateur [idUser=" + idUser + ", login=" + login + ", password=" + password + ", profil=" + profil
				+ "]";
	}

}
