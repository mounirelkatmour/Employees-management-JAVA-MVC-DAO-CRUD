package Controller;

import Model.CreerCompte;
import Model.CreerCompteModel;
import View.CreerCompteView;

public class CreerCompteController {
    private CreerCompteView creerCompteView;
    private CreerCompteModel creerCompteModel;
    public CreerCompteController(CreerCompteModel creerCompteModel, CreerCompteView creerCompteView) {
        this.creerCompteView = creerCompteView;
        this.creerCompteModel = creerCompteModel;
        this.creerCompteView.getCreateAccountButton().addActionListener(e -> this.creerCompte());
    }
    public void creerCompte(){
        int id = EmployeeController.getId();
        String username = creerCompteView.getUsername();
        String password = creerCompteView.getPassword();
        CreerCompte newAccount = new CreerCompte(username, password);
        creerCompteModel.creerCompte(id, newAccount);
    }
    
}
