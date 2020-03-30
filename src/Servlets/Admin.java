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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

@WebServlet(name = "Admin", urlPatterns = {"/Admin"})
public class Admin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("update_form") != null) {
            System.out.println("Update form");
        } else if (request.getParameter("add_form") != null) {
            System.out.println("Add form");
            Product P  = new Product();
            P.setName(request.getParameter("add_name"));
            P.setPrice(parseInt(request.getParameter("add_price")));
            P.setDescription(request.getParameter("add_description"));

            ProductDAO productDAO = new ProductDAO(DAOConnection.ConnectDb());
            productDAO.create(P);
        }

        var name = request.getParameter("name");
        var price = request.getParameter("price");
        System.out.println(name);
        System.out.println(price);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //   if (session.getAttribute("id") != null) {
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
      /*  } else {
            response.sendRedirect(request.getContextPath() + "/Login");
        }*/
    }
}
