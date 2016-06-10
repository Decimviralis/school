package com.school.persistence.entity;

import javax.persistence.*;

/**
 * Created by Максим on 17.05.2016.
 */
@Entity
@Table(name = "accountant")
@NamedQueries(value = {
        @NamedQuery(name = "Accountant.all", query = "from Accountant ")
})
public class Accountant extends BaseEntity {
    @Column(name = "name", length = 1000)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "phone", unique = true)
    private String phone;

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Accountant{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", phone='" + phone + '\'' +
                '}';
    }
}
