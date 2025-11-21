/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grantswriter.domains.certificates.BaseCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;


@Entity
@Table(name="`marriage_certificate`")
public class MarriageCertificate extends BaseCertificate {

    @ManyToOne
    @JoinColumn(name = "`bride_id`")
    private Person bride;

    @ManyToOne
    @JoinColumn(name = "`groom_id`")
    private Person groom;

    @Column(name = "`when_married`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String whenMarried;

    @ManyToOne
    @JoinColumn(name = "`where_married_id`")
    private Place whereMarried;

    @Column(name = "`untracked_where_married`")
    private String untrackedWhereMarried;


    @ManyToOne
    @JoinColumn(name = "`bride_residence_id`")
    private Place brideUsualResidence;

    @Column(name = "`groom_untracked_residence`")
    private String groomUntrackedResidence;

    @Column(name = "`bride_untracked_residence`")
    private String brideUntrackedResidence;


    @ManyToOne
    @JoinColumn(name = "`first_witness`")
    private Person firstWitness;

    @ManyToOne
    @JoinColumn(name = "`second_witness`")
    private Person secondWitness;



    @Column(name = "`groom_rank`")
    private String groomRank;

    @Column(name = "`bride_rank`")
    private String brideRank;

    public Person getBride() {
        return bride;
    }

    public void setBride(Person bride) {
        this.bride = bride;
    }

    public Person getGroom() {
        return groom;
    }

    public void setGroom(Person groom) {
        this.groom = groom;
    }

    public String getWhenMarried() {
        return whenMarried;
    }

    public Place getWhereMarried() {
        return whereMarried;
    }

    public void setWhereMarried(Place whereMarried) {
        this.whereMarried = whereMarried;
    }

    public String getUntrackedWhereMarried() {
        return untrackedWhereMarried;
    }

    public void setUntrackedWhereMarried(String untrackedWhereMarried) {
        this.untrackedWhereMarried = untrackedWhereMarried;
    }

    public Place getBrideUsualResidence() {
        return brideUsualResidence;
    }

    public void setBrideUsualResidence(Place brideUsualResidence) {
        this.brideUsualResidence = brideUsualResidence;
    }

    public String getGroomUntrackedResidence() {
        return groomUntrackedResidence;
    }

    public void setGroomUntrackedResidence(String groomUntrackedResidence) {
        this.groomUntrackedResidence = groomUntrackedResidence;
    }

    public String getBrideUntrackedResidence() {
        return brideUntrackedResidence;
    }

    public void setBrideUntrackedResidence(String brideUntrackedResidence) {
        this.brideUntrackedResidence = brideUntrackedResidence;
    }

    public Person getFirstWitness() {
        return firstWitness;
    }

    public void setFirstWitness(Person firstWitness) {
        this.firstWitness = firstWitness;
    }

    public Person getSecondWitness() {
        return secondWitness;
    }

    public void setSecondWitness(Person secondWitness) {
        this.secondWitness = secondWitness;
    }

    public void setWhenMarried(String whenMarried) {
        this.whenMarried = whenMarried;
    }

    public String getGroomRank() {
        return groomRank;
    }

    public void setGroomRank(String groomRank) {
        this.groomRank = groomRank;
    }

    public String getBrideRank() {
        return brideRank;
    }

    public void setBrideRank(String brideRank) {
        this.brideRank = brideRank;
    }

}
