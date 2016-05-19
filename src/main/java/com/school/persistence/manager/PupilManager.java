package com.school.persistence.manager;

import com.school.persistence.entity.Pupil;

import java.util.List;

/**
 * Created by nkurtushin on 18.05.16.
 */
public class PupilManager extends BaseManager<Pupil> {
    private static PupilManager instance = new PupilManager();

    public static PupilManager getInstance() {
        return instance;
    }

    private PupilManager() {

    }

    @Override
    public Pupil findById(Long id) {
        return getSession().get(Pupil.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Pupil> getAllPupils() {
        return getSession().getNamedQuery("Pupil.All").list();
    }
}
