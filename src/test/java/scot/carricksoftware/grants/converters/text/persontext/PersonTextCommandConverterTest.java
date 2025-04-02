/*
 * Copyright (c) Andrew Grant of Carrick Software 30/03/2025, 13:45. All rights reserved.
 *
 */

package scot.carricksoftware.grants.converters.text.persontext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.commands.text.PersonTextCommand;
import scot.carricksoftware.grants.commands.text.PersonTextCommandImpl;
import scot.carricksoftware.grants.domains.people.Person;
import scot.carricksoftware.grants.domains.text.PersonText;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;

class PersonTextCommandConverterTest {

    private PersonTextCommandConverter converter;

    @BeforeEach
    void setUp() {
        converter = new PersonTextCommandConverterImpl();
    }

    @Test
    void covertTest() {
        Long Id = GetRandomLong();
        Person person = GetRandomPerson();
        PersonTextCommand source = new PersonTextCommandImpl();

        source.setId(Id);
        source.setPerson(person);

        PersonText target = converter.convert(source);

        assertNotNull(target);
        assertEquals(Id, target.getId());
        assertEquals(person, target.getPerson());
    }
}