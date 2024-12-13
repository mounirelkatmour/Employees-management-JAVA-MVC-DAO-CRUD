package Main;

import Controller.EmployeeController;
import Controller.HolidayController;
import Controller.LoginController;
import DAO.EmployeeDAOImpl;
import DAO.HolidayDAOImpl;
import DAO.LoginDAOImpl;
import Model.EmployeeModel;
import Model.HolidayModel;
import Model.LoginModel;
import View.AdminView;
import View.EmployeeView;
import View.HolidayView;
import View.LimitedView;
import View.LoginView;

public class Main {

    public static void main(String[] args) {
        EmployeeController employeeController = new EmployeeController(new EmployeeModel(new EmployeeDAOImpl()), EmployeeView.getInstance());
        HolidayController holidayController = new HolidayController(new HolidayModel(new HolidayDAOImpl()), HolidayView.getInstance());
        AdminView adminView = AdminView.getInstance();
    }
}