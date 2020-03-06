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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@WebServlet(name = "Index", urlPatterns = {"/Home"})
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("addToCart") != null){

            var id = Integer.parseInt(request.getParameter("product"));
            ProductDAO productDAO = new ProductDAO(DAOConnection.ConnectDb());
            var product = productDAO.find(id);
            int quantity = product.getQuantity();
            if (quantity == 0){
                product.setQuantity(1);
                quantity = 1;
            }
            System.out.println(quantity);

            HttpSession session = request.getSession();
            ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("list_products");
            if (list == null){
                list = new ArrayList<>();
            }
            boolean isAlone = true;
            for (Product prod: list) {
                if (prod.getId() == product.getId()){
                    prod.setQuantity(quantity + 1);
                    isAlone = false;
                }
            }
            if (isAlone){
                list.add(product);
            }
            System.out.println(product.getQuantity());
            session.setAttribute("list_products", list);
        }


        String url = request.getRequestURL().toString();
        var arrayUrl = url.split("/");
        var categoryName = arrayUrl[arrayUrl.length-1];
        response.sendRedirect(request.getContextPath()+"/"+categoryName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("search") != null){
            var idCategory = Integer.parseInt(request.getParameter("searchCategory"));
            var searchWord = request.getParameter("searchWord");

            ProductDAO productDAO = new ProductDAO(DAOConnection.ConnectDb());
            var list = productDAO.FindByCategoryAndName(searchWord, idCategory);
            System.out.println(list);
        }

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
