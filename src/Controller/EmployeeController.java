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
            if (!employeeView.Nom.getText().isEmpty() && !employeeView.Prenom.getText().isEmpty()){
                String firstname = employeeView.Nom.getText();
                String lastname = employeeView.Prenom.getText();
                this.findByFullName(firstname,lastname);
            }
            if (!employeeView.Nom.getText().isEmpty()) {
                String lastname = employeeView.Nom.getText();
                this.findByLastName(lastname);
            }
            if (!employeeView.Prenom.getText().isEmpty()) {
                String firstname = employeeView.Prenom.getText();
                this.findByFirstName(firstname);
            }
            if (!employeeView.Telephone.getText().isEmpty()) {
                String phone = employeeView.Telephone.getText();
                this.findByPhone(phone);
            }
            if (!employeeView.Email.getText().isEmpty()) {
                String email = employeeView.Email.getText();
                this.findByEmail(email);
            }
            if (!employeeView.Salaire.getText().isEmpty()) {
                String salaireString = employeeView.Salaire.getText();
                double salaire = Double.parseDouble(salaireString);
                this.findBySalaire(salaire);
            }
        });
        this.employeeView.Supprimer.addActionListener(e -> supprimerEmployee());
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
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire()});
        }
    }
    public void findByFullName(String firstname, String lastname) {
        firstname = employeeView.Prenom.getText();
        lastname = employeeView.Nom.getText();
        List<Employee> employees = employeeModel.findByFullName(firstname,lastname);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.Tableau.getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire()});
        }
    }
    public void findByFirstName(String firstname) {
        firstname = employeeView.Prenom.getText();
        List<Employee> employees = employeeModel.findByFirstName(firstname);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.Tableau.getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire()});
        }
    }
    public void findByLastName(String lastname) {
        lastname = employeeView.Nom.getText();
        List<Employee> employees = employeeModel.findByLastName(lastname);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.Tableau.getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire()});
        }
    }
    public void findByPhone(String phone) {
        List<Employee> employees = employeeModel.findByPhone(phone);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.Tableau.getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire()});
        }
    }
    public void findBySalaire(double salaire) {
        List<Employee> employees = employeeModel.findBySalaire(salaire);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.Tableau.getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire()});
        }
    }
    public void supprimerEmployee() {
        int selectedRow = employeeView.Tableau.getSelectedRow();
        if (selectedRow != -1) {
            try {
                int id = Integer.parseInt(employeeView.Tableau.getModel().getValueAt(selectedRow, 0).toString());
                System.out.println("Selected ID: " + id);
                employeeModel.supprimerEmployee(id);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format.");
            }
        } else {
            EmployeeView.SupprimerFail("Veuillez choisir un employé.");
        }
        this.afficherEmployee();
    }
}
