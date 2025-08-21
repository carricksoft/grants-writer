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
    @Column(name = "`groom_age`")
    private String groomAge;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`bride_age`")
    private String brideAge;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`groom_condition`")
    private String groomCondition;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`bride_condition`")
    private String brideCondition;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`groom_rank`")
    private String groomRank;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`bride_rank`")
    private String brideRank;

    @SuppressWarnings("JpaDataSourceORMInspection")
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
    @JoinColumn(name = "`groom_father`")
    private Person groomFather;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`bride_father`")
    private Person brideFather;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`groom_untracked_father`")
    private String groomUntrackedFather;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`bride_untracked_father`")
    private String brideUntrackedFather;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`groom_father_rank`")
    private String groomFatherRank;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`bride_father_rank`")
    private String brideFatherRank;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`first_witness`")
    private Person firstWitness;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`second_witness`")
    private Person secondWitness;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_first_witness`")
    private String untrackedFirstWitness;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_second_witness`")
    private String untrackedSecondWitness;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`year_married`")
    private String yearMarried;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`month_married`")
    private String monthMarried;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`day_married`")
    private String dayMarried;

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
    public String getGroomAge() {
        return groomAge;
    }

    @SuppressWarnings("unused")
    public void setGroomAge(String groomAge) {
        this.groomAge = groomAge;
    }

    @SuppressWarnings("unused")
    public String getBrideAge() {
        return brideAge;
    }

    public void setBrideAge(String brideAge) {
        this.brideAge = brideAge;
    }

    @SuppressWarnings("unused")
    public String getGroomCondition() {
        return groomCondition;
    }

    @SuppressWarnings("unused")
    public void setGroomCondition(String groomCondition) {
        this.groomCondition = groomCondition;
    }

    @SuppressWarnings("unused")
    public String getBrideCondition() {
        return brideCondition;
    }

    @SuppressWarnings("unused")
    public void setBrideCondition(String brideCondition) {
        this.brideCondition = brideCondition;
    }

    @SuppressWarnings("unused")
    public String getGroomRank() {
        return groomRank;
    }

    @SuppressWarnings("unused")
    public void setGroomRank(String groomRank) {
        this.groomRank = groomRank;
    }

    @SuppressWarnings("unused")
    public String getBrideRank() {
        return brideRank;
    }

    @SuppressWarnings("unused")
    public void setBrideRank(String brideRank) {
        this.brideRank = brideRank;
    }

    @SuppressWarnings("unused")
    public Place getGroomUsualResidence() {
        return groomUsualResidence;
    }

    @SuppressWarnings("unused")
    public void setGroomUsualResidence(Place groomUsualResidence) {
        this.groomUsualResidence = groomUsualResidence;
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
    public Person getGroomFather() {
        return groomFather;
    }

    @SuppressWarnings("unused")
    public void setGroomFather(Person groomFather) {
        this.groomFather = groomFather;
    }

    @SuppressWarnings("unused")
    public Person getBrideFather() {
        return brideFather;
    }

    @SuppressWarnings("unused")
    public void setBrideFather(Person brideFather) {
        this.brideFather = brideFather;
    }

    @SuppressWarnings("unused")
    public String getGroomUntrackedFather() {
        return groomUntrackedFather;
    }

    @SuppressWarnings("unused")
    public void setGroomUntrackedFather(String groomUntrackedFather) {
        this.groomUntrackedFather = groomUntrackedFather;
    }

    @SuppressWarnings("unused")
    public String getBrideUntrackedFather() {
        return brideUntrackedFather;
    }

    @SuppressWarnings("unused")
    public void setBrideUntrackedFather(String brideUntrackedFather) {
        this.brideUntrackedFather = brideUntrackedFather;
    }

    @SuppressWarnings("unused")
    public String getBrideFatherRank() {
        return brideFatherRank;
    }

    @SuppressWarnings("unused")
    public void setBrideFatherRank(String brideFatherRank) {
        this.brideFatherRank = brideFatherRank;
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

    @SuppressWarnings("unused")
    public String getUntrackedFirstWitness() {
        return untrackedFirstWitness;
    }

    @SuppressWarnings("unused")
    public void setUntrackedFirstWitness(String untrackedFirstWitness) {
        this.untrackedFirstWitness = untrackedFirstWitness;
    }

    @SuppressWarnings("unused")
    public String getUntrackedSecondWitness() {
        return untrackedSecondWitness;
    }

    @SuppressWarnings("unused")
    public void setUntrackedSecondWitness(String untrackedSecondWitness) {
        this.untrackedSecondWitness = untrackedSecondWitness;
    }

    public String getGroomFatherRank() {
        return groomFatherRank;
    }

    public void setGroomFatherRank(String groomFatherRank) {
        this.groomFatherRank = groomFatherRank;
    }

    public String getYearMarried() {
        return yearMarried;
    }

    public void setYearMarried(String yearMarried) {
        this.yearMarried = yearMarried;
    }

    public String getMonthMarried() {
        return monthMarried;
    }

    public void setMonthMarried(String monthMarried) {
        this.monthMarried = monthMarried;
    }

    public String getDayMarried() {
        return dayMarried;
    }

    public void setDayMarried(String dayMarried) {
        this.dayMarried = dayMarried;
    }


    public void setWhenMarried(String whenMarried) {
        this.whenMarried = whenMarried;
    }
}
