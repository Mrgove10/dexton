package DAO;

import Beans.Users;

import java.sql.*;

public class UsersDAO extends DAO<Users> {
    public UsersDAO(Connection conn) {
        super(conn);
    }

    public boolean create(Users obj) {
        return false;
    }

    public boolean delete(Users obj) {
        return false;
    }

    public boolean update(Users obj) {
        return false;
    }

    public Users find(int id) {
        Users Users = new Users();

        return Users;
    }
}
