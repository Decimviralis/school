package com.school.util;

import com.school.persistence.entity.Act;
import com.school.persistence.entity.Pupil;

import java.time.Month;

/**
 * Created by nkurtushin on 10.06.16.
 */
public class PaymentEntry {
    private Pupil pupil;
    private Act act;
    private Month month;

    public PaymentEntry(Pupil pupil, Act act, Month month) {
        this.pupil = pupil;
        this.act = act;
        this.month = month;
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

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentEntry that = (PaymentEntry) o;

        if (pupil != null ? !pupil.equals(that.pupil) : that.pupil != null) return false;
        if (act != null ? !act.equals(that.act) : that.act != null) return false;
        return month == that.month;

    }

    @Override
    public int hashCode() {
        int result = pupil != null ? pupil.hashCode() : 0;
        result = 31 * result + (act != null ? act.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        return result;
    }
}
