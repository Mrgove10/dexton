package DAO.Classes;

import Beans.Category;
import DAO.DAO;

import java.sql.Connection;

public class CategoryDAO extends DAO<Category> {
    public CategoryDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Category obj) {
        return false;
    }

    @Override
    public boolean delete(Category obj) {
        return false;
    }

    @Override
    public boolean update(Category obj) {
        return false;
    }

    @Override
    public Category find(int id) {
        return null;
    }
}
