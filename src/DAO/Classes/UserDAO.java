package DAO.Classes;

import Beans.User;
import DAO.DAO;

import java.sql.*;

public class UserDAO extends DAO<User> {
    public UserDAO(Connection conn) {
        super(conn);
    }

    public boolean create(User obj) {
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
        }
    }

    public boolean delete(User obj) {
        return false;
    }

    public boolean update(User obj) {
        return false;
    }

    public User find(int id) {
        User user = new User();

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
                int idRole = rs.getInt("ROLE");
            }
            rs.close();

        } catch (SQLException e) {

        }

        return User;
    }
}
