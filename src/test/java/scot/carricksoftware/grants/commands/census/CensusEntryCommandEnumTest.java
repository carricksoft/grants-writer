/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:15. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryRelationship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCensusEntryRelationshipRandomValue.GetRandomCensusEntryRelationship;

class CensusEntryCommandEnumTest {

    private CensusEntryCommand command;

    @BeforeEach
    void setUp() {
        command = new CensusEntryCommandImpl();
    }

    @Test
    void getRelationshipTest() {
        assertNull(command.getRelationship());
    }

    @Test
    void setNameTest() {
        CensusEntryRelationship relationship = GetRandomCensusEntryRelationship();
        command.setRelationship(relationship);
        assertEquals(relationship, command.getRelationship());
    }

}