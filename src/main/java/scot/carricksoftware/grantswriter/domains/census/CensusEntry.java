/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:34. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.census;

import jakarta.persistence.*;
import scot.carricksoftware.grantswriter.BaseEntity;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.enums.censusentry.CensusEntryCondition;
import scot.carricksoftware.grantswriter.enums.censusentry.CensusEntryGaelic;
import scot.carricksoftware.grantswriter.enums.censusentry.CensusEntryRelationship;
import scot.carricksoftware.grantswriter.enums.censusentry.CensusEntryWorker;
import scot.carricksoftware.grantswriter.enums.general.Sex;
import scot.carricksoftware.grantswriter.enums.general.YesNo;


@Entity
public class CensusEntry extends BaseEntity {

    private String name;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`census_id`")
    private Census census;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`person_id`")
    private Person person;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`relationship`")
    private CensusEntryRelationship relationship;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`gaelic`")
    private CensusEntryGaelic gaelic;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`condition`")
    private CensusEntryCondition condition;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`worker`")
    private CensusEntryWorker worker;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`sex`")
    private Sex sex;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`age`")
    private String age;


    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`where_born`")
    private String whereBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`birth_day`")
    private String birthDay;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`birth_year`")
    private String birthYear;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`personal_occupation`")
    private String personalOccupation;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`notes`")
    private String notes;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`children_who_have_died`")
    private String childrenWhoHaveDied;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`children_still_alive`")
    private String childrenStillAlive;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`children_born_alive`")
    private String childrenBornAlive;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`years_Completed_Marriage`")
    private String yearsCompletedMarriage;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`working_at_home`")
    private YesNo workingAtHome;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`industry_or_service`")
    private String industryOrService;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Census getCensus() {
        return census;
    }

    public void setCensus(Census census) {
        this.census = census;
    }

    public String toString() {
        return census.toString();
    }

    public CensusEntryRelationship getRelationship() {
        return relationship;
    }

    public void setRelationship(CensusEntryRelationship relationship) {
        this.relationship = relationship;
    }

    public CensusEntryCondition getCondition() {
        return this.condition;
    }

    public void setCondition(CensusEntryCondition condition) {
        this.condition = condition;
    }

    public CensusEntryGaelic getGaelic() {
        return this.gaelic;
    }

    public void setGaelic(CensusEntryGaelic gaelic) {
        this.gaelic = gaelic;
    }

    public CensusEntryWorker getWorker() {
        return this.worker;
    }

    public void setWorker(CensusEntryWorker worker) {
        this.worker = worker;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWhereBorn() {
        return this.whereBorn;
    }

    public void setWhereBorn(String whereBorn) {
        this.whereBorn = whereBorn;
    }

    public Sex getSex() {
        return this.sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getPersonalOccupation() {
        return this.personalOccupation;
    }

    public void setPersonalOccupation(String occupation) {
        this.personalOccupation = occupation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getChildrenWhoHaveDied() {
        return childrenWhoHaveDied;
    }

    public void setChildrenWhoHaveDied(String childrenWhoHaveDied) {
        this.childrenWhoHaveDied = childrenWhoHaveDied;
    }

    public String getChildrenStillAlive() {
        return childrenStillAlive;
    }

    public void setChildrenStillAlive(String childrenStillAlive) {
        this.childrenStillAlive = childrenStillAlive;
    }

    public String getChildrenBornAlive() {
        return childrenBornAlive;
    }

    public void setChildrenBornAlive(String childrenBornAlive) {
        this.childrenBornAlive = childrenBornAlive;
    }

    public String getYearsCompletedMarriage() {
        return yearsCompletedMarriage;
    }

    public void setYearsCompletedMarriage(String yearsCompletedMarriage) {
        this.yearsCompletedMarriage = yearsCompletedMarriage;
    }

    public YesNo getWorkingAtHome() {
        return workingAtHome;
    }

    public void setWorkingAtHome(YesNo yesNo) {
        this.workingAtHome = yesNo;
    }

    public String getIndustryOrService() {
        return industryOrService;
    }

    public void setIndustryOrService(String industryOrService) {
        this.industryOrService = industryOrService;
    }
}
