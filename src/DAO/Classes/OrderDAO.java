package DAO.Classes;

import Beans.Order;
import DAO.DAO;
import Utils.Logging;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO extends DAO<Order> {
    public OrderDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Order obj) throws IOException {
        try {
            PreparedStatement ps = this.connect.prepareStatement("INSERT INTO Orders(USER, STATUS) VALUES (?,?);");
            ps.setInt(1, obj.getUserID());
            ps.setString(2, obj.getStatus());

            ps.executeUpdate();

        } catch (SQLException e) {
            Logging.AddLog(Logging.Severity.Error, e.toString());
            return false;
        } finally {
            // Fermeture de la connexion
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return true;
                }
            } catch (SQLException ignore) {
                Logging.AddLog(Logging.Severity.Error, ignore.toString());
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean delete(Order obj) {
        //TODO : this
        return false;
    }

    @Override
    public boolean update(Order obj) {
        //TODO : this
        return false;
    }

    @Override
    public Order find(int id) {
        //TODO : this
        return null;
    }
}
