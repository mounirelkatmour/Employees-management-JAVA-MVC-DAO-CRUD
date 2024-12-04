package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Model.Employee;
import Model.Poste;
import Model.Role;
import View.EmployeeView;

public class EmployeeDAOImpl implements EmployeeDAOI {
    private Connection connection;
    public EmployeeDAOImpl() {
        connection = DBConnection.getConnection();
    }
    @Override
    public void ajouterEmployee(Employee employee) {
        String SQL = "INSERT INTO employee (id, nom, prenom, salaire, email, phone, role, poste) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setInt(1, Employee.getId());
            stmt.setString(2, employee.getNom());
            stmt.setString(3, employee.getPrenom());
            stmt.setDouble(4, employee.getSalaire());
            stmt.setString(5, employee.getEmail());
            stmt.setString(6, employee.getPhone());            
            stmt.setString(7, employee.getRole().name());
            stmt.setString(8, employee.getPoste().name());
            stmt.executeUpdate();
            EmployeeView employeeView = new EmployeeView();
            employeeView.Nom.setText("");
            employeeView.Prenom.setText("");
            employeeView.Email.setText("");
            employeeView.Telephone.setText("");
            employeeView.Salaire.setText("");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Employee findByEmail(int EmployeeId) {
        String SQL = "SELECT * FROM employee WHERE id = ?";
        Employee employee = null;
        try (PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setInt(1, EmployeeId);
            try (ResultSet rset = stmt.executeQuery()) {
                if (rset.next()) {
                    employee = new Employee(rset.getInt("id"), rset.getString("nom"), rset.getString("prenom"), rset.getDouble("salaire"), rset.getString("email"), rset.getString("phone"), Role.valueOf(rset.getString("role")), Poste.valueOf(rset.getString("poste")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    @Override
    public List<Employee> findAll() {
        String SQL = "SELECT * FROM employee";
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(SQL);
                ResultSet rset = stmt.executeQuery()) {
            while (rset.next()) {
                Employee employee = new Employee(rset.getInt("id"), rset.getString("nom"), rset.getString("prenom"), rset.getDouble("salaire"), rset.getString("email"), rset.getString("phone"), Role.valueOf(rset.getString("role")), Poste.valueOf(rset.getString("poste")));
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }
    @Override
    public void update(Employee employee, int EmployeeId) {
        String SQL = "UPDATE employee SET nom = ?, prenom = ?, salaire = ?, email = ?, phone = ?, role = ?, poste = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setString(1, employee.getNom());
            stmt.setString(2, employee.getPrenom());
            stmt.setDouble(3, employee.getSalaire());
            stmt.setString(4, employee.getEmail());
            stmt.setString(5, employee.getPhone());
            stmt.setString(6, employee.getRole().name());
            stmt.setString(7, employee.getPoste().name());
            stmt.setInt(8, EmployeeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete(int EmployeeId) {
        String SQL = "DELETE FROM employee WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setInt(1, EmployeeId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Role> findAllRoles() {
        String SQL = "SELECT DISTINCT role FROM employee";
        List<Role> roles = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(SQL);
                ResultSet rset = stmt.executeQuery()) {
            while (rset.next()) {
                roles.add(Role.valueOf(rset.getString("role")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }
    @Override
    public List<Poste> findAllPosts() {
        String SQL = "SELECT DISTINCT poste FROM employee";
        List<Poste> posts = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(SQL);
                ResultSet rset = stmt.executeQuery()) {
            while (rset.next()) {
                posts.add(Poste.valueOf(rset.getString("poste")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
}
