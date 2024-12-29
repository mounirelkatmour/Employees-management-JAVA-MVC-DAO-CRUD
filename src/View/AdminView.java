package View;

import javax.swing.*;

public class AdminView extends JFrame {
    private static AdminView INSTANCE = null;
    private JTabbedPane tabbedPane = new JTabbedPane();
    private EmployeeView employeeView;
    private HolidayView holidayView;

    public static AdminView getInstance(EmployeeView employeeView, HolidayView holidayView) {
        if (INSTANCE == null) {
            INSTANCE = new AdminView(employeeView, holidayView);
        }
        return INSTANCE;
    }
    public static AdminView getInstance() {
        return INSTANCE;
    }
    public AdminView(EmployeeView employeeView, HolidayView holidayView) {
        this.employeeView = employeeView;
        this.holidayView = holidayView;
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
    public void ViewDispose() {
        INSTANCE = null;
        dispose();
    }
}
