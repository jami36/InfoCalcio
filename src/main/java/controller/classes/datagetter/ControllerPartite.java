package controller.classes.datagetter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.interfaces.IServletUtils;
import dao.classes.DaoPartite;
import dao.interfaces.IDaoPartite;
/**
 * Servlet implementation class Partite
 */
@WebServlet({
	"/partite",
	"/partite/*", 
	"/partita/*"
	})
public class ControllerPartite extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	IDaoPartite dao;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPartite() {
        super();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String dbAddress = "jdbc:mysql://localhost:3306/JAMI36?useSSL=false&user=jami36&password=babacchio36";
        dao = new DaoPartite(dbAddress);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		response.setContentType("application/json");
		if(pathInfo== null || pathInfo.equals("")) {
			response.getWriter().append(dao.partite());
		}else {
			if(request.getServletPath().equals("/partita")) {
				response.getWriter().append(dao.partita(IServletUtils.getIdFromUrl(request)));
			}else if(request.getServletPath().equals("/partite")) {
				response.getWriter().append(
						IServletUtils.isNumeric(pathInfo.substring(1)) ? dao.partiteCompetizione(IServletUtils.getIdFromUrl(request)) : 
															dao.partiteSquadra(pathInfo.substring(1)));
			}
		}
	}


}
