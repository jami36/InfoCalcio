package controller.classes.sicurezza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class AccessManager {

	private static AdminUser adminuser;

	public AccessManager(String username, String password,HttpSession htps) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/JAMI36?useSSL=false&user=jami36&password=babacchio36");){
			PreparedStatement preSt = c.prepareStatement("SELECT *  FROM admin WHERE uname = ? ");
		    preSt.setString(1, username);
		    ResultSet rs = preSt.executeQuery();
		    rs.next();
		    adminuser = rs.getString("passwd").equals(password) ? new AdminUser(htps) : null;
		}catch (SQLException e ) {
			adminuser = null;
			e.printStackTrace();
		}catch (Exception e ) {
			adminuser = null;
			e.printStackTrace();
		}
	}
	public boolean checkLog() {
		if (adminuser != null)
		return adminuser.getRisultato();
		
		return false;
	}
	public boolean setSession(HttpSession session) {
		return adminuser.setSession(session);
	}
	public static boolean isAdmin(HttpServletRequest request) {
		return adminuser != null && adminuser.getSession( request) ;
	}
	public static boolean isAdminLogged() {
		return adminuser != null ;
	}
	public void logout() {
		adminuser = null;
	}
}
