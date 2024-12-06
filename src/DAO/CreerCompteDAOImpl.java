package DAO;

import java.sql.*;

import Model.CreerCompte;
import View.CreerCompteView;

public class CreerCompteDAOImpl implements CreerCompteDAOI {
    private Connection connection;
    public CreerCompteDAOImpl() {
        connection = DBConnection.getConnection();
    }
    @Override
    public void creerCompte(int id, CreerCompte newAccount) {
        String SQL = "INSERT INTO login (username, password,id) VALUES (?, ?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(SQL)) {
            stmt.setString(1, newAccount.getUsername());
            stmt.setString(2, newAccount.getPassword());
            stmt.setInt(3, id);
            stmt.executeUpdate();
            CreerCompteView.CreerCompteSuccess();
        } catch (SQLException e) {
            if(e.getMessage().contains("Duplicate entry")&&e.getMessage().contains("id")){
                CreerCompteView.CreerCompteFail("Cet employé a deja un compte.");
                return;
            }else{
                if(e.getMessage().contains("Duplicate entry")&&e.getMessage().contains("username")){
                    CreerCompteView.CreerCompteFail("Ce username est deja pris.");
                    return;
                }else{
                    e.printStackTrace();
                }
            }
        }
    }
}
