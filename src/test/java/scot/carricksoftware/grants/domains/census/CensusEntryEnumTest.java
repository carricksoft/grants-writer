/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:01. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryCondition;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryRelationship;
import scot.carricksoftware.grants.enums.censusentry.CensusEntryGaelic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCensusEntryRandomEnums.*;

@ExtendWith(MockitoExtension.class)
class CensusEntryEnumTest {

    private CensusEntry entry;

    @BeforeEach
    void setUp() {
        entry = new CensusEntry();
    }

    @Test
    void getRelationShipTest() {
        assertNull(entry.getRelationship());
    }

    @Test
    void setRelationshipTest() {
        CensusEntryRelationship relationship = GetRandomCensusEntryRelationship();
        entry.setRelationship(relationship);
        assertEquals(relationship, entry.getRelationship());
    }

    @Test
    void getConditionTest() {
        assertNull(entry.getCondition());
    }

    @Test
    void setConditionTest() {
        CensusEntryCondition condition = GetRandomCensusEntryCondition();
        entry.setCondition(condition);
        assertEquals(condition, entry.getCondition());
    }

    @Test
    void getGaelicTest() {
        assertNull(entry.getCondition());
    }

    @Test
    void setGaelicTest() {
        CensusEntryGaelic gaelic = GetRandomCensusEntryGaelic();
        entry.setGaelic(gaelic);
        assertEquals(gaelic, entry.getGaelic());
    }

}