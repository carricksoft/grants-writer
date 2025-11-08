/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 01:50. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.certificates.divorcecertificate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;
import scot.carricksoftware.grantswriter.BaseEntity;
import scot.carricksoftware.grantswriter.constants.ApplicationConstants;
import scot.carricksoftware.grantswriter.domains.people.Person;


@Entity
public class DivorceCertificate extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "`first_party_id`")
    private Person firstParty;

    @ManyToOne
    @JoinColumn(name = "`second_party_id`")
    private Person secondParty;

    @Column(name= "`registered_date`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_FORMAT)
    private String registeredDate;

    @Column(name= "`first_party_date`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_FORMAT)
    private String firstPartyDate;

    @Column(name= "`second_party_date`")
    @DateTimeFormat(pattern = ApplicationConstants.DATE_FORMAT)
    private String secondPartyDate;

    public Person getFirstParty() {
        return firstParty;
    }

    public void setFirstParty(Person firstParty) {
        this.firstParty = firstParty;
    }

    public Person getSecondParty() {
        return secondParty;
    }

    public void setSecondParty(Person secondParty) {
        this.secondParty = secondParty;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String getFirstPartyDate() {
        return firstPartyDate;
    }

    public void setFirstPartyDate(String firstPartyDate) {
        this.firstPartyDate = firstPartyDate;
    }

    public String getSecondPartyDate() {
        return secondPartyDate;
    }

    public void setSecondPartyDate(String secondPartyDate) {
        this.secondPartyDate = secondPartyDate;
    }
}
