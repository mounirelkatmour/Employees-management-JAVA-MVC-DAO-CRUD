package Controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.Employee;
import Model.EmployeeModel;
import Model.LoginModel;
import Model.Poste;
import Model.Role;
import Utilities.Utils;
import View.EmployeeView;

public class EmployeeController {
    protected EmployeeModel employeeModel;
    protected static EmployeeView employeeView;
    private static boolean isDeselecting = false;
    public EmployeeController(EmployeeModel employeeModel, EmployeeView employeeView) {
        this.employeeModel = employeeModel;
        EmployeeController.employeeView = employeeView;
        EmployeeController.employeeView.getAjouterButton().addActionListener(e -> this.ajouterEmployee());
        EmployeeController.employeeView.getAfficherButton().addActionListener(e -> {
            if (employeeView.getNomField().getText().isEmpty() && employeeView.getPrenomField().getText().isEmpty() && employeeView.getSalaireField().getText().isEmpty() && employeeView.getEmailField().getText().isEmpty() && employeeView.getPhoneField().getText().isEmpty()) {
                this.afficherEmployee();
            }
            if (!employeeView.getNomField().getText().isEmpty() && !employeeView.getPrenomField().getText().isEmpty()){
                String firstname = employeeView.getNomField().getText();
                String lastname = employeeView.getPrenomField().getText();
                this.findByFullName(firstname,lastname);
                this.deselectEmployee();
            }
            if (employeeView.getNomField().getText().isEmpty() || employeeView.getPrenomField().getText().isEmpty() ){
                if (!employeeView.getNomField().getText().isEmpty()) {
                    String lastname = employeeView.getNomField().getText();
                    this.findByLastName(lastname);
                    this.deselectEmployee();
                }
                if (!employeeView.getPrenomField().getText().isEmpty()) {
                    String firstname = employeeView.getPrenomField().getText();
                    this.findByFirstName(firstname);
                    this.deselectEmployee();
                }
            }
            if (!employeeView.getPhoneField().getText().isEmpty()) {
                String phone = employeeView.getPhoneField().getText();
                this.findByPhone(phone);
                this.deselectEmployee();
            }
            if (!employeeView.getEmailField().getText().isEmpty()) {
                String email = employeeView.getEmailField().getText();
                this.findByEmail(email);
                this.deselectEmployee();
            }
            if (!employeeView.getSalaireField().getText().isEmpty()) {
                String salaireString = employeeView.getSalaireField().getText();
                double salaire = Double.parseDouble(salaireString);
                this.findBySalaire(salaire);
                this.deselectEmployee();
            }
        });
        EmployeeController.employeeView.getSupprimerButton().addActionListener(e -> this.supprimerEmployee());
        EmployeeController.employeeView.getModifierButton().addActionListener(e -> this.updateEmployee());
        EmployeeController.employeeView.getCreerCompteButton().addActionListener(e -> new CreerCompteController());
        EmployeeController.employeeView.getTable().getSelectionModel().addListSelectionListener(e -> this.setEmployeeInformations());
        EmployeeController.employeeView.getDeselectButton().addActionListener(e -> EmployeeController.deselectEmployee());
        this.afficherEmployee();
    }
    public void ajouterEmployee() {
        String nom  = employeeView.getNomField().getText();
        String prenom = employeeView.getPrenomField().getText();
        String salaire = employeeView.getSalaireField().getText();
        String email = employeeView.getEmailField().getText();
        String phone = employeeView.getPhoneField().getText();
        Role role = (Role) employeeView.getRoleComboBox().getSelectedItem();
        Poste poste = (Poste) employeeView.getPosteComboBox().getSelectedItem();
        boolean ajouter = employeeModel.ajouterEmployee(nom, prenom, salaire, email, phone, role , poste);
        if(ajouter) {
            this.afficherEmployee();
        }
    }
    public void afficherEmployee() {
        List<Employee> employees = employeeModel.afficherEmployee();
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.getTable().getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire(), e.getPhone(), e.getRole(), e.getPoste(),e.getHolidayBalance()});
        }
    }
    public void findByEmail(String email) {
        email = employeeView.getEmailField().getText();
        List<Employee> employees = employeeModel.findByEmail(email);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.getTable().getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire(), e.getPhone(), e.getRole(), e.getPoste(),e.getHolidayBalance()});
        }
    }
    public void findByFullName(String firstname, String lastname) {
        firstname = employeeView.getPrenomField().getText();
        lastname = employeeView.getNomField().getText();
        List<Employee> employees = employeeModel.findByFullName(firstname,lastname);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.getTable().getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire(), e.getPhone(), e.getRole(), e.getPoste(),e.getHolidayBalance()});
        }
    }
    public void findByFirstName(String firstname) {
        firstname = employeeView.getPrenomField().getText();
        List<Employee> employees = employeeModel.findByFirstName(firstname);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.getTable().getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire(), e.getPhone(), e.getRole(), e.getPoste(),e.getHolidayBalance()});
        }
    }
    public void findByLastName(String lastname) {
        lastname = employeeView.getNomField().getText();
        List<Employee> employees = employeeModel.findByLastName(lastname);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.getTable().getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire(), e.getPhone(), e.getRole(), e.getPoste(),e.getHolidayBalance()});
        }
    }
    public void findByPhone(String phone) {
        List<Employee> employees = employeeModel.findByPhone(phone);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.getTable().getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire(), e.getPhone(), e.getRole(), e.getPoste(),e.getHolidayBalance()});
        }
    }
    public void findBySalaire(double salaire) {
        List<Employee> employees = employeeModel.findBySalaire(salaire);
        DefaultTableModel tableModel = (DefaultTableModel) employeeView.getTable().getModel();
        tableModel.setRowCount(0);
        for(Employee e : employees) {
            tableModel.addRow(new Object[]{e.getId(), e.getNom(), e.getPrenom(), e.getEmail(), e.getSalaire(), e.getPhone(), e.getRole(), e.getPoste(),e.getHolidayBalance()});
        }
    }
    public void supprimerEmployee() {
        int selectedRow = employeeView.getTable().getSelectedRow();
        if (selectedRow != -1) {
            try {
                int id = Integer.parseInt(employeeView.getTable().getModel().getValueAt(selectedRow, 0).toString());
                employeeModel.supprimerEmployee(id);
                this.deselectEmployee();
                this.afficherEmployee();
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format.");
            }
        } else {
            EmployeeView.SupprimerFail("Veuillez choisir un employé.");
        }
        this.afficherEmployee();
    }
    public void updateEmployee() {
        int selectedRow = employeeView.getTable().getSelectedRow();
        if (selectedRow != -1) {
            try {
                int id = Integer.parseInt(employeeView.getTable().getModel().getValueAt(selectedRow, 0).toString());
                String nom = employeeView.getNomField().getText();
                String prenom = employeeView.getPrenomField().getText();
                String email = employeeView.getEmailField().getText();
                double salaire = Utils.parseDouble(employeeView.getSalaireField().getText());
                String phone = employeeView.getPhoneField().getText();
                Role role = (Role) (employeeView.getRoleComboBox().getSelectedItem());
                Poste poste = (Poste) employeeView.getPosteComboBox().getSelectedItem();
                Employee employeeToUpdate = employeeModel.findById(id);
                if (employeeToUpdate != null) {
                    employeeModel.updateEmployee(employeeToUpdate,id, nom, prenom, email, salaire, phone, role, poste);
                    this.deselectEmployee();
                    this.afficherEmployee();
                } else {
                    EmployeeView.ModifierFail("L'employé avec l'ID spécifié n'existe pas.");
                }
            } catch (NumberFormatException e) {
                EmployeeView.ModifierFail("Erreur lors de la mise à jour de l'employé.");
            }
        }else{
            EmployeeView.ModifierFail("Veuillez choisir un employé.");
        }
    }
    public static int getId(){
        int selectedRow = employeeView.getTable().getSelectedRow();
        int id=-1;
        if (selectedRow != -1) {
            try {
                id = Integer.parseInt(employeeView.getTable().getModel().getValueAt(selectedRow, 0).toString());
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format.");
            }
        }
        return id;
    }
    public static void viderLesChamps(){
        boolean check = LoginModel.getIsAdmin();
        check = true;////// BINMA 9ADINA HOLIDAYS O LOGIN 
        if(check == true){
            employeeView.getNomField().setText("");
            employeeView.getPrenomField().setText("");
            employeeView.getSalaireField().setText("");
            employeeView.getEmailField().setText("");
            employeeView.getPhoneField().setText("");
            employeeView.getRoleComboBox().setSelectedIndex(-1);
            employeeView.getPosteComboBox().setSelectedIndex(-1);
            return;
        }
    }
    public void setEmployeeInformations() {
        if (isDeselecting) return;
        int selectedRow = employeeView.getTable().getSelectedRow();
        if (selectedRow == -1) {
            return;
        }
        int id = Integer.parseInt(employeeView.getTable().getModel().getValueAt(selectedRow, 0).toString());
        Employee employee = employeeModel.findById(id);
        employeeView.getNomField().setText(employee.getNom());
        employeeView.getPrenomField().setText(employee.getPrenom());
        employeeView.getSalaireField().setText(String.valueOf(employee.getSalaire()));
        employeeView.getEmailField().setText(employee.getEmail());
        employeeView.getPhoneField().setText(employee.getPhone());
        employeeView.getRoleComboBox().setSelectedItem(employee.getRole());
        employeeView.getPosteComboBox().setSelectedItem(employee.getPoste());
        employeeView.getDeselectButton().setVisible(true);
    }

    public static void deselectEmployee() {
        isDeselecting = true;
        employeeView.getNomField().setText("");
        employeeView.getPrenomField().setText("");
        employeeView.getSalaireField().setText("");
        employeeView.getEmailField().setText("");
        employeeView.getPhoneField().setText("");
        employeeView.getRoleComboBox().setSelectedIndex(-1);
        employeeView.getPosteComboBox().setSelectedIndex(-1);
        employeeView.getDeselectButton().setVisible(false);
        employeeView.getTable().clearSelection();
        isDeselecting = false;
    }
}
