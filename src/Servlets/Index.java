package Servlets;

import Beans.Role;
import Beans.User;
import DAO.DAOConnection;
import DAO.Classes.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Index", urlPatterns = {"/Home"})
public class Index extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User();
        user.setLastName("MICHEL");
        user.setFirstName("Jean");
        user.setEmail("JeanLaPute@gmail.com");
        user.setPassword("vatefaireenculer");

        Role role = new Role();
        role.setName("Admin");
        role.setId(2);

        user.setRole(role);

        UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
        //User user = userDAO.find("edouardclisson@gmail.com", "123456");
        userDAO.create(user);
        System.out.println(user.getEmail());
        this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
    }
}
