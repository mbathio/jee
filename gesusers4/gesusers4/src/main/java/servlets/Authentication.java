package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import forms.AuthentificationForm;

@WebServlet({"/login", "/logout"})
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_CONNEXION = "/WEB-INF/login.jsp";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getServletPath()) {
			case "/login":
				getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
				break;

			case "/logout":
				if (request.getSession(false) != null) {
					request.getSession().invalidate();
				}
				response.sendRedirect(request.getContextPath() + "/login");
				break;

			default:
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AuthentificationForm form = new AuthentificationForm(request);

		if (form.authentifier()) {
			response.sendRedirect(request.getContextPath() + "/list");
		} else {
			String path = request.getContextPath() + "/login?error=1";
			String sentLogin = form.getLogin();
			if (sentLogin != null) {
				path += "&user=" + sentLogin;
			}
			response.sendRedirect(path);
		}
	}
}
