package Controller;

import DAO.EmployeeDAOImpl;
import DAO.HolidayDAOImpl;
import Model.EmployeeModel;
import Model.HolidayModel;
import Model.LoginModel;
import View.AdminView;
import View.EmployeeView;
import View.HolidayView;
import View.LimitedView;
import View.LoginView;

public class LoginController {
    private LoginModel loginModel;
    private LoginView loginView;

    public LoginController(LoginModel loginModel, LoginView loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
        this.loginView.getLoginButton().addActionListener(e -> this.Login());
    }

    private void Login() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        boolean LoggedIn = loginModel.Login(username, password);
        if (LoggedIn == true) {
            loginView.dispose();
            EmployeeController employeeController = new EmployeeController(new EmployeeModel(new EmployeeDAOImpl()), EmployeeView.getInstance());
            HolidayController holidayController = new HolidayController(new HolidayModel(new HolidayDAOImpl()), HolidayView.getInstance());
            AdminView.getInstance();
        }
    }
}


