package com.school.action.act;

import com.school.action.BaseAction;
import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Act;
import com.school.persistence.manager.ActManager;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by nkurtushin on 27.05.16.
 */
public class RemoveActAction extends BaseAction{
    private Long actId;

    @Action(value = "removeact", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = {
                    "actionName", "showact", "namespace", "/"
            })
    })
    @Override
    public String execute() throws Exception {
        if(actId != null) {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    Act act = ActManager.getInstance().findById(actId);
                    if(act != null) {
                        ActManager.getInstance().delete(act);
                    }
                }
            });
        }
        return SUCCESS;
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }
}
