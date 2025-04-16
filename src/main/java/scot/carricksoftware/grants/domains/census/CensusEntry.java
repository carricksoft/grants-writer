/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 01:34. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import jakarta.persistence.*;
import scot.carricksoftware.grants.BaseEntity;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryGaelic;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryRelationship;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryCondition;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryWorker;

@Entity
public class CensusEntry extends BaseEntity {

    private String name;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "censusEntry_census_id")
    private Census census;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @Enumerated(EnumType.STRING)
    private CensusEntryRelationship relationship;

    @Enumerated(EnumType.STRING)
    private CensusEntryGaelic gaelic;

    @Enumerated(EnumType.STRING)
    private CensusEntryCondition condition;

    @Enumerated(EnumType.STRING)
    private CensusEntryWorker worker;

    private String age;

    private String whereBorn;


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
        return worker;
    }

    public void setWorker(CensusEntryWorker worker) {
        this.worker = worker;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWhereBorn() {
        return whereBorn;
    }

    public void setWhereBorn(String whereBorn) {
        this.whereBorn = whereBorn;
    }
}
