package com.school.persistence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Максим on 17.05.2016.
 */
@Entity
@Table(name = "receipt")
@NamedQueries(value = {
        @NamedQuery(name = "Receipt.All", query = "from Receipt ")
})
public class Receipt extends BaseEntity {
    @Column(name = "description")
    private String description;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "accountant_id")
    private Accountant accountant;

    @ManyToOne
    @JoinColumn(name = "pupil_id")
    private Pupil pupil;

    @ManyToOne
    @JoinColumn(name = "act_id")
    private Act act;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Accountant getAccountant() {
        return accountant;
    }

    public void setAccountant(Accountant accountant) {
        this.accountant = accountant;
    }

    public Pupil getPupil() {
        return pupil;
    }

    public void setPupil(Pupil pupil) {
        this.pupil = pupil;
    }

    public Act getAct() {
        return act;
    }

    public void setAct(Act act) {
        this.act = act;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "description='" + description + '\'' +
                ", sum=" + sum +
                ", date=" + date +
                ", accountant=" + accountant +
                ", pupil=" + pupil +
                ", act=" + act +
                '}';
    }
}
