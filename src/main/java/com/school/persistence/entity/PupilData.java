package com.school.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Максим on 17.05.2016.
 */
@Entity
@Table(name = "modifiable_pupil_data")
public class PupilData extends BaseEntity {
    @Column(name = "Age")
    private Integer age;

    @Column(name = "Grade")
    private String grade;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "PupilData{" +
                "age=" + age +
                ", grade='" + grade + '\'' +
                '}';
    }
}
