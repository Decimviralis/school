package com.school.persistence.manager;

import com.school.persistence.entity.Act;

import java.util.List;

/**
 * Created by nkurtushin on 18.05.16.
 */
public class ActManager extends BaseManager<Act> {
    private static ActManager instance = new ActManager();
    private ActManager() {

    }

    public static ActManager getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    public List<Act> getAllActs() {
        return getSession().getNamedQuery("Act.all").list();
    }

    @Override
    public Act findById(Long id) {
        return getSession().get(Act.class, id);
    }
}
