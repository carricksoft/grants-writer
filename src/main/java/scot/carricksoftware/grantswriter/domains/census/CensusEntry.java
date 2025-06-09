/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.census;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import scot.carricksoftware.grantswriter.BaseEntity;
import scot.carricksoftware.grantswriter.domains.people.Person;

@Entity
public class CensusEntry extends BaseEntity {

    @SuppressWarnings({"unused", "JpaDataSourceORMInspection"})
    @Column(name = "`name`")
    private String name;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "`census_id`")
    private Census census;


    @SuppressWarnings({"JpaDataSourceORMInspection", "unused"})
    @ManyToOne
    @JoinColumn(name = "`person_id`")
    private Person person;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @Column(name = "`personal_occupation`")
    private String personalOccupation;


    public void setName(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused")
    public void setPerson(Person person) {
        this.person = person;
    }

    public Census getCensus() {
        return census;
    }

    public void setCensus(Census census) {
        this.census = census;
    }

    public String getPersonalOccupation() {
        return personalOccupation;
    }

    public void setPersonalOccupation(String personalOccupation) {
        this.personalOccupation = personalOccupation;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }
}
