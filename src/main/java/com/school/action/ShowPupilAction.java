package com.school.action;

import com.opensymphony.xwork2.Preparable;
import com.school.HibernateUtils;
import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Pupil;
import com.school.persistence.manager.PupilManager;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nkurtushin on 18.05.16.
 */
@Namespace("/")
@ParentPackage("action")
public class ShowPupilAction extends BaseAction implements Preparable {
    private List<Pupil> pupils = new ArrayList<>();
    private Long chosenId;
    private Pupil chosen;

    @Action(value = "showpupil", results = {
            @Result(name = SUCCESS, type = "tiles", location = "pupil")
    })
    @Override
    public String execute() throws Exception {
        if(chosenId != null) {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    chosen = PupilManager.getInstance().findById(chosenId);
                }
            });
        }
        return SUCCESS;
    }

    @Override
    public void prepare() throws Exception {
        try {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    pupils = PupilManager.getInstance().getAllPupils();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(List<Pupil> pupils) {
        this.pupils = pupils;
    }

    public Pupil getChosen() {
        return chosen;
    }

    public void setChosen(Pupil chosen) {
        this.chosen = chosen;
    }

    public void setChosenId(Long chosenId) {
        this.chosenId = chosenId;
    }

    public Long getChosenId() {
        return chosenId;
    }
}
