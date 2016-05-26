package com.school.action.accountant;

import com.school.action.BaseAction;
import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Accountant;
import com.school.persistence.manager.AccountantManager;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by nkurtushin on 26.05.16.
 */
public class RemoveAccountantAction extends BaseAction {
    private Long accountantId;

    @Action(value = "removeaccountant", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = {
                    "actionName", "showaccountant", "namespace", "/"
            })
    })
    @Override
    public String execute() throws Exception {
        if(accountantId != null) {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    Accountant acc = AccountantManager.getInstance().findById(accountantId);
                    if(acc != null) {
                        AccountantManager.getInstance().delete(acc);
                    }
                }
            });
        }
        return SUCCESS;
    }

    public Long getAccountantId() {
        return accountantId;
    }

    public void setAccountantId(Long accountantId) {
        this.accountantId = accountantId;
    }
}
