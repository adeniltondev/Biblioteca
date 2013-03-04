/*
 * Classe que gerencia conexão com o banco de dados
 */
package br.com.biblioteca.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

    
/**
 *
 * @author Régis
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static {
        try {
            
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
        } catch (Exception error) {
            throw new ExceptionInInitializerError("Erro ao tentar inicializar Session Factory" + error);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}