/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.biblioteca.utils;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 * @author Régis
 */
public class PhaseListenerUtil implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } finally {
                session.close();
            }
        }
    }
    
    @Override
    public void beforePhase(PhaseEvent fase) {
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
        }
    }
    
    //Autoruza o Phase para qualquer fase da aplicação
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
