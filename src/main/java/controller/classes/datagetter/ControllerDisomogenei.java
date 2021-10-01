package controller.classes.datagetter;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.classes.DaoAltre;
import dao.interfaces.IDaoAltre;
import controller.interfaces.IServletUtils;
/**
 * Servlet implementation class Altre
 */
@WebServlet({
	"/competizioni",
	"/giocatori/*",
	"/gols/partita/*",
	"/giocatori/partita/*",
	"/giocatori/squadra/*"
})
public class ControllerDisomogenei extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDaoAltre dao;
	private Gson gson;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerDisomogenei() {
		super();
		try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String dbAddress = "jdbc:mysql://localhost:3306/JAMI36?useSSL=false&user=jami36&password=babacchio36";
        dao = new DaoAltre(dbAddress);
        gson = new Gson();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		boolean isRequestPathNull = request.getPathInfo()==null || request.getPathInfo().equals("");
		response.setContentType("application/json");
		if (isRequestPathNull) {
			switch(request.getServletPath()) {
			case "/competizioni" :
				response.getWriter().append(dao.campionati());
				break;

			}
		}else {
			switch(request.getServletPath()) {

			case "/gols/partita" : {
				int id = IServletUtils.getIdFromUrl(request);
				response.getWriter().append(dao.gols(id));
				break;
			}
			case "/giocatori/partita" : {
				int id = IServletUtils.getIdFromUrl(request);
				response.getWriter().append(dao.giocatoriPartita(id));
				break;
			}
			case "/giocatori/squadra" : {
				response.getWriter().append(dao.giocatoriSquadra(pathInfo.substring(1)));
				break;
			}
			case "/giocatori" : {
				int id = IServletUtils.getIdFromUrl(request);
				response.getWriter().append(dao.giocatore(id));
				break;
			}
			}
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String msg = "{ \"msg\" : \"[MSG]\" }";
		
		String body = getBody(request);
		
		if (body.equals("")) {
			msg = msg.replace("[MSG]", "Non ci sono dati, non posso aggiungere nulla");
		} else {
			//Persona p = gson.fromJson(body, Persona.class);
			msg = msg.replace("[MSG]", "OK");
		}
		
		response.setContentType("application/json");
		response.getWriter().append(msg);
		
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
