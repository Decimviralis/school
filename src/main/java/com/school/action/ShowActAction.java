package com.school.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by nkurtushin on 18.05.16.
 */
@Namespace("/")
@ParentPackage("action")
public class ShowActAction extends BaseAction {

    @Action(value = "showact", results = {
            @Result(name = SUCCESS, type = "tiles", location = "act")
    })
    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
