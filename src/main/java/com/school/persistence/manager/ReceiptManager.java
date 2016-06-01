package com.school.persistence.manager;

import com.school.persistence.entity.Receipt;

import java.util.List;

/**
 * Created by nkurtushin on 18.05.16.
 */
public class ReceiptManager extends BaseManager<Receipt> {
    private static ReceiptManager instance = new ReceiptManager();

    private ReceiptManager() {

    }

    public static ReceiptManager getInstance() {
        return instance;
    }

    @Override
    public Receipt findById(Long id) {
        return getSession().get(Receipt.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Receipt> getAllReceipts() {
        return getSession().getNamedQuery("Receipt.All").list();
    }
}
