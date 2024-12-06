package Controller;

import Model.LoginModel;
import View.LoginView;

public class LoginController {
    private LoginModel loginModel;
    private LoginView loginView;

    public LoginController(LoginModel loginModel, LoginView loginView) {
        this.loginModel = loginModel;
        this.loginView = loginView;
        this.loginView.getLoginButton().addActionListener(e -> this.Login());
    }

    private void Login() {}
}
