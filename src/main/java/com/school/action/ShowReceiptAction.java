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
public class ShowReceiptAction extends BaseAction {
    @Action(value = "showreceipt", results = {
            @Result(name = SUCCESS, type = "tiles", location = "receipt")
    })
    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
