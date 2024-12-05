package Model;

import DAO.EmployeeDAOImpl;
import Utilities.Utils;
import View.EmployeeView;

public class EmployeeModel {
    private EmployeeDAOImpl dao;
    public EmployeeModel(EmployeeDAOImpl dao) {
        this.dao = dao;
    }

    public void ajouterEmployee(String nom, String prenom, String salaire, String email, String phone, Role role, Poste poste) {
        double salaireDouble = Utils.parseDouble(salaire);
        if(nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || phone.isEmpty() || salaireDouble == 0) {
            EmployeeView.AjouterFail("Veuillez remplir tous les champs.");
            return;
        }

        if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            EmployeeView.AjouterFail("Veuillez entrer une adresse email valide.");
            return;
        }
        
        if(!phone.matches("^0\\d{9}$")) {
            EmployeeView.AjouterFail("Le numéro de téléphone doit contenir 10 chiffres");
        }
        
        if(Utils.parseDouble(salaire) < 0 ){
            EmployeeView.AjouterFail("Le salaire doit être un nombre positif");
        }
        
        Employee employee = new Employee(0, nom, prenom, salaireDouble, email, phone, role, poste);
        dao.ajouterEmployee(employee);
    }
}