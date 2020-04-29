package DAO.Classes;

import Beans.Role;
import DAO.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoleDAO extends DAO<Role> {
    public RoleDAO(Connection conn) {
        super(conn);
    }

    /**
     * Creates a Role
     *
     * @param obj
     * @return
     */
    public boolean create(Role obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Roles(ID, NAME) VALUES (?,?);");
            preparedStatement.setInt(1, obj.getId());
            preparedStatement.setString(2, obj.getName());
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

    /**
     * Delete a role
     *
     * @param obj
     * @return
     */
    public boolean delete(Role obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM Roles WHERE ID = ?");
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

    /**
     * Updates a Role
     *
     * @param obj
     * @return
     */
    public boolean update(Role obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Roles " +
                    "SET NAME = ? WHERE ID = ?");
            preparedStatement.setString(1, obj.getName());
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

    /**
     * find all
     *
     * @return
     */
    public ArrayList<Role> find() {
        return null;
    }

    /**
     * Find a role based on its id
     *
     * @param id
     * @return
     */
    public Role find(int id) {
        Role role = new Role();

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Roles WHERE ID = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Retrieve by column name
                role.setId(rs.getInt("ID"));
                role.setName(rs.getString("NAME"));
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

        return role;
    }
}

