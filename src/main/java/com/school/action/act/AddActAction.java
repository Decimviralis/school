package com.school.action.act;

import com.school.action.BaseAction;
import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Act;
import com.school.persistence.manager.ActManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.text.ParseException;

/**
 * Created by nkurtushin on 27.05.16.
 */
@ParentPackage("action")
@Namespace("/")
public class AddActAction extends BaseAction {
    private Act act = new Act();
    private String date;
    private String description;
    private Double cost;

    @Action(value = "addact", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = {
                    "actionName", "showact", "namespace", "/"
            }),
            @Result(name = INPUT, type = "tiles", location = "addAct")
    })
    @Override
    public String execute() throws Exception {
        try {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    act.setDescription(description);
                    act.setCost(cost);
                    try {
                        act.setAdoptionDate(DateUtils.parseDate(date, "dd-MM-yyyy"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    ActManager.getInstance().persist(act);
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
            addActionError("internal error");
        }
        return SUCCESS;
    }

    @Override
    public void validate() {
        if(StringUtils.isEmpty(description)) {
            addActionError("empty description");
        }
        if(StringUtils.isEmpty(date)) {
            addActionError("empty date");
        }
        if(cost == null) {
            addActionError("empty cost");
        }
        try {
            DateUtils.parseDate(date, "dd-MM-yyyy");
        }catch (Exception e) {
            addActionError("wrong date format");
        }
    }

    @Action(value = "addact_input", results = {
            @Result(name = INPUT, type = "tiles", location = "addAct")
    })
    @Override
    public String input() throws Exception {
        return super.input();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
