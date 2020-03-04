package Servlets;

import Beans.User;
import DAO.Classes.UserDAO;
import DAO.DAOConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Compte")
public class Compte extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var email = request.getParameter("email");
        var firstName = request.getParameter("firstName");
        var lastName = request.getParameter("lastName");

        try {
            UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
            HttpSession session = request.getSession();

            User user = userDAO.find((Integer) session.getAttribute("id"));
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);

            var isUpdate = userDAO.update(user);
            System.out.println("Is Update ? "+isUpdate);
        }catch (Exception e){
            System.out.println("Error : "+e.getMessage());
        }

        response.sendRedirect(request.getContextPath()+"/Account");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("id") == null){
            response.sendRedirect(request.getContextPath()+"/Login");
        }else{
            UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
            var user = userDAO.find((Integer) session.getAttribute("id"));
            request.setAttribute("user", user);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Compte.jsp").forward(request, response);
        }
    }
}
