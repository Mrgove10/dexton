package DAO.Classes;

import Beans.Brand;
import DAO.DAO;
import Utils.Logging;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandDAO extends DAO<Brand> {
    private Connection connect;

    public BrandDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Brand obj) throws IOException {
        try {
            PreparedStatement ps = this.connect.prepareStatement("INSERT INTO Brands(NAME) VALUES (?);");
            ps.setString(1, obj.getName());

            ps.executeUpdate();

        } catch (SQLException e) {
            Logging.AddLog(Logging.Severity.Error, e.toString());
            return false;
        } finally {
            // Fermeture de la connexion
            try {
                if (this.connect != null)
                    this.connect.close();
                return true;
            } catch (SQLException ignore) {
                Logging.AddLog(Logging.Severity.Error, ignore.toString());
                return false;
            }
        }
    }

    @Override
    public boolean delete(Brand obj) {
        return false;
    }

    @Override
    public boolean update(Brand obj) {
        return false;
    }

    @Override
    public Brand find(int id) throws IOException {
        Brand brand = new Brand();
        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Brands WHERE ID = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                brand.setId(rs.getInt("ID"));
                brand.setName(rs.getString("NAME"));
            }
        } catch (SQLException e) {
            Logging.AddLog(Logging.Severity.Error, e.toString());
        } finally {
            // Fermeture de la connexion
            try {
                if (this.connect != null)
                    this.connect.close();
            } catch (SQLException ignore) {
                Logging.AddLog(Logging.Severity.Error, ignore.toString());
            }
        }
        return brand;
    }
}