package Servlets;

import Beans.Order;
import Beans.Product;
import Beans.User;
import DAO.Classes.OrderDAO;
import DAO.Classes.ProductDAO;
import DAO.Classes.UserDAO;
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

        //Products
        ProductDAO productDAO = new ProductDAO(DAOConnection.ConnectDb());
        var listProducts = new ArrayList<Product>();
        listProducts = productDAO.find();
        request.setAttribute("listProducts", listProducts);

        //Users
        UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
        var listUsers = new ArrayList<User>();
        listUsers = userDAO.find();
        request.setAttribute("listUsers", listUsers);

        //Orders
        OrderDAO orderDAO = new OrderDAO(DAOConnection.ConnectDb());
        var listOrders = new ArrayList<Order>();
        listOrders = orderDAO.find();
        request.setAttribute("listOrders", listOrders);

        this.getServletContext().getRequestDispatcher("/WEB-INF/Admin.jsp").forward(request, response);
    }
}
