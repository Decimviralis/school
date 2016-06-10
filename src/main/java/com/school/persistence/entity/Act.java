package com.school.persistence.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Максим on 17.05.2016.
 */
@Entity
@Table(name = "act")
@NamedQueries(value = {
        @NamedQuery(name = "Act.all", query = "from Act")
})
public class Act extends BaseEntity {
    @Column(name = "description")
    private String description;

    @Column(name = "adoption_date")
    private Date adoptionDate;

    private Double cost;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(Date adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    @Override
    public String toString() {
        return "Act{" +
                "description='" + description + '\'' +
                ", adoptionDate=" + adoptionDate +
                ", cost=" + cost +
                '}';
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
