/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 10:25. All rights reserved.
 *
 */

package scot.carricksoftware.grantswriter.domains.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.people.Person;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;


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