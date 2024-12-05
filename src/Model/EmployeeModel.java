package Model;

import java.util.List;

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
            return;
        }
        
        if(Utils.parseDouble(salaire) < 0 ){
            EmployeeView.AjouterFail("Le salaire doit être un nombre positif");
            return;
        }
        
        Employee employee = new Employee(0, nom, prenom, salaireDouble, email, phone, role, poste);
        dao.ajouterEmployee(employee);
    }
    public List<Employee> afficherEmployee() {
        return dao.afficherEmployee();
    }
    public List<Employee> findByEmail(String email) {
        return dao.findByEmail(email);
    }
    public List<Employee> findByFullName(String firstname,String lastname) {
        return dao.findByFullName(firstname,lastname);
    }
    public List<Employee> findByFirstName(String firstname) {
        return dao.findByFirstName(firstname);
    }
    public List<Employee> findByLastName(String lastname) {
        return dao.findByLastName(lastname);
    }
    public List<Employee> findByPhone(String phone) {
        return dao.findByPhone(phone);
    }
    public List<Employee> findBySalaire(double salaire) {
        return dao.findBySalaire(salaire);
    }
    public void supprimerEmployee(int id) {
        if(EmployeeView.SupprimerConfirmation()){
            dao.supprimerEmployee(id);
        }
        return;
    }
    public Employee findById(int id) {
        return dao.findById(id);
    }
    public void updateEmployee(Employee employee,int id,String nom,String prenom,String email,double salaire,String phone,Role role,Poste poste) {
        if(!nom.isEmpty()) employee.setNom(nom);
        if(!prenom.isEmpty()) employee.setPrenom(prenom);
        if(!email.isEmpty()){
            if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                EmployeeView.ModifierFail("Veuillez entrer une adresse email valide.");
                return;
            }
            employee.setEmail(email);
        }
        if(salaire != 0) {
            if(salaire < 0 ){
                EmployeeView.ModifierFail("Le salaire doit être un nombre positif");
                return;
            }
            employee.setSalaire(salaire);
        };
        if(!phone.isEmpty()){
            if(!phone.matches("^0\\d{9}$")) {
                EmployeeView.ModifierFail("Le numéro de téléphone doit contenir 10 chiffres");
                return;
            }
            employee.setPhone(phone);
        } 
        if(role != null) employee.setRole(role);
        if(poste != null) employee.setPoste(poste);
        dao.modifierEmployee(employee,id);
    }
}