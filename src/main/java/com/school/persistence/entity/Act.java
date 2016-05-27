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
    @Column(name = "Description")
    private String description;
    @Column(name = "Adoption_date")
    private Date adoptionDate;

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
                '}';
    }
}
