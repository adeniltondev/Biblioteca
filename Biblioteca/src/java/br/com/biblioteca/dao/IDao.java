/*
 * Interface contendo métodos para conexão com o banco de dados
 */
package br.com.biblioteca.dao;

import br.com.biblioteca.exception.ExceptionHandler;
import java.io.Serializable;
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;

/**
 *
 * @author Régis
 */
public interface IDao<T> {
    
    public void save(T entity) throws ExceptionHandler;
    public void update(T entity) throws ExceptionHandler;
    public void remove(T entity) throws ExceptionHandler;
    public void merge(T entity) throws ExceptionHandler;
    public T getEntity(Serializable id);
    public T getEntityByDetachedCriteria(DetachedCriteria criteria);
    public List<T> getEntities() throws ExceptionHandler;
    public List<T> getListByDetachedCriteria(DetachedCriteria criteria);
    public T getEntityById(Integer id) throws ExceptionHandler;
}
