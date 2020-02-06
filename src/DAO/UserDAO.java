package DAO;

import Beans.User;

import java.sql.*;

public class UserDAO extends DAO<User> {
    public UserDAO(Connection conn) {
        super(conn);
    }

    public boolean create(User obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Users(LASTNAME, FIRSTNAME, EMAIL) VALUES (?,?,?);");
            preparedStatement.setString(1, obj.getLastName());
            preparedStatement.setString(2, obj.getFirstName());
            preparedStatement.setString(3, obj.getEmail());

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
        User User = new User();

        return User;
    }
}
