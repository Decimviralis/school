package com.school.persistence.manager;

import com.school.persistence.entity.Accountant;

import java.util.List;

/**
 * Created by nkurtushin on 18.05.16.
 */
public class AccountantManager extends BaseManager<Accountant>{
    private static AccountantManager instance = new AccountantManager();

    private AccountantManager() {

    }

    public static AccountantManager getInstance() {
        return instance;
    }

    @SuppressWarnings("unchecked")
    public List<Accountant> getAllAccountants() {
        return getSession().getNamedQuery("Accountant.all").list();
    }

    @Override
    public Accountant findById(Long id) {
        return getSession().get(Accountant.class, id);
    }
}
