package Controller;

import DAO.EmployeeDAOImpl;
import Model.EmployeeModel;
import Model.LoginModel;
import View.EmployeeView;
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
            if(LoginModel.getIsAdmin() == true) {
                EmployeeModel model = new EmployeeModel(new EmployeeDAOImpl());
                EmployeeView view = EmployeeView.getInstance();
                new EmployeeController(model, view);
            }
            if(LoginModel.getIsAdmin() == false) {
                EmployeeModel model = new EmployeeModel(new EmployeeDAOImpl());
                EmployeeView view = LimitedView.getLimitedInstance();
                new EmployeeController(model, view);
            }

        }

    }
}

