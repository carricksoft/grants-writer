/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 02:07. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.people;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class PersonCensusCommandTest {

    PersonCommand command;

    @BeforeEach
    void setUp() {
        command = new PersonCommandImpl();
    }

    @Test
    void getIdTest() {
        assertNull(command.getId());
    }

    @Test
    void setIdTest() {
        Long id = GetRandomLong();
        command.setId(id);
        assertEquals(id, command.getId());
    }

    @Test
    void getFirstNameTest() {
        assertNull(command.getFirstName());
    }

    @Test
    void setFirstNameTest() {
        String firstName = GetRandomString();
        command.setFirstName(firstName);
    }

    @Test
    void getLastNameTest() {
        assertNull(command.getLastName());
    }

    @Test
    void setLastNameTest() {
        String lastName = GetRandomString();
        command.setLastName(lastName);
    }
}