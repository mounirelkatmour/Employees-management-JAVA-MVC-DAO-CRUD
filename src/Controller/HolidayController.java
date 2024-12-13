package Controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import DAO.HolidayDAOImpl;
import Model.Employee;
import Model.Holiday;
import Model.HolidayModel;
import Model.HolidayType;
import View.HolidayView;
import Model.Employee;

public class HolidayController {
    private HolidayModel holidayModel;
    private HolidayView holidayView;

    public HolidayController(HolidayModel model, HolidayView view) {
        this.holidayModel = model;
        this.holidayView = view;
        setEmployeesInComboBox();
        holidayView.getAjouterButton().addActionListener(e -> this.ajouterHoliday());
        this.afficherHoliday();
    }

    public void ajouterHoliday() {
        JComboBox<String> nom = holidayView.getNomEmployeComboBox();
        int Employeeid = Integer.parseInt(nom.getSelectedItem().toString().split(" - ")[0]);
        System.out.println(Employeeid);
        HolidayType type = (HolidayType) holidayView.getTypeComboBox().getSelectedItem();
        String dateDebut = holidayView.getDateDebut();
        String dateFin = holidayView.getDateFin();
        Holiday holiday = new Holiday(1,Employeeid, type, dateDebut, dateFin);
        holidayModel.ajouterHoliday(holiday);
    }
    public void afficherHoliday() {
        DefaultTableModel model = (DefaultTableModel) holidayView.getHolidayTable().getModel();
        Employee employee;
        model.setRowCount(0);
        List<Holiday> holidays = holidayModel.afficher();
        for (Holiday holiday : holidays) {
            employee = holidayModel.FindById(holiday.getId());
            model.addRow(new Object[]{holiday.getId(), employee.getNom() + " " + employee.getPrenom(), holiday.getType(), holiday.getStart(), holiday.getEnd()});
        }
    }

    public void setEmployeesInComboBox() {
        List<Employee> employees = holidayModel.afficherEmployee();
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        
        for (Employee e : employees) {
            comboBoxModel.addElement(e.getId() + " - " + e.getNom() + " " + e.getPrenom());
        }
        
        holidayView.getNomEmployeComboBox().setModel(comboBoxModel);
    }
}