package Servlets;

import Beans.Category;
import Beans.Product;
import Beans.Role;
import Beans.User;
import DAO.Classes.CategoryDAO;
import DAO.Classes.ProductDAO;
import DAO.DAOConnection;
import DAO.Classes.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "Index", urlPatterns = {"/Home"})
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO(DAOConnection.ConnectDb());
        var listProducts = productDAO.find();
        var listNewProducts = new ArrayList<Product>();
        for (Product product : listProducts) {
            Date current = new Date();

            Calendar date = Calendar.getInstance();
            date.setTime(product.getAddDate());
            date.add(Calendar.DATE, 7);

            Calendar currentDate = Calendar.getInstance();
            currentDate.setTime(current);

            if (date.after(currentDate) || date.equals(currentDate)){
                listNewProducts.add(product);
            }
        }

        request.setAttribute("categories", Navigation());
        request.setAttribute("listNewProducts", listNewProducts);
        request.setAttribute("currentPage", "Home");
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }

    private ArrayList<Category> Navigation(){
        CategoryDAO categoryDAO = new CategoryDAO(DAOConnection.ConnectDb());
        return categoryDAO.findAll();
    }
}
