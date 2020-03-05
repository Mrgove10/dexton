package Servlets;

import Beans.Category;
import DAO.Classes.CategoryDAO;
import DAO.Classes.ProductDAO;
import DAO.DAOConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Products", urlPatterns = {"/All", "/Laptops", "/Smartphones", "/Cameras", "/Accessories"})
public class Products extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        var arrayUrl = url.split("/");
        var categoryName = arrayUrl[arrayUrl.length-1];
        System.out.println(categoryName);
        CategoryDAO categoryDAO = new CategoryDAO(DAOConnection.ConnectDb());
        var category = categoryDAO.find(categoryName);

        this.getServletContext().getRequestDispatcher("/WEB-INF/Products.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}

