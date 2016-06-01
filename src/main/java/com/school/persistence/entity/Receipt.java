package com.school.persistence.entity;

import javax.persistence.*;

/**
 * Created by Максим on 17.05.2016.
 */
@Entity
@Table(name = "receipt_of_payment")
@NamedQueries(value = {
        @NamedQuery(name = "Receipt.All", query = "from Receipt ")
})
public class Receipt extends BaseEntity {
    @Column(name = "Receipt_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_booker")
    private Accountant accountant;

    @ManyToOne
    @JoinColumn(name = "pupil_id")
    private Pupil pupil;

    @ManyToOne
    @JoinColumn(name = "statement")
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

    @Override
    public String toString() {
        return "Receipt{" +
                "description='" + description + '\'' +
                ", accountant=" + accountant +
                ", pupil=" + pupil +
                ", act=" + act +
                '}';
    }
}
