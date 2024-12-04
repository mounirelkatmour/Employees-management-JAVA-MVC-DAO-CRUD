package Model;

import DAO.EmployeeDAOImpl;

public class EmployeeModel {
    private EmployeeDAOImpl dao;
    public EmployeeModel(EmployeeDAOImpl dao) {
        this.dao = dao;
    }

    public boolean ajouterEmployee(String nom, String prenom, double salaire, String email, String phone, Role role,
            Poste poste) {
        try {
            if (((double)salaire) < 0) {
                return false;
            }
            Employee.setId(Employee.getId() + 1);
            Employee employee = new Employee(Employee.getId() ,nom, prenom, salaire, email, phone, role, poste);
            dao.ajouterEmployee(employee);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}