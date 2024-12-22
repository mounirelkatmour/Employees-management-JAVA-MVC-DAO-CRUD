package Controller;

import DAO.EmployeeDAOImpl;
import DAO.HolidayDAOImpl;
import Model.EmployeeModel;
import Model.HolidayModel;
import Model.LoginModel;
import Model.Role;
import View.AdminView;
import View.EmployeeView;
import View.HolidayView;
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
        Role role = loginModel.Login(username, password);
        if (role == Role.ADMIN) {
            loginView.dispose();
            EmployeeController employeeController = new EmployeeController(new EmployeeModel(new EmployeeDAOImpl()), EmployeeView.getInstance());
            HolidayController holidayController = new HolidayController(new HolidayModel(new HolidayDAOImpl()), HolidayView.getInstance());
            AdminView.getInstance(EmployeeView.getInstance(),HolidayView.getInstance());
        }
        if (role == Role.MANAGER) {
            loginView.dispose();
            EmployeeController employeeController = new EmployeeController(new EmployeeModel(new EmployeeDAOImpl()), EmployeeView.getInstance());
            HolidayController holidayController = new HolidayController(new HolidayModel(new HolidayDAOImpl()), HolidayView.getInstance());
            AdminView.getInstance(EmployeeView.getInstance(),HolidayView.getInstance());
        }
        if (role == Role.EMPLOYEE) {
            loginView.dispose();
            EmployeeController employeeController = new EmployeeController(new EmployeeModel(new EmployeeDAOImpl()), EmployeeView.getInstance());
            HolidayController holidayController = new HolidayController(new HolidayModel(new HolidayDAOImpl()), HolidayView.getInstance());
            AdminView.getInstance(EmployeeView.getInstance(),HolidayView.getInstance());
        }
    }
}


