/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.deathcertificate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.domains.certificates.BaseCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.enums.general.Sex;

@Entity
public class DeathCertificate extends BaseCertificate {



    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`person_id`")
    private Person deceased;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Enumerated(EnumType.STRING)
    @Column(name = "`sex`")
    private Sex sex;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`occupation`")
    private String occupation;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`when_born`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String whenBorn;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`age`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String age;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`marital_status`")
    private String maritalStatus;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`when_died`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String whenDied;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`where_died_id`")
    private Place whereDied;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_where_died`")
    private String untrackedWhereDied;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`usual_residence_id`")
    private Place usualResidence;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_usual_residence`")
    private String untrackedUsualResidence;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`cause_of_death`")
    @Lob
    private String causeOfDeath;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`spouse_id`")
    private Person spouse;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_spouse`")
    private String untrackedSpouse;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`spouse_occupation`")
    private String spouseOccupation;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`father_id`")
    private Person father;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @JoinColumn(name = "`untracked_father`")
    private String untrackedFather;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @JoinColumn(name = "`father_occupation`")
    private String fatherOccupation;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`mother_id`")
    private Person mother;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @JoinColumn(name = "`untracked_mother`")
    private String untrackedMother;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @JoinColumn(name = "`mother_occupation`")
    private String motherOccupation;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne()
    @JoinColumn(name = "`informant_id`")
    private Person informant;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @JoinColumn(name = "`informant_address`")
    private String informantAddress;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`untracked_informant`")
    private String untrackedInformant;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`informant_qualification`")
    private String informantQualification;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`when_registered`")
    private String whenRegistered;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`where_registered`")
    private String whereRegistered;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`regiment`")
    private String regiment;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`service_number`")
    private String serviceNumber;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`service_rank`")
    private String serviceRank;

    @SuppressWarnings("unused")
    public Person getDeceased() {
        return deceased;
    }

    @SuppressWarnings("unused")
    public void setDeceased(Person deceased) {
        this.deceased = deceased;
    }

    @SuppressWarnings("unused")
    public Sex getSex() {
        return sex;
    }

    @SuppressWarnings("unused")
    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @SuppressWarnings("unused")
    public String getOccupation() {
        return occupation;
    }

    @SuppressWarnings("unused")
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @SuppressWarnings("unused")
    public String getWhenBorn() {
        return whenBorn;
    }

    @SuppressWarnings("unused")
    public void setWhenBorn(String whenBorn) {
        this.whenBorn = whenBorn;
    }

    @SuppressWarnings("unused")
    public String getAge() {
        return age;
    }

    @SuppressWarnings("unused")
    public void setAge(String age) {
        this.age = age;
    }

    @SuppressWarnings("unused")
    public String getMaritalStatus() {
        return maritalStatus;
    }

    @SuppressWarnings("unused")
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @SuppressWarnings("unused")
    public String getWhenDied() {
        return whenDied;
    }

    @SuppressWarnings("unused")
    public void setWhenDied(String whenDied) {
        this.whenDied = whenDied;
    }

    @SuppressWarnings("unused")
    public Place getWhereDied() {
        return whereDied;
    }

    @SuppressWarnings("unused")
    public void setWhereDied(Place whereDied) {
        this.whereDied = whereDied;
    }

    @SuppressWarnings("unused")
    public String getUntrackedWhereDied() {
        return untrackedWhereDied;
    }

    @SuppressWarnings("unused")
    public void setUntrackedWhereDied(String untrackedWhereDied) {
        this.untrackedWhereDied = untrackedWhereDied;
    }

    @SuppressWarnings("unused")
    public Place getUsualResidence() {
        return usualResidence;
    }

    @SuppressWarnings("unused")
    public void setUsualResidence(Place usualResidence) {
        this.usualResidence = usualResidence;
    }

    @SuppressWarnings("unused")
    public String getUntrackedUsualResidence() {
        return untrackedUsualResidence;
    }

    @SuppressWarnings("unused")
    public void setUntrackedUsualResidence(String untrackedUsualResidence) {
        this.untrackedUsualResidence = untrackedUsualResidence;
    }

    @SuppressWarnings("unused")
    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    @SuppressWarnings("unused")
    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    @SuppressWarnings("unused")
    public Person getSpouse() {
        return spouse;
    }

    @SuppressWarnings("unused")
    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    @SuppressWarnings("unused")
    public String getUntrackedSpouse() {
        return untrackedSpouse;
    }

    @SuppressWarnings("unused")
    public void setUntrackedSpouse(String untrackedSpouse) {
        this.untrackedSpouse = untrackedSpouse;
    }

    @SuppressWarnings("unused")
    public String getSpouseOccupation() {
        return spouseOccupation;
    }

    @SuppressWarnings("unused")
    public void setSpouseOccupation(String spouseOccupation) {
        this.spouseOccupation = spouseOccupation;
    }

    @SuppressWarnings("unused")
    public Person getFather() {
        return father;
    }

    @SuppressWarnings("unused")
    public void setFather(Person father) {
        this.father = father;
    }

    @SuppressWarnings("unused")
    public String getUntrackedFather() {
        return untrackedFather;
    }

    @SuppressWarnings("unused")
    public void setUntrackedFather(String untrackedFather) {
        this.untrackedFather = untrackedFather;
    }

    @SuppressWarnings("unused")
    public String getFatherOccupation() {
        return fatherOccupation;
    }

    @SuppressWarnings("unused")
    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    @SuppressWarnings("unused")
    public Person getMother() {
        return mother;
    }

    @SuppressWarnings("unused")
    public void setMother(Person mother) {
        this.mother = mother;
    }

    @SuppressWarnings("unused")
    public String getUntrackedMother() {
        return untrackedMother;
    }

    @SuppressWarnings("unused")
    public void setUntrackedMother(String untrackedMother) {
        this.untrackedMother = untrackedMother;
    }

    @SuppressWarnings("unused")
    public String getMotherOccupation() {
        return motherOccupation;
    }

    @SuppressWarnings("unused")
    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    @SuppressWarnings("unused")
    public Person getInformant() {
        return informant;
    }

    @SuppressWarnings("unused")
    public void setInformant(Person informant) {
        this.informant = informant;
    }

    @SuppressWarnings("unused")
    public String getInformantAddress() {
        return informantAddress;
    }

    @SuppressWarnings("unused")
    public void setInformantAddress(String informantAddress) {
        this.informantAddress = informantAddress;
    }

    @SuppressWarnings("unused")
    public String getUntrackedInformant() {
        return untrackedInformant;
    }

    @SuppressWarnings("unused")
    public void setUntrackedInformant(String untrackedInformant) {
        this.untrackedInformant = untrackedInformant;
    }

    @SuppressWarnings("unused")
    public String getInformantQualification() {
        return informantQualification;
    }

    @SuppressWarnings("unused")
    public void setInformantQualification(String informantQualification) {
        this.informantQualification = informantQualification;
    }

    @SuppressWarnings("unused")
    public String getWhenRegistered() {
        return whenRegistered;
    }

    @SuppressWarnings("unused")
    public void setWhenRegistered(String whenRegistered) {
        this.whenRegistered = whenRegistered;
    }

    @SuppressWarnings("unused")
    public String getWhereRegistered() {
        return whereRegistered;
    }

    @SuppressWarnings("unused")
    public void setWhereRegistered(String whereRegistered) {
        this.whereRegistered = whereRegistered;
    }

    @SuppressWarnings("unused")
    public String getRegiment() {
        return regiment;
    }

    @SuppressWarnings("unused")
    public void setRegiment(String regiment) {
        this.regiment = regiment;
    }

    @SuppressWarnings("unused")
    public String getServiceNumber() {
        return serviceNumber;
    }

    @SuppressWarnings("unused")
    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    @SuppressWarnings("unused")
    public String getServiceRank() {
        return serviceRank;
    }

    @SuppressWarnings("unused")
    public void setServiceRank(String serviceRank) {
        this.serviceRank = serviceRank;
    }
}
