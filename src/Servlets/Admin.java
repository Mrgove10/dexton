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

            ProductDAO productDAO = new ProductDAO(DAOConnection.ConnectDb());
            Product product = productDAO.find(Integer.parseInt(request.getParameter("update_form")));

            product.setName(request.getParameter("name"));
            product.setPrice(Float.parseFloat(request.getParameter("price")));
            product.setDescription(request.getParameter("description"));
            product.setBrand(request.getParameter("brand"));
            product.setCategoryID(Integer.parseInt(request.getParameter("category")));
            product.setRating(Float.parseFloat(request.getParameter("rating")));

            ProductDAO productDAO_update = new ProductDAO(DAOConnection.ConnectDb());
            productDAO_update.update(product);

            System.out.println("Update form");

        } else if (request.getParameter("add_form") != null) {
            Product P  = new Product();
            P.setName(request.getParameter("add_name"));
            P.setPrice(parseInt(request.getParameter("add_price")));
            P.setDescription(request.getParameter("add_description"));
            P.setBrand(request.getParameter("add_brand"));
            P.setCategoryID(Integer.parseInt(request.getParameter("add_category")));
            P.setRating(Float.parseFloat(request.getParameter("add_rating")));
            ProductDAO productDAO = new ProductDAO(DAOConnection.ConnectDb());
            productDAO.create(P);

        } else if (request.getParameter("delete_form") != null){
            ProductDAO productDAO = new ProductDAO(DAOConnection.ConnectDb());
            Product product = productDAO.find(Integer.parseInt(request.getParameter("delete_form")));
            ProductDAO productDAO_delete = new ProductDAO(DAOConnection.ConnectDb());
            productDAO_delete.delete(product);
        }
        response.sendRedirect( request.getContextPath() + "/Admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("id") != null) {
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
        } else { //TODO : uncomment this for pro use
            response.sendRedirect(request.getContextPath() + "/Login");
        }
    }
}
