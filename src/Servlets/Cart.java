package Servlets;

import Beans.Category;
import Beans.Product;
import DAO.Classes.CategoryDAO;
import DAO.DAOConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Cart", urlPatterns = {"/Cart"})
public class Cart extends HttpServlet {
    private ArrayList<Category> Navigation(){
        CategoryDAO categoryDAO = new CategoryDAO(DAOConnection.ConnectDb());
        return categoryDAO.findAll();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Product> list_product;
        try{
            list_product = (ArrayList<Product>) session.getAttribute("list_products");
            int item = Integer.parseInt(request.getParameter("delete"));
            list_product.remove(item);

        }catch (Exception e){
            System.out.println(e);
        }
        response.sendRedirect( request.getContextPath() + "/Cart");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<Product> list_product = new ArrayList<>();

        if (session.getAttribute("list_products") != null){
            list_product = (ArrayList<Product>) session.getAttribute("list_products");
        }

        Float total = 0f;
        int total_product = 0;
        try{
            for (Product item : list_product) {
                total_product += item.getQuantity();
                total += item.getPrice() * item.getQuantity();
            }
        }catch (Exception e){
            System.out.print(e);
        }
        request.setAttribute("categories", Navigation());
        request.setAttribute("list_products", list_product);
        request.setAttribute("total", total);
        request.setAttribute("total_products", total_product);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Cart.jsp").forward(request, response);
    }
}
