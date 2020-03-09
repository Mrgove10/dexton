package Servlets;

import Beans.Product;
import DAO.Classes.ProductDAO;
import DAO.DAOConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Admin", urlPatterns = {"/Admin"})
public class Admin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductDAO productDAO = new ProductDAO(DAOConnection.ConnectDb());
        var listProducts = new ArrayList<Product>();
        listProducts = productDAO.find();

        request.setAttribute("listProducts", listProducts);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Admin.jsp").forward(request, response);
    }
}
