package iservice;

import dao.IDao;
import metier.Cours;
import metier.Etudiant;
import service.IService;

public class Service implements IService {

	@Override
	public void associerCoursEtudiant(Etudiant etudiant, Cours cours) {
		IDao dao = new IDao() {
		};		
	}

}
