package Servlets;

import Beans.User;
import DAO.Classes.UserDAO;
import DAO.DAOConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Compte")
public class Compte extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var email = request.getParameter("email");
        var firstName = request.getParameter("firstName");
        var lastName = request.getParameter("lastName");
        User user = new User();
        try {
            UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
            HttpSession session = request.getSession();

            user = userDAO.find((Integer) session.getAttribute("id"));
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);

            userDAO = new UserDAO(DAOConnection.ConnectDb());
            var isUpdate = userDAO.update(user);

            session.setAttribute("prenom", user.getFirstName());
            session.setAttribute("nom", user.getLastName());

            Cookie cookie = new Cookie("email", user.getEmail());
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);

            System.out.println("Is Update ? "+isUpdate);
        }catch (Exception e){
            System.out.println("Error : "+e.getMessage());
            request.setAttribute("message", "<p style='color:red;'>An error has occured when try to update your account</p>");
        }

        request.setAttribute("user", user);
        request.setAttribute("message", "<p style='color:green;'>Update successfully</p>");

        this.getServletContext().getRequestDispatcher("/WEB-INF/Compte.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("id") == null){
            response.sendRedirect(request.getContextPath()+"/Login");
        }else{
            UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
            var user = userDAO.find((Integer) session.getAttribute("id"));
            request.setAttribute("user", user);
            request.setAttribute("message", "");
            this.getServletContext().getRequestDispatcher("/WEB-INF/Compte.jsp").forward(request, response);
        }
    }
}
