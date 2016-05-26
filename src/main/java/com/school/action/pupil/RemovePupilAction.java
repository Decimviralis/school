package com.school.action.pupil;

import com.school.action.BaseAction;
import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Pupil;
import com.school.persistence.manager.PupilManager;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by nkurtushin on 26.05.16.
 */
public class RemovePupilAction extends BaseAction {
    private Long pupilId;

    @Action(value = "removepupil", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = {
                    "actionName", "showpupil", "namespace", "/"
            })
    })
    @Override
    public String execute() throws Exception {
        executeDatabaseRequest(new IDatabaseRequest() {
            @Override
            public void execute() {
                Pupil pupil = PupilManager.getInstance().findById(pupilId);
                if(pupil != null) {
                    PupilManager.getInstance().delete(pupil);
                }
            }
        });
        return SUCCESS;
    }

    public Long getPupilId() {
        return pupilId;
    }

    public void setPupilId(Long pupilId) {
        this.pupilId = pupilId;
    }
}
