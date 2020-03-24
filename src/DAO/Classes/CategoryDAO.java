package DAO.Classes;

import Beans.Category;
import DAO.DAO;
import Utils.Logging;
import jdk.jshell.spi.ExecutionControl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO extends DAO<Category> {
    public CategoryDAO(Connection conn) {
        super(conn);
    }

    /**
     * Creates a category
     *
     * @param obj
     * @return
     */
    public boolean create(Category obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("INSERT INTO Categories(ID, NAME) VALUES (?,?);");
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
     * Deletes an category
     *
     * @param obj
     * @return
     */
    public boolean delete(Category obj) throws IOException {
        try {
            PreparedStatement ps = this.connect.prepareStatement("DELETE FROM Categories WHERE ID = ?");
            ps.setInt(1, obj.getId());
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

    /**
     * Updates a role
     *
     * @param obj
     * @return
     */
    public boolean update(Category obj) {
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Categories " +
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

    public ArrayList<Category> find() {
        return null;
    }

    /**
     * Finds a role
     *
     * @param id
     * @return
     */
    public Category find(int id) {
        Category category = new Category();

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Categories WHERE ID = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Retrieve by column name
                category.setId(rs.getInt("ID"));
                category.setName(rs.getString("NAME"));
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

        return category;
    }

    public Category find(String name) {
        Category category = new Category();

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Categories WHERE NAME = ?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Retrieve by column name
                category.setId(rs.getInt("ID"));
                category.setName(rs.getString("NAME"));
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

        return category;
    }

    public ArrayList<Category> findAll() {
        ArrayList<Category> listCategory = new ArrayList<Category>();

        try {
            PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM Categories");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //Retrieve by column name
                Category category = new Category();
                category.setId(rs.getInt("ID"));
                category.setName(rs.getString("NAME"));
                listCategory.add(category);
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

        return listCategory;
    }
}
