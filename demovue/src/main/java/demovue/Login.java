package demovue;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final String VUE_PAGE = "/WEB-INF/page.jsp"; // Chemin de la vue

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirige vers la page JSP pour afficher le formulaire de connexion
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(VUE_PAGE);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Définit le type de contenu pour la réponse
        response.setContentType("text/html; charset=utf-8");

        // Récupère les paramètres envoyés par le formulaire
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        // Message en fonction des informations de connexion
        if ("admin".equals(login) && "passer".equals(password)) {
            request.setAttribute("message", "Connexion réussie");
        } else {
            request.setAttribute("message", "Connexion impossible");
        }

        // Redirige vers la page JSP pour afficher le message
        getServletContext().getRequestDispatcher(VUE_PAGE).forward(request, response);
    }
}
