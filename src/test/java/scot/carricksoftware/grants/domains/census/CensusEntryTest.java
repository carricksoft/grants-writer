/*
 * Copyright (c) Andrew Grant of Carrick Software 20/03/2025, 11:01. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.census;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomCensusValues.GetRandomCensus;

@ExtendWith(MockitoExtension.class)
class CensusEntryTest {

    private CensusEntry entry;

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
    void toStringTest() {
        String string = GetRandomString();
        entry.setCensus(censusMock);
        when(censusMock.toString()).thenReturn(string);

        entry.setName(GetRandomString());
        assertEquals(string, entry.toString());
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

    @Test
    void getAgeTest() {
        assertNull(entry.getAge());
    }

    @Test
    void setAgeTest() {
        String age = GetRandomString();
        entry.setAge(age);
        assertEquals(age, entry.getAge());
    }

    @Test
    void getWhereBornTest() {
        assertNull(entry.getWhereBorn());
    }

    @Test
    void setWhereBornTest() {
        String whereBorn = GetRandomString();
        entry.setWhereBorn(whereBorn);
        assertEquals(whereBorn, entry.getWhereBorn());
    }

}