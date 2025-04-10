/*
 * Copyright (c) Andrew Grant of Carrick Software 19/03/2025, 02:00. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryRelationship;

public class CensusEntryCommandImpl implements CensusEntryCommand {

    private Long id;

    private String name;

    private Census census;

    private Person person;

    private CensusEntryRelationship relationship;

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
}
