package com.school.action.accountant;

import com.opensymphony.xwork2.Preparable;
import com.school.action.BaseAction;
import com.school.action.pupil.ShowPupilAction;
import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Accountant;
import com.school.persistence.manager.AccountantManager;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

/**
 * Created by nkurtushin on 18.05.16.
 */
@Namespace("/")
@ParentPackage("action")
public class ShowAccountantAction extends BaseAction implements Preparable{
    private List<Accountant> accountants;
    private Long chosenId;
    private Accountant chosen;

    @Action(value = "showaccountant", results = {
            @Result(name = SUCCESS, type = "tiles", location = "accountant")
    })
    @Override
    public String execute() throws Exception {
        if(chosenId != null && !chosenId.equals(ALL_ID)) {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    chosen = AccountantManager.getInstance().findById(chosenId);
                }
            });
        }
        return SUCCESS;
    }

    public List<Accountant> getAccountants() {
        return accountants;
    }

    public void setAccountants(List<Accountant> accountants) {
        this.accountants = accountants;
    }

    public Long getChosenId() {
        return chosenId;
    }

    public void setChosenId(Long chosenId) {
        this.chosenId = chosenId;
    }

    @Override
    public void prepare() throws Exception {
        try {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    accountants = AccountantManager.getInstance().getAllAccountants();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Accountant getChosen() {
        return chosen;
    }

    public void setChosen(Accountant chosen) {
        this.chosen = chosen;
    }
}
