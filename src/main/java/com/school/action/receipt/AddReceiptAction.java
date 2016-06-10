package com.school.action.receipt;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.school.action.BaseAction;
import com.school.persistence.IDatabaseRequest;
import com.school.persistence.entity.Accountant;
import com.school.persistence.entity.Act;
import com.school.persistence.entity.Pupil;
import com.school.persistence.entity.Receipt;
import com.school.persistence.manager.AccountantManager;
import com.school.persistence.manager.ActManager;
import com.school.persistence.manager.PupilManager;
import com.school.persistence.manager.ReceiptManager;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import java.text.ParseException;
import java.util.List;

/**
 * Created by nkurtushin on 01.06.16.
 */
public class AddReceiptAction extends BaseAction implements Preparable{
    private List<Accountant> accountants;
    private List<Pupil> pupils;
    private List<Act> acts;
    private Long accountantId;
    private Long actId;
    private Long pupilId;
    private String description;
    private String date;
    private Double sum;

    public AddReceiptAction() {
    }

    @Action(value = "addreceipt", results = {
            @Result(name = SUCCESS, type = "redirectAction", params = {
                    "actionName", "showreceipt", "namespace", "/"
            }),
            @Result(name = INPUT,  type = "tiles", location = "addReceipt")
    })
    @Override
    public String execute() throws Exception {
        try {
            executeDatabaseRequest(new IDatabaseRequest() {
                @Override
                public void execute() {
                    Receipt receipt = new Receipt();
                    receipt.setDescription(description);
                    receipt.setAccountant(AccountantManager.getInstance().findById(accountantId));
                    receipt.setAct(ActManager.getInstance().findById(actId));
                    receipt.setPupil(PupilManager.getInstance().findById(pupilId));
                    try {
                        receipt.setDate(DateUtils.parseDate(date, "dd-MM-yyyy"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    receipt.setSum(sum);
                    ReceiptManager.getInstance().persist(receipt);
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
            addActionError("internal error");
        }
        return SUCCESS;
    }

    @Action(value = "addreceipt_input", results = {
            @Result(name = INPUT,  type = "tiles", location = "addReceipt")
    })
    @Override
    public String input() throws Exception {
        return INPUT;
    }

    @Override
    public void validate() {
        if(accountantId == null) {
            addActionError("empty accountant");
        }
        if(actId == null) {
            addActionError("empty act");
        }
        if(pupilId == null) {
            addActionError("empty pupil");
        }
        if(sum == null) {
            addActionError("empty sum");
        }
        if(StringUtils.isEmpty(description)) {
            addActionError("empty description");
        }
        try {
            DateUtils.parseDate(date, "dd-MM-yyyy");
        } catch (ParseException e) {
            addActionError("wrong date format");
        }

    }

    public Long getAccountantId() {
        return accountantId;
    }

    public void setAccountantId(Long accountantId) {
        this.accountantId = accountantId;
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public Long getPupilId() {
        return pupilId;
    }

    public void setPupilId(Long pupilId) {
        this.pupilId = pupilId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Accountant> getAccountants() {
        return accountants;
    }

    public void setAccountants(List<Accountant> accountants) {
        this.accountants = accountants;
    }

    public List<Pupil> getPupils() {
        return pupils;
    }

    public void setPupils(List<Pupil> pupils) {
        this.pupils = pupils;
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
                    pupils = PupilManager.getInstance().getAllPupils();
                    acts = ActManager.getInstance().getAllActs();
                    accountants = AccountantManager.getInstance().getAllAccountants();
                }
            });
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
