package com.school.action.accountant;

import com.school.action.BaseAction;
import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Accountant;
import com.school.persistence.manager.AccountantManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by nkurtushin on 26.05.16.
 */
public class AddAccountantAction extends BaseAction{
    private Accountant accountant = new Accountant();

    @Action(value = "addaccountant", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = {
                    "actionName", "showaccountant", "namespace", "/"
            }),
            @Result(name = INPUT, type = "tiles", location = "addAccountant")
    })
    @Override
    public String execute() throws Exception {
        try {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    AccountantManager.getInstance().persist(accountant);
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
        if(StringUtils.isEmpty(accountant.getName())) {
            addActionError("empty name");
        }
        if(StringUtils.isEmpty(accountant.getSurname())) {
            addActionError("empty surname");
        }
        if(StringUtils.isEmpty(accountant.getPhone())) {
            addActionError("empty phone");
        }
        if(accountant.getSalary() == null) {
            addActionError("empty salary/wrong format");
        }
    }

    @Action(value = "addaccountant_input", results = {
            @Result(name = INPUT, type = "tiles", location = "addAccountant")
    })
    @Override
    public String input() throws Exception {
        return super.input();
    }

    public Accountant getAccountant() {
        return accountant;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }
}
