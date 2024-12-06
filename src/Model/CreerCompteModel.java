package Model;

import DAO.CreerCompteDAOImpl;
import View.CreerCompteView;

public class CreerCompteModel {
    private CreerCompteDAOImpl dao;
    public CreerCompteModel(CreerCompteDAOImpl dao) {
        this.dao = dao;
    }
    public void creerCompte(int id, CreerCompte newAccount){
        if (newAccount.getUsername().trim().isEmpty() || newAccount.getPassword().trim().isEmpty()) {
            CreerCompteView.CreerCompteFail("Veuillez remplir tous les champs.");
            return;
        }
        dao.creerCompte(id, newAccount);
    }
}
