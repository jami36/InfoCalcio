package controller.classes.manutenzione;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import controller.classes.sicurezza.AccessManager;
import dao.classes.DaoAdminAggiunta;
import dao.classes.DaoAdminModifica;
import dao.classes.DaoSquadre;
import entities.*;

/**
 * Servlet implementation class AdminIndex
 */
@WebServlet({"/admin" , "/admin/*"})
public class ControllerAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoAdminAggiunta daoA;
	DaoAdminModifica daoM;
	Gson gson = new Gson();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerAdmin() {
		super();
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String dbAddress = "jdbc:mysql://localhost:3306/JAMI36?useSSL=false&user=jami36&password=babacchio36";
        daoA = new DaoAdminAggiunta(dbAddress);
        daoM = new DaoAdminModifica(dbAddress);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		if(AccessManager.isAdmin(request)) {
			if(request.getPathInfo()!=null&&request.getPathInfo().equals("/logout")) {
				AccessManager as = (AccessManager) request.getSession().getAttribute("user");
				as.logout();
				request.removeAttribute("user");
				request.getSession().invalidate();
				response.sendRedirect("{\"logout\" : true}");
			}
			response.getWriter().append("{ \"logged\" : true }");
		}else {
			response.getWriter().append("{ \"logged\" : false }");
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		if (request.getPathInfo() != null && request.getPathInfo().equals("/login")) {
			if(!AccessManager.isAdminLogged()) {
				AccessManager as = new AccessManager((String) request.getAttribute("passwd") ,
						(String) request.getAttribute("uname"), null);
				System.out.println("passa dentro if");
				request.getSession().setAttribute(
						"user", 
						as);
				if(as.checkLog()) {
					as.setSession(request.getSession());
					response.getWriter().append("{ \"logged\" : true }");
				}else {
					response.getWriter().append("{ \"logged\" : false }");
				}

			}else{
				response.getWriter().append("{ \"logged\" : false }");
			}
		}
		else if(request.getPathInfo() != null ) {
			String json = getBody(request);
			json = json.substring(1, json.length() -1).replaceAll("\\\\\\\"", "\"").replaceAll("\\\\n", "");
			String res ="messaggio figo";
			switch(request.getPathInfo()) {
			case "/aggiungi/competizioni" :
				res += daoA.addCompetizione(Arrays.asList((gson.fromJson(json, Competizione[].class))));
				System.out.println(res);
				break;
			case "/aggiungi/squadre"  : 
				res += daoA.addSquadre(Arrays.asList((gson.fromJson(json, Squadra[].class))));
				System.out.println(res);
				break;
			case "/aggiungi/giocatori" : 
				res += daoA.addGiocatori(Arrays.asList((gson.fromJson(json, Giocatore[].class))));
				System.out.println(res);
				break;
			case "/aggiungi/partite"  :
				res += daoA.addPartite(Arrays.asList((gson.fromJson(json, Partita[].class))));
				System.out.println(res);
				break;
			case "/aggiungi/gols":
				res += daoA.addGols(Arrays.asList((gson.fromJson(json, Gol[].class))));
				System.out.println(res);
				break;
			case "/aggiungi/competizionisquadre" : 
				res += daoA.addCompetizioniSquadre(Arrays.asList((gson.fromJson(json, Competizione[].class))));
				System.out.println(res);
				break;
			case "/aggiungi/contratti" :
				res += daoA.addContratti(Arrays.asList(gson.fromJson(json, Contratto[].class)));
				System.out.println(res);
				break;
			default :
				response.getWriter().append("404 - non c'è niente qui!!");

			}
			System.out.println(res);
			response.getWriter().append(res);
			
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String res ="non c'è nulla qui!";
		String path = request.getPathInfo();
		String json = getBody(request);
		json = json.substring(1, json.length()-1).replaceAll("\\\\\\\"", "\"").replaceAll("\\\\n", "");
		System.out.println(json);
		
		switch(path) {
		case "/modifica/giocatori" :
		res = daoM.modificaGiocatore(gson.fromJson(json, Giocatore.class));
		break;
		case "/modifica/partite" :
		res = daoM.modificaPartita(gson.fromJson(json, Partita.class));
		break;
		case "/modifica/squadre" :
		res = daoM.modificaSquadra(gson.fromJson(json, Squadra.class));
		break;
		}
		response.getWriter().append(res);
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