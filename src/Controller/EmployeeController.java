package Controller;

import java.awt.event.ActionListener;

import Model.EmployeeModel;
import Model.Poste;
import Model.Role;
import View.EmployeeView;

public class EmployeeController {
    private EmployeeModel employeeModel;
    private EmployeeView employeeView;
    public EmployeeController(EmployeeModel employeeModel, EmployeeView employeeView) {
        this.employeeModel = employeeModel;
        this.employeeView = employeeView;
        this.employeeView.Ajouter.addActionListener(e -> ajouterEmployee());
    }
    public void ajouterEmployee() {
        String nom  = employeeView.Nom.getText();
        String prenom = employeeView.Prenom.getText();
        double salaire = Double.parseDouble(employeeView.Salaire.getText());
        String email = employeeView.Email.getText();
        String phone = employeeView.Telephone.getText();
        Role role = (Role) employeeView.RoleComboBox.getSelectedItem();
        Poste poste = (Poste) employeeView.PosteComboBox.getSelectedItem();
        employeeModel.ajouterEmployee(nom, prenom, salaire, email, phone, role , poste);
    }
    
}
