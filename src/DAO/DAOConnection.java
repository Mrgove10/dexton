package DAO;

import java.sql.*;

public class DAOConnection {
    public static Connection ConnectDb() {
        Connection connexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                connexion = DriverManager.getConnection(Config.path, Config.user, Config.password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return connexion;
    }
}
