/*
 * Copyright (c) Andrew Grant of Carrick Software 18/03/2025, 10:22. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.people;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.people.PersonCommand;
import scot.carricksoftware.grants.commands.people.PersonCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static scot.carricksoftware.grants.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;

class PersonCommandConverterTest {
    private PersonCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PersonCommandConverterImpl();
    }

    @Test
    void convertTest() {
        Long id = GetRandomLong();
        String firstName = GetRandomString();
        String lastName = GetRandomString();
        PersonCommand source = new PersonCommandImpl();
        source.setId(id);
        source.setFirstName(firstName);
        source.setLastName(lastName);

        Person target = converter.convert(source);

        assert target != null;
        assertEquals(id, target.getId());
        assertEquals(firstName, target.getFirstName());
        assertEquals(lastName, target.getLastName());
    }
}