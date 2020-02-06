package DAO;

import java.sql.*;

public class DAOConnection {
    public static Connection ConnectDb() {
        Connection connexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("test1");
        }

        try {
            connexion = DriverManager.getConnection(Config.path, Config.user, Config.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connexion;
    }
}
