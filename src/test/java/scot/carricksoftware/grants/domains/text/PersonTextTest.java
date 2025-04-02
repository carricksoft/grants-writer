/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:25. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class PersonTextTest {

    private PersonText personText;

    @BeforeEach
    void setUp() {
        personText = new PersonText();
    }

    @Test
    void getIdTest() {
        Long id = GetRandomLong();
        personText.setId(id);
        assertNotNull(personText.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        personText.setId(id);
        assertEquals(id, personText.getId());
    }

    @Test
    void getPersonTest() {
        assertNull(personText.getPerson());
    }

    @Test
    void setPersonTest() {
        Person person = GetRandomPerson();
        personText.setPerson(person);
        assertEquals(person, personText.getPerson());
    }

}