/*
 * Copyright (c) Andrew Grant of Carrick Software 28/03/2025, 23:56. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.images;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.*;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class PersonImageCommandTest {

    private PersonImageCommand imageCommand;

    @BeforeEach
    void setUp() {
        imageCommand = new PersonImageCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(imageCommand.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        imageCommand.setId(id);
        assertEquals(id, imageCommand.getId());
    }

    @Test
    void getPersonTest() {
        assertNull(imageCommand.getPerson());
    }

    @Test
    void setPersonTest() {
        Person person = GetRandomPerson();
        imageCommand.setPerson(person);
        assertEquals(person, imageCommand.getPerson());
    }

}