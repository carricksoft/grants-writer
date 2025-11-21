/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.deathcertificate;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.domains.certificates.BaseCertificate;
import scot.carricksoftware.grantswriter.domains.people.Person;
import scot.carricksoftware.grantswriter.domains.places.Place;
import scot.carricksoftware.grantswriter.enums.general.Sex;

@Entity
@Table(name="`death_certificate`")
public class DeathCertificate extends BaseCertificate {



    @ManyToOne
    @JoinColumn(name = "`person_id`")
    private Person deceased;

    @Enumerated(EnumType.STRING)
    @Column(name = "`sex`")
    private Sex sex;

    @Column(name = "`occupation`")
    private String occupation;

    @Column(name = "`when_born`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String whenBorn;

    @Column(name = "`age`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String age;

    @Column(name = "`marital_status`")
    private String maritalStatus;

    @Column(name = "`when_died`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_TIME_FORMAT)
    private String whenDied;

    @ManyToOne
    @JoinColumn(name = "`where_died_id`")
    private Place whereDied;

    @Column(name = "`untracked_where_died`")
    private String untrackedWhereDied;

    @ManyToOne
    @JoinColumn(name = "`usual_residence_id`")
    private Place usualResidence;

    @Column(name = "`untracked_usual_residence`")
    private String untrackedUsualResidence;

    @Column(name = "`cause_of_death`")
    @Lob
    private String causeOfDeath;

    @ManyToOne
    @JoinColumn(name = "`spouse_id`")
    private Person spouse;

    @Column(name = "`untracked_spouse`")
    private String untrackedSpouse;

    @Column(name = "`spouse_occupation`")
    private String spouseOccupation;

    @ManyToOne
    @JoinColumn(name = "`father_id`")
    private Person father;

    @JoinColumn(name = "`untracked_father`")
    private String untrackedFather;

    @JoinColumn(name = "`father_occupation`")
    private String fatherOccupation;

    @ManyToOne
    @JoinColumn(name = "`mother_id`")
    private Person mother;

    @JoinColumn(name = "`untracked_mother`")
    private String untrackedMother;

    @JoinColumn(name = "`mother_occupation`")
    private String motherOccupation;

    @ManyToOne()
    @JoinColumn(name = "`informant_id`")
    private Person informant;

    @JoinColumn(name = "`informant_address`")
    private String informantAddress;

    @Column(name = "`untracked_informant`")
    private String untrackedInformant;

    @Column(name = "`informant_qualification`")
    private String informantQualification;

    @Column(name = "`when_registered`")
    private String whenRegistered;

    @Column(name = "`where_registered`")
    private String whereRegistered;

    @Column(name = "`regiment`")
    private String regiment;

    @Column(name = "`service_number`")
    private String serviceNumber;

    @Column(name = "`service_rank`")
    private String serviceRank;

    public Person getDeceased() {
        return deceased;
    }

    public void setDeceased(Person deceased) {
        this.deceased = deceased;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getWhenBorn() {
        return whenBorn;
    }

    public void setWhenBorn(String whenBorn) {
        this.whenBorn = whenBorn;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getWhenDied() {
        return whenDied;
    }

    public void setWhenDied(String whenDied) {
        this.whenDied = whenDied;
    }

    public Place getWhereDied() {
        return whereDied;
    }

    public void setWhereDied(Place whereDied) {
        this.whereDied = whereDied;
    }

    public String getUntrackedWhereDied() {
        return untrackedWhereDied;
    }

    public void setUntrackedWhereDied(String untrackedWhereDied) {
        this.untrackedWhereDied = untrackedWhereDied;
    }

    public Place getUsualResidence() {
        return usualResidence;
    }

    public void setUsualResidence(Place usualResidence) {
        this.usualResidence = usualResidence;
    }

    public String getUntrackedUsualResidence() {
        return untrackedUsualResidence;
    }

    public void setUntrackedUsualResidence(String untrackedUsualResidence) {
        this.untrackedUsualResidence = untrackedUsualResidence;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public String getUntrackedSpouse() {
        return untrackedSpouse;
    }

    public void setUntrackedSpouse(String untrackedSpouse) {
        this.untrackedSpouse = untrackedSpouse;
    }

    public String getSpouseOccupation() {
        return spouseOccupation;
    }

    public void setSpouseOccupation(String spouseOccupation) {
        this.spouseOccupation = spouseOccupation;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public String getUntrackedFather() {
        return untrackedFather;
    }

    public void setUntrackedFather(String untrackedFather) {
        this.untrackedFather = untrackedFather;
    }

    public String getFatherOccupation() {
        return fatherOccupation;
    }

    public void setFatherOccupation(String fatherOccupation) {
        this.fatherOccupation = fatherOccupation;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public String getUntrackedMother() {
        return untrackedMother;
    }

    public void setUntrackedMother(String untrackedMother) {
        this.untrackedMother = untrackedMother;
    }

    public String getMotherOccupation() {
        return motherOccupation;
    }

    public void setMotherOccupation(String motherOccupation) {
        this.motherOccupation = motherOccupation;
    }

    public Person getInformant() {
        return informant;
    }

    public void setInformant(Person informant) {
        this.informant = informant;
    }

    public String getInformantAddress() {
        return informantAddress;
    }

    public void setInformantAddress(String informantAddress) {
        this.informantAddress = informantAddress;
    }

    public String getUntrackedInformant() {
        return untrackedInformant;
    }

    public void setUntrackedInformant(String untrackedInformant) {
        this.untrackedInformant = untrackedInformant;
    }

    public String getInformantQualification() {
        return informantQualification;
    }


    public void setInformantQualification(String informantQualification) {
        this.informantQualification = informantQualification;
    }

    public String getWhenRegistered() {
        return whenRegistered;
    }

    public void setWhenRegistered(String whenRegistered) {
        this.whenRegistered = whenRegistered;
    }

    public String getWhereRegistered() {
        return whereRegistered;
    }

    public void setWhereRegistered(String whereRegistered) {
        this.whereRegistered = whereRegistered;
    }

    public String getRegiment() {
        return regiment;
    }

    public void setRegiment(String regiment) {
        this.regiment = regiment;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getServiceRank() {
        return serviceRank;
    }

    public void setServiceRank(String serviceRank) {
        this.serviceRank = serviceRank;
    }
}
