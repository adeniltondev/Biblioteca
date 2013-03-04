/*
 * Classe que implementa os metodos do CRUD
 */
package br.com.biblioteca.dao;

import br.com.biblioteca.exception.ExceptionHandler;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Régis
 */
public class GenericDao<T> implements IDao<T>, Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Class<T> classe;
    private Session session;

    public GenericDao(Class<T> classe, Session session) {
        this.classe = classe;
        this.session = session;
    }

    @Override
    public void save(T entity) throws ExceptionHandler {
        session.save(entity);
    }

    @Override
    public void update(T entity) throws ExceptionHandler {
        session.update(entity);
    }

    @Override
    public void remove(T entity) throws ExceptionHandler {
        session.delete(entity);
    }

    @Override
    public void merge(T entity) throws ExceptionHandler {
        session.merge(entity);
    }

    @Override
    public T getEntity(Serializable id) {
        T entity = (T) session.get(classe, id);
        return entity;
    }

    @Override
    public T getEntityByDetachedCriteria(DetachedCriteria criteria) {
        T entity = (T) criteria.getExecutableCriteria(session).uniqueResult();
        return entity;
    }

    @Override
    public List<T> getEntities() throws ExceptionHandler {
        return session.createCriteria(classe).list();
    }

    @Override
    public List<T> getListByDetachedCriteria(DetachedCriteria criteria) {
        return criteria.getExecutableCriteria(session).list();
    }

    @Override
    public T getEntityById(Integer id) throws ExceptionHandler {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
