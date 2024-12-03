package DAO;

import java.util.List;
import Model.Employee;
import Model.Poste;
import Model.Role;

public interface EmployeeDAOI {
    Employee findByEmail(int EmployeeId);
    List<Employee> findAll();
    void add(Employee employee);
    void update(Employee employee,int EmployeeId);
    void delete(int EmployeeId);
    List<Role> findAllRoles();
    List<Poste> findAllPosts();
}
