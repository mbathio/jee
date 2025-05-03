package servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer la session actuelle
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // Invalider la session
            session.invalidate();
        }
        
        // Rediriger vers la page d'accueil
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}