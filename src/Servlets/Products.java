package Servlets;

import Beans.Category;
import Beans.Product;
import DAO.Classes.CategoryDAO;
import DAO.Classes.ProductDAO;
import DAO.DAOConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "Products", urlPatterns = {"/All", "/Laptops", "/Smartphones", "/Cameras", "/Accessories"})
public class Products extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURL().toString();
        var arrayUrl = url.split("/");
        var categoryName = arrayUrl[arrayUrl.length-1];
        System.out.println(categoryName);


        ProductDAO productDAO = new ProductDAO(DAOConnection.ConnectDb());
        var listProducts = new ArrayList<Product>();
        if (categoryName.equals("All")){
            listProducts = productDAO.find();
        }else {
            CategoryDAO categoryDAO = new CategoryDAO(DAOConnection.ConnectDb());
            var category = categoryDAO.find(categoryName);

            listProducts = productDAO.findProductsFromCategory(category.getId());
        }
        var listNewProducts = new ArrayList<Product>();
        for (Product product : listProducts) {
            Date current = new Date();

            Calendar date = Calendar.getInstance();
            date.setTime(product.getAddDate());
            date.add(Calendar.DATE, 7);

            Calendar currentDate = Calendar.getInstance();
            date.setTime(current);

            if (date.after(currentDate) || date.equals(currentDate)){
                listNewProducts.add(product);
            }
        }

        request.setAttribute("listNewProducts", listNewProducts);
        request.setAttribute("listProducts", listProducts);
        request.setAttribute("categories", Navigation());
        this.getServletContext().getRequestDispatcher("/WEB-INF/Products.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private ArrayList<Category> Navigation(){
        CategoryDAO categoryDAO = new CategoryDAO(DAOConnection.ConnectDb());
        return categoryDAO.findAll();
    }

}

