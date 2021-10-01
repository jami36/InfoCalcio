package controller.interfaces;

import javax.servlet.http.HttpServletRequest;

public interface IServletUtils {

	public static int getIdFromUrl(HttpServletRequest request) {
		String path = request.getPathInfo();
		if(isNumeric(path.substring(1))) {
		return Integer.parseInt(path.substring(1));
		}
		else {
			return -1;
		}
	}
	
	public static boolean isNumeric(String stringa) {
		try {
			Integer.parseInt(stringa);
		}catch(Exception e) {
			return false;
		}
		return true;
	}
}
