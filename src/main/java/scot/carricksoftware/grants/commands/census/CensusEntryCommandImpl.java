/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 02:00. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryGaelic;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryRelationship;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryCondition;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryWorker;

public class CensusEntryCommandImpl implements CensusEntryCommand {

    private Long id;

    private String name;

    private Census census;

    private Person person;

    private CensusEntryRelationship relationship;

    private CensusEntryCondition condition;

    private CensusEntryGaelic gaelic;

    private CensusEntryWorker worker;

    private String age;

    private String whereBorn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Census getCensus() {
        return census;
    }

    @Override
    public void setCensus(Census census) {
        this.census = census;
    }

    @Override
    public Person getPerson() {
        return this.person;
    }

    @Override
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public CensusEntryRelationship getRelationship() {
        return relationship;
    }

    @Override
    public void setRelationship(CensusEntryRelationship relationship) {
        this.relationship = relationship;
    }

    @Override
    public CensusEntryCondition getCondition() {
        return condition;
    }

    @Override
    public void setCondition(CensusEntryCondition condition) {
        this.condition = condition;
    }

    @Override
    public CensusEntryGaelic getGaelic() {
        return gaelic;
    }

    @Override
    public void setGaelic(CensusEntryGaelic gaelic) {
        this.gaelic = gaelic;
    }

    @Override
    public CensusEntryWorker getWorker() {
        return worker;
    }

    @Override
    public void setWorker(CensusEntryWorker worker) {
        this.worker = worker;
    }

    @Override
    public String getAge() {
        return age;
    }

    @Override
    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String getWhereBorn() {
        return whereBorn;
    }

    @Override
    public void setWhereBorn(String whereBorn) {
        this.whereBorn = whereBorn;
    }
}
