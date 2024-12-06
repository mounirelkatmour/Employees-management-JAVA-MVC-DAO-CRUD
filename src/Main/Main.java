package Main;

import Controller.LoginController;
import DAO.LoginDAOImpl;
import Model.LoginModel;
import View.LoginView;

public class Main {

    public static void main(String[] args) {
        LoginModel model = new LoginModel(new LoginDAOImpl());
        LoginView view = LoginView.getInstance();
        new LoginController(model,view);
    }
}