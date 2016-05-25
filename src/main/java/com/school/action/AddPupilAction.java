package com.school.action;

import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Pupil;
import com.school.persistence.entity.PupilData;
import com.school.persistence.manager.PupilDataManager;
import com.school.persistence.manager.PupilManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by nkurtushin on 25.05.16.
 */
@Namespace("/")
@ParentPackage("action")
public class AddPupilAction extends BaseAction{
    private PupilData data = new PupilData();
    private Pupil pupil = new Pupil();


    @Action(value = "addpupil", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = {
                    "actionName", "showpupil", "namespace", "/"
            }),
            @Result(name = INPUT, type="tiles", location = "addPupil")
    })
    @Override
    public String execute() throws Exception {
        executeDatabaseRequest(new IDatabaseRequest() {
            @Override
            public void execute() {
                PupilDataManager.getInstance().persist(data);
                pupil.setPupilData(data);
                PupilManager.getInstance().persist(pupil);
            }
        });
        return SUCCESS;
    }

    @Action(value = "addpupil_input", results = {
            @Result(name = INPUT, type="tiles", location = "addPupil")
    })
    @Override
    public String input() throws Exception {
        return super.input();
    }

    @Override
    public void validate() {
        if (data.getAge() == null) {
            addActionError("Empty age");
        }
        if(StringUtils.isEmpty(data.getGrade())) {
            addActionError("Empty grade");
        }
        if(StringUtils.isEmpty(pupil.getName())) {
            addActionError("Empty name");
        }
        if(StringUtils.isEmpty(pupil.getSurname())) {
            addActionError("Empty surname");
        }
        if(StringUtils.isEmpty(pupil.getPhone())) {
            addActionError("Empty phone");
        }
    }

    public PupilData getData() {
        return data;
    }

    public void setData(PupilData data) {
        this.data = data;
    }

    public Pupil getPupil() {
        return pupil;
    }

    public void setPupil(Pupil pupil) {
        this.pupil = pupil;
    }
}
