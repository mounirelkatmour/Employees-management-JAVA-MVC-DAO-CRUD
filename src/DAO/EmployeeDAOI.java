package DAO;

import java.util.List;
import Model.Employee;
import Model.Poste;
import Model.Role;

public interface EmployeeDAOI {
    public void ajouterEmployee(Employee employee);
    public List<Employee> afficherEmployee();
    public void update(Employee employee,int EmployeeId);
    public void supprimerEmployee(int EmployeeId);
    public List<Employee> findByEmail(String email);
    public List<Employee> findByFirstName(String firstname);
    public List<Employee> findByLastName(String lastname);
    public List<Employee> findByFullName(String firstname,String lastname);
    public List<Employee> findByPhone(String phone);
    public List<Employee> findBySalaire(double salaire);
    public List<Role> findAllRoles();
    public List<Poste> findAllPosts();
}
