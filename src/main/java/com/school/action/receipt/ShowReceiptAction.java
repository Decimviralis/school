package com.school.action.receipt;

import com.school.action.BaseAction;
import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Act;
import com.school.persistence.entity.Pupil;
import com.school.persistence.entity.Receipt;
import com.school.persistence.manager.ReceiptManager;
import com.school.util.PaymentEntry;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nkurtushin on 01.06.16.
 */
public class ShowReceiptAction extends BaseAction {

    private Map<PaymentEntry, List<Receipt>> receipts = new HashMap<>();
    @Action(value = "showreceipt", results = {
            @Result(name = SUCCESS, type = "tiles", location = "receipt")
    })
    @Override
    public String execute() throws Exception {
        try {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    ReceiptManager.getInstance().getAllReceipts().forEach(receipt -> {
                        LocalDate date = receipt.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        PaymentEntry entry = new PaymentEntry(receipt.getPupil(), receipt.getAct(), date.getMonth());
                        List<Receipt> recs = receipts.get(entry);
                        if(recs == null) {
                            recs = new ArrayList<Receipt>();
                            receipts.put(entry, recs);
                        }
                        recs.add(receipt);
                    });
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public Map<PaymentEntry, List<Receipt>> getReceipts() {
        return receipts;
    }

    public void setReceipts(Map<PaymentEntry, List<Receipt>> receipts) {
        this.receipts = receipts;
    }

    public boolean isClosed(Act act, List<Receipt> receipts) {
        return receipts.stream().mapToDouble(Receipt::getSum).sum() > act.getCost();
    }

    public double getPaid(List<Receipt> receipts) {
        System.out.println("getpaid called" + receipts);
        return receipts.stream()
                .mapToDouble(Receipt::getSum)
                .sum();
    }
}
