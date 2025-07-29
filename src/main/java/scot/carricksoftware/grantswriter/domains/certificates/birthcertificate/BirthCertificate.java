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
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.domains.certificates.BaseCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;

@Entity
public class BirthCertificate extends BaseCertificate {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`new_born_id`")
    private Person newBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`father_id`")
    private Person father;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`father_rank`")
    private String fatherRank;

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

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_informant`")
    private String untrackedInformant;

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

    public String getUntrackedInformant() {
        return untrackedInformant;
    }

    @SuppressWarnings("unused")
    public void setWhenBorn(String whenBorn) {
        this.whenBorn = whenBorn;
    }

    @SuppressWarnings("unused")
    public void setWhereBorn(Place whereBorn) {
        this.whereBorn = whereBorn;
    }

    @SuppressWarnings("unused")
    public void setUntrackedWhereBorn(String untrackedWhereBorn) {
        this.untrackedWhereBorn = untrackedWhereBorn;
    }

    @SuppressWarnings("unused")
    public void setWhenRegistered(String whenRegistered) {
        this.whenRegistered = whenRegistered;
    }

    @SuppressWarnings("unused")
    public void setWhereRegistered(String whereRegistered) {
        this.whereRegistered = whereRegistered;
    }

    @SuppressWarnings("unused")
    public void setUntrackedInformant(String untrackedInformant) {
        this.untrackedInformant = untrackedInformant;
    }

    public String getFatherRank() {
        return fatherRank;
    }

    @SuppressWarnings("unused")
    public void setFatherRank(String fatherRank) {
        this.fatherRank = fatherRank;
    }
}
