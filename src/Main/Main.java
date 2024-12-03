package Main;

import Controller.EmployeeController;
import DAO.EmployeeDAOImpl;
import View.EmployeeView;

public class Main {

    public static void main(String[] args) {
        EmployeeDAOImpl model = new EmployeeDAOImpl();
        EmployeeView view = new EmployeeView();
        new EmployeeController(model, view);
    }
}