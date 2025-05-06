package servlets;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;


import java.io.IOException;

import dao.UtilisateurDao;

@WebServlet("/list")
public class ListUser extends HttpServlet 
{
    private static final String VUE_LIST_UTILISATEUR = "/WEB-INF/listerUtilisateurs.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.setAttribute("utilisateurs", UtilisateurDao.lister());
        getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEUR).forward(request, response);
    }
}