package DAO.Classes;

import Beans.Order;
import Beans.OrderDetail;
import DAO.DAO;
import Utils.Logging;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailDAO extends DAO<Order> {
    public OrderDetailDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(OrderDetail obj) throws IOException {
        try {
            PreparedStatement ps = this.connect.prepareStatement("INSERT INTO OrderDetails(ORDER, PRODUCT, QUANTITY) VALUES (?,?,?);");
            ps.setInt(1, obj.getOrder());
            ps.setInt(2, obj.getProduct());
            ps.setInt(3, obj.getQuantity());

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
            //    Logging.AddLog(Logging.Severity.Error, ignore.toString());
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean delete(OrderDetail obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE OrderDetails Orders WHERE ID = ?");
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
    public boolean update(OrderDetail obj) {
        try {
            PreparedStatement ps = this.connect.prepareStatement("UPDATE OrderDetails " +
                    "SET ORDER = ?, PRODUCT = ?, QUANTITY = ?" +
                    "WHERE ID = ?");
            ps.setInt(1, obj.getOrder());
            ps.setInt(1, obj.getProduct());
            ps.setInt(1, obj.getQuantity());
            ps.setInt(1, obj.getId());
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
    public OrderDetail find(int id) {
        OrderDetail orderDetail = new OrderDetail();

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM OrderDetails WHERE ID = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Retrieve by column name
                orderDetail.setId(rs.getInt("ID"));
                orderDetail.setOrder(rs.getInt("ORDER"));
                orderDetail.setProduct(rs.getString("PRODUCT"));
                orderDetail.setQuantity(rs.getString("QUANTITY"));
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

        return orderDetail;
    }
}
