package Controller;

import DAO.HolidayDAOImpl;
import Model.HolidayModel;
import View.HolidayView;

public class HolidayControler {
    private HolidayView holidayView;
    private HolidayModel holidayModel;
    public HolidayControler(HolidayView holidayView, HolidayModel holidayModel) {
        this.holidayView = holidayView;
        this.holidayModel = holidayModel;
    }
}
