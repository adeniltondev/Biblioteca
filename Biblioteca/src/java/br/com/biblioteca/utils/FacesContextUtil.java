/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.utils;

import javax.faces.context.FacesContext;
import org.hibernate.Session;

/**
 *
 * @author Régis
 */
public class FacesContextUtil {
    
    private static final String HIBERNATE_SESSION = "hibernate_util";

    public static Session getRequestSession() {
        return (Session) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(HIBERNATE_SESSION);
    }
    
    public static void setRequestSession(Session session) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(HIBERNATE_SESSION, session);
    }
}
