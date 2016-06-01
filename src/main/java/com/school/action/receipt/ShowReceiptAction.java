package com.school.action.receipt;

import com.school.action.BaseAction;
import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Receipt;
import com.school.persistence.manager.ReceiptManager;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import java.util.List;

/**
 * Created by nkurtushin on 01.06.16.
 */
public class ShowReceiptAction extends BaseAction {
    private List<Receipt> receipts;

    @Action(value = "showreceipt", results = {
            @Result(name = SUCCESS, type = "tiles", location = "receipt")
    })
    @Override
    public String execute() throws Exception {
        try {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    receipts = ReceiptManager.getInstance().getAllReceipts();
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public List<Receipt> getReceipts() {
        return receipts;
    }

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }
}
