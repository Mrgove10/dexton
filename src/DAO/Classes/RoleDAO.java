package DAO.Classes;

import Beans.Role;
import Beans.User;
import DAO.DAO;

import java.sql.*;

public class RoleDAO extends DAO<Role> {
    public RoleDAO(Connection conn) {
        super(conn);
    }

    public boolean create(Role obj) {
        /*
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Users(LASTNAME, FIRSTNAME, EMAIL, ROLE) VALUES (?,?,?,?);");
            preparedStatement.setString(1, obj.getLastName());
            preparedStatement.setString(2, obj.getFirstName());
            preparedStatement.setString(3, obj.getEmail());
            preparedStatement.setInt(4, obj.getRoleId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            // Fermeture de la connexion
            try {
                if (this.connect != null)
                    this.connect.close();
                return true;
            } catch (SQLException ignore) {
                return false;
            }
        }*/
        return false;
    }

    public boolean delete(Role obj) {
        return false;
    }

    public boolean update(Role obj) {
        return false;
    }

    public Role find(int id) {
        Role role = new Role();

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Roles WHERE ID = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
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
                if (this.connect != null)
                    this.connect.close();
            } catch (SQLException ignore) {
            }
        }

        return role;
    }
}

