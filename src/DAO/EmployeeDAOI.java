package DAO;

import java.util.List;
import Model.Employee;
import Model.Poste;
import Model.Role;

public interface EmployeeDAOI {
    public Employee findByEmail(int EmployeeId);
    public List<Employee> findAll();
    public void ajouterEmployee(Employee employee);
    public void update(Employee employee,int EmployeeId);
    public void delete(int EmployeeId);
    public List<Role> findAllRoles();
    public List<Poste> findAllPosts();
}
