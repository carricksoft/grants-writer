/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:31. All rights reserved.
 *
 */

package scot.carricksoftware.grants.commands.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommand;
import scot.carricksoftware.grants.commands.certificates.divorcecertificates.DivorceCertificateCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class DivorceCertificateCommandImplTest {

    private DivorceCertificateCommand command;

    @BeforeEach
    void setUp() {
        command = new DivorceCertificateCommandImpl();
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
    public void getFirstPartyTest() {
        assertNull(command.getId());
    }

    @Test
    public void setFirstPartyTest() {
        Person person = GetRandomPerson();
        command.setFirstParty(person);
        assertEquals(person, command.getFirstParty());
    }

    @Test
    public void getSecondPartyTest() {
        assertNull(command.getSecondParty());
    }

    @Test
    public void setSecondPartyTest() {
        Person person = GetRandomPerson();
        command.setSecondParty(person);
        assertEquals(person, command.getSecondParty());
    }

}