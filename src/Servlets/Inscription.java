package Servlets;

import Beans.Role;
import Beans.User;
import DAO.Classes.UserDAO;
import DAO.DAOConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Inscription")
public class Inscription extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = new User();
        user.setFirstName(request.getParameter("prenom"));
        user.setLastName(request.getParameter("nom"));
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("pwd"));
        try{
            UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
            userDAO.create(user);
            Cookie cookie = new Cookie("email", request.getParameter("email"));
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);
            response.sendRedirect( request.getContextPath() + "/Login");
        } catch (Exception e){
            System.out.println(e);
            response.sendRedirect( request.getContextPath() + "/Signin");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Inscription.jsp").forward(request, response);
    }
}
