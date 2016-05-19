package com.school.persistence.entity;

import javax.persistence.*;

/**
 * Created by Максим on 17.05.2016.
 */
@Entity
@Table(name = "pupil")
@NamedQueries(value = {
        @NamedQuery(name = "Pupil.All", query = "from Pupil ")
})
public class Pupil extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone_number")
    private String phone;

    @OneToOne
    @JoinColumn(name = "pupil_data")
    private PupilData pupilData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PupilData getPupilData() {
        return pupilData;
    }

    public void setPupilData(PupilData pupilData) {
        this.pupilData = pupilData;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", pupilData=" + pupilData +
                '}';
    }
}
