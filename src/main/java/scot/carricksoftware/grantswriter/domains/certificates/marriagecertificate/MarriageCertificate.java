/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.marriagecertificate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grantswriter.domains.certificates.BaseCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;


@Entity
public class MarriageCertificate extends BaseCertificate {

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`bride_id`")
    private Person bride;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`groom_id`")
    private Person groom;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`when_married`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String whenMarried;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`where_married_id`")
    private Place whereMarried;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_where_married`")
    private String untrackedWhereMarried;


    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`bride_residence_id`")
    private Place brideUsualResidence;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`groom_untracked_residence`")
    private String groomUntrackedResidence;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`bride_untracked_residence`")
    private String brideUntrackedResidence;


    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`first_witness`")
    private Person firstWitness;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`second_witness`")
    private Person secondWitness;



    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`groom_rank`")
    private String groomRank;

    @SuppressWarnings("JpaDataSourceORMInspection")
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
