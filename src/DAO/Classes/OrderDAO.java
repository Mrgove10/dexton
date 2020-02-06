package DAO.Classes;

import Beans.Order;
import DAO.DAO;

import java.sql.Connection;

public class OrderDAO extends DAO<Order> {
    public OrderDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Order obj) {
        return false;
    }

    @Override
    public boolean delete(Order obj) {
        return false;
    }

    @Override
    public boolean update(Order obj) {
        return false;
    }

    @Override
    public Order find(int id) {
        return null;
    }
}
