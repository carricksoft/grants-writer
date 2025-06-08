/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:01. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;


@ExtendWith(MockitoExtension.class)
class CensusEntryPartThreeTest {

    private CensusEntry entry;


    @BeforeEach
    void setUp() {
        entry = new CensusEntry();
    }

    @Test
    public void getChildrenWhoHaveDiedTest() {
        assertNull(entry.getChildrenWhoHaveDied());
    }

    @Test
    public void setChildrenWhoHaveDiedTest() {
        String string = GetRandomString();
        entry.setChildrenWhoHaveDied(string);
        assertEquals(string, entry.getChildrenWhoHaveDied());
    }

    @Test
    public void getChildrenStillAliveTest() {
        assertNull(entry.getChildrenStillAlive());
    }

    @Test
    public void setChildrenStillAliveTest() {
        String string = GetRandomString();
        entry.setChildrenStillAlive(string);
        assertEquals(string, entry.getChildrenStillAlive());
    }

    @Test
    public void getChildrenBornAliveTest() {
        assertNull(entry.getChildrenBornAlive());
    }

    @Test
    public void setChildrenBornAliveTest() {
        String string = GetRandomString();
        entry.setChildrenBornAlive(string);
        assertEquals(string, entry.getChildrenBornAlive());
    }

    @Test
    public void getYearsCompletedMarriageTest() {
        assertNull(entry.getYearsCompletedMarriage());
    }

    @Test
    public void setYearsCompletedMarriageTest() {
        String string = GetRandomString();
        entry.setYearsCompletedMarriage(string);
        assertEquals(string, entry.getYearsCompletedMarriage());
    }

    @Test
    public void getIndustryOrServiceTest() {
        assertNull(entry.getIndustryOrService());
    }

    @Test
    public void setIndustryOrServiceTest() {
        String string = GetRandomString();
        entry.setIndustryOrService(string);
        assertEquals(string, entry.getIndustryOrService());
    }


}