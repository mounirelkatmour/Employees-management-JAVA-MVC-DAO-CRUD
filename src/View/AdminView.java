package View;

import javax.swing.*;

public class AdminView extends JFrame {
    private static AdminView INSTANCE = new AdminView();
    private JTabbedPane tabbedPane = new JTabbedPane();
    private EmployeeView employeeView = EmployeeView.getInstance();
    private HolidayView holidayView = HolidayView.getInstance();

    public AdminView() {
        setTitle("Admin Dashboard - Gestion des Employés et Congés");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(930, 520);
        setLocationRelativeTo(null);
        employeeView.dispose();
        holidayView.dispose();
        tabbedPane.addTab("Gestion des Employés", employeeView.getContentPane());
        tabbedPane.addTab("Gestion des Congés", holidayView.getContentPane());
        add(tabbedPane);
        setVisible(true);
    }
    public static AdminView getInstance() {
        return INSTANCE;
    }
}