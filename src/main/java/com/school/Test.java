package com.school;

import com.school.persistence.entity.Receipt;
import org.hibernate.Session;

/**
 * Created by Максим on 17.05.2016.
 */
public class Test {
    public static void main(String[] args) {
        try {
            HibernateUtils.getInstance().init();
            HibernateUtils.getInstance().beginTransaction();
//            Accountant acc = new Accountant();
//            acc.setName("Ангелина");
//            acc.setSurname("ываыва");
//            acc.setPhone("434234234");
//            acc.setSalary(12500.55);
//            HibernateUtils.getInstance().getCurrentSession().save(acc);
//            Accountant acc = HibernateUtils.getInstance().getCurrentSession()
//                    .get(Accountant.class, 1L);
            Session session = HibernateUtils.getInstance().getCurrentSession();
            Receipt rec = session.get(Receipt.class, 1L);
            System.out.println(rec);
            HibernateUtils.getInstance().commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                HibernateUtils.getInstance().shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
