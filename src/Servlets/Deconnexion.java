package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "Deconnexion", urlPatterns = {"/Logout"})
public class Deconnexion extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("id", null);
        session.setAttribute("prenom", null);
        session.setAttribute("nom", null);
        response.sendRedirect(request.getContextPath()+"/Home");
    }
}
