package com.school.persistence.manager;

import com.school.HibernateUtils;
import org.hibernate.Session;

/**
 * Created by nkurtushin on 18.05.16.
 */
public abstract class BaseManager<T> {
    public Session getSession() {
        return HibernateUtils.getInstance().getCurrentSession();
    }

    public Long persist(T entity) {
        return (Long) getSession().save(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public abstract T findById(Long id);

}