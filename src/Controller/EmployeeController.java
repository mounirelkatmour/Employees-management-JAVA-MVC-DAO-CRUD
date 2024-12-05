package Controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.Employee;
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
        this.employeeView.Afficher.addActionListener(e -> {
            if (employeeView.Nom.getText().isEmpty() && employeeView.Prenom.getText().isEmpty() && employeeView.Salaire.getText().isEmpty() && employeeView.Email.getText().isEmpty() && employeeView.Telephone.getText().isEmpty()) {
                this.afficherEmployee();
            }
            if (!employeeView.Email.getText().isEmpty()) {
                String email = employeeView.Email.getText();
                this.findByEmail(email);
            }
        });
        this.afficherEmployee();
    }
    public void ajouterEmployee() {
        String nom  = employeeView.Nom.getText();
        String prenom = employeeView.Prenom.getText();
        String salaire = employeeView.Salaire.getText();
        String email = employeeView.Email.getText();
        String phone = employeeView.Telephone.getText();
        Role role = (Role) employeeView.RoleComboBox.getSelectedItem();
        Poste poste = (Poste) employeeView.PosteComboBox.getSelectedItem();
        employeeModel.ajouterEmployee(nom, prenom, salaire, email, phone, role , poste);
    }
    public void afficherEmployee() {
        List<Employee> employees = employeeModel.afficherEmployee();
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.Tableau.getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire()});
        }
    }
    public void findByEmail(String email) {
        email = employeeView.Email.getText();
        List<Employee> employees = employeeModel.findByEmail(email);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.Tableau.getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            // System.out.println(e.getId() + " " + e.getNom() + " " + e.getPrenom() + " " + e.getEmail() + " " + e.getSalaire());
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire()});
        }
    }
}
