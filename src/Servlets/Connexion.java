package Servlets;

import DAO.Classes.UserDAO;
import DAO.DAOConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Connexion")
public class Connexion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var email = request.getParameter("email");
        var password = request.getParameter("password");

        // find user in DB
        UserDAO userDAO = new UserDAO(DAOConnection.ConnectDb());
        var userFind = userDAO.find(email, password);
        System.out.println(userFind);
        if (userFind.getEmail() != null){
            System.out.println("FIND !");
            // create session
            HttpSession session = request.getSession();
            session.setAttribute("id", userFind.getId());
            session.setAttribute("prenom", userFind.getFirstName());
            session.setAttribute("nom", userFind.getLastName());

            Cookie cookie = new Cookie("email", userFind.getEmail());
            cookie.setMaxAge(60 * 60 * 24 * 7);
            response.addCookie(cookie);

            response.sendRedirect(request.getContextPath()+"/Home");
        }else {
            System.out.println("NOOOOOOO");
            request.setAttribute("error", true);
            this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("error", false);
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals("email")){
                    request.setAttribute("email", cookie.getValue());
                }
            }
        }

        this.getServletContext().getRequestDispatcher("/WEB-INF/Connexion.jsp").forward(request, response);
    }
}
