/*
 * Copyright (c) Andrew Grant of Carrick Software 24/03/2025, 17:20. All rights reserved.
 *
 */

package scot.carricksoftware.grants.domains.certificates;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scot.carricksoftware.grants.domains.people.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static scot.carricksoftware.grants.GenerateRandomNumberValues.GetRandomLong;
import static scot.carricksoftware.grants.GenerateRandomPeopleValues.GetRandomPerson;


class DivorceCertificateTest {

    private DivorceCertificate certificate;

    @BeforeEach
    void setUp() {
        certificate = new DivorceCertificate();
    }

    @Test
    public void getIdTest() {
        assertNull(certificate.getId());
    }

    @Test
    public void setIdTest() {
        Long id = GetRandomLong();
        certificate.setId(id);
        assertEquals(id, certificate.getId());
    }

    @Test
    public void getFirstPartyTest() {
        assertNull(certificate.getId());
    }

    @Test
    public void setFirstPartyTest() {
        Person person = GetRandomPerson();
        certificate.setFirstParty(person);
        assertEquals(person, certificate.getFirstParty());
    }

    @Test
    public void getSecondPartyTest() {
        assertNull(certificate.getSecondParty());
    }

    @Test
    public void setSecondPartyTest() {
        Person person = GetRandomPerson();
        certificate.setSecondParty(person);
        assertEquals(person, certificate.getSecondParty());
    }


}