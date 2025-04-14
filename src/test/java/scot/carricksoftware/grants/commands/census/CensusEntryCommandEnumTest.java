/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:15. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.census;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryCondition;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryGaelic;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryRelationship;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryWorker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCensusEntryRandomEnums.*;

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
    void setRelationshipTest() {
        CensusEntryRelationship relationship = GetRandomCensusEntryRelationship();
        command.setRelationship(relationship);
        assertEquals(relationship, command.getRelationship());
    } 
    
    @Test
    void getConditionTest() {
        assertNull(command.getCondition());
    }

    @Test
    void setConditionTest() {
        CensusEntryCondition condition = GetRandomCensusEntryCondition();
        command.setCondition(condition);
        assertEquals(condition, command.getCondition());
    }

    @Test
    void getGaelicTest() {
        assertNull(command.getGaelic());
    }

    @Test
    void setGaelicTest() {
        CensusEntryGaelic gaelic = GetRandomCensusEntryGaelic();
        command.setGaelic(gaelic);
        assertEquals(gaelic, command.getGaelic());
    }

    @Test
    void getWorkerTest() {
        assertNull(command.getWorker());
    }

    @Test
    void setWorkerTest() {
        CensusEntryWorker worker = GetRandomCensusEntryWorker();
        command.setWorker(worker);
        assertEquals(worker, command.getWorker());
    }
    
}