/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:13. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;

import scot.carricksoftware.grants.domains.census.Census;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryRelationship;

public interface CensusEntryCommand {

    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    Census getCensus();

    void setCensus(Census census);

    Person getPerson();

    void setPerson(Person person);

    CensusEntryRelationship getRelationship();

    void setRelationship(CensusEntryRelationship relationship);
}
