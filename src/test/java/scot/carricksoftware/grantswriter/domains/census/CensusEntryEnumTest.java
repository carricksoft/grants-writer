/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:01. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.enums.censusentry.CensusEntryCondition;
import scot.carricksoftware.grantswriter.enums.censusentry.CensusEntryGaelic;
import scot.carricksoftware.grantswriter.enums.censusentry.CensusEntryRelationship;
import scot.carricksoftware.grantswriter.enums.censusentry.CensusEntryWorker;
import scot.carricksoftware.grantswriter.enums.general.Sex;
import scot.carricksoftware.grantswriter.enums.general.YesNo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCensusEntryRandomEnums.GetRandomCensusEntryCondition;
import static scot.carricksoftware.grantswriter.GenerateCensusEntryRandomEnums.GetRandomCensusEntryGaelic;
import static scot.carricksoftware.grantswriter.GenerateCensusEntryRandomEnums.GetRandomCensusEntryRelationship;
import static scot.carricksoftware.grantswriter.GenerateCensusEntryRandomEnums.GetRandomCensusEntrySex;
import static scot.carricksoftware.grantswriter.GenerateCensusEntryRandomEnums.GetRandomCensusEntryWorker;
import static scot.carricksoftware.grantswriter.GenerateGeneralRandomEnums.GetRandomGeneralYesNo;

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

    @Test
    void getWorkerTest() {
        assertNull(entry.getCondition());
    }

    @Test
    void setWorkerTest() {
        CensusEntryWorker worker = GetRandomCensusEntryWorker();
        entry.setWorker(worker);
        assertEquals(worker, entry.getWorker());
    }

    @Test
    void getSexTest() {
        assertNull(entry.getSex());
    }

    @Test
    void setSexTest() {
        Sex sex = GetRandomCensusEntrySex();
        entry.setSex(sex);
        assertEquals(sex, entry.getSex());
    }

    @Test
    void getWorkingAtHomeTest() {
        assertNull(entry.getWorkingAtHome());
    }

    @Test
    void setWorkingAtHomeTest() {
        YesNo workingAtHome = GetRandomGeneralYesNo();
        entry.setWorkingAtHome(workingAtHome);
        assertEquals(workingAtHome, entry.getWorkingAtHome());
    }


}