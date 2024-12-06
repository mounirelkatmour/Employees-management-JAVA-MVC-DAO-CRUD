package View;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JFrame{
    private static final LoginView INSTANCE = new LoginView();
    private JPanel General = new JPanel();
    private JPanel InputsContainer = new JPanel();
    private JLabel UsernameLabel = new JLabel("Username");
    private JTextField Username = new JTextField();
    private JLabel PasswordLabel = new JLabel("Password");
    private JTextField Password = new JTextField();
    private JPanel ButtonsContainer = new JPanel();
    private JButton Login = new JButton("Login");

    public LoginView() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
        add(General);
        General.setLayout(new BorderLayout());
        General.add(InputsContainer, BorderLayout.CENTER);
        InputsContainer.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
        General.add(ButtonsContainer, BorderLayout.SOUTH);
        ButtonsContainer.setBorder(BorderFactory.createEmptyBorder(5, 0, 15, 0));
        InputsContainer.setLayout(new GridLayout(4,2, 10, 10));
        InputsContainer.add(UsernameLabel,0);
        InputsContainer.add(Username,1);
        InputsContainer.add(PasswordLabel,2);
        InputsContainer.add(Password,3);
        ButtonsContainer.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonsContainer.add(Login);

    }
    public static LoginView getInstance() {
        return INSTANCE;
    }
}
