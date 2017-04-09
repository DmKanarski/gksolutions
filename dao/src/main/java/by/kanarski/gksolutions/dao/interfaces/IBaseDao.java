package by.kanarski.gksolutions.dao.interfaces;

import java.io.Serializable;

/**
 * Main dao interface. Represents base methods to database access
 * @author Dzmitry Kanarski
 * @version 1.0
 * @param <T> this is any of represented dao implementations
 */

public interface IBaseDao<T> {

    /**
     * Appends entity in the database
     * @param t entity to be appended to database
     */
    void add(T t);

    /**
     * Recives entity from databse by id
     * @param id the entity id
     * @return entity with the corresponding id
     */
    T getById(Serializable id);

    /**
     * Updates entity in database
     * @param t entity to be update
     */
    void update(T t);

    /**
     * Deletes entity in database
     * @param t entity to be delete
     */
    void delete(T t);

    void setEntityClass(Class<T> entityClass);

}
