package DAO;

import Model.CreerCompte;

public interface CreerCompteDAOI {
    public boolean creerCompte(int id, CreerCompte newAccount);
}