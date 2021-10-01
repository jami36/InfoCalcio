package controller.classes.sicurezza;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AdminUser {
    private HttpSession htps;
    private final boolean risultato;
    AdminUser(HttpSession htps){

        this.risultato = true;
        this.htps = htps;
    }
    boolean getSession(HttpServletRequest request) {
        return htps != null && request.getSession().equals(htps);
    }
    boolean setSession(HttpSession session) {
        if (risultato) this.htps = session;
        return risultato;
    }
    public boolean getRisultato() {
        return risultato;
    }

}