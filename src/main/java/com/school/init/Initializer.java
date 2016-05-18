package com.school.init;

import com.school.HibernateUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Максим on 17.05.2016.
 */
public class Initializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            HibernateUtils.getInstance().init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            HibernateUtils.getInstance().shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
