package Servlets;

import Beans.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "Cart", urlPatterns = {"/Cart"})
public class Cart extends HttpServlet {
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
//        request.setAttribute("list_products", new ArrayList<Product>());
        ArrayList<Product> list_product = new ArrayList<>();

        if (session.getAttribute("list_products") != null){
            list_product = (ArrayList<Product>) session.getAttribute("list_products");
        }
//        else {
//            Product product = new Product();
//            product.setName("nom");
//            product.setBrand("marque");
//            product.setCategoryID(1);
//            product.setDescription("description");
//            product.setRating(5);
//            product.setPrice(12);
//            list_product.add(product);
//
//            Product product2 = new Product();
//            product2.setName("nom");
//            product2.setBrand("marque");
//            product2.setCategoryID(1);
//            product2.setDescription("description");
//            product2.setRating(5);
//            product2.setPrice(10);
//            list_product.add(product2);
//            session.setAttribute("list_products", list_product);
//        }

        Float total = 0f;
        try{
            for (Product item : list_product) {
                total += item.getPrice();
            }
        }catch (Exception e){
            System.out.print(e);
        }
        request.setAttribute("list_products", list_product);
        request.setAttribute("total", total);
        request.setAttribute("total_products", list_product.size());
        this.getServletContext().getRequestDispatcher("/WEB-INF/Cart.jsp").forward(request, response);
    }
}
