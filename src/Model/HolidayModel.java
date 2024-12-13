package Model;

import DAO.HolidayDAOImpl;

public class HolidayModel {
    private HolidayDAOImpl dao;
    public HolidayModel(HolidayDAOImpl dao) {
        this.dao = dao;
    }
}
