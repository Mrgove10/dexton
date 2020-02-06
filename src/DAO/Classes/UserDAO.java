package DAO.Classes;

import Beans.Role;
import Beans.User;
import DAO.DAO;
import Utils.Logging;

import java.io.IOException;
import java.sql.*;

public class UserDAO extends DAO<User> {
    public UserDAO(Connection conn) {
        super(conn);
    }

    public boolean create(User obj) throws IOException {
        try {
            PreparedStatement ps = this.connect.prepareStatement("INSERT INTO Users(LASTNAME, FIRSTNAME, EMAIL, ROLE) VALUES (?,?,?,?);");
            ps.setString(1, obj.getLastName());
            ps.setString(2, obj.getFirstName());
            ps.setString(3, obj.getEmail());
            ps.setInt(4, obj.getRoleId());

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

    public boolean delete(User obj) throws IOException {
        try {
            PreparedStatement ps = this.connect.prepareStatement("DELETE FROM Users WHERE ID = ?");
            ps.setInt(1, obj.getID());

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

    public boolean update(User obj) throws IOException {
        try {
            PreparedStatement ps = this.connect.prepareStatement("UPDATE Users " +
                    "SET EMAIL = ?, FIRSTNAME = ?, LASTNAME = ?, PASSWORD = ?, ROLE = ?" +
                    "WHERE ID = ?");

            ps.setString(1, obj.getEmail());
            ps.setString(2, obj.getFirstName());
            ps.setString(3, obj.getLastName());
            ps.setString(4, obj.getPassword());
            ps.setInt(5, obj.getRoleId());
            ps.setInt(6, obj.getID());

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

    public User find(int id) throws IOException {
        User user = new User();
        int idRole = -1;

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Users WHERE ID = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                //Retrieve by column name
                user.setID(rs.getInt("ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setFirstName(rs.getString("FIRSTNAME"));
                user.setFirstName(rs.getString("LASTNAME"));
                idRole = rs.getInt("ROLE");
            }
            rs.close();

            RoleDAO roleDAO = new RoleDAO(this.connect);
            Role role = roleDAO.find(idRole);
            user.setRole(role);

        } catch (SQLException e) {
            e.printStackTrace();
            Logging.AddLog(Logging.Severity.Error, e.toString());
        } finally {
            try {
                if (this.connect != null)
                    this.connect.close();
            } catch (SQLException ignore) {
                Logging.AddLog(Logging.Severity.Error, ignore.toString());
            }
        }

        return user;
    }
}
