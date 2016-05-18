package com.school.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Максим on 17.05.2016.
 */
@Entity
@Table(name = "act")
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
