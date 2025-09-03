/*
 * Copyright (c) 2025.  Andrew Grant Carrick Software. All rights reserved
 *
 */

package scot.carricksoftware.grantswriter.domains.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grantswriter.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grantswriter.GenerateCertificateRandomValues.GetRandomString;
import static scot.carricksoftware.grantswriter.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grantswriter.GenerateRandomPeopleValues.GetRandomPerson;

class PersonTextTest {

    private PersonText personText;

    @BeforeEach
    void setUp() {
        personText = new PersonText();
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

    @Test
    void getLevelTest() {
        assertNull(personText.getLevel());
    }

    @Test
    void setLevelTest() {
        Long level = GetRandomLong();
        personText.setLevel(level);
        assertEquals(level, personText.getLevel());
    }

    @Test
    void getOrderTest() {
        assertNull(personText.getOrder());
    }

    @Test
    void setOrderTest() {
        Long order = GetRandomLong();
        personText.setOrder(order);
        assertEquals(order, personText.getOrder());
    }

    @Test
    void getHeadingTest() {
        assertNull(personText.getHeading());
    }

    @Test
    void setHeadingTest() {
        String heading = GetRandomString();
        personText.setHeading(heading);
        assertEquals(heading, personText.getHeading());
    }

    @Test
    void getContentTest() {
        assertNull(personText.getContent());
    }

    @Test
    void setContentTest() {
        String content = GetRandomString();
        personText.setContent(content);
        assertEquals(content, personText.getContent());
    }

}