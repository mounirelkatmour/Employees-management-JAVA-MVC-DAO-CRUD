package Controller;

import DAO.EmployeeDAOImpl;
import View.EmployeeView;

public class EmployeeController {
    private EmployeeDAOImpl employeeDAO;
    private EmployeeView employeeView;
    public EmployeeController(EmployeeDAOImpl employeeDAO, EmployeeView employeeView) {
        this.employeeDAO = employeeDAO;
        this.employeeView = employeeView;
    }
}
