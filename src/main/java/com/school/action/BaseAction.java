package com.school.action;

import com.opensymphony.xwork2.ActionSupport;
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

    @Action(value = "enter", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = {
                    "actionName", "showpupil"
            })
    })
    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
}
