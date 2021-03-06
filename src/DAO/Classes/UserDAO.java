package DAO.Classes;

import Beans.Role;
import Beans.User;
import DAO.DAO;
import Utils.Logging;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class UserDAO extends DAO<User> {
    public UserDAO(Connection conn) {
        super(conn);
    }

    /**
     * Creates a user
     * @param obj
     * @return
     * @throws IOException
     */
    public boolean create(User obj) {
        try {
            PreparedStatement ps = this.connect.prepareStatement("INSERT INTO Users(LASTNAME, FIRSTNAME, EMAIL, PASSWORD) VALUES (?,?,?,?);");
            ps.setString(1, obj.getLastName());
            ps.setString(2, obj.getFirstName());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getPassword());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            // Fermeture de la connexion
            try {
                if (this.connect != null) {
                    this.connect.close();
                    return true;
                }
            } catch (SQLException ignore) {
                System.out.println(ignore);
                return false;
            }
        }
        return false;
    }

    /**
     * Deltes a User
     * @param obj
     * @return
     * @throws IOException
     */
    public boolean delete(User obj) throws IOException {
        try {
            PreparedStatement ps = this.connect.prepareStatement("DELETE FROM Users WHERE ID = ?");
            ps.setInt(1, obj.getId());

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

    /**
     * Updates a user
     * @param obj
     * @return
     * @throws IOException
     */
    public boolean update(User obj) throws IOException {
        try {
            PreparedStatement ps = this.connect.prepareStatement("UPDATE Users " +
                    "SET EMAIL = ?, FIRSTNAME = ?, LASTNAME = ?" +
                    "WHERE ID = ?");

            ps.setString(1, obj.getEmail());
            ps.setString(2, obj.getFirstName());
            ps.setString(3, obj.getLastName());
            ps.setInt(4, obj.getId());

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

    /**
     * Find a user wit there id
     * @param id
     * @return
     * @throws IOException
     */
    public User find(int id) throws IOException {
        User user = new User();
        int idRole = -1;

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Users WHERE ID = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                //Retrieve by column name
                user.setId(rs.getInt("ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setFirstName(rs.getString("FIRSTNAME"));
                user.setLastName(rs.getString("LASTNAME"));
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


    public ArrayList<User> find() throws IOException {
        ArrayList<User> userList = new ArrayList<>();
        int idRole = -1;

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Users");

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                User user = new User();
                //Retrieve by column name
                user.setId(rs.getInt("ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setFirstName(rs.getString("FIRSTNAME"));
                user.setLastName(rs.getString("LASTNAME"));
                idRole = rs.getInt("ROLE");
                userList.add(user);

                RoleDAO roleDAO = new RoleDAO(this.connect);
                Role role = roleDAO.find(idRole);
                user.setRole(role);
            }
            rs.close();

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

        return userList;
    }

    /**
     * Find a user with there email ans password
     * @param email
     * @param password
     * @return
     * @throws IOException
     */
    public User find(String email, String password) throws IOException {
        User user = new User();
        int idRole = -1;

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Users WHERE EMAIL = ? AND PASSWORD = ?");
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                //Retrieve by column name
                user.setId(rs.getInt("ID"));
                user.setEmail(rs.getString("EMAIL"));
                user.setFirstName(rs.getString("FIRSTNAME"));
                user.setLastName(rs.getString("LASTNAME"));
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
