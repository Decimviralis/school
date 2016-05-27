package com.school.action.act;

import com.opensymphony.xwork2.Preparable;
import com.school.action.BaseAction;
import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Act;
import com.school.persistence.manager.ActManager;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

/**
 * Created by nkurtushin on 18.05.16.
 */
@Namespace("/")
@ParentPackage("action")
public class ShowActAction extends BaseAction implements Preparable{
    private Act chosen;
    private Long chosenId;
    private List<Act> acts;

    @Action(value = "showact", results = {
            @Result(name = SUCCESS, type = "tiles", location = "act"),
            @Result(name = INPUT, type = "tiles", location = "act")
    })
    @Override
    public String execute() throws Exception {
        try {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    if (chosenId != null) {
                        if(!chosenId.equals(ALL_ID)) {
                            chosen = ActManager.getInstance().findById(chosenId);
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.execute();
    }

    public Act getChosen() {
        return chosen;
    }

    public void setChosen(Act chosen) {
        this.chosen = chosen;
    }

    public Long getChosenId() {
        return chosenId;
    }

    public void setChosenId(Long chosenId) {
        this.chosenId = chosenId;
    }

    public List<Act> getActs() {
        return acts;
    }

    public void setActs(List<Act> acts) {
        this.acts = acts;
    }

    @Override
    public void prepare() throws Exception {
        try {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    acts = ActManager.getInstance().getAllActs();
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
