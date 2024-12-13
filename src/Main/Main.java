package Main;

import Controller.LoginController;
import DAO.LoginDAOImpl;
import Model.LoginModel;
import View.AdminView;
import View.EmployeeView;
import View.HolidayView;
import View.LoginView;

public class Main {

    public static void main(String[] args) {
        // LoginModel model = new LoginModel(new LoginDAOImpl());
        // LoginView view = LoginView.getInstance();
        // new LoginController(model,view);
        // HolidayView.getInstance();
        // EmployeeView.getInstance();
        AdminView.getInstance();
    }
}