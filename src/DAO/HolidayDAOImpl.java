package DAO;

import java.sql.*;

import Model.HolidayModel;

public class HolidayDAOImpl implements HolidayDAOI {
    private Connection connection;
    public HolidayDAOImpl() {
        connection = DBConnection.getConnection();
    }
    @Override
    public void ajouterHoliday() {
    }
    @Override
    public void modifierHoliday() {
    }
    @Override
    public void supprimerHoliday() {
    }
}
