package idao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import metier.Cours;
import metier.Etudiant;
import service.IService;

public class CoursPersonneDao implements IService {
	
	public static String password = "root";

	// information de la base de donnee

	static String url = "jdbc:mysql://localhost/ges_ecole_ensup";
	static String login = "root";

	static Connection cn = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	public void associerCoursEtudiant(Etudiant etudiant, Cours cours) {
		
		try {
			// etape1 chargement du driver

			Class.forName("com.mysql.jdbc.Driver");

			// etape2 recupertion de la connnexion

			cn = DriverManager.getConnection(url, login, password);

			// etape 3 creation du statement
			st = cn.createStatement();
			String sql = "INSERT INTO `personne_cours` (`idPersonne`,`themeCours`) " + "VALUES ('"
					+ etudiant.getIdPersonne() + "','" + cours.getThemeCours() + ")'";

			// etape 4 executer la requette
			st.executeUpdate(sql);
			System.out.println("Cours associ� a l'�tudiant avec succ�s !!!! ");

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
}
