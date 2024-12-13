package Model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import DAO.HolidayDAOImpl;
import View.HolidayView;

public class HolidayModel {
    private HolidayDAOImpl dao;
    public HolidayModel(HolidayDAOImpl dao) {
        this.dao = dao;
    }
    public List<Employee> afficherEmployee() {
        return dao.afficherEmployee();
    }
    public List<Holiday> afficher() {
        return dao.afficher();
    }
    public void ajouterHoliday(Holiday holiday, Employee employee) {
        int days = calculateHolidayTime(holiday.getStart(), holiday.getEnd());
        if (startCheck(holiday.getStart())) {
            HolidayView.fail("La date de début doit venir avant aujourd'hui.");
            return;
        }
        if (days <= 0) {
            HolidayView.fail("La date de fin doit venir après la date de début.");
            return;
        }
        if (employee.getHolidayBalance() >= days) {
            employee.setHolidayBalance(employee.getHolidayBalance() - days);
            dao.ajouter(holiday);
        } else {
            HolidayView.fail("Le nombre de jours de congés disponibles est insuffisant.");
        }
    }

    public boolean startCheck(String startDateString) {
        LocalDate startDate = LocalDate.parse(startDateString);
        return startDate.isBefore(LocalDate.now());
    }

    public int calculateHolidayTime(String startDateString, String endDateString) {
        LocalDate startDate = LocalDate.parse(startDateString);
        LocalDate endDate = LocalDate.parse(endDateString);
        return (int) ChronoUnit.DAYS.between(startDate, endDate);
    }

    public Employee FindById(int EmployeeId) {
        return dao.findById(EmployeeId);
    }
    public void supprimerHoliday(int holidayId) {
        dao.supprimer(holidayId);
    }
}
