package by.kanarski.gksolutions.dao.impl;

import by.kanarski.gksolutions.dao.interfaces.IBaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * @author Dzmitry Kanarski
 * @version 1.0
 */

@Repository
public abstract class BaseDao<T> implements IBaseDao<T> {

    private SessionFactory sessionFactory;

    private Class<T> entityClass;

    @Autowired
    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(T t) {
        getSession().save(t);
    }

    @Override
    public T getById(Serializable id) {
        return (T) getSession().get(getEntityClass(), id);
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public void delete(T t) {
        getSession().delete(t);
    }

    @Override
    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Class<T> getEntityClass() {
        if (entityClass == null) {
            ParameterizedType classType = (ParameterizedType) getClass().getGenericSuperclass();
            entityClass = (Class<T>) classType.getActualTypeArguments()[0];
        }
        return entityClass;
    }
}
