/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.birthcertificate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grantswriter.BaseEntity;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;

@Entity
public class BirthCertificate extends BaseEntity {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`new_born_id`")
    private Person newBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`father_id`")
    private Person father;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`mother_id`")
    private Person mother;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`informant_id`")
    private Person informant;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`when_born`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String whenBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`where_born_id`")
    private Place whereBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_where_born`")
    private String untrackedWhereBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`when_registered`")
    private String whenRegistered;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`where_registered`")
    private String whereRegistered;


    public Person getNewBorn() {
        return newBorn;
    }

    public void setNewBorn(Person newBorn) {
        this.newBorn = newBorn;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getInformant() {
        return informant;
    }

    public void setInformant(Person informant) {
        this.informant = informant;
    }

    public String getWhenBorn() {
        return whenBorn;
    }


    public Place getWhereBorn() {
        return whereBorn;
    }

    public String getUntrackedWhereBorn() {
        return untrackedWhereBorn;
    }

    public String getWhenRegistered() {
        return whenRegistered;
    }

    public String getWhereRegistered() {
        return whereRegistered;
    }
}
