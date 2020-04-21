package DAO;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public abstract class DAO<T> {
    protected Connection connect = null;

    public DAO(Connection conn){
        this.connect = conn;
    }

    /**
     * Méthode de création
     * @param obj
     * @return boolean
     */
    public abstract boolean create(T obj) throws IOException;

    /**
     * Méthode pour effacer
     * @param obj
     * @return boolean
     */
    public abstract boolean delete(T obj) throws IOException;

    /**
     * Méthode de mise à jour
     * @param obj
     * @return boolean
     */
    public abstract boolean update(T obj) throws IOException;

    /**
     * Méthode de recherche des informations
     * @param id
     * @return T
     */
    public abstract T find(int id) throws IOException;

    /**
     * Get all the things in that categorie
     * @return
     * @throws IOException
     */
    public abstract ArrayList<T> find() throws IOException;
}
