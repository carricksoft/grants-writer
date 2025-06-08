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
class CensusEntryPartTwoTest {

    private CensusEntry entry;


    @BeforeEach
    void setUp() {
        entry = new CensusEntry();
    }

    @Test
    void getBirthDayTest() {
        assertNull(entry.getBirthDay());
    }

    @Test
    void setBirthDayTest() {
        String birthDay = GetRandomString();
        entry.setBirthDay(birthDay);
        assertEquals(birthDay, entry.getBirthDay());
    }

    @Test
    void getBirthYearTest() {
        assertNull(entry.getBirthYear());
    }

    @Test
    void setBirthYearTest() {
        String birthYear = GetRandomString();
        entry.setBirthYear(birthYear);
        assertEquals(birthYear, entry.getBirthYear());
    }

    @Test
    void getPersonalOccupationTest() {
        assertNull(entry.getPersonalOccupation());
    }

    @Test
    void setPersonalOccupationTest() {
        String occupation = GetRandomString();
        entry.setPersonalOccupation(occupation);
        assertEquals(occupation, entry.getPersonalOccupation());
    }

    @Test
    void getNotesTest() {
        assertNull(entry.getNotes());
    }

    @Test
    void setNotesTest() {
        String notes = GetRandomString();
        entry.setNotes(notes);
        assertEquals(notes, entry.getNotes());
    }


}