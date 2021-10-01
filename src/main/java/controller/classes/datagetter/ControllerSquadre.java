package controller.classes.datagetter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.classes.DaoSquadre;
import dao.interfaces.IDaoSquadre;
import controller.interfaces.IServletUtils;
/**
 * Servlet implementation class Squadre
 */
@WebServlet({"/squadre" , "/squadre/*"})
public class ControllerSquadre extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private IDaoSquadre dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSquadre() {
        super();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String dbAddress = "jdbc:mysql://localhost:3306/JAMI36?useSSL=false&user=jami36&password=babacchio36";
        dao = new DaoSquadre(dbAddress);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		response.setContentType("application/json");
		if(pathInfo!= null && !IServletUtils.isNumeric(pathInfo.substring(1))) {
				response.getWriter().append(dao.squadra(pathInfo.substring(1)) );
		}else {
			response.getWriter().append(dao.squadre(IServletUtils.getIdFromUrl(request)));
		}
	}



}
