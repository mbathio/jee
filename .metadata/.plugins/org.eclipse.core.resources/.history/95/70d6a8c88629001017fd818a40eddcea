package servlets;

import java.io.IOException;

import beans.Utilisateur;
import dao.UtilisateurDao;
import forms.UserForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddUser extends HttpServlet{
	

	private static final String VUE_AJOUT_UTILISATEUR = "/WEB-INF/ajouterUtilisateurs.jsp";
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
	}
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	UserForm form= new UserForm(request);
    	
    	if(form.ajouter())
    	{
    		response.sendRedirect("list");
    	}
    	else 
    	{
    		request.setAttribute("status", form.isStatus());
    		request.setAttribute("statusMesaage", form.getStatusMessage());
    		request.setAttribute("erreurs", form.getErreurs());
    		request.setAttribute("utilisateur", form.getUtilisateur());
    		getServletContext().getRequestDispatcher(VUE_AJOUT_UTILISATEUR).forward(request, response);
    	}
    	
    	
    }

}
