package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Filtre de sécurité : empêche l'accès aux pages sans authentification.
 */
@WebFilter({"/list", "/add", "/update", "/delete"}) // Mets ici les URLs à protéger
public class AuthenticationFilters implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialisation si besoin
    }

    @Override
    public void destroy() {
        // Nettoyage si besoin
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);
        Object utilisateur = (session != null) ? session.getAttribute("utilisateur") : null;

        if (utilisateur == null) {
            // Redirige vers la page de login si non connecté
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            // L'utilisateur est connecté, on continue
            chain.doFilter(request, response);
        }
    }
}
