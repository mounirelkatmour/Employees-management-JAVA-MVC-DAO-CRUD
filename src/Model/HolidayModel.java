package Model;

import java.util.List;

import DAO.HolidayDAOImpl;

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
    public void ajouterHoliday(Holiday holiday) {
        dao.ajouter(holiday);
    }
    public Employee FindById(int EmployeeId) {
        return dao.findById(EmployeeId);
    }
}
