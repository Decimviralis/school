package com.school.action;

import com.opensymphony.xwork2.ActionSupport;
import com.school.HibernateUtils;
import com.school.persistence.IDatabaseRequest;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by nkurtushin on 18.05.16.
 */
@Namespace("/")
@ParentPackage("action")
public class BaseAction extends ActionSupport {
    public static final Long ALL_ID = -1L;

    @Action(value = "enter", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = {
                    "actionName", "showpupil"
            })
    })
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    protected void executeDatabaseRequest(IDatabaseRequest request) throws Exception{
        try {
            HibernateUtils.getInstance().beginTransaction();
            request.execute();
            HibernateUtils.getInstance().commitTransaction();
        }catch (Exception e) {
            HibernateUtils.getInstance().rollbackTransaction();
            System.err.println("error");
            throw e;
        }
    }
}
