package Model;

import DAO.CreerCompteDAOImpl;
import View.CreerCompteView;

public class CreerCompteModel {
    private CreerCompteDAOImpl dao;
    public CreerCompteModel(CreerCompteDAOImpl dao) {
        this.dao = dao;
    }
    public boolean creerCompte(int id, CreerCompte newAccount){
        if (newAccount.getUsername().trim().isEmpty() || newAccount.getPassword().trim().isEmpty()) {
            CreerCompteView.CreerCompteFail("Veuillez remplir tous les champs.");
            return false;
        }else if (newAccount.getPassword().length() < 8) {
            CreerCompteView.CreerCompteFail("Le mot de passe doit contenir au moins 8 caractères.");
            return false;
        }
        return dao.creerCompte(id, newAccount);
    }
}
