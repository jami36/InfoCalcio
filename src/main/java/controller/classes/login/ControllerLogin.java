package controller.classes.login;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.classes.sicurezza.AccessManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/admin/login")
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AccessManager.isAdminLogged()) {
			String s = getBody(request);
			String[] admin = s.split(",");
		//	String[] admin = (String[]) request.getAttribute("admin");
			request.getSession().setAttribute(
					"user", 
					new AccessManager(
							admin[0],
							admin[1],
							request.getSession()));
		}else{
			response.getWriter().append("Admin già loggato");
		}
		response.getWriter().append(AccessManager.isAdmin(request)? "true" : "false");
		
	}
	private String getBody(HttpServletRequest request) throws IOException {
		String ris = "";
		
		BufferedReader br = request.getReader();
		String line = null;
		
		while ((line = br.readLine()) != null) {
			ris += line;
		}
		
		return ris;
	}
}
