package DAO.Classes;

import Beans.Order;
import DAO.DAO;
import Utils.Logging;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM Orders WHERE ID = ?");
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Fermeture de la connexion
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return true;
                }
            } catch (SQLException ignore) {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean update(Order obj) {
        try {
            PreparedStatement ps = this.connect.prepareStatement("UPDATE Orders " +
                    "SET USER = ?, STATUS = ?" +
                    "WHERE ID = ?");
            ps.setInt(1, obj.getUserID());
            ps.setString(2, obj.getStatus());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Fermeture de la connexion
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return true;
                }
            } catch (SQLException ignore) {
                return false;
            }
        }
        return false;
    }

    @Override
    public Order find(int id) {
        Order order = new Order();

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Orders WHERE ID = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Retrieve by column name
                order.setId(rs.getInt("ID"));
                order.setUserID(rs.getInt("USER"));
                order.setStatus(rs.getString("STATUS"));
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture de la connexion
            try {
                if (this.connect != null) {
                    this.connect.close();
                }
            } catch (SQLException ignore) {
            }
        }

        return order;
    }
}
