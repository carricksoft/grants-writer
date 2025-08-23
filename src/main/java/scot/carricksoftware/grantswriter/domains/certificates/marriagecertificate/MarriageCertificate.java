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

    @SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
    @ManyToOne
    @JoinColumn(name = "`groom_residence_id`")
    private Place groomUsualResidence;

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

    @SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
    @Column(name = "`untracked_first_witness`")
    private String untrackedFirstWitness;

    @SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
    @Column(name = "`untracked_second_witness`")
    private String untrackedSecondWitness;

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

    @SuppressWarnings("unused")
    public String getWhenMarried() {
        return whenMarried;
    }



    @SuppressWarnings("unused")
    public Place getWhereMarried() {
        return whereMarried;
    }

    @SuppressWarnings("unused")
    public void setWhereMarried(Place whereMarried) {
        this.whereMarried = whereMarried;
    }

    @SuppressWarnings("unused")
    public String getUntrackedWhereMarried() {
        return untrackedWhereMarried;
    }

    @SuppressWarnings("unused")
    public void setUntrackedWhereMarried(String untrackedWhereMarried) {
        this.untrackedWhereMarried = untrackedWhereMarried;
    }



    @SuppressWarnings("unused")
    public Place getBrideUsualResidence() {
        return brideUsualResidence;
    }

    @SuppressWarnings("unused")
    public void setBrideUsualResidence(Place brideUsualResidence) {
        this.brideUsualResidence = brideUsualResidence;
    }

    @SuppressWarnings("unused")
    public String getGroomUntrackedResidence() {
        return groomUntrackedResidence;
    }

    @SuppressWarnings("unused")
    public void setGroomUntrackedResidence(String groomUntrackedResidence) {
        this.groomUntrackedResidence = groomUntrackedResidence;
    }

    @SuppressWarnings("unused")
    public String getBrideUntrackedResidence() {
        return brideUntrackedResidence;
    }

    @SuppressWarnings("unused")
    public void setBrideUntrackedResidence(String brideUntrackedResidence) {
        this.brideUntrackedResidence = brideUntrackedResidence;
    }


    @SuppressWarnings("unused")
    public Person getFirstWitness() {
        return firstWitness;
    }

    @SuppressWarnings("unused")
    public void setFirstWitness(Person firstWitness) {
        this.firstWitness = firstWitness;
    }

    @SuppressWarnings("unused")
    public Person getSecondWitness() {
        return secondWitness;
    }

    @SuppressWarnings("unused")
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
