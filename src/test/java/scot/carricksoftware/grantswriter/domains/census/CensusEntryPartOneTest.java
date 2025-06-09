/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:01. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grantswriter.domains.people.Person;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomCensusValues.GetRandomCensus;


@ExtendWith(MockitoExtension.class)
class CensusEntryPartOneTest {

    private CensusEntry entry;

    @SuppressWarnings("unused")
    @Mock
    private Census censusMock;

    @BeforeEach
    void setUp() {
        entry = new CensusEntry();
    }

    @Test
    void getNameTest() {
        assertNull(entry.getName());
    }

    @Test
    void setNameTest() {
        String name = GetRandomString();
        entry.setName(name);
        assertEquals(name, entry.getName());
    }

    @Test
    void getCensusTest() {
        assertNull(entry.getCensus());
    }

    @Test
    void setCensusTest() {
        Census census = GetRandomCensus();
        entry.setCensus(census);
        assertEquals(census, entry.getCensus());
    }


    @Test
    void getPersonTest() {
        assertNull(entry.getPerson());
    }

    @Test
    void setPersonTest() {
        Person person = new Person();
        entry.setPerson(person);
        assertEquals(person, entry.getPerson());
    }




}