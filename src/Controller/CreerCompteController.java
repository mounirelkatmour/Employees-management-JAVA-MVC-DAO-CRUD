package Controller;

import DAO.CreerCompteDAOImpl;
import Model.CreerCompte;
import Model.CreerCompteModel;
import View.CreerCompteView;
import View.EmployeeView;

public class CreerCompteController {
    private CreerCompteView creerCompteView;
    private CreerCompteModel creerCompteModel;

    public CreerCompteController(CreerCompteModel creerCompteModel, CreerCompteView creerCompteView) {
        this.creerCompteView = creerCompteView;
        this.creerCompteModel = creerCompteModel;
        
        this.creerCompteView.getCreateAccountButton().addActionListener(e -> CreateAccountCheck());
    }

    public CreerCompteController() {
        if (EmployeeController.getId() != -1) {
            CreerCompteModel cmodel = new CreerCompteModel(new CreerCompteDAOImpl());
            CreerCompteView cview = new CreerCompteView();
            new CreerCompteController(cmodel, cview);
        } else {
            EmployeeView.ModifierFail("Veuillez choisir un employé.");
        }
    }

    private void CreateAccountCheck() {
        boolean isSuccess = creerCompte();
        if (isSuccess) {
            EmployeeController.deselectEmployee();
            creerCompteView.dispose();
        }
    }

    public boolean creerCompte() {
        int id = EmployeeController.getId();
        String username = creerCompteView.getUsername().replaceAll("\\s", "_");
        String password = creerCompteView.getPassword();
        CreerCompte newAccount = new CreerCompte(username, password);
        return creerCompteModel.creerCompte(id, newAccount);
    }
}
