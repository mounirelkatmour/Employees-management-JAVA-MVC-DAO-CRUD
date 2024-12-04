package Main;

import Controller.EmployeeController;
import DAO.EmployeeDAOImpl;
import Model.EmployeeModel;
import View.EmployeeView;

public class Main {

    public static void main(String[] args) {
        EmployeeModel model = new EmployeeModel(new EmployeeDAOImpl());
        EmployeeView view = new EmployeeView();
        new EmployeeController(model, view);
    }
}