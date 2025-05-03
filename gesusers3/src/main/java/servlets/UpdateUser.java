package servlets;
import java.io.IOException;
import forms.UserForm;
import beans.Utilisateur;
import dao.UtilisateurDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateUser extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private static String VUE_UPDATE_UTILISATEUR = "/WEB-INF/modifierUtilisateur.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer l'ID depuis l'URL
        String idStr = request.getParameter("id");
        
        if (idStr != null && !idStr.isEmpty()) {
            try {
                int id = Integer.parseInt(idStr);
                Utilisateur utilisateur = UtilisateurDao.get(id);
                
                if (utilisateur != null) {
                    request.setAttribute("utilisateur", utilisateur);
                } else {
                    request.setAttribute("erreur", "Utilisateur non trouvé");
                }
            } catch (NumberFormatException e) {
                request.setAttribute("erreur", "ID invalide");
            }
        }
        
        getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserForm form = new UserForm(request);
        
        if(form.modifie()) {
            response.sendRedirect("list");
        } else {
            request.setAttribute("status", form.isStatus());
            request.setAttribute("statusMesaage", form.getStatusMessage());
            request.setAttribute("erreurs", form.getErreurs());
            request.setAttribute("utilisateur", form.getUtilisateur());
            getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR).forward(request, response);
        }
    }
}