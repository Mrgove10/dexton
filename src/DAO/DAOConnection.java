package DAO;

import java.sql.*;

public class DAOConnection {
    public static Connection ConnectDb() {
        Connection connexion = null;

        //TODO: what is this ?
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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
