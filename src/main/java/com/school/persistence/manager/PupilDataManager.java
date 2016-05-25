package com.school.persistence.manager;

import com.school.persistence.entity.PupilData;

/**
 * Created by nkurtushin on 18.05.16.
 */
public class PupilDataManager extends BaseManager<PupilData> {
    private static PupilDataManager instance = new PupilDataManager();
    private PupilDataManager() {

    }

    public static PupilDataManager getInstance() {
        return instance;
    }

    @Override
    public PupilData findById(Long id) {
        return getSession().get(PupilData.class, id);
    }
}
