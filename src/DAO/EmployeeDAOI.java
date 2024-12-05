package DAO;

import java.util.List;
import Model.Employee;
import Model.Poste;
import Model.Role;

public interface EmployeeDAOI {
    public void ajouterEmployee(Employee employee);
    public List<Employee> afficherEmployee();
    public void update(Employee employee,int EmployeeId);
    public void delete(int EmployeeId);
    public List<Employee> findByEmail(String email);
    public List<Role> findAllRoles();
    public List<Poste> findAllPosts();
}
