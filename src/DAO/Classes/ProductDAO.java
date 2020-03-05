package DAO.Classes;

import Beans.Product;
import DAO.DAO;
import Utils.Logging;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DAO<Product> {
    public ProductDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean create(Product obj) throws IOException {
        try {
            PreparedStatement ps = this.connect.prepareStatement("INSERT INTO Products(NAME, PRICE, DESCRIPTION, BRAND, CATEGORY, RATING, ADDDATE) VALUES (?,?,?,?,?,?,?);");
            ps.setString(1, obj.getName());
            ps.setFloat(2, obj.getPrice());
            ps.setString(3, obj.getDescription());
            ps.setString(4, obj.getBrand());
            ps.setInt(5, obj.getCategoryID());
            ps.setFloat(6, obj.getRating());
            ps.setDate(7, obj.getAddDate());

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

    @Override
    public boolean delete(Product obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("DELETE FROM Products WHERE ID = ?");
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

    @Override
    public boolean update(Product obj) {
        try {
            PreparedStatement ps = this.connect.prepareStatement("UPDATE Products " +
                    "SET NAME = ?, PRICE = ?, DESCRIPTION = ?, BRAND = ?, CATEGORY = ?, RATING = ?, ADDDATE = ?" +
                    "WHERE ID = ?");
            ps.setString(1, obj.getName());
            ps.setFloat(2, obj.getPrice());
            ps.setString(3, obj.getDescription());
            ps.setString(4, obj.getBrand());
            ps.setInt(5, obj.getCategoryID());
            ps.setFloat(6, obj.getRating());
            ps.setDate(7, obj.getAddDate());
            ps.executeUpdate();

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

    public ArrayList<Product> find() {
        ArrayList<Product> productList = new ArrayList<>();

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Products");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                //Retrieve by column name
                product.setId(rs.getInt("ID"));
                product.setName(rs.getString("NAME"));
                product.setBrand(rs.getString("BRAND"));
                product.setAddDate(rs.getDate("ADDDATE"));
                product.setCategoryID(rs.getInt("CATEGORY"));
                product.setDescription(rs.getString("DESCRIPTION"));
                product.setPrice(rs.getFloat("PRICE"));
                product.setRating(rs.getFloat("RATING"));
                productList.add(product);
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
        return productList;
    }

    public Product find(int id) {
        Product product = new Product();

        try {

            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Products WHERE ID = ?");
            ps.setInt(1, id);


            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Retrieve by column name
                product.setId(rs.getInt("ID"));
                product.setName(rs.getString("NAME"));
                product.setBrand(rs.getString("BRAND"));
                product.setAddDate(rs.getDate("ADDDATE"));
                product.setCategoryID(rs.getInt("CATEGORY"));
                product.setDescription(rs.getString("DESCRIPTION"));
                product.setPrice(rs.getFloat("PRICE"));
                product.setRating(rs.getFloat("RATING"));

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

        return product;
    }

    public ArrayList<Product> findProductsFromCategory(int categoryID) {
        ArrayList<Product> productList = new ArrayList<Product>();

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Products WHERE CATEGORY = ?");
            ps.setInt(1, categoryID);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Retrieve by column name
                Product product = new Product();
                product.setId(rs.getInt("ID"));
                product.setName(rs.getString("NAME"));
                product.setBrand(rs.getString("BRAND"));
                product.setAddDate(rs.getDate("ADDDATE"));
                product.setCategoryID(rs.getInt("CATEGORY"));
                product.setDescription(rs.getString("DESCRIPTION"));
                product.setPrice(rs.getFloat("PRICE"));
                product.setRating(rs.getFloat("RATING"));
                productList.add(product);
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

        return productList;
    }
}
