/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.birthcertificate;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.domains.certificates.BaseCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;

@Entity
@Table(name="`birth_certificate`")
public class BirthCertificate extends BaseCertificate {

    @ManyToOne()
    @JoinColumn(name = "`new_born_id`")
    private Person newBorn;

    @ManyToOne()
    @JoinColumn(name = "`father_id`")
    private Person father;

    @Column(name = "`father_rank`")
    private String fatherRank;

    @ManyToOne()
    @JoinColumn(name = "`mother_id`")
    private Person mother;

    @ManyToOne()
    @JoinColumn(name = "`informant_id`")
    private Person informant;

    @Column(name = "`when_born`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String whenBorn;

    @ManyToOne
    @JoinColumn(name = "`where_born_id`")
    private Place whereBorn;

    @Column(name = "`untracked_where_born`")
    private String untrackedWhereBorn;

    @Column(name = "`when_registered`")
    private String whenRegistered;

    @Column(name = "`where_registered`")
    private String whereRegistered;

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

    public void setWhenBorn(String whenBorn) {
        this.whenBorn = whenBorn;
    }

    public void setWhereBorn(Place whereBorn) {
        this.whereBorn = whereBorn;
    }

    public void setUntrackedWhereBorn(String untrackedWhereBorn) {
        this.untrackedWhereBorn = untrackedWhereBorn;
    }

    public void setWhenRegistered(String whenRegistered) {
        this.whenRegistered = whenRegistered;
    }

    public void setWhereRegistered(String whereRegistered) {
        this.whereRegistered = whereRegistered;
    }

    public void setUntrackedInformant(String untrackedInformant) {
        this.untrackedInformant = untrackedInformant;
    }

    public String getFatherRank() {
        return fatherRank;
    }
    
    public void setFatherRank(String fatherRank) {
        this.fatherRank = fatherRank;
    }
}
