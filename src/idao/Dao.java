/**
 * 
 */
package idao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mysql.jdbc.ResultSetMetaData;

import metier.Etudiant;
import metier.Personne;
import metier.Utilisateur;

/**
 * 
 * @author zeuhias
 *
 */
public class Dao {

	public static String password = "";

	// information de la base de donnee

	static String url = "jdbc:mysql://localhost/ges_ecole_ensup";
	static String login = "root";

	static Connection cn = null;
	static Statement st = null;
	static ResultSet rs = null;

	/**
	 * liste des �tudiants
	 */
	public static void lireEtudiant() {

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "select * from personne";

			// etape 4 executer la requette
			System.out.println("Liste des etudiants ");
			rs = st.executeQuery(sql);
			
//			ArrayList<String> etudiants = new ArrayList<String>();
			List<Personne> etudiants = new ArrayList<Personne>();
			
			while (rs.next()) {
				Personne p = new Personne(rs.getInt("idPersonne"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), rs.getString("adresse"), rs.getString("telephone"));
				etudiants.add(p);
			}
			
			//liste dont les noms commencent par "S"
			etudiants.stream()
				.filter(x -> x.getNom().startsWith("S") )
				.forEach(x -> System.out.println(((Personne) x).getNom()));
			
			// meme adresse
//			etudiants.stream()
//				.sorted(Comparator.comparing(Personne::getAdresse))
//				.filter(x -> ((Personne) x).getNom().startsWith("S") )
//				.forEach(x -> System.out.println(  ((Personne) x)  ));
			
			//liste des meme prenom commencant par "s"
//			etudiants.stream()
//			.sorted(Comparator.comparing(Personne::getPrenom))
//			.filter(x -> ((Personne) x).getNom().startsWith("S") )
//			.forEach(x -> System.out.println(  ((Personne) x)  ));
			
			

			// etape5 parcours du resultSet
//			while (rs.next()) {
//				System.out.print(rs.getInt("idPersonne"));
//				System.out.print(" ");
//				System.out.print(rs.getString("nom"));
//				System.out.print(" ");
//				System.out.print(rs.getString("prenom"));
//				System.out.print(" ");
//				System.out.print(rs.getString("email"));
//				System.out.print(" ");
//				System.out.print(rs.getString("adresse"));
//				System.out.print(" ");
//				System.out.print(rs.getString("telephone"));
//				System.out.print(" ");
//				System.out.print(rs.getString("date_naissance"));
//				System.out.println(" ");
//			}

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param utilisateur les informations sur l'utilisateur
	 */
	public static void creerUtilisateur(Utilisateur utilisateur) {
		// information de la base de donnee

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "INSERT INTO `utilisateur` (`login`,`password`, `profil`) " + "VALUES ('"
					+ utilisateur.getLogin() + "','" + utilisateur.getPassword() + "', '" + utilisateur.getProfil()
					+ "')";

			// etape 4 executer la requette
			st.executeUpdate(sql);
			System.out.println("Utilisateur enr�gistr� avec succ�s !!!! ");

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param utilisateur
	 * @return
	 */
	public static Utilisateur selectionUtilisateur(Utilisateur utilisateur) {

		Utilisateur user = null;
		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "select * from utilisateur where `login` =  '" + utilisateur.getLogin() + "' and "
					+ "`password` = '" + utilisateur.getPassword() + "'";

			// etape 4 executer la requette
			rs = st.executeQuery(sql);

			// etape5 parcours du resultSet
			while (rs.next()) {
				user = new Utilisateur(rs.getInt("idUser"), rs.getString("login"), rs.getString("password"),
						rs.getString("profil"));
			}

		} catch (SQLException e) {
			System.out.println("L'utilisateur n'existe pas");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("L'utilisateur n'existe pas");
			e.printStackTrace();
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return user;
	}

	/**
	 * 
	 * @param etudiant
	 */
	public static void creerEtudiant(Etudiant etudiant) {

		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "INSERT INTO `personne` (`nom`, `prenom`,`email`, "
					+ "`adresse`,`telephone`, `date_naissance`) " + "VALUES ('" + etudiant.getNom() + "','"
					+ etudiant.getPrenom() + "', '" + etudiant.getEmail() + "', '" + etudiant.getAdresse() + "', '"
					+ etudiant.getTelephone() + "', '" + etudiant.getDateNaissanceEtudiant() + "')";

			// etape 4 executer la requette
			st.executeUpdate(sql);
			System.out.println("Etudiant enr�gistr� avec succ�s !!!! ");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	/**
	 * Lire les informations d'un etudiant
	 */
	public static Etudiant lireUnEtudiant(int idEtudiant) {
		Etudiant etudiant = null;
		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "select * from personne where  `idPersonne` =  '" + idEtudiant + "'";

			// etape 4 executer la requette
			
			rs = st.executeQuery(sql);

			// etape5 parcours du resultSet
			while (rs.next()) {
				etudiant = new Etudiant(rs.getInt("idPersonne"), rs.getString("nom"), 
						rs.getString("prenom"), rs.getString("email"), rs.getString("adresse"), 
						rs.getString("telephone"), rs.getString("date_naissance"));
			}

		} catch (SQLException e) {
			System.out.println("L'�tudiant n'existe pas");
		} catch (ClassNotFoundException e) {
			System.out.println("L'�tudiant n'existe pas");
		} finally {

			// etape 5 liberer les ressources
			try {
				cn.close();
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return etudiant;
	}

}
